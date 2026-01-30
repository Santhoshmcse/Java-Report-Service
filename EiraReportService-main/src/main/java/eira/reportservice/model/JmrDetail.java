package eira.reportservice.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jmr_details", schema = "saas")
public class JmrDetail {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "jmrid")
	    private BigInteger jmrId;

	    @Column(name = "ticketid")
	    private BigInteger ticketId;
	    
	    @Column (name = "emserialno")
	    private String emSerialNo;
	    
	    @Column (name = "imagename")
	    private String imageName;
	    
	    
	    @Column (name = "imagepath")
	    private String imagePath;
	    
	    @Column (name = "emreading")
	    private String emrReading;
	    
	    @Column (name = "remarks")
	    private String remarks;
	    
	    @Column (name = "lmrtimestamp")
	    private String lmrTimeStamp;
	    
	    @Column (name = "lmrvalue")
	    private String lmrValue;
	    
	    @Column (name = "plantdowntime")
	    private String plantDownTime;
	    
	    @Column (name ="slogdate")
	    private String sLogDate;
	    
	    @Column (name = "status")
	    private Integer status;
	    
	    @Column (name = "createddate")
	    private String createdDate;
	    
	    @Column (name = "createdby")
	    private Integer createdBy;

	    @Column(name = "lastupdatedby")
	    private Integer lastUpdatedBy;
	    
	    @Column (name = "lastupdateddate")
	    private String lastUpdatedDate;
	    
	    @Column(name ="reportimagename")
	    private String reportImageName;
	    
	    @Column (name ="reportimagepath")
	    private String reportImagePath;
	    
	    @Column (name = "reporttimestamp")
	    private String reportTimeStamp;
	    
	    @Column (name ="transactionid")
	    private BigInteger transactionId;

		public BigInteger getJmrId() {
			return jmrId;
		}

		public void setJmrId(BigInteger jmrId) {
			this.jmrId = jmrId;
		}

		public BigInteger getTicketId() {
			return ticketId;
		}

		public void setTicketId(BigInteger ticketId) {
			this.ticketId = ticketId;
		}

		public String getEmSerialNo() {
			return emSerialNo;
		}

		public void setEmSerialNo(String emSerialNo) {
			this.emSerialNo = emSerialNo;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public String getImagePath() {
			return imagePath;
		}

		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}

		public String getEmrReading() {
			return emrReading;
		}

		public void setEmrReading(String emrReading) {
			this.emrReading = emrReading;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		

		public String getLmrTimeStamp() {
			return lmrTimeStamp;
		}

		public void setLmrTimeStamp(String lmrTimeStamp) {
			this.lmrTimeStamp = lmrTimeStamp;
		}

		public String getLmrValue() {
			return lmrValue;
		}

		public void setLmrValue(String lmrValue) {
			this.lmrValue = lmrValue;
		}

		public String getPlantDownTime() {
			return plantDownTime;
		}

		public void setPlantDownTime(String plantDownTime) {
			this.plantDownTime = plantDownTime;
		}

		public String getsLogDate() {
			return sLogDate;
		}

		public void setsLogDate(String sLogDate) {
			this.sLogDate = sLogDate;
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

		public String getReportImageName() {
			return reportImageName;
		}

		public void setReportImageName(String reportImageName) {
			this.reportImageName = reportImageName;
		}

		public String getReportImagePath() {
			return reportImagePath;
		}

		public void setReportImagePath(String reportImagePath) {
			this.reportImagePath = reportImagePath;
		}

		public String getReportTimeStamp() {
			return reportTimeStamp;
		}

		public void setReportTimeStamp(String reportTimeStamp) {
			this.reportTimeStamp = reportTimeStamp;
		}

		public BigInteger getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(BigInteger transactionId) {
			this.transactionId = transactionId;
		}
	    
	    
	    
}
