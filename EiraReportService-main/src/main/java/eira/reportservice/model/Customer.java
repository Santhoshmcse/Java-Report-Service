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
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "customer", schema = "saas")
@EqualsAndHashCode(callSuper = false)
public class Customer  implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "customername")
	private String customerName;
	
	@Column(name = "customerwebsite")
	private String customerWebsite;
	
	@Column(name = "address")
	private String address;
	
	@Column(name ="contactperson")
	private String contactPerson;
	
	@Column (name = "mobilenumber")
	private String mobileNumber;
	
	@Column (name = "emailid")
	private String emailId;
	
	@Column (name = "customerlogopath")
	private String customerLogoPath;
	
	@Column (name = "status")
	private Integer status;
	
	@Column (name = "createdby")
	private Integer createdBy;
	
	@Column (name = "createddate")
	private Timestamp createdDate;
	
	@Column (name = "lastupdatedby")
	private BigInteger lastUpdatedBy;
	
	@Column (name = "lastupdateddate")
	private Timestamp lastUpdatedDate;
	
	@Column (name = "state")
	private String state;
	
	@Column (name = "country")
	private String country;
	
	@Column (name = "logoname")
	private String logoName;
	
	@Column (name = "subscriptionid")
	private Integer subscriptionId;
	
	@Column (name = "companyId")
	private Integer companyId; 
	
	@Column (name = "usercount")
	private Integer userCount;

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

	public String getCustomerWebsite() {
		return customerWebsite;
	}

	public void setCustomerWebsite(String customerWebsite) {
		this.customerWebsite = customerWebsite;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerLogoPath() {
		return customerLogoPath;
	}

	public void setCustomerLogoPath(String customerLogoPath) {
		this.customerLogoPath = customerLogoPath;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public BigInteger getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigInteger lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
