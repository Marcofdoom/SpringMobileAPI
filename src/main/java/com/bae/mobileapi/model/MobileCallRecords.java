package com.bae.mobileapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MobileCallRecords {

	@Id
	private String callerMSISDN;

	@Column(nullable = true)
	private Long callerCellTowerId;

	private String receiverMSISDN;

	@Column(nullable = true)
	private Long receiverTowerId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public MobileCallRecords() {

	}

	public MobileCallRecords(String callerMSISDN, Long callerCellTowerId, String receiverMSISDN, Long receiverTowerId,
			Date timeStamp) {
		this.callerMSISDN = callerMSISDN;
		this.callerCellTowerId = callerCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
		this.timeStamp = timeStamp;
	}

	public String getCallerMSISDN() {
		return callerMSISDN;
	}

	public void setCallerMSISDN(String callerMSISDN) {
		this.callerMSISDN = callerMSISDN;
	}

	public Long getCallerCellTowerId() {
		return callerCellTowerId;
	}

	public void setCallerCellTowerId(Long callerCellTowerId) {
		this.callerCellTowerId = callerCellTowerId;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	public Long getReceiverTowerId() {
		return receiverTowerId;
	}

	public void setReceiverTowerId(Long receiverTowerId) {
		this.receiverTowerId = receiverTowerId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}