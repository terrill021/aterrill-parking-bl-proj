package com.ceiba.bl.parking.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

public class Bill {

	private String id;
	private Date dateIn;
	private Date dateOut;
	private String parkingId;
	private Vehicle vehicle;
	
	private Double value;
	private Boolean state;
	
	public Bill () {
		
	}
	
	public Bill(String id, Date dateIn, Date dateOut, String parkingId, Vehicle vehicle, Double value, Boolean state) {
		super();
		this.id = id;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.parkingId = parkingId;
		this.vehicle = vehicle;
		this.value = value;
		this.state = state;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParkingId() {
		return parkingId;
	}

	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}
	
}
