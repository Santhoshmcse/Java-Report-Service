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
@Table(name = "preventive_maintenance", schema = "saas")
@EqualsAndHashCode(callSuper = false)
public class PreventiveMaintenance {
	
	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pmid")
	private String pmId;
	
	@Column(name = "groupname")
	private String groupName;
	
	@Column (name = "sequence")
	private String sequence;
	
	@Column (name= "checkpoint")
	private String checkPoint;
	
	@Column (name= "task")
	private String task;

	@Column (name= "imagerequired")
	private Integer imageRequired;
	
	@Column (name= "mandatoryflag")
	private String mandatoryFlag;
	
	@Column (name ="checktype")
	private Integer checkType;
	
	@Column (name = "serialnumberrequired")
	private Integer serialNumberRequired;
	
	@Column (name = "stringnumberrequired")
	private Integer stringNumberRequired;
	
	@Column (name ="groupsequence")
	private Integer groupSequence;
	
	@Column (name = "status")
	private Integer status;
	
	@Column (name ="createddate")
	private String createdDate;
	
	@Column (name = "createdby")
	private Integer createdBy;
	
	@Column (name ="lastupdatedby")
	private Integer lastupdatedBy;
	
	@Column (name ="lastupdateddate")
	private String lastupdatedDate;
	
	@Column (name ="category")
	private String category;

	

	public String getPmId() {
		return pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
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

	public Integer getImageRequired() {
		return imageRequired;
	}

	public void setImageRequired(Integer imageRequired) {
		this.imageRequired = imageRequired;
	}

	public String getMandatoryFlag() {
		return mandatoryFlag;
	}

	public void setMandatoryFlag(String mandatoryFlag) {
		this.mandatoryFlag = mandatoryFlag;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getSerialNumberRequired() {
		return serialNumberRequired;
	}

	public void setSerialNumberRequired(Integer serialNumberRequired) {
		this.serialNumberRequired = serialNumberRequired;
	}

	public Integer getStringNumberRequired() {
		return stringNumberRequired;
	}

	public void setStringNumberRequired(Integer stringNumberRequired) {
		this.stringNumberRequired = stringNumberRequired;
	}

	public Integer getGroupSequence() {
		return groupSequence;
	}

	public void setGroupSequence(Integer groupSequence) {
		this.groupSequence = groupSequence;
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

	public Integer getLastupdatedBy() {
		return lastupdatedBy;
	}

	public void setLastupdatedBy(Integer lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	public String getLastupdatedDate() {
		return lastupdatedDate;
	}

	public void setLastupdatedDate(String lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
