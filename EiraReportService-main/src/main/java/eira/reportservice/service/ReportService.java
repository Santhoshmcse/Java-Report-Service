package eira.reportservice.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import eira.reportservice.dto.CategoryDTO;
import eira.reportservice.dto.PictureRepositoryDTO;
import net.sf.jasperreports.engine.JRException;

public interface ReportService {

	byte[] generateReport(int ticketId) throws IOException, JRException;

	byte[] generateStringMonitoringReport(int ticketId) throws IOException;

	byte[] generateJmrReport(int ticketId) throws IOException;

	byte[] generatePmReport(int ticketId) throws IOException;

	byte[] generateOperationReport(int ticketId) throws IOException;

	List<PictureRepositoryDTO> getPictureRepositoryDetails(BigInteger ticketId);

	CategoryDTO getCategoryNameByTicketId(int ticketId);

	BigDecimal getInstallationCapacityBySiteId(BigInteger siteId);
}
