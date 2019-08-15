package com.bae.anprapi.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class MobileCallRecords {
	
	@Id
	private long callerMSISDN;
	
	private String callerCellTowerId;
	
	private String recieverMSISDN;
	
	private long recieverCellTowerId;
	
	private long timestamp;

	public MobileCallRecords() {
		super();
	}

	public MobileCallRecords(long callerMSISDN, String callerCellTowerId, String recieverMSISDN,
			long recieverCellTowerId, long timestamp) {
		super();
		this.callerMSISDN = callerMSISDN;
		this.callerCellTowerId = callerCellTowerId;
		this.recieverMSISDN = recieverMSISDN;
		this.recieverCellTowerId = recieverCellTowerId;
		this.timestamp = timestamp;
	}

}