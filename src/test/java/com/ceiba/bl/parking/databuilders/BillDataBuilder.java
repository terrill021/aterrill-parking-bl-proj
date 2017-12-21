package com.ceiba.bl.parking.databuilders;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.bl.parking.models.Vehicle;

public class BillDataBuilder {

	private String id;
	private Date dateIn;
	private Date dateOut;
	
	private Vehicle vehicle;
	
	private Double value;
	private Boolean state;
	
	public BillDataBuilder () {
		this.id = "bill-test-id";
		this.dateIn = Calendar.getInstance().getTime();
		this.dateOut = Calendar.getInstance().getTime();
		this.vehicle = new Vehicle();
		this.value = 1000d;
		this.state = true;
	}

	public String getId() {
		return id;
	}

	public BillDataBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public BillDataBuilder setDateIn(Date dateIn) {
		this.dateIn = dateIn;
		return this;
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

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	
}
