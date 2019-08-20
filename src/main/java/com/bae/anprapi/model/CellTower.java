package com.bae.anprapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


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

	public Long getCellTower() {
		return cellTower;
	}

	public void setCellTower(Long cellTower) {
		this.cellTower = cellTower;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
}