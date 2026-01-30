package eira.reportservice.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "preventive_maintenance_details", schema = "saas")
@EqualsAndHashCode(callSuper = false)
public class PreventiveMaintainanceDetail {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionid")
	private BigInteger transactionId;

	@Column(name = "ticketid")
	private BigInteger ticketId;

	@Column(name = "pmid")
	private String pmId;

	@Column(name = "checkstatus")
	private String checkStatus;

	@Column(name = "serialnumber")
	private String serialNumber;

	@Column(name = "stringnumber")
	private String stringNumber;

	@Column(name = "imagepath")
	private String imagePath;

	@Column(name = "mdate")
	private String mDate;

	@Column(name = "sdate")
	private String sDate;

	@Column(name = "status")
	private Integer status;

	@Column(name = "createddate")
	private String createdDate;

	@Column(name = "lastupdateddate")
	private String lastUpdatedDate;

	@Column(name = "lastupdatedby")
	private Integer lastUpdatedBy;

	@Column(name = "crestedby")
	private Integer createdBy;

	@Column(name = "checktype")
	private Integer checkType;

	@Column(name = "pmremarks")
	private String pmRemarks;
	
	@Column(name = "others_remarks")
	private String othersRemarks;
	
	

	public String getOthersRemarks() {
		return othersRemarks;
	}

	public void setOthersRemarks(String othersRemarks) {
		this.othersRemarks = othersRemarks;
	}

	public BigInteger getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}

	public BigInteger getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigInteger ticketId) {
		this.ticketId = ticketId;
	}

	public String getPmId() {
		return pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public String getPmRemarks() {
		return pmRemarks;
	}

	public void setPmRemarks(String pmRemarks) {
		this.pmRemarks = pmRemarks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
