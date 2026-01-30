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
@Table(name = "tickettype", schema = "saas")
public class TicketType implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tickettypeid")
	private BigInteger ticketTypeId;
	
	@Column(name = "tickettypename")
	private String ticketTypeName;
	
	@Column(name ="status")
	private Integer status;
	
	@Column (name = "createddate")
	private Timestamp createdDate;
	
	@Column (name = "createdby")
	private Integer createdBy;
	
	@Column( name = "lastupdateddate")
	private Timestamp lastUpdatedDate;

	
	
	// getter and setters
	
	public BigInteger getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(BigInteger ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
