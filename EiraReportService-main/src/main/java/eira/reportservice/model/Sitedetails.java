package eira.reportservice.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "site_master", schema = "saas")
public class Sitedetails {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "siteid")
	private BigInteger siteId;

	@Column(name = "customerid")
	private Integer customerId;

	@Column(name = "sitetypeid")
	private BigInteger siteTypeId;

	@Column(name = "sectortypeid")
	private Integer sectorTypeId;

	@Column(name = "curing_data")
	private String curing_Data;

	@Column(name = "sitename")
	private String siteName;

	@Column(name = "sitedescription")
	private String siteDescription;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "postalcode")
	private String postalCode;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "sitelocationurl")
	private String siteLocationUrl;

	@Column(name = "installationcapacity")
	private BigDecimal installationCapacity;

	@Column(name = "status")
	private BigInteger Status;

	@Column(name = "dailygenbasedon")
	private BigInteger dailyGenBasedOn;

	@Column(name = "timezoneid")
	private BigInteger timeZoneId;

	@Column(name = "iscuringserviceenabled")
	private BigInteger isCuringServiceEnabled;

	@Column(name = "customalertcount")
	private BigInteger customAlertCount;

	@Column(name = "ticketcount")
	private BigInteger ticketCount;

	@Column(name = "sitecode")
	private String siteCode;

	@Column(name = "sitefrequency")
	private String siteFrequency;

	@Column(name = "createdby")
	private BigInteger createdBy;

	@Column(name = "lastupdatedby")
	private BigInteger lastUpdatedBy;

	@Column(name = "units")
	private String units;

	@Column(name = "modeoffiletransfer")
	private String modeOfFileTransfer;

	@Column(name = "energy_gen_based")
	private Integer energyGenBasedOn;

	@Column(name = "domain")
	private String domain;

	@Column(name = "isdirectorycreated")
	private int IsDirectoryCreated;

	@Column(name = "sitereference")
	private String siteReference;

	public String getSiteReference() {
		return siteReference;
	}

	public void setSiteReference(String siteReference) {
		this.siteReference = siteReference;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public BigInteger getSiteId() {
		return siteId;
	}

	public void setSiteId(BigInteger siteId) {
		this.siteId = siteId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigInteger getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(BigInteger siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public Integer getSectorTypeId() {
		return sectorTypeId;
	}

	public void setSectorTypeId(Integer sectorTypeId) {
		this.sectorTypeId = sectorTypeId;
	}

	public String getCuring_Data() {
		return curing_Data;
	}

	public void setCuring_Data(String curing_Data) {
		this.curing_Data = curing_Data;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSiteLocationUrl() {
		return siteLocationUrl;
	}

	public void setSiteLocationUrl(String siteLocationUrl) {
		this.siteLocationUrl = siteLocationUrl;
	}

	public BigDecimal getInstallationCapacity() {
		return installationCapacity;
	}

	public void setInstallationCapacity(BigDecimal installationCapacity) {
		this.installationCapacity = installationCapacity;
	}

	public BigInteger getStatus() {
		return Status;
	}

	public void setStatus(BigInteger status) {
		Status = status;
	}

	public BigInteger getDailyGenBasedOn() {
		return dailyGenBasedOn;
	}

	public void setDailyGenBasedOn(BigInteger dailyGenBasedOn) {
		this.dailyGenBasedOn = dailyGenBasedOn;
	}

	public BigInteger getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(BigInteger timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public BigInteger getIsCuringServiceEnabled() {
		return isCuringServiceEnabled;
	}

	public void setIsCuringServiceEnabled(BigInteger isCuringServiceEnabled) {
		this.isCuringServiceEnabled = isCuringServiceEnabled;
	}

	public BigInteger getCustomAlertCount() {
		return customAlertCount;
	}

	public void setCustomAlertCount(BigInteger customAlertCount) {
		this.customAlertCount = customAlertCount;
	}

	public BigInteger getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(BigInteger ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteFrequency() {
		return siteFrequency;
	}

	public void setSiteFrequency(String siteFrequency) {
		this.siteFrequency = siteFrequency;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public BigInteger getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigInteger lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getModeOfFileTransfer() {
		return modeOfFileTransfer;
	}

	public void setModeOfFileTransfer(String modeOfFileTransfer) {
		this.modeOfFileTransfer = modeOfFileTransfer;
	}

	public Integer getEnergyGenBasedOn() {
		return energyGenBasedOn;
	}

	public void setEnergyGenBasedOn(Integer energyGenBasedOn) {
		this.energyGenBasedOn = energyGenBasedOn;
	}

	public int getIsDirectoryCreated() {
		return IsDirectoryCreated;
	}

	public void setIsDirectoryCreated(int isDirectoryCreated) {
		IsDirectoryCreated = isDirectoryCreated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
