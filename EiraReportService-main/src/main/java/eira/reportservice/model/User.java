package eira.reportservice.model;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "muser" , schema = "saas")
public class User implements Serializable {
    
    private static final long serialVersionUID = -723583058586873479L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "emailid")
    private String emailId;
    @Column(name = "status")
    private Integer status;
    @Column(name = "mobileno")
    private String mobileNo;
    @Column(name = "customerid")
    private Integer customerId;
    @Column(name = "postalcode")
    private Integer postalCode;
    @Column(name = "createdby")
    private Integer createdBy;
    @Column(name = "createddate")
    private Date createdDate;
    @Column(name = "lastupdatedby")
    private Integer lastupdatedBy;
    @Column(name = "encryptedpassword")
    private String encryptedPassword;
    @Column(name = "isnewuser")
    private Boolean isnewUser;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "lastupdateddate")
    private Date lastupdatedDate;
    @Column(name = "roleid")
    private Integer roleId;
    @Column(name = "designation")
    private String designation;
    @Column(name = "first_login")
    private Boolean first_Login;
    @Column(name = "login_attempt")
    private Integer login_Attempt;
    @Column(name = "attempt_timestamp")
    private String attempt_Timestamp;
    @Column(name = "usertypeid")
    private Integer usertypeId;
    @Column(name = "companyid")
    private Integer companyId;
    @Column(name = "deviceid")
    private String deviceId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getLastupdatedBy() {
		return lastupdatedBy;
	}
	public void setLastupdatedBy(Integer lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public Boolean getIsnewUser() {
		return isnewUser;
	}
	public void setIsnewUser(Boolean isnewUser) {
		this.isnewUser = isnewUser;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Boolean getFirst_Login() {
		return first_Login;
	}
	public void setFirst_Login(Boolean first_Login) {
		this.first_Login = first_Login;
	}
	public Integer getLogin_Attempt() {
		return login_Attempt;
	}
	public void setLogin_Attempt(Integer login_Attempt) {
		this.login_Attempt = login_Attempt;
	}
	public String getAttempt_Timestamp() {
		return attempt_Timestamp;
	}
	public void setAttempt_Timestamp(String attempt_Timestamp) {
		this.attempt_Timestamp = attempt_Timestamp;
	}
	public Integer getUsertypeId() {
		return usertypeId;
	}
	public void setUsertypeId(Integer usertypeId) {
		this.usertypeId = usertypeId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}

