package eira.reportservice.controller;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eira.reportservice.dto.CategoryDTO;
import eira.reportservice.service.ReportService;
import eira.reportservice.serviceimpl.ReportServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private ReportServiceImpl pictureRepositoryServiceImpl;

	@GetMapping("/print-picture-repository-details")
	public void printPictureRepositoryDetails(@RequestParam("ticketId") BigInteger ticketId) {
		pictureRepositoryServiceImpl.printPictureRepositoryDetails(ticketId);
	}

	
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<byte[]> generateReport(@PathVariable int ticketId) throws IOException {
	    try {
	        // Retrieve category and ticket type data
	        CategoryDTO data = reportService.getCategoryNameByTicketId(ticketId);

	        // Extract ticket type and category names
	        String ticketTypeName = data != null ? data.getTicketTypeName().toLowerCase() : "default";
	        String categoryName = data != null ? data.getCategoryName().toLowerCase() : "default";

	        System.out.println("ticketTypeName: " + ticketTypeName);
	        System.out.println("categoryName: " + categoryName);

	        // Initialize pdfBytes (default report will be assigned here)
	        byte[] pdfBytes;

	        // Generate report based on ticket type first, then category name
	        switch (ticketTypeName) {
	            case "operation":
	                if ("plant down".equals(categoryName)) {
	                    pdfBytes = reportService.generateOperationReport(ticketId);
	                } else {
	                    pdfBytes = reportService.generateOperationReport(ticketId);  // Default for 'operation' ticket type
	                }
	                break;

	            case "maintenance":
	                switch (categoryName) {
	                    case "string current measurement":
	                        pdfBytes = reportService.generateStringMonitoringReport(ticketId);
	                        break;
	                    case "jmr":
	                        pdfBytes = reportService.generateJmrReport(ticketId);
	                        break;
	                    case "dc pm":
	                    case "inverter pm":	
	                    case "mms pm":
	                    case "lt panel pm":	
	                    case "lightening arrestor and earth pits pm":	
	                        pdfBytes = reportService.generatePmReport(ticketId);
	                        break;
	                    default:
	                        pdfBytes = reportService.generateReport(ticketId);  // Default for 'maintenance' ticket type
	                        break;
	                }
	                break;

	            default:
	                pdfBytes = reportService.generateReport(ticketId);  // Default report for unknown ticket types
	                break;
	        }

	        // Prepare headers
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("inline", ticketTypeName + "_" + categoryName + "_Report.pdf");
	        headers.setContentLength(pdfBytes.length);

	        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new IOException("Failed to generate PDF report", e);
	    }
	}

//
//	@GetMapping("/stringmonitoring/{ticketId}")
//	public ResponseEntity<byte[]> generateStringMonitoringReport(@PathVariable int ticketId) throws IOException {
//		try {
//
//			// Use the category name to generate the report
//			byte[] pdfBytes = reportService.generateStringMonitoringReport(ticketId);
//
//			// Prepare headers
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_PDF);
//			headers.setContentDispositionFormData("inline", " String Monitoring Report.pdf");
//			headers.setContentLength(pdfBytes.length);
//
//			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new IOException("Failed to generate PDF report", e);
//		}
//	}
//
//	@GetMapping("/jmrticket/{ticketId}")
//	public ResponseEntity<byte[]> generateJmrReport(@PathVariable int ticketId) throws IOException {
//		try {
//
//			// Use the category name to generate the report
//			byte[] pdfBytes = reportService.generateJmrReport(ticketId);
//
//			// Prepare headers
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_PDF);
//			headers.setContentDispositionFormData("inline", " JMR REPORT Report.pdf");
//			headers.setContentLength(pdfBytes.length);
//
//			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new IOException("Failed to generate PDF report", e);
//		}
//	}
//
//	@GetMapping("/pmticket/{ticketId}")
//	public ResponseEntity<byte[]> generatepmReport(@PathVariable int ticketId) throws IOException {
//		try {
//
//			// Use the category name to generate the report
//			byte[] pdfBytes = reportService.generatePmReport(ticketId);
//
//			// Prepare headers
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_PDF);
//			headers.setContentDispositionFormData("inline", "Preventive Maintenance Report.pdf");
//			headers.setContentLength(pdfBytes.length);
//
//			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new IOException("Failed to generate PDF report", e);
//		}
//	}
//
//	@GetMapping("/operation/ticket/{ticketId}")
//	public ResponseEntity<byte[]> generateOperationReport(@PathVariable int ticketId) throws IOException {
//		try {
//
//			CategoryDTO data = reportService.getCategoryNameByTicketId(ticketId);
//
//			// Extract category name
//			String categoryName = data.getCategoryName();
//
//			// Use the category name to generate the report
//			byte[] pdfBytes = reportService.generateOperationReport(ticketId);
//
//			// Prepare headers
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_PDF);
//			headers.setContentDispositionFormData("inline", categoryName + " Report.pdf");
//			headers.setContentLength(pdfBytes.length);
//
//			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new IOException("Failed to generate PDF report", e);
//		}
//	}

}
