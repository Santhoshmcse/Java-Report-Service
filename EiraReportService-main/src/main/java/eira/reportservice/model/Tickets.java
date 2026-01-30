package eira.reportservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticketdetails", schema = "saas")
public class Tickets implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketid")
	private BigInteger ticketId;

	@Column(name = "siteid")
	private BigInteger siteId;

	@Column(name = "description")
	private String description;

	@Column(name = "assignedto")
	private BigInteger assignedTo;

	@Column(name = "startedtimestamp")
	private String startedTimestamp;

	@Column(name = "closedtimestamp")
	private LocalDateTime closedTimestamp;

	@Column(name = "equipmentid")
	private BigInteger equipmentId;

	@Column(name = "ticketstatusid")
	private BigInteger ticketStatusId;

	@Column(name = "createdby")
	private BigInteger createdBy;

	@Column(name = "createddate")
	private LocalDateTime createdDate;

	@Column(name = "lastupdateddate")
	private String lastUpdatedDate;

	@Column(name = "lastupdatedby")
	private BigInteger lastupdatedBy;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "ticketstateid")
	private BigInteger ticketStateId;

	@Column(name = "tickettypeid")
	private BigInteger ticketTypeId;

	@Column(name = "ticketcategoryid")
	private BigInteger ticketCategoryId;

	@Column(name = "ticketdetail")
	private String ticketDetail;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "scheduleon")
	private LocalDateTime scheduleOn;

	@Column(name = "daycycle")
	private Integer dayCycle;

	@Column(name = "ticketcode")
	private String ticketCode;
	
	@Column (name = "completedtimestamp")
	private String completedTimestamp;

	@Column(name = "uploadflag")
	private BigInteger uploadFlag;

	// Getters and Setters
	public BigInteger getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigInteger ticketId) {
		this.ticketId = ticketId;
	}

	public BigInteger getLastupdatedBy() {
		return lastupdatedBy;
	}

	public void setLastupdatedBy(BigInteger lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	public BigInteger getUploadFlag() {
		return uploadFlag;
	}

	public void setUploadFlag(BigInteger uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	public BigInteger getSiteId() {
		return siteId;
	}

	public void setSiteId(BigInteger siteId) {
		this.siteId = siteId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(BigInteger assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStartedTimestamp() {
		return startedTimestamp;
	}

	public void setStartedTimestamp(String startedTimestamp) {
		this.startedTimestamp = startedTimestamp;
	}

	public LocalDateTime getClosedTimestamp() {
		return closedTimestamp;
	}

	public void setClosedTimestamp(LocalDateTime closedTimestamp) {
		this.closedTimestamp = closedTimestamp;
	}

	public BigInteger getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(BigInteger equipmentId) {
		this.equipmentId = equipmentId;
	}

	public BigInteger getTicketStatusId() {
		return ticketStatusId;
	}

	public void setTicketStatusId(BigInteger ticketStatusId) {
		this.ticketStatusId = ticketStatusId;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigInteger getTicketStateId() {
		return ticketStateId;
	}

	public void setTicketStateId(BigInteger ticketStateId) {
		this.ticketStateId = ticketStateId;
	}

	public BigInteger getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(BigInteger ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public BigInteger getTicketCategoryId() {
		return ticketCategoryId;
	}

	public void setTicketCategoryId(BigInteger ticketCategoryId) {
		this.ticketCategoryId = ticketCategoryId;
	}

	public String getTicketDetail() {
		return ticketDetail;
	}

	public void setTicketDetail(String ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getScheduleOn() {
		return scheduleOn;
	}

	public void setScheduleOn(LocalDateTime scheduleOn) {
		this.scheduleOn = scheduleOn;
	}

	public Integer getDayCycle() {
		return dayCycle;
	}

	public void setDayCycle(Integer dayCycle) {
		this.dayCycle = dayCycle;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public BigInteger getLastUpdatedBy() {
		return lastupdatedBy;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCompletedTimestamp() {
		return completedTimestamp;
	}

	public void setCompletedTimestamp(String completedTimestamp) {
		this.completedTimestamp = completedTimestamp;
	}
	

}
