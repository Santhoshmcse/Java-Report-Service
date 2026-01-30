
package eira.reportservice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
public class PictureRepositoryDTO {
	private Integer reportSeq; // Added field to match query
	private String beforePictureServerPath;
	private String afterPictureServerPath;
	private String sequence;
	private BigInteger siteId;
	private String ticketDetail;
	private Integer customerId;
	private String siteName;

	private BigDecimal installationCapacity;
	private String customerName;
	private String customerLogoPath;
	private String categoryName;
	private String ticketCode;
	private String ticketTypeName;
	private String statusName;
	private String listName;
	private Integer beforePictureStatus;
	private Integer afterPictureStatus;
	private String groupName;
	private String beforePicturedLogdate;
	private String afterPicturedLogdate;
	private String energymeterserverPath;
	private String servicemeterserverPath;
	private String domain;
	private String siteReference;
	private String firstName;
	private String lastUpdatedDate;
	private String displayName;
	
	
	// Formatter to parse and format date strings
		private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


	// Corrected constructor with all parameters in the right order
	public PictureRepositoryDTO(Integer reportSeq, String beforePictureServerPath, String afterPictureServerPath,
			String sequence, BigInteger siteId, String ticketDetail, Integer customerId, String siteName, String domain,
			String siteReference,BigDecimal installationCapacity, String customerName, String customerLogoPath, String categoryName,
			String ticketCode, String ticketTypeName, String statusName, String listName, Integer beforePictureStatus,
			Integer afterPictureStatus, String groupName, String beforePicturedLogdate, String afterPicturedLogdate,
			String firstName, String lastUpdatedDate, String displayName, String energymeterserverPath,
			String servicemeterserverPath) {
		this.reportSeq = reportSeq;
		this.beforePictureServerPath = beforePictureServerPath;
		this.afterPictureServerPath = afterPictureServerPath;
		this.sequence = sequence;
		this.siteId = siteId;
		this.ticketDetail = ticketDetail;
		this.customerId = customerId;
		this.siteName = siteName;
		this.domain = domain;
		this.siteReference = siteReference;
		this.firstName = firstName;
		this.lastUpdatedDate = lastUpdatedDate;
		this.displayName = displayName;
		this.installationCapacity = installationCapacity;
		this.customerName = customerName;
		this.ticketCode = ticketCode;
		this.ticketTypeName = ticketTypeName;
		this.statusName = statusName;
		this.listName = listName;
		this.beforePictureStatus = beforePictureStatus;
		this.afterPictureStatus = afterPictureStatus;
		this.groupName = groupName;
		this.beforePicturedLogdate = beforePicturedLogdate;
		this.afterPicturedLogdate = afterPicturedLogdate;
		this.customerLogoPath = customerLogoPath;
		this.categoryName = categoryName;
		this.energymeterserverPath = energymeterserverPath;
		this.servicemeterserverPath = servicemeterserverPath;
	}

	public String getSiteReference() {
		return siteReference;
	}

