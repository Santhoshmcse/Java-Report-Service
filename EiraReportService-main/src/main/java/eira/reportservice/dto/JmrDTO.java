package eira.reportservice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class JmrDTO {

	private String ticketCode;
	private String startedTimestamp;
	private String categoryName;
	private BigInteger siteId;
	private String siteName;
	private String address;
	private String city;
	private String domain;
	private BigDecimal installationCapacity;
	private String capacity;
	private String siteCapacity;
	private Integer customerId;
	private String customerName;
	private String customerLogoPath;
	private String emSerialNo;
	private String imageName;
	private String imagePath;
	private String sLogDate;
	private String emrReading;
	private String lmrValue;
	private String lmrTimestamp;
	private String plantDownTime;
	private String cmReading;
	private String netGeneration;
	private String customerSignature;
	private String siteSignature;
	private String lmrReading;
	private String creationDate;
	private String reportImagePath;
	private String reportTimeStamp;

	public JmrDTO(String ticketCode, String startedTimestamp, String categoryName, BigInteger siteId, String siteName,
			String address, String city, String domain, String capacity, String siteCapacity, Integer customerId,
			String customerName, String customerLogoPath, String emSerialNo, String imageName, String imagePath,
			String sLogDate, String emrReading, String lmrValue, String lmrTimestamp, String plantDownTime,
			String reportImagePath, String reportTimeStamp, String customerSignature, String siteSignature) {
		this.ticketCode = ticketCode;
		this.startedTimestamp = startedTimestamp;
		this.categoryName = categoryName;
		this.siteId = siteId;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.domain = domain;
		this.capacity = capacity;
		this.siteCapacity = siteCapacity;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerLogoPath = customerLogoPath;
		this.emSerialNo = emSerialNo;
		this.imageName = imageName;
		this.imagePath = imagePath;
		this.sLogDate = sLogDate;
		this.emrReading = emrReading;
		this.lmrValue = lmrValue;
		this.lmrTimestamp = lmrTimestamp;
		this.plantDownTime = plantDownTime;
		this.reportImagePath = reportImagePath;
		this.reportTimeStamp = reportTimeStamp;
		this.customerSignature = customerSignature;
		this.siteSignature = siteSignature;
	}

	public String getReportTimeStamp() {
		return reportTimeStamp;
	}

	public void setReportTimeStamp(String reportTimeStamp) {
		this.reportTimeStamp = reportTimeStamp;
	}

	public String getReportImagePath() {
		return reportImagePath;
	}

	public void setReportImagePath(String reportImagePath) {
		this.reportImagePath = reportImagePath;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getStartedTimestamp() {
		return startedTimestamp;
	}

	public void setStartedTimestamp(String startedTimestamp) {
		this.startedTimestamp = startedTimestamp;
	}

	public String getLmrReading() {
		return lmrReading;
	}

	public void setLmrReading(String lmrReading) {
		this.lmrReading = lmrReading;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCustomerLogoPath() {
		return customerLogoPath;
	}

	public void setCustomerLogoPath(String customerLogoPath) {
		this.customerLogoPath = customerLogoPath;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public BigInteger getSiteId() {
		return siteId;
	}

	public void setSiteId(BigInteger siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getInstallationCapacity() {
		return installationCapacity;
	}

	public void setInstallationCapacity(BigDecimal installationCapacity) {
		this.installationCapacity = installationCapacity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getSiteCapacity() {
		return siteCapacity;
	}

	public void setSiteCapacity(String siteCapacity) {
		this.siteCapacity = siteCapacity;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmSerialNo() {
		return emSerialNo;
	}

	public void setEmSerialNo(String emSerialNo) {
		this.emSerialNo = emSerialNo;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getsLogDate() {
		return sLogDate;
	}

	public void setsLogDate(String sLogDate) {
		this.sLogDate = sLogDate;
	}

	public String getEmrReading() {
		return emrReading;
	}

	public void setEmrReading(String emrReading) {
		this.emrReading = emrReading;
	}

	public String getLmrValue() {
		return lmrValue;
	}

	public void setLmrValue(String lmrValue) {
		this.lmrValue = lmrValue;
	}

	public String getLmrTimestamp() {
		return lmrTimestamp;
	}

	public void setLmrTimestamp(String lmrTimestamp) {
		this.lmrTimestamp = lmrTimestamp;
	}

	public String getPlantDownTime() {
		return plantDownTime;
	}

	public void setPlantDownTime(String plantDownTime) {
		this.plantDownTime = plantDownTime;
	}

	public String getCmReading() {
		return cmReading;
	}

	public void setCmReading(String cmReading) {
		this.cmReading = cmReading;
	}

	public String getNetGeneration() {
		return netGeneration;
	}

	public void setNetGeneration(String netGeneration) {
		this.netGeneration = netGeneration;
	}

	public String getCustomerSignature() {
		return customerSignature;
	}

	public void setCustomerSignature(String customerSignature) {
		this.customerSignature = customerSignature;
	}

	public String getSiteSignature() {
		return siteSignature;
	}

	public void setSiteSignature(String siteSignature) {
		this.siteSignature = siteSignature;
	}

}