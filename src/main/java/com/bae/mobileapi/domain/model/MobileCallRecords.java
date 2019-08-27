package com.bae.mobileapi.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MobileCallRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "caller_msisdn")
	private PeopleMobile callerMsisdn;

	@Column(nullable = true)
	private Long callerCellTower;

	@ManyToOne()
	@JoinColumn(name = "receiver_msisdn")
	private PeopleMobile receiverMsisdn;

	@Column(nullable = true)
	private Long receiverCellTower;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public MobileCallRecords() {

	}

	public MobileCallRecords(Long id, PeopleMobile callerMsisdn, Long callerCellTower, PeopleMobile receiverMsisdn,
			Long receiverCellTower, Date timestamp) {
		this.id = id;
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

	public PeopleMobile getCallerMsisdn() {
		return callerMsisdn;
	}

	public void setCallerMsisdn(PeopleMobile callerMsisdn) {
		this.callerMsisdn = callerMsisdn;
	}

	public Long getCallerCellTower() {
		return callerCellTower;
	}

	public void setCallerCellTower(Long callerCellTower) {
		this.callerCellTower = callerCellTower;
	}

	public PeopleMobile getReceiverMsisdn() {
		return receiverMsisdn;
	}

	public void setReceiverMsisdn(PeopleMobile receiverMsisdn) {
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