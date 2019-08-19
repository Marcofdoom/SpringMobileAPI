package com.bae.anprapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CellTower {

	@Id
	private Long cellTower;

	private String operator;

	private String type;

	private Float latitude;

	private Float longitude;

	public CellTower() {

	}

	public CellTower(Long cellTower, String operator, String type, Float latitude, Float longitude) {
		this.cellTower = cellTower;
		this.operator = operator;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}