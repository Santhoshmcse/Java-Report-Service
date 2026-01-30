package eira.reportservice.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "string_monitoring", schema = "saas")
public class StringMonitoring {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stringmonitoringid")
	private BigInteger stringMonitoringId;

	@Column(name = "ticketid")
	private BigInteger ticketId;

	@Column(name = "equipmentid")
	private BigInteger equipmentId;

	@Column(name = "smbsequence")
	private Integer smbSequence;

	@Column(name = "stringsequence")
	private Integer stringSequence;

	@Column(name = "sm_voltage")
	private String sm_Voltage;

	@Column(name = "sm_current")
	private String sm_Current;

	@Column(name = "sm_fuse")
	private String sm_Fuse;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "timestamp")
	private String timestamp;

	@Column(name = "dlogdate")
	private String dLogDate;

	@Column(name = "status")
	private Integer status;

	@Column(name = "createddate")
	private String createdDate;

	@Column(name = "createdby")
	private Integer createdBy;

	@Column(name = "lastupdatedby")
	private Integer lastUpdatedBy;

	@Column(name = "lastupdateddate")
	private String lastUpdatedDate;

	public BigInteger getStringMonitoringId() {
		return stringMonitoringId;
	}

	public void setStringMonitoringId(BigInteger stringMonitoringId) {
		this.stringMonitoringId = stringMonitoringId;
	}

	public BigInteger getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigInteger ticketId) {
		this.ticketId = ticketId;
	}

	public BigInteger getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(BigInteger equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Integer getSmbSequence() {
		return smbSequence;
	}

	public void setSmbSequence(Integer smbSequence) {
		this.smbSequence = smbSequence;
	}

	public Integer getStringSequence() {
		return stringSequence;
	}

	public void setStringSequence(Integer stringSequence) {
		this.stringSequence = stringSequence;
	}

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
		return sm_Fuse;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getdLogDate() {
		return dLogDate;
	}

	public void setdLogDate(String dLogDate) {
		this.dLogDate = dLogDate;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
