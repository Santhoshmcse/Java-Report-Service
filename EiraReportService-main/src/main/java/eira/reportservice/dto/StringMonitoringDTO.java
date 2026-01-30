package eira.reportservice.dto;

import java.math.BigDecimal;

public class StringMonitoringDTO {

	private String sm_Voltage;
	private String sm_Current;
	private String sm_Fuse;
	private String remarks;
	private String dLogDate;
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
	private String displayName;
	private Integer smbSequence;
    private Integer stringSequence;
    
    
	StringMonitoringDTO(String sm_Voltage, String sm_Current, String sm_Fuse, String remarks, String dLogDate,
			String ticketDetail, Integer customerId, String siteName, BigDecimal installationCapacity,
			String customerName, String customerLogoPath, String categoryName, String ticketCode, String ticketTypeName,
			String statusName,String displayName,Integer smbSequence,Integer stringSequence) {

		this.sm_Voltage = sm_Voltage;
		this.sm_Current = sm_Current;
		this.sm_Fuse = sm_Fuse;
		this.remarks = remarks;
		this.dLogDate = dLogDate;
		this.ticketDetail = ticketDetail;
		this.customerId = customerId;
		this.siteName = siteName;
		this.installationCapacity = installationCapacity;
		this.customerName = customerName;
		this.customerLogoPath = customerLogoPath;
		this.categoryName = categoryName;
		this.ticketCode = ticketCode;
		this.ticketTypeName = ticketTypeName;
		this.statusName = statusName;
		this.displayName = displayName;
		this.smbSequence = smbSequence;
		this.stringSequence = stringSequence;
	}

	// Getter and Setters

	public String getSm_Voltage() {
		return sm_Voltage;
	}

	public void setSm_Voltage(String sm_Voltage) {
		this.sm_Voltage = sm_Voltage;
	}

	public String getSm_Current() {
		return sm_Current;
	}

	public void setSm_Current(String sm_Current) {
		this.sm_Current = sm_Current;
	}

	public String getSm_Fuse() {
	    return "1".equals(sm_Fuse) ? "Yes" : "No";
	}


	public void setSm_Fuse(String sm_Fuse) {
		this.sm_Fuse = sm_Fuse;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public Integer getSmbSequence() {
		return smbSequence;
	}

	public void setSmbSequence(Integer smbSequence) {
		this.smbSequence = smbSequence;
	}

	public String getdLogDate() {
		return dLogDate;
	}

	public void setdLogDate(String dLogDate) {
		this.dLogDate = dLogDate;
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

	public BigDecimal getInstallationCapacity() {
		return installationCapacity;
	}

	public void setInstallationCapacity(BigDecimal installationCapacity) {
		this.installationCapacity = installationCapacity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStringSequence() {
		return stringSequence;
	}

	public void setStringSequence(Integer stringSequence) {
		this.stringSequence = stringSequence;
	}
	

}
