package eira.reportservice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eira.reportservice.dto.JmrDTO;
import eira.reportservice.model.JmrDetail;
@Repository
public interface JmrRepository  extends JpaRepository<JmrDetail, BigInteger> {
	
	@Query("SELECT new eira.reportservice.dto.JmrDTO( " +
		       "  td.ticketCode as ticketCode, " +
		       "  td.startedTimestamp as startedTimeStamp, " +
		       "  tc.categoryName, " +
		       "  sm.siteId as siteId, " +
		       "  sm.siteName as siteName, " +
		       "  sm.address as address, " +
		       "  sm.city as city, " +
		       "  sm.domain as domain, " +
		       "  (CASE " +
		       "    WHEN sm.installationCapacity > 1000 " +
		       "    THEN CONCAT(CAST(ROUND(sm.installationCapacity / 1000, 2) AS string), ' MWp') " +
		       "    ELSE CONCAT(CAST(ROUND(sm.installationCapacity, 2) AS string), ' kWp') " +
		       "  END) as capacity, " +
		       "  (CASE " +
		       "    WHEN sm.installationCapacity >= 1000 " +
		       "    THEN CONCAT(CAST(ROUND(sm.installationCapacity / 1000, 2) AS string), ' MWp') " +
		       "    ELSE CONCAT(CAST(ROUND(sm.installationCapacity, 2) AS string), ' kWp') " +
		       "  END) as siteCapacity, " +
		       "  cs.customerId as customerId, " +
		       "  cs.customerName as customerName, " +
		       "  cs.customerLogoPath as customerLogoPath, " +
		       "  jd.emSerialNo as emSerialNo, " +
		       "  jd.imageName as imageName, " +
		       "  jd.imagePath as imagePath, " +
		       "  jd.sLogDate as sLogDate, " +
		       "  jd.emrReading as emrReading, " +
		       "  jd.lmrValue as lmrValue, " +
		       "  jd.lmrTimeStamp as lmrTimeStamp, " +
		       "  jd.plantDownTime as plantDownTime, " +
		       "  jd.reportImagePath as reportImagePath, " +
		       "  jd.reportTimeStamp as reportTimeStamp, " +
		       "  'Signature of ' || COALESCE('Customer', 'Customer') || ' Representative' as customerSignature, " +
		       "  'Signature of ' || COALESCE('Site', 'Site') || ' Representative' as siteSignature " +
		       ") " +
		       "FROM Tickets td " +
		       "JOIN Sitedetails sm ON sm.siteId = td.siteId " +
		       "JOIN Customer cs ON cs.customerId = sm.customerId " +
		       "JOIN TicketCategory tc ON tc.categoryId = td.ticketCategoryId " +
		       "JOIN JmrDetail jd ON td.ticketId = jd.ticketId " +
		       "WHERE td.ticketId = :ticketId")
		List<JmrDTO> findJmrDetailsByTicketId(@Param("ticketId") BigInteger ticketId);



}
