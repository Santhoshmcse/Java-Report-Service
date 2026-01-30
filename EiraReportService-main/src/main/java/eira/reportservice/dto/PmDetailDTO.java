package eira.reportservice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PmDetailDTO {
	private BigInteger ticketId;
	private String ticketCode;
	private String remarks;
	private String completedTimestamp;
	private String siteName;
	private BigDecimal installationCapacity;
	private String siteReference;
	private Integer customerId;
	private String customerName;
	private String customerLogoPath;
	private Integer groupSequence;
	private String groupName;
	private String checkPoint;
	private String task;
	private String checkStatus;
	private String category;
	private String sequence;
	private String pmId;
	private String serialNumber;
	private String stringNumber;
	private String pmRemarks;
	private String othersRemarks;
	private String imagePath;
	private String sDate;
	private String domain;
	private String categoryName;
	private Integer checkCount;
	private Long taskCount;
	private Integer zeroCount;
	private String firstName;
	private String formattedSLogDate;
	private String lastUpdatedDate;
	private String ticketTypeName;

	// Constructor with all fields
	public PmDetailDTO(BigInteger ticketId, String ticketCode, String remarks, String completedTimestamp,
			String siteName, BigDecimal installationCapacity, String siteReference, Integer customerId,
			String customerName, String customerLogoPath, Integer groupSequence, String groupName, String checkPoint,
			String task, String checkStatus, String category, String sequence, String pmId, String serialNumber,
			String stringNumber, String pmRemarks, String othersRemarks, String imagePath, String sDate, String domain,
			String categoryName, String firstName, String lastUpdatedDate,String ticketTypeName, Integer checkCount, Long taskCount, Integer zeroCount) {
// Assign fields here

		this.ticketId = ticketId;
		this.ticketCode = ticketCode;
		this.remarks = remarks;
		this.completedTimestamp = completedTimestamp;
		this.siteName = siteName;
		this.installationCapacity = installationCapacity;
		this.siteReference = siteReference;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerLogoPath = customerLogoPath;
		this.groupSequence = groupSequence;
		this.groupName = groupName;
		this.checkPoint = checkPoint;
		this.task = task;
		this.checkStatus = checkStatus;
		this.category = category;
		this.sequence = sequence;
		this.pmId = pmId;
		this.serialNumber = serialNumber;
		this.stringNumber = stringNumber;
		this.pmRemarks = pmRemarks;
		this.othersRemarks = othersRemarks;
		this.imagePath = imagePath;
		this.sDate = sDate;
		this.domain = domain;
		this.categoryName = categoryName;
		this.checkCount = checkCount;
		this.taskCount = taskCount;
		this.zeroCount = zeroCount;
		this.firstName = firstName;
		this.lastUpdatedDate = lastUpdatedDate;
		this.ticketTypeName = ticketTypeName;
	}

	
	public String getTicketTypeName() {
		return ticketTypeName;
	}


	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}


	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSiteReference() {
		return siteReference;
	}

	public void setSiteReference(String siteReference) {
		this.siteReference = siteReference;
	}

	public String getOthersRemarks() {
		return othersRemarks;
	}

	public void setOthersRemarks(String othersRemarks) {
		this.othersRemarks = othersRemarks;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getFormattedSLogDate() {
		return formattedSLogDate;
	}

	public void setFormattedSLogDate(String formattedSLogDate) {
		this.formattedSLogDate = formattedSLogDate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getZeroCount() {
		return zeroCount;
	}

	public void setZeroCount(Integer zeroCount) {
		this.zeroCount = zeroCount;
	}

	public Long getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Long taskCount) {
		this.taskCount = taskCount;
	}

	public String getCustomerLogoPath() {
		return customerLogoPath;
	}

	public void setCustomerLogoPath(String customerLogoPath) {
		this.customerLogoPath = customerLogoPath;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public BigInteger getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigInteger ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public String getPmId() {
		return pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCompletedTimestamp() {
		return completedTimestamp;
	}

	public void setCompletedTimestamp(String completedTimestamp) {
		this.completedTimestamp = completedTimestamp;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public BigDecimal getInstallationCapacity() {
		return installationCapacity;
	}

	public void setInstallationCapacity(BigDecimal installationCapacity) {
		this.installationCapacity = installationCapacity;
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

	public Integer getGroupSequence() {
		return groupSequence;
	}

	public void setGroupSequence(Integer groupSequence) {
		this.groupSequence = groupSequence;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStringNumber() {
		return stringNumber;
	}

	public void setStringNumber(String stringNumber) {
		this.stringNumber = stringNumber;
	}

	public String getPmRemarks() {
		return pmRemarks;
	}

	public void setPmRemarks(String pmRemarks) {
		this.pmRemarks = pmRemarks;
	}

	public Integer getCheckCount() {
		return checkCount;
	}

	public void setCheckCount(Integer checkCount) {
		this.checkCount = checkCount;
	}

}
