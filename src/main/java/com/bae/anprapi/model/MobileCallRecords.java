package com.bae.anprapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
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
}