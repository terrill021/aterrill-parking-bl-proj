package com.ceiba.bl.parking.impl;

import com.ceiba.bl.parking.IParking;
import com.ceiba.bl.parking.models.Vehicle;
import com.ceiba.repository.nosqldb.IDbNoSql;

public class ParkingImpl implements IParking{

	IDbNoSql iDbNoSql;
	
	@Override
	public void registerVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double charge(String licensePlate) {
		// TODO Auto-generated method stub
		return null;
	}

}
