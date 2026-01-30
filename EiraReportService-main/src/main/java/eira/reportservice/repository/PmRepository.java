package eira.reportservice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eira.reportservice.dto.PmDetailDTO;

import eira.reportservice.model.PreventiveMaintenance;

public interface PmRepository extends JpaRepository<PreventiveMaintenance, BigInteger> {
	
	
	@Query("SELECT new eira.reportservice.dto.PmDetailDTO( "
	        + "td.ticketId, td.ticketCode, td.remarks, td.completedTimestamp, "
	        + "sm.siteName, sm.installationCapacity,sm.siteReference as siteReference, "
	        + "cs.customerId, cs.customerName, "
	        + "cs.customerLogoPath as customerLogoPath, "
	        + "pm.groupSequence, pm.groupName, pm.checkPoint, pm.task, "
	        + "pmd.checkStatus, pm.category, pm.sequence, pm.pmId, "
	        + "pmd.serialNumber, pmd.stringNumber, pmd.pmRemarks,pmd.othersRemarks, pmd.imagePath, pmd.sDate,sm.domain,tc.categoryName,u.firstName, td.lastUpdatedDate,tt.ticketTypeName,"
	        + "(CASE WHEN pmd.checkStatus = '1' THEN 1 ELSE 0 END) as checkCount, "
	        + "(SELECT COUNT(pmd2.pmId) FROM PreventiveMaintainanceDetail pmd2 WHERE pmd2.ticketId = td.ticketId) as taskCount, "
	        + "0 as zeroCount) "  // Added zeroCount here
	        + "FROM Tickets td "
	        + "JOIN Sitedetails sm ON sm.siteId = td.siteId "
	        + "JOIN Customer cs ON cs.customerId = sm.customerId "
	        + "JOIN PreventiveMaintainanceDetail pmd ON pmd.ticketId = td.ticketId "
	        + "JOIN PreventiveMaintenance pm ON pm.pmId = pmd.pmId "
	        + "JOIN TicketCategory tc ON tc.categoryId = td.ticketCategoryId " 
	        + "JOIN TicketType tt ON tt.ticketTypeId = td.ticketTypeId " 
	        +"JOIN User u ON u.userId = td.assignedTo "
	        + "WHERE td.ticketId = :ticketId "
	        + "ORDER BY pm.pmId, pm.sequence, pm.groupSequence")
	List<PmDetailDTO> findPmDetailsByTicketId(@Param("ticketId") BigInteger ticketId);

	@Query(value = "SELECT " +
	        "COALESCE(tbl2.customername, ' ') AS customername, " +
	        "COALESCE(tbl1.sitename, ' ') AS sitename, " +
	        "COALESCE(TO_CHAR(tbl0.completedtimestamp, 'YYYY-MM-DD HH24:MI:SS'), ' ') AS creationdate, " +
	        "tbl0.ticketid AS ticketid, " +
	        "COALESCE(CAST(tbl0.ticketcode AS TEXT), ' ') AS ticketcode, " +  // Replaced ::text with CAST
	        "COALESCE(tbl0.remarks, ' ') AS remarks, " +
	        "CASE " +
	            "WHEN COALESCE(tbl1.installationcapacity, 0) >= 1000 " +
	            "THEN ROUND(COALESCE(tbl1.installationcapacity, 0) / 1000, 2) || ' MWh' " +
	            "ELSE ROUND(COALESCE(tbl1.installationcapacity, 0), 2) || ' kWh' " +
	        "END AS sitecapacity, " +
	        "COALESCE(tbl3.totaltask, 0) AS totaltask, " +
	        "COALESCE(tbl3.checkcount, 0) AS checkcount, " +
	        "CASE " +
	            "WHEN COALESCE(tbl3.totaltask, 0) = 0 " +
	            "THEN '0 %' " +
	            "ELSE ROUND(((COALESCE(tbl3.totaltask, 0) - COALESCE(tbl3.checkcount, 0)) / COALESCE(tbl3.totaltask, 0)) * 100, 2) || ' %' " +
	        "END AS healthcheck, " +
	        "COALESCE(tbl4.measurecount, 0) AS measurecount, " +
	        "0 AS zerocount, " +
	        "COALESCE(tbl1.domain, ' ') AS domainname " +
	        "FROM (SELECT * FROM saas.ticketdetails WHERE ticketid = :ticketId) tbl0 " +
	        "LEFT OUTER JOIN saas.site_master tbl1 ON tbl0.siteid = tbl1.siteid " +
	        "LEFT OUTER JOIN saas.customer tbl2 ON tbl1.customerid = tbl2.customerid " +
	        "LEFT OUTER JOIN ( " +
	            "SELECT ticketid, COUNT(pmid) AS totaltask, " +
	            "SUM(CASE WHEN checkstatus = 1 THEN 1 ELSE 0 END) AS checkcount " +
	            "FROM saas.preventive_maintenance_details " +
	            "WHERE status = 1 AND ticketid = :ticketId " +
	            "GROUP BY ticketid) tbl3 " +
	        "ON tbl3.ticketid = tbl0.ticketid " +
	        "LEFT OUTER JOIN ( " +
	            "SELECT ticketid, COUNT(transactionid) AS measurecount " +
	            "FROM saas.preventive_maintenance_details " +
	            "WHERE status = 1 AND ticketid = :ticketId " +
	            "GROUP BY ticketid) tbl4 " +
	        "ON tbl4.ticketid = tbl0.ticketid", nativeQuery = true)
	List<Object[]> findReportByTicketId(@Param("ticketId") BigInteger ticketId);

	


}
