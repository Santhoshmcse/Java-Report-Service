package eira.reportservice.model;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickettransaction", schema = "saas")
public class TicketTransaction implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionid")
	private BigInteger transactionId;

	@Column(name = "ticketid")
	private BigInteger ticketId;

	@Column(name = "assignedto")
	private BigInteger assignedTo;

	@Column(name = "ticketstatusid")
	private BigInteger ticketStatusId;

	@Column(name = "createdby")
	private BigInteger createdBy;

	@Column(name = "description")
	private String description;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "daycycle")
	private Integer dayCycle;

	@Column(name = "createddate")
	private String createdDate;

	@Column(name = "lastupdateddate")
	private String lastUpdatedDate;

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

	public BigInteger getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(BigInteger assignedTo) {
		this.assignedTo = assignedTo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getDayCycle() {
		return dayCycle;
	}

	public void setDayCycle(Integer dayCycle) {
		this.dayCycle = dayCycle;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
