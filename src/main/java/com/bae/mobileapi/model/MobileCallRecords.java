package com.bae.mobileapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MobileCallRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String callerMsisdn;

	@Column(nullable = true)
	private Long callerCellTower;

	private String receiverMsisdn;

	@Column(nullable = true)
	private Long receiverCellTower;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public MobileCallRecords() {

	}

	public MobileCallRecords(String callerMsisdn, Long callerCellTower, String receiverMsisdn, Long receiverCellTower,
			Date timestamp) {
		this.callerMsisdn = callerMsisdn;
		this.callerCellTower = callerCellTower;
		this.receiverMsisdn = receiverMsisdn;
		this.receiverCellTower = receiverCellTower;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCallerMsisdn() {
		return callerMsisdn;
	}

	public void setCallerMsisdn(String callerMsisdn) {
		this.callerMsisdn = callerMsisdn;
	}

	public Long getCallerCellTower() {
		return callerCellTower;
	}

	public void setCallerCellTower(Long callerCellTower) {
		this.callerCellTower = callerCellTower;
	}

	public String getReceiverMsisdn() {
		return receiverMsisdn;
	}

	public void setReceiverMsisdn(String receiverMsisdn) {
		this.receiverMsisdn = receiverMsisdn;
	}

	public Long getReceiverCellTower() {
		return receiverCellTower;
	}

	public void setReceiverCellTower(Long receiverCellTower) {
		this.receiverCellTower = receiverCellTower;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}