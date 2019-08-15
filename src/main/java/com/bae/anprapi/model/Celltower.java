package com.bae.anprapi.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Celltower {
	
	@Id
	private long cellTower;
	
	private String operator;
	
	private String type;
	
	private long latitude;
	
	private long longitude;

	public Celltower() {
		super();
	}

	public Celltower(long cellTower, String operator, String type, long latitude, long longitude) {
		super();
		this.cellTower = cellTower;
		this.operator = operator;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}