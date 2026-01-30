package eira.reportservice.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_master", schema = "saas")
public class EquipmentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipmentid")
    private BigInteger equipmentId;

    @Column(name = "equipmenttypeid")
    private BigInteger equipmentTypeId;

    @Column(name = "equipmentcategoryid")
    private BigInteger equipmentCategoryId;

    @Column(name = "siteid")
    private BigInteger siteId;

    @Column(name = "isprimaryequipment")
    private Boolean isPrimaryEquipment;

    @Column(name = "serialno")
    private String serialNo;

    @Column(name = "primarymapequipment")
    private BigInteger primaryMapEquip;

    @Column(name = "description")
    private String description;

    @Column(name = "displayname")
    private String displayName;

    @Column(name = "device_sn")
    private String deviceSn;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "modbusaddress")
    private String modBusAddress;

    @Column(name = "accapacity")
    private BigDecimal acCapacity;

    @Column(name = "acunits")
    private String acUnits;

    @Column(name = "dcunits")
    private String dcUnits;

    @Column(name = "dccapacity")
    private BigDecimal dcCapacity;

    @Column(name = "noofcomponents")
    private BigInteger noOfComponents;

    @Column(name = "disconnectrating")
    private String disconnectRating;

    @Column(name = "disconnecttype")
    private String disconnectType;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "ftpdefdevicesn")
    private String ftpDefDeviceSn;

    @Column(name = "dataloggerid")
    private BigInteger dataLoggerId;

    @Column(name = "isreplaced")
    private Boolean isReplaced;

    @Column(name = "replacecount")
    private BigInteger replaceCount;

    @Column(name = "prodflag")
    private BigInteger prodFlag;

    @Column(name = "statusmasterid")
    private BigInteger statusMasterId;

    @Column(name = "dailygenbasedon")
    private BigInteger dailyGenBasedOn;

    @Column(name = "status")
    private BigInteger status;

    @Column(name = "lastreplacedon")
    private Timestamp lastReplacedOn;

    @Column(name = "createdby")
    private BigInteger createdBy;

    @Column(name = "lastupdatedby")
    private BigInteger lastUpdatedBy;

    @Column(name = "is_configured")
    private Boolean isConfigured;

    @Column(name = "warranty_date")
    private Timestamp warrantyDate;

    @Column(name = "installation_date")
    private Timestamp installationDate;

    @Column(name = "energycounter")
    private Integer energyCounter;

    // Getters and setters
    public BigInteger getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(BigInteger equipmentId) {
        this.equipmentId = equipmentId;
    }

    public BigInteger getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(BigInteger equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public BigInteger getEquipmentCategoryId() {
        return equipmentCategoryId;
    }

    public void setEquipmentCategoryId(BigInteger equipmentCategoryId) {
        this.equipmentCategoryId = equipmentCategoryId;
    }

    public BigInteger getSiteId() {
        return siteId;
    }

    public void setSiteId(BigInteger siteId) {
        this.siteId = siteId;
    }

    public Boolean getIsPrimaryEquipment() {
        return isPrimaryEquipment;
    }

    public void setIsPrimaryEquipment(Boolean isPrimaryEquipment) {
        this.isPrimaryEquipment = isPrimaryEquipment;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public BigInteger getPrimaryMapEquip() {
        return primaryMapEquip;
    }

    public void setPrimaryMapEquip(BigInteger primaryMapEquip) {
        this.primaryMapEquip = primaryMapEquip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getModBusAddress() {
        return modBusAddress;
    }

    public void setModBusAddress(String modBusAddress) {
        this.modBusAddress = modBusAddress;
    }

    public BigDecimal getAcCapacity() {
        return acCapacity;
    }

    public void setAcCapacity(BigDecimal acCapacity) {
        this.acCapacity = acCapacity;
    }

    public String getAcUnits() {
        return acUnits;
    }

    public void setAcUnits(String acUnits) {
        this.acUnits = acUnits;
    }

    public String getDcUnits() {
        return dcUnits;
    }

    public void setDcUnits(String dcUnits) {
        this.dcUnits = dcUnits;
    }

    public BigDecimal getDcCapacity() {
        return dcCapacity;
    }

    public void setDcCapacity(BigDecimal dcCapacity) {
        this.dcCapacity = dcCapacity;
    }

    public BigInteger getNoOfComponents() {
        return noOfComponents;
    }

    public void setNoOfComponents(BigInteger noOfComponents) {
        this.noOfComponents = noOfComponents;
    }

    public String getDisconnectRating() {
        return disconnectRating;
    }

    public void setDisconnectRating(String disconnectRating) {
        this.disconnectRating = disconnectRating;
    }

    public String getDisconnectType() {
        return disconnectType;
    }

    public void setDisconnectType(String disconnectType) {
        this.disconnectType = disconnectType;
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

    public String getFtpDefDeviceSn() {
        return ftpDefDeviceSn;
    }

    public void setFtpDefDeviceSn(String ftpDefDeviceSn) {
        this.ftpDefDeviceSn = ftpDefDeviceSn;
    }

    public BigInteger getDataLoggerId() {
        return dataLoggerId;
    }

    public void setDataLoggerId(BigInteger dataLoggerId) {
        this.dataLoggerId = dataLoggerId;
    }

    public Boolean getIsReplaced() {
        return isReplaced;
    }

    public void setIsReplaced(Boolean isReplaced) {
        this.isReplaced = isReplaced;
    }

    public BigInteger getReplaceCount() {
        return replaceCount;
    }

    public void setReplaceCount(BigInteger replaceCount) {
        this.replaceCount = replaceCount;
    }

    public BigInteger getProdFlag() {
        return prodFlag;
    }

    public void setProdFlag(BigInteger prodFlag) {
        this.prodFlag = prodFlag;
    }

    public BigInteger getStatusMasterId() {
        return statusMasterId;
    }

    public void setStatusMasterId(BigInteger statusMasterId) {
        this.statusMasterId = statusMasterId;
    }

    public BigInteger getDailyGenBasedOn() {
        return dailyGenBasedOn;
    }

    public void setDailyGenBasedOn(BigInteger dailyGenBasedOn) {
        this.dailyGenBasedOn = dailyGenBasedOn;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public Timestamp getLastReplacedOn() {
        return lastReplacedOn;
    }

    public void setLastReplacedOn(Timestamp lastReplacedOn) {
        this.lastReplacedOn = lastReplacedOn;
    }

    public Boolean getIsConfigured() {
        return isConfigured;
    }

    public void setIsConfigured(Boolean isConfigured) {
        this.isConfigured = isConfigured;
    }

    public Timestamp getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Timestamp warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public Timestamp getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Timestamp installationDate) {
        this.installationDate = installationDate;
    }

    public Integer getEnergyCounter() {
        return energyCounter;
    }

    public void setEnergyCounter(Integer energyCounter) {
        this.energyCounter = energyCounter;
    }
}

