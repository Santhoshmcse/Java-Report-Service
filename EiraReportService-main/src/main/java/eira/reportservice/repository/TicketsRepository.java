package eira.reportservice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eira.reportservice.dto.CategoryDTO;
import eira.reportservice.model.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets, BigInteger>{
	
	
	@Query("SELECT new eira.reportservice.dto.CategoryDTO(tc.categoryName, tt.ticketTypeName) " +
		       "FROM Tickets td " +
		       "JOIN Sitedetails sm ON sm.siteId = td.siteId " +
		       "JOIN Customer cs ON cs.customerId = sm.customerId " +
		       "JOIN TicketCategory tc ON tc.categoryId = td.ticketCategoryId " +
		       "JOIN TicketType tt ON tt.ticketTypeId = td.ticketTypeId " +
		       "WHERE td.ticketId = :ticketId")
		List<CategoryDTO> findByCategoryByTicketId(@Param("ticketId") int ticketId);  // Changed ticketID to BigInteger


}
