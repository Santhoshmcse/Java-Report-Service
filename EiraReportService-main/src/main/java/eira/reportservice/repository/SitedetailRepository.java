package eira.reportservice.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eira.reportservice.model.Sitedetails;

@Repository
public interface SitedetailRepository extends JpaRepository<Sitedetails, BigInteger> {
	

	@Query(value = "SELECT installationcapacity FROM saas.site_master WHERE siteid = :siteId", nativeQuery = true)
    Optional<BigDecimal> findInstallationCapacityBySiteId(@Param("siteId") BigInteger siteId);
}
