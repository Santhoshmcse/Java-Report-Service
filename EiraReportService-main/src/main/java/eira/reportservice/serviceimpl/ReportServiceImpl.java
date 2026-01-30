
package eira.reportservice.serviceimpl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eira.reportservice.dto.CategoryDTO;
import eira.reportservice.dto.EnergyServiceDTO;
import eira.reportservice.dto.JmrDTO;
import eira.reportservice.dto.PictureRepositoryDTO;
import eira.reportservice.dto.PmDetailDTO;
import eira.reportservice.dto.StringMonitoringDTO;
import eira.reportservice.repository.JmrRepository;
import eira.reportservice.repository.PictureRepo;
import eira.reportservice.repository.PmRepository;
import eira.reportservice.repository.SitedetailRepository;
import eira.reportservice.repository.StringMonitoringRepo;
import eira.reportservice.repository.TicketsRepository;
import eira.reportservice.service.ReportService;
import jakarta.persistence.EntityNotFoundException;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.util.JRSwapFile;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private PictureRepo pictureRepository;
	
	@Autowired
	private TicketsRepository ticketRepository;


	@Autowired
	private StringMonitoringRepo stringMonitoringRepo;

	@Autowired
	private JmrRepository jmrRepo;

	@Autowired
	private PmRepository pmRepo;

	@Autowired
	private SitedetailRepository sitedetailRepository;

	@Override
	public List<PictureRepositoryDTO> getPictureRepositoryDetails(BigInteger ticketId) {
		return pictureRepository.findByTicketId(ticketId);
	}

	public void printPictureRepositoryDetails(BigInteger ticketId) {
		List<PictureRepositoryDTO> results = getPictureRepositoryDetails(ticketId);

		// Print the results
		for (PictureRepositoryDTO result : results) {
			System.out.println(result.toString());
		}
	}

	@Override
	public byte[] generateReport(int ticketId) throws IOException {
	    JRSwapFileVirtualizer virtualizer = null;
	    List<File> tempFiles = new ArrayList<>(); // Initialize the list to track temporary files

	    try {
	        String tempDir = System.getProperty("java.io.tmpdir");
	        int blockSize = 4096; // Reduced block size for finer memory management
	        int minGrowCount = 100; // Increase disk page growth for large reports

	        JRSwapFile swapFile = new JRSwapFile(tempDir, blockSize, minGrowCount);
	        virtualizer = new JRSwapFileVirtualizer(10, swapFile); 

	        List<PictureRepositoryDTO> data = pictureRepository.findByTicketId(BigInteger.valueOf(ticketId));
	        List<EnergyServiceDTO> energyServiceData = pictureRepository
	                .findEnergyMeterAndServiceReportByTicketId(BigInteger.valueOf(ticketId));

	        // Ensure that the data is not empty
	        if (data == null || data.isEmpty()) {
	            throw new IOException("No data found for ticket ID: " + ticketId);
	        }

	        // Ensure energy service data is not empty
	        if (energyServiceData == null || energyServiceData.isEmpty()) {
	            throw new IOException("No energy service data found for ticket ID: " + ticketId);
	        }

	        EnergyServiceDTO energyServiceDTO = energyServiceData.get(0);

	        // Determine which JRXML file to load based on ticketTypeName
	        String jrxmlFileName = null;
	        String ticketTypeName = data.get(0).getTicketTypeName();
	        String ticketCode = data.get(0).getTicketCode();
	        String categoryName = data.get(0).getCategoryName();
	        String statusName = data.get(0).getStatusName();
	        String domainName = data.get(0).getDomain();
	        String companyName = (domainName != null) ? domainName + " Pvt Ltd" : "HummerSoft Technologies Pvt Ltd";
	        String reportHeader = ticketTypeName + "   -   " + categoryName;

	        String reportTitle = (ticketCode != null ? ticketCode : "") + "-"
	                + (categoryName != null ? categoryName : "") + " Report";
	        String statusDetail = " Status -" + (statusName != null ? statusName : "");
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	        Timestamp date = Timestamp.valueOf(data.get(0).getLastUpdatedDate());
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.HOUR_OF_DAY, 5);
	        cal.add(Calendar.MINUTE, 30);
	        String formattedDate = dateFormat.format(cal.getTime());

	        if ("Maintenance".equalsIgnoreCase(ticketTypeName)) {
	            if ("Modules Cleaning".equalsIgnoreCase(categoryName)) {
	                jrxmlFileName = "/reports/Module Cleaning.jrxml";
	            } else if ("Inverter Cleaning".equalsIgnoreCase(categoryName)) {
	                jrxmlFileName = "/reports/Inverter Cleaning.jrxml";
	            } else if ("Mechanical PM".equalsIgnoreCase(categoryName)) {
	                jrxmlFileName = "/reports/Mechanical PM.jrxml";
	            } else if ("Vegetation".equalsIgnoreCase(categoryName)) {
	                jrxmlFileName = "/reports/Vegetation.jrxml";
	            } else if ("DataLogger Cleaning".equalsIgnoreCase(categoryName)) {
	                jrxmlFileName = "/reports/DataLogger Cleaning.jrxml";
	            } else {
	                System.out.println("There is no template found");
	            }
	        }

	        InputStream jrxmlInputStream = getClass().getResourceAsStream(jrxmlFileName);
	        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

	        JasperReportsContext context = DefaultJasperReportsContext.getInstance();
	        JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.print.keep.full.text.element.width",
	                "true");
	        JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.export.pdf.compressed", "true");
	        JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.compiler.keep.java.file", "false");

	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("REPORT_TITLE", reportTitle);
	        parameters.put("STATUS_DETAIL", statusDetail);
	        parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
	        parameters.put("ENERGY_METER_BEFORE_LOG_DATE", energyServiceDTO.getEnergyMeterBeforeLogDate());
	        parameters.put("SERVICE_REPORT_BEFORE_LOG_DATE", energyServiceDTO.getServiceReportBeforeLogDate());
	        parameters.put("ENERGY_METER_SERVER_PATH", energyServiceDTO.getEnergyMeterServerPath());
	        parameters.put("SERVICE_REPORT_SERVER_PATH", energyServiceDTO.getServiceReportServerPath());
	        parameters.put("AREACOVERED_REPORT_SERVER_PATH", energyServiceDTO.getAreaCoveredPictureServerPath());
	        parameters.put("AREACOVERED_DATE", energyServiceDTO.getAreaCoveredPictureLogDate());
	        parameters.put("COMPANY_NAME", companyName);
	        parameters.put("REPORT_HEADER", reportHeader);
	        parameters.put("FORMATTED_DATE", formattedDate);

	        String ReportPicturePath = null;
	        if (energyServiceDTO.getServiceReportServerPath() != null && !energyServiceDTO.getServiceReportServerPath().isEmpty()) {
	            ReportPicturePath = energyServiceDTO.getServiceReportServerPath();
	        } else if (energyServiceDTO.getAreaCoveredPictureServerPath() != null && !energyServiceDTO.getAreaCoveredPictureServerPath().isEmpty()) {
	            ReportPicturePath = energyServiceDTO.getAreaCoveredPictureServerPath();
	        }
	        parameters.put("REPORT_PICTURE_SERVER_PATH", ReportPicturePath);
	        parameters.entrySet().removeIf(entry -> entry.getValue() == null);

	        JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.engine.export.skip.page.breaks", "true");

	        // Fill the report with data and parameters
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

	        // Save the filled report to a temporary file
	        File tempReportFile = File.createTempFile("report_", ".jrprint");
	        tempFiles.add(tempReportFile);
	        JRSaver.saveObject(jasperPrint, tempReportFile.getAbsolutePath());

	        // Export report to PDF
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);

	        return byteArrayOutputStream.toByteArray();
	    } catch (JRException e) {
	        throw new IOException("Error generating PDF report", e);
	    } catch (OutOfMemoryError e) {
	        System.err.println("Out of Memory Error: " + e.getMessage());
	        throw new IOException("Memory limit exceeded during report generation", e);
	    } finally {
	        if (virtualizer != null) {
	            virtualizer.cleanup();
	        }
	        cleanupTempFiles(tempFiles);
	        cleanupTempFontFiles();
	    }
	}

	public byte[] generateOperationReport(int ticketId) throws IOException {
		JRSwapFileVirtualizer virtualizer = null;
		List<File> tempFiles = new ArrayList<>(); // Initialize the list to track temporary files

		try {
			// Set up the swap file virtualizer
			String tempDir = System.getProperty("java.io.tmpdir"); // Temp directory
			int blockSize = 8192; // Increased block size to 8KB
			int minGrowCount = 200; // Increased minimum grow count to 200

			JRSwapFile swapFile = new JRSwapFile(tempDir, blockSize, minGrowCount);
			virtualizer = new JRSwapFileVirtualizer(2, swapFile); // Second argument is the maximum number of pages

			// Fetch data using the repository
			List<PictureRepositoryDTO> data = pictureRepository.findByTicketId(BigInteger.valueOf(ticketId));

			// Ensure that the data is not empty
			if (data == null || data.isEmpty()) {
				throw new IOException("No data found for ticket ID: " + ticketId);
			}
			String ticketCode = data.get(0).getTicketCode();
			String categoryName = data.get(0).getCategoryName();
			String reportTitle = (categoryName != null ? categoryName : "") + " Report";
			String domainName = data.get(0).getDomain();
			System.out.println("domainName---------" + domainName);
			String companyName = (domainName != null) ? domainName + " Pvt Ltd" : "HummerSoft Technologies Pvt Ltd";

			String timezoneOffset = "+530";
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			Timestamp date = Timestamp.valueOf(data.get(0).getLastUpdatedDate());

			// Create a Calendar instance and set the timestamp
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			// Adjust the calendar time based on the timezone offset
			int offsetMinutes = Integer.parseInt(timezoneOffset);
			cal.add(Calendar.MINUTE, offsetMinutes);

			// Get the adjusted date and format it
			String formattedDate = dateFormat.format(cal.getTime());

			// Initialize a list to hold before picture paths
			List<String> beforePicturePaths = new ArrayList<>();

			// Extract fields needed from the DTOs
			for (PictureRepositoryDTO dto : data) {
				String beforePictureServerPath = dto.getBeforePictureServerPath();
				// Add the before picture path to the list
				beforePicturePaths.add(beforePictureServerPath);
			}

			// Process the first path if needed (e.g., image compression)
			String compressedBeforePicturePath = null;
			if (!beforePicturePaths.isEmpty()) {
				ExecutorService executor = Executors.newFixedThreadPool(5); // Adjust thread pool size as needed
				List<Future<String>> futurePaths = new ArrayList<>();
				futurePaths.add(executor.submit(() -> compressImageFromPath(beforePicturePaths.get(0), tempFiles)));

				// Wait for image compression to complete
				try {
					compressedBeforePicturePath = futurePaths.get(0).get();
				} catch (InterruptedException | ExecutionException e) {
					throw new IOException("Error processing image paths", e);
				}

				executor.shutdown();
			}

			// Determine the JRXML file based on categoryName (you can modify this as
			// needed)
			String jrxmlFileName = "/reports/Operation.jrxml";

			InputStream jrxmlInputStream = getClass().getResourceAsStream(jrxmlFileName);
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

			// Set up report properties
			JasperReportsContext context = DefaultJasperReportsContext.getInstance();
			JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.print.keep.full.text.element.width",
					"true");
			JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.export.pdf.compressed", "true");
			JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.compiler.keep.java.file", "false");

			// Set up the parameters for the report
			Map<String, Object> parameters = new HashMap<>();

			// Add necessary parameters
			parameters.put("compressedBeforePicturePath", compressedBeforePicturePath); // Example parameter
			parameters.put("beforePictureList", beforePicturePaths); // Add the before picture list
			parameters.put("REPORT_TITLE", reportTitle);
			parameters.put("COMPANY_NAME", companyName);
			parameters.put("FORMATTED_DATE", formattedDate);
			// Remove parameters with null values
			parameters.entrySet().removeIf(entry -> entry.getValue() == null);

			// Fill the report with data and parameters
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			// Save the filled report to a temporary file
			File tempReportFile = File.createTempFile("report_", ".jrprint");
			tempFiles.add(tempReportFile);
			JRSaver.saveObject(jasperPrint, tempReportFile.getAbsolutePath());

			// Export report to PDF
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);

			return byteArrayOutputStream.toByteArray();

		} catch (JRException e) {
			throw new IOException("Error generating PDF report", e);
		} finally {
			if (virtualizer != null) {
				virtualizer.cleanup();
			}
			cleanupTempFiles(tempFiles);
			cleanupTempFontFiles();
		}
	}

	@Override
	public byte[] generateStringMonitoringReport(int ticketId) {
		try {
			// Fetch data from the repository
			List<StringMonitoringDTO> stringmonitoringData = stringMonitoringRepo
					.findStringMonitoringByTicketId(BigInteger.valueOf(ticketId));

			if (stringmonitoringData == null || stringmonitoringData.isEmpty()) {
				throw new IOException("No data found for ticket ID: " + ticketId);
			}

			String categoryName = stringmonitoringData.get(0).getCategoryName();
			String ticketCode = stringmonitoringData.get(0).getTicketCode();
			Integer smbSequence = stringmonitoringData.get(0).getSmbSequence();
			Integer stringSequence = stringmonitoringData.get(0).getStringSequence();
			String smbName = "SMB -" + smbSequence;
			String stringName = "String -" + stringSequence;
			String reportTitle = (ticketCode != null ? ticketCode : "") + "-"
					+ (categoryName != null ? categoryName : "") + " Report";

			// Define the JRXML file path
			String jrxmlFileName = "/reports/String Monitoring.jrxml";

			// Load and compile the JRXML file
			InputStream jrxmlInputStream = getClass().getResourceAsStream(jrxmlFileName);
			if (jrxmlInputStream == null) {
				throw new IOException("JRXML file not found: " + jrxmlFileName);
			}
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

			// Create the data source
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(stringmonitoringData);

			// Prepare parameters
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("CollectionBeanParam", dataSource); // For the table component
			parameters.put("ReportTitle", "String Monitoring Report");
			parameters.put("StatusDetail", "Status Details");
			parameters.put("REPORT_TITLE", reportTitle);
			parameters.put("SMB_NAME", smbName);
			parameters.put("STRING_NAME", stringName);
			// Fill the report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			// Export the report to a PDF
			return JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (JRException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public byte[] generateJmrReport(int ticketId) {
		try {
			// Fetch data from the repository
			List<JmrDTO> jmrData = jmrRepo.findJmrDetailsByTicketId(BigInteger.valueOf(ticketId));

			if (jmrData == null || jmrData.isEmpty()) {
				throw new IOException("No data found for ticket ID: " + ticketId);
			}

			String ticketCode = jmrData.get(0).getTicketCode();
			String categoryName = jmrData.get(0).getCategoryName();
			String domainName = jmrData.get(0).getDomain();
			String companyName = (domainName != null) ? domainName + " Pvt Ltd" : "HummerSoft Technologies Pvt Ltd";
			// Define the JRXML file path
			String jrxmlFileName = "/reports/JMR Report.jrxml";
			// Create the report title
			String reportTitle = (ticketCode != null ? ticketCode : "") + "-"
					+ (categoryName != null ? categoryName : "") + " Report";
			// Calculate and set lmrReading
			BigDecimal lmrValue = new BigDecimal(jmrData.get(0).getLmrValue());
			String lmrReading = lmrValue.compareTo(new BigDecimal("1000")) > 0
					? lmrValue.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP) + " MWh"
					: lmrValue + " kWh";

			jmrData.get(0).setLmrReading(lmrReading); // Ensure there is a setter method in JmrDTO

			// Calculate and set netGeneration
			BigDecimal emrReading = new BigDecimal(jmrData.get(0).getEmrReading());
			String cmReading = emrReading.compareTo(new BigDecimal("1000")) > 0
					? emrReading.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP) + " MWh"
					: emrReading + " kWh";
			jmrData.get(0).setCmReading(cmReading);
			BigDecimal netGen = emrReading.subtract(lmrValue);
			String netGeneration = netGen.compareTo(new BigDecimal("1000")) > 0
					? netGen.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP) + " MWh"
					: netGen + " kWh";
			jmrData.get(0).setNetGeneration(netGeneration);
			// Calculate and set creationDate (startedTimestamp with timezone offset)
			String timezoneOffset = "+530"; // Replace with your desired timezone offset in minutes (+/- minutes)
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Timestamp startedTimestamp = Timestamp.valueOf(jmrData.get(0).getStartedTimestamp()); // Assuming
																									// startedTimestamp
																									// is in your DTO
			Calendar cal = Calendar.getInstance();
			cal.setTime(startedTimestamp);
			cal.add(Calendar.MINUTE, Integer.parseInt(timezoneOffset)); // Add timezone offset in minutes
			String creationDate = dateFormat.format(cal.getTime());
			jmrData.get(0).setCreationDate(creationDate); // Ensure there is a setter for creationDate in JmrDTO
			Timestamp sLogTimestamp = Timestamp.valueOf(jmrData.get(0).getsLogDate());

			cal.setTime(sLogTimestamp);
			cal.add(Calendar.MINUTE, Integer.parseInt(timezoneOffset));
			String formattedSLogDate = dateFormat.format(cal.getTime());
			jmrData.get(0).setsLogDate(formattedSLogDate);

			// Adjust and format reportTimeStamp
			Timestamp reportTimestamp = Timestamp.valueOf(jmrData.get(0).getReportTimeStamp());
			cal.setTime(reportTimestamp);
			cal.add(Calendar.MINUTE, Integer.parseInt(timezoneOffset));
			String formattedReportTimeStamp = dateFormat.format(cal.getTime());
			jmrData.get(0).setReportTimeStamp(formattedReportTimeStamp);
			// Load and compile the JRXML file
			InputStream jrxmlInputStream = getClass().getResourceAsStream(jrxmlFileName);
			if (jrxmlInputStream == null) {
				throw new IOException("JRXML file not found: " + jrxmlFileName);
			}
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

			// Create the data source
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(jmrData);

			// Prepare parameters
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("CollectionBeanParam", dataSource); // For the table component
			parameters.put("ReportTitle", reportTitle);
			parameters.put("StatusDetail", "Status Details");
			parameters.put("LMR_READING", lmrReading);
			parameters.put("CREATION_DATE", creationDate);
			parameters.put("NET_GENERATION", netGeneration);
			parameters.put("COMPANY_NAME", companyName);
			parameters.put("SLOG_DATE", formattedSLogDate);
			parameters.put("REPORT_TIMESTAMP", formattedReportTimeStamp);

			// Fill the report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			// Export the report to a PDF
			return JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (JRException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public byte[] generatePmReport(int ticketId) throws IOException {

		// Step 1: Fetch the data for the report
		List<PmDetailDTO> pmData = pmRepo.findPmDetailsByTicketId(BigInteger.valueOf(ticketId));
		List<Object[]> results = pmRepo.findReportByTicketId(BigInteger.valueOf(ticketId));

		if (pmData == null || pmData.isEmpty()) {
			throw new IOException("No data found for ticket ID: " + ticketId);
		}
		System.out.println("Date123--------"+pmData.get(0).getFormattedSLogDate());
		String ticketCode = pmData.get(0).getTicketCode();
		String categoryName = pmData.get(0).getCategoryName();
		String reportTitle = (ticketCode != null ? ticketCode : "") + "-" + (categoryName != null ? categoryName : "")
				+ " Report";
		String domainName = pmData.get(0).getDomain();
		// Step 2: Format the sLogDate for each PmDetailDTO
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Timestamp date = Timestamp.valueOf(pmData.get(0).getLastUpdatedDate());
	//	System.out.println("Last Updated Date---------"+data.get(0).getLastUpdatedDate());

		// Create a Calendar instance and set the timestamp
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		// Add IST timezone offset (+5 hours 30 minutes) only once
		cal.add(Calendar.HOUR_OF_DAY, 5);
		cal.add(Calendar.MINUTE, 30);

		// Get the adjusted date and format it
		String formattedDate = dateFormat.format(cal.getTime());


		
		try (InputStream mainReportStream = getClass().getResourceAsStream("/reports/PMMainReport.jrxml");
				InputStream subReportStream = getClass().getResourceAsStream("/reports/PM Report.jrxml");
				InputStream headerSubReportStream = getClass().getResourceAsStream("/reports/PM HEADER.jrxml")) {

			if (mainReportStream == null || subReportStream == null || headerSubReportStream == null) {
				throw new IOException("Report files not found.");
			}

			// Step 2: Compile the main and sub reports
			JasperReport mainReport = JasperCompileManager.compileReport(mainReportStream);
			JasperReport subReport = JasperCompileManager.compileReport(subReportStream);
			JasperReport headerSubReport = JasperCompileManager.compileReport(headerSubReportStream);

			// Step 3: Set up parameters for the main report
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("SUBREPORT", subReport); // Pass the compiled subreport
			parameters.put("SUBREPORT_DATA_SOURCE", new JRBeanCollectionDataSource(pmData)); // Data source for the
																								// subreport
			parameters.put("ReportTitle", reportTitle);
			// Step 4: Prepare data for the second subreport (PM HEADER)
			List<Map<String, Object>> headerDataList = new ArrayList<>();
			for (Object[] row : results) {
				Map<String, Object> headerData = new HashMap<>();

				Long totalTask = ((Number) row[7]).longValue();
				Integer checkCount = ((Number) row[8]).intValue();
				String siteCapacity = (String) row[6];
				String remarks = (String) row[5];
				String healthCheck = (String) row[9];
				String domainname = (String) row[12]; // Adjusted index for domainname

				String companyName = (domainname != null && !domainname.trim().isEmpty()) ? domainname + " Pvt Ltd"
						: "HummerSoft Technologies Pvt Ltd";
				System.out.println(companyName);
				headerData.put("totalTask", totalTask);
				headerData.put("checkCount", checkCount);
				headerData.put("siteCapacity", siteCapacity);
				headerData.put("remarks", remarks);
				headerData.put("healthcheck", healthCheck);
				headerData.put("domainname", domainname);
				headerData.put("companyName", companyName); // Add companyName to header data
				parameters.put("FORMATTED_DATE", formattedDate);
				headerDataList.add(headerData);
			}

			JRBeanCollectionDataSource headerDataSource = new JRBeanCollectionDataSource(headerDataList);

			// Add the subreport and its data source to the parameters
			parameters.put("HEADER_SUBREPORT", headerSubReport);
			parameters.put("HEADER_SUBREPORT_DATA_SOURCE", headerDataSource);
			// Pass the companyName to the report parameters

			// Step 5: Create a JRBeanCollectionDataSource for the main report data
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pmData);

			// Step 6: Fill the report with data
			JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, parameters, dataSource);

			// Step 7: Export the report to PDF format
			return JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (JRException e) {
			throw new IOException("Error generating report: " + e.getMessage(), e);
		}
	}

	@Override
	public BigDecimal getInstallationCapacityBySiteId(BigInteger siteId) {
		return sitedetailRepository.findInstallationCapacityBySiteId(siteId)
				.orElseThrow(() -> new EntityNotFoundException("Site not found with id: " + siteId));
	}

	private String compressImageFromPath(String imagePath, List<File> tempFiles) throws IOException {
		if (imagePath == null || imagePath.isEmpty()) {
			return imagePath;
		}

		// Check if the path is a URL
		if (imagePath.startsWith("http://") || imagePath.startsWith("https://")) {
			Callable<String> task = () -> {
				URL url = new URL(imagePath);
				BufferedImage bufferedImage;
				try (InputStream inputStream = new BufferedInputStream(url.openStream())) {
					bufferedImage = ImageIO.read(inputStream);
				}

				// Resize image before compressing (e.g., scale down to 1024x768)
				Image scaledImage = bufferedImage.getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
				BufferedImage resizedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = resizedImage.createGraphics();
				g2d.drawImage(scaledImage, 0, 0, null);
				g2d.dispose();

				ByteArrayOutputStream compressedImageStream = new ByteArrayOutputStream();
				ImageIO.write(resizedImage, "jpg", compressedImageStream);

				File tempFile = File.createTempFile("compressed_", ".jpg");
				tempFiles.add(tempFile);
				try (OutputStream outputStream = new FileOutputStream(tempFile)) {
					outputStream.write(compressedImageStream.toByteArray());
				}

				return tempFile.getAbsolutePath();
			};

			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<String> future = executor.submit(task);

			try {
				return future.get(); // Wait for the task to complete
			} catch (InterruptedException | ExecutionException e) {
				throw new IOException("Error downloading and compressing image", e);
			} finally {
				executor.shutdown();
			}
		} else {
			// Existing logic for local files
			File inputFile = new File(imagePath);
			if (!inputFile.exists()) {
				throw new FileNotFoundException("File not found: " + imagePath);
			}

			BufferedImage bufferedImage;
			try (InputStream inputStream = new FileInputStream(inputFile)) {
				bufferedImage = ImageIO.read(inputStream);
			}

			// Resize image before compressing
			Image scaledImage = bufferedImage.getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
			BufferedImage resizedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = resizedImage.createGraphics();
			g2d.drawImage(scaledImage, 0, 0, null);
			g2d.dispose();

			ByteArrayOutputStream compressedImageStream = new ByteArrayOutputStream();
			ImageIO.write(resizedImage, "jpg", compressedImageStream);

			String compressedImagePath = imagePath.replace(".jpg", "_compressed.jpg");
			File compressedImageFile = new File(compressedImagePath);
			tempFiles.add(compressedImageFile);
			try (OutputStream outputStream = new FileOutputStream(compressedImageFile)) {
				outputStream.write(compressedImageStream.toByteArray());
			}

			return compressedImagePath;
		}
	}

	private void cleanupTempFiles(List<File> tempFiles) {
		for (File file : tempFiles) {
			if (file.exists()) {
				boolean deleted = file.delete();
				if (!deleted) {
					System.err.println("Failed to delete temp file: " + file.getAbsolutePath());
				}
			}
		}
	}

	private void cleanupTempFontFiles() {
		String tempDir = System.getProperty("java.io.tmpdir");
		File dir = new File(tempDir);
		File[] fontFiles = dir.listFiles((d, name) -> name.endsWith(".ttf") || name.endsWith(".otf"));

		if (fontFiles != null) {
			for (File file : fontFiles) {
				if (file.exists()) {
					boolean deleted = file.delete();
					if (!deleted) {
						System.err.println("Failed to delete font file: " + file.getAbsolutePath());
					}
				}
			}
		}
	}

	@Override
	public CategoryDTO getCategoryNameByTicketId(int ticketId) {
		List<CategoryDTO> categories = ticketRepository.findByCategoryByTicketId(ticketId);
		if (categories != null && !categories.isEmpty()) {
			
			return categories.get(0);
		}
		return null;
	}

}