package com.ceiba.bl.parking.models;

import java.util.List;

public class Parking {
	
	private String id;
	private String name;
	private String capacity;
	
	private List<Vehicle> cars;
	private List<Vehicle> motorcycles;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public List<Vehicle> getCars() {
		return cars;
	}
	public void setCars(List<Vehicle> cars) {
		this.cars = cars;
	}
	public List<Vehicle> getMotorcycles() {
		return motorcycles;
	}
	public void setMotorcycles(List<Vehicle> motorcycles) {
		this.motorcycles = motorcycles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
