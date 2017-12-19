package com.ceiba.bl.parking;

import com.ceiba.bl.parking.models.Vehicle;

public interface IParking {

	void registerVehicle(Vehicle vehicle);
	
	Double charge(String licensePlate);
}