	public void setSiteReference(String siteReference) {
		this.siteReference = siteReference;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getBeforePictureStatus() {
		return beforePictureStatus;
	}

	public void setBeforePictureStatus(Integer beforePictureStatus) {
		this.beforePictureStatus = beforePictureStatus;
	}

	public Integer getAfterPictureStatus() {
		return afterPictureStatus;
	}

	public void setAfterPictureStatus(Integer afterPictureStatus) {
		this.afterPictureStatus = afterPictureStatus;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public PictureRepositoryDTO(String categoryName) {
		this.categoryName = categoryName;
	}

	public PictureRepositoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	// Getter for beforePicturedLogdate with IST time offset
    public String getBeforePicturedLogdate() {
        return applyISTOffset(beforePicturedLogdate);
    }

    // Setter for beforePicturedLogdate
    public void setBeforePicturedLogdate(String beforePicturedLogdate) {
        this.beforePicturedLogdate = beforePicturedLogdate;
    }

    // Getter for afterPicturedLogdate with IST time offset
    public String getAfterPicturedLogdate() {
        return applyISTOffset(afterPicturedLogdate);
    }

    // Setter for afterPicturedLogdate
    public void setAfterPicturedLogdate(String afterPicturedLogdate) {
        this.afterPicturedLogdate = afterPicturedLogdate;
    }


	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getCustomerLogoPath() {
		return customerLogoPath;
	}

	public void setCustomerLogoPath(String customerLogoPath) {
		this.customerLogoPath = customerLogoPath;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getReportSeq() {
		return reportSeq;
	}

	public void setReportSeq(Integer reportSeq) {
		this.reportSeq = reportSeq;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	// Getters and setters
	public String getBeforePictureServerPath() {
		return beforePictureServerPath;
	}

	public void setBeforePictureServerPath(String beforePictureServerPath) {
		this.beforePictureServerPath = beforePictureServerPath;
	}

	public String getAfterPictureServerPath() {
		return afterPictureServerPath;
	}

	public void setAfterPictureServerPath(String afterPictureServerPath) {
		this.afterPictureServerPath = afterPictureServerPath;
	}

	public BigInteger getSiteId() {
		return siteId;
	}

	public void setSiteId(BigInteger siteId) {
		this.siteId = siteId;
	}

	public String getTicketDetail() {
		return ticketDetail;
	}

	public void setTicketDetail(String ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public BigDecimal getInstallationCapacity() { // Corrected getter
		return installationCapacity;
	}

	public void setInstallationCapacity(BigDecimal installationCapacity) { // Corrected setter
		this.installationCapacity = installationCapacity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		System.out.println("Energy Meter Path: " + customerName);
		this.customerName = customerName;
	}

	public String getEnergymeterserverPath() {
		return energymeterserverPath;
	}

	public void setEnergymeterserverPath(String energymeterserverPath) {
		this.energymeterserverPath = energymeterserverPath;
	}

	public String getServicemeterserverPath() {
		return servicemeterserverPath;
	}

	public void setServicemeterserverPath(String servicemeterserverPath) {
		this.servicemeterserverPath = servicemeterserverPath;
	}
	
	 // Helper method to apply IST (+5:30) offset
    private String applyISTOffset(String date) {
        if (date != null && !date.isEmpty()) {
            LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
            // Apply +5 hours and 30 minutes offset for IST (UTC+5:30)
            OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC).withOffsetSameInstant(ZoneOffset.ofHoursMinutes(5, 30));
            return offsetDateTime.format(formatter);
        }
        return date;
    }
	@Override
	public String toString() {
		return "PictureRepositoryDTO{" + "reportSeq=" + reportSeq + ", beforePictureServerPath='"
				+ beforePictureServerPath + '\'' + ", afterPictureServerPath='" + afterPictureServerPath + '\''
				+ ", sequence=" + sequence + ", siteId=" + siteId + ", ticketDetail='" + ticketDetail + '\''
				+ ", customerId=" + customerId + ", siteName='" + siteName + '\'' + ", installationCapacity="
				+ installationCapacity + ", customerName='" + customerName + '\'' + ", customerLogoPath='"
				+ customerLogoPath + '\'' + ", categoryName='" + categoryName + '\'' + ", ticketCode='" + ticketCode
				+ '\'' + ", ticketTypeName='" + ticketTypeName + '\'' + ", statusName='" + statusName + '\''
				+ ", listName='" + listName + '\'' + ", groupName='" + groupName + '\'' + ", beforePicturedLogdate="
				+ beforePicturedLogdate + ", afterPicturedLogdate=" + afterPicturedLogdate + ", energymeterserverPath='"
				+ energymeterserverPath + '\'' + ", servicemeterserverPath='" + servicemeterserverPath + '\'' + '}';
	}

}
