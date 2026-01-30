
package eira.reportservice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eira.reportservice.dto.CategoryDTO;
import eira.reportservice.dto.EnergyServiceDTO;
import eira.reportservice.dto.PictureRepositoryDTO;
import eira.reportservice.model.PictureRepository;

@Repository
public interface PictureRepo extends JpaRepository<PictureRepository, BigInteger> {
	
	
	

	@Query("SELECT new eira.reportservice.dto.PictureRepositoryDTO(" +
		       "CASE " +
		       "  WHEN pr.groupName = 'Module Array' THEN 1 " +
		       "  WHEN pr.groupName = 'Energy Meter' THEN 2 " +
		       "  WHEN pr.groupName = 'Service Report' THEN 3 " +
		       "  WHEN pr.groupName = 'Sensor' THEN 4 " +
		       "  ELSE 5 " +
		       "END as reportSeq, " +
		       "CASE " +
		       "  WHEN pr.groupName NOT IN ('Energy Meter', 'Service Report') THEN pr.beforePictureServerPath " +
		       "  ELSE NULL " +
		       "END as beforePictureServerPath, " +
		       "CASE " +
		       "  WHEN pr.groupName NOT IN ('Energy Meter', 'Service Report') THEN pr.afterPictureServerPath " +
		       "  ELSE NULL " +
		       "END as afterPictureServerPath, " +
		       "CASE " +
		       "  WHEN (pr.beforePictureStatus = 1 AND pr.afterPictureStatus = 1) OR tt.ticketTypeName = 'Operation' THEN pr.sequence " +
		       "  ELSE NULL " +
		       "END as sequence, " +
		       "td.siteId as siteId, " +
		       "td.ticketDetail as ticketDetail, " +
		       "sm.customerId as customerId, " +
		       "sm.siteName as siteName, " +
		       "sm.domain as domain, " +
		       "sm.siteReference as siteReference, " +
		       "sm.installationCapacity as installationCapacity, " +
		       "cs.customerName as customerName, " +
		       "cs.customerLogoPath as customerLogoPath, " +
		       "tc.categoryName, " +
		       "td.ticketCode, " +
		       "tt.ticketTypeName, " +
		       "ts.statusName, " +
		       "pr.listName, " +
		       "pr.beforePictureStatus, " +
		       "pr.afterPictureStatus, " +
		       "pr.groupName, " +
		       "pr.beforePicturedLogdate, " +
		       "pr.afterPicturedLogdate, " +
		       "u.firstName, " +
		       "td.lastUpdatedDate, " +
		       "e.displayName, " +
		       "CASE " +
		       "  WHEN pr.groupName = 'Energy Meter' THEN pr.beforePictureServerPath " +
		       "  ELSE NULL " +
		       "END as energymeterserverPath, " +
		       "CASE " +
		       "  WHEN pr.groupName = 'Service Report' THEN pr.beforePictureServerPath " +
		       "  WHEN pr.groupName = 'Area Covered' THEN pr.beforePictureServerPath " +
		       "  ELSE NULL " +
		       "END as servicemeterserverPath) " +
		       "FROM PictureRepository pr " +
		       "JOIN Tickets td ON td.ticketId = pr.ticketId " +
		       "JOIN Sitedetails sm ON sm.siteId = td.siteId " +
		       "JOIN Customer cs ON cs.customerId = sm.customerId " +
		       "JOIN TicketCategory tc ON tc.categoryId = td.ticketCategoryId " +
		       "JOIN TicketType tt ON tt.ticketTypeId = td.ticketTypeId " +
		       "JOIN TicketStatus ts ON ts.ticketStatusId = td.ticketStatusId " +
		       "JOIN User u ON u.userId = td.assignedTo " +
		       "JOIN EquipmentMaster e ON e.equipmentId = td.equipmentId " +
		       "WHERE pr.ticketId = :ticketId and pr.groupName NOT IN ('Energy Meter', 'Service Report', 'Area Covered') " +
		       "ORDER BY " +
		       "CASE WHEN pr.groupName IN ('Energy Meter', 'Service Report', 'Area Covered') THEN 1 ELSE 0 END, " + 
		       "reportSeq,  pr.beforePicturedLogdate")
		List<PictureRepositoryDTO> findByTicketId(@Param("ticketId") BigInteger ticketId);

	
	@Query("SELECT new eira.reportservice.dto.EnergyServiceDTO( " +
		       "MAX(CASE WHEN pr.groupName = 'Energy Meter' THEN pr.beforePictureServerPath END), " +
		       "MAX(CASE WHEN pr.groupName = 'Service Report' THEN pr.beforePictureServerPath END), " +
		       "MAX(CASE WHEN pr.groupName = 'Area Covered' THEN pr.beforePictureServerPath END), " +
		       "MAX(CASE WHEN pr.groupName = 'Area Covered' THEN pr.beforePicturedLogdate END), " +
		       "MAX(CASE WHEN pr.groupName = 'Energy Meter' THEN pr.beforePicturedLogdate END), " +
		       "MAX(CASE WHEN pr.groupName = 'Service Report' THEN pr.beforePicturedLogdate END)) " +
		       "FROM PictureRepository pr " +
		       "WHERE pr.groupName IN ('Energy Meter', 'Service Report','Area Covered') " +
		       "AND pr.ticketId = :ticketId")
		List<EnergyServiceDTO> findEnergyMeterAndServiceReportByTicketId(@Param("ticketId") BigInteger ticketId);
		
	





}