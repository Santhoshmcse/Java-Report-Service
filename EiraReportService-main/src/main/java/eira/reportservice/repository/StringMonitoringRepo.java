package eira.reportservice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eira.reportservice.dto.StringMonitoringDTO;
import eira.reportservice.model.StringMonitoring;

@Repository
public interface StringMonitoringRepo extends JpaRepository<StringMonitoring, BigInteger> {

	@Query("SELECT new eira.reportservice.dto.StringMonitoringDTO(smr.sm_Voltage, smr.sm_Current, smr.sm_Fuse, smr.remarks, smr.dLogDate, td.ticketDetail, sm.customerId, sm.siteName, sm.installationCapacity, cs.customerName, cs.customerLogoPath, tc.categoryName, td.ticketCode, tt.ticketTypeName, ts.statusName, em.displayName, smr.smbSequence, smr.stringSequence) "
	        + "FROM StringMonitoring smr "
	        + "JOIN Tickets td ON td.ticketId = smr.ticketId "
	        + "JOIN Sitedetails sm ON sm.siteId = td.siteId "
	        + "JOIN Customer cs ON cs.customerId = sm.customerId "
	        + "JOIN TicketCategory tc ON tc.categoryId = td.ticketCategoryId "
	        + "JOIN TicketType tt ON tt.ticketTypeId = td.ticketTypeId "
	        + "JOIN EquipmentMaster em ON em.equipmentId = td.equipmentId "
	        + "JOIN TicketStatus ts ON ts.ticketStatusId = td.ticketStatusId "
	        + "WHERE smr.ticketId = :ticketId "
	        + "GROUP BY smr.smbSequence, smr.stringSequence, smr.sm_Voltage, smr.sm_Current, smr.sm_Fuse, smr.remarks, smr.dLogDate, td.ticketDetail, sm.customerId, sm.siteName, sm.installationCapacity, cs.customerName, cs.customerLogoPath, tc.categoryName, td.ticketCode, tt.ticketTypeName, ts.statusName, em.displayName "
	        + "ORDER BY smr.smbSequence")
	List<StringMonitoringDTO> findStringMonitoringByTicketId(@Param("ticketId") BigInteger ticketId);

}
