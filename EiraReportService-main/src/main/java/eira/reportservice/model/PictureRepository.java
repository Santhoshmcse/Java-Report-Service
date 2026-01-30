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
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "picture_repository", schema = "saas")
@EqualsAndHashCode(callSuper = false)
public class PictureRepository implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionid")
	private BigInteger transactionId;

	@Column(name = "ticketid")
	private BigInteger ticketId;

	@Column(name = "groupsequence")
	private Integer groupSequence;

	@Column(name = "groupname")
	private String groupName;

	@Column(name = "listname")
	private String listName;

	@Column(name = "listsequence")
	private int listSequence;

	@Column(name = "sequence")
	private String sequence;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	@Column(name = "picturetype")
	private int pictureType;

	@Column(name = "beforepicturename")
	private String beforePictureName;

	@Column(name = "beforepictureserverpath")
	private String beforePictureServerPath;

	@Column(name = "beforepicturelocalpath")
	private String beforePictureLocalPath;

	@Column(name = "beforepicturedlogdate")
	private String beforePicturedLogdate;

	@Column(name = "beforepicturestatus")
	private int beforePictureStatus;

	@Column(name = "afterpicturename")
	private String afterPictureName;

	@Column(name = "afterpictureserverpath")
	private String afterPictureServerPath;

	@Column(name = "afterpicturelocalpath")
	private String afterPictureLocalPath;

	@Column(name = "afterpicturedlogdate", nullable = true)
	private String afterPicturedLogdate;

	@Column(name = "afterpicturestatus")
	private int afterPictureStatus;

	@Column(name = "status")
	private int status;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@Column(name = "equipmentid")
	private int equipmentId;

	@Column(name = "createdby")
	private int createdBy;

	@Column(name = "lastupdatedby")
	private int lastUpdatedBy;

	@Column(name = "lastupdateddate")
	private Timestamp lastUpdatedDate;

	@Transient
	private String energymeterserverPath;

	@Transient
	private String servicemeterserverPath;

	public String getEnergymeterserverPath() {
		return energymeterserverPath;
	}

	public void setEnergymeterserverPath(String energymeterserverPath) {
		this.energymeterserverPath = energymeterserverPath;
	}

	public String getServicemeterserverPath() {
		return servicemeterserverPath;
	}

	public void setServicemeterserverPath(String servicemeterserverPath) {
		this.servicemeterserverPath = servicemeterserverPath;
	}

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

	public Integer getGroupSequence() {
		return groupSequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public void setGroupSequence(Integer groupSequence) {
		this.groupSequence = groupSequence;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public int getListSequence() {
		return listSequence;
	}

	public void setListSequence(int listSequence) {
		this.listSequence = listSequence;
	}

	public String getSequence() {
		return sequence;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getPictureType() {
		return pictureType;
	}

	public void setPictureType(int pictureType) {
		this.pictureType = pictureType;
	}

	public String getBeforePictureName() {
		return beforePictureName;
	}

	public void setBeforePictureName(String beforePictureName) {
		this.beforePictureName = beforePictureName;
	}

	public String getBeforePictureServerPath() {
		return beforePictureServerPath;
	}

	public void setBeforePictureServerPath(String beforePictureServerPath) {
		this.beforePictureServerPath = beforePictureServerPath;
	}

	public String getBeforePictureLocalPath() {
		return beforePictureLocalPath;
	}

	public void setBeforePictureLocalPath(String beforePictureLocalPath) {
		this.beforePictureLocalPath = beforePictureLocalPath;
	}

	public String getBeforePicturedLogdate() {
		return beforePicturedLogdate;
	}

	public void setBeforePicturedLogdate(String beforePicturedLogdate) {
		this.beforePicturedLogdate = beforePicturedLogdate;
	}

	public int getBeforePictureStatus() {
		return beforePictureStatus;
	}

	public void setBeforePictureStatus(int beforePictureStatus) {
		this.beforePictureStatus = beforePictureStatus;
	}

	public String getAfterPictureName() {
		return afterPictureName;
	}

	public void setAfterPictureName(String afterPictureName) {
		this.afterPictureName = afterPictureName;
	}

	public String getAfterPictureServerPath() {
		return afterPictureServerPath;
	}

	public void setAfterPictureServerPath(String afterPictureServerPath) {
		this.afterPictureServerPath = afterPictureServerPath;
	}

	public String getAfterPictureLocalPath() {
		return afterPictureLocalPath;
	}

	public void setAfterPictureLocalPath(String afterPictureLocalPath) {
		this.afterPictureLocalPath = afterPictureLocalPath;
	}

	public String getAfterPicturedLogdate() {
		return afterPicturedLogdate;
	}

	public void setAfterPicturedLogdate(String afterPicturedLogdate) {
		this.afterPicturedLogdate = afterPicturedLogdate;
	}

	public int getAfterPictureStatus() {
		return afterPictureStatus;
	}

	public void setAfterPictureStatus(int afterPictureStatus) {
		this.afterPictureStatus = afterPictureStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
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
