package eira.reportservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticketstatus", schema = "saas")
public class TicketStatus implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketstatusid")
	private BigInteger ticketStatusId;
	
	@Column(name = "statusname")
	private String statusName;
	
	@Column (name = "createddate")
	private Timestamp createdDate;

	public BigInteger getTicketStatusId() {
		return ticketStatusId;
	}

	public void setTicketStatusId(BigInteger ticketStatusId) {
		this.ticketStatusId = ticketStatusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
