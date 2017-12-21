package com.ceiba.bl.parking.impl;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.bl.parking.IParking;
import com.ceiba.bl.parking.databuilders.ParkingDataBuilder;
import com.ceiba.bl.parking.models.Bill;
import com.ceiba.bl.parking.models.Parking;
import com.ceiba.bl.parking.models.Vehicle;
import com.ceiba.repository.nosqldb.IDbNoSql;
import com.ceiba.repository.nosqldb.impl.MongoDb;
import com.ceiba.utilities.IDateUtilities;

public class ParkingImplTest {

	IDbNoSql iDbNoSql;
	ParkingImpl ParkingImpl;
	Parking parking;
	Vehicle vehicle;
	Bill bill;
	IDateUtilities iDateUtilities;
	
	@Before 
	public void before() {
		iDbNoSql = Mockito.mock(IDbNoSql.class);
		iDateUtilities = Mockito.mock(IDateUtilities.class);
		ParkingImpl = new ParkingImpl();
		ParkingImpl.setiDbNoSql(iDbNoSql);
		ParkingImpl.setiDateUtilities(iDateUtilities);
		bill = new Bill();
		parking = new ParkingDataBuilder().build();
		vehicle = new Vehicle("321", "bcd-123", "car", 80f);
	}
	
	@Test
	public void testRegisterVehicle() throws Exception {
		
		// Arrange
		Mockito.when(iDbNoSql.save(bill)).thenReturn(true);
		Mockito.when(iDbNoSql.findOne(parking.getId(), Parking.class)).thenReturn(parking);
		Mockito.when(iDateUtilities.getDayOfWeek()).thenReturn(Calendar.WEDNESDAY);
		Mockito.when(iDateUtilities.getDateStamp()).thenReturn(Calendar.getInstance().getTime());
		
		// act
		Bill bill = ParkingImpl.registerVehicle(parking.getId(), vehicle);
		
		// assert
		assertNotNull(bill);		
	}
	
	/**
	 * When vehicle licensePlate starts by A and day of week is sunday o monday
	 * then don´t let to in the car.
	 * @throws Exception
	 */
	@Test(expected=Exception.class)
	public void testRegisterVehicleFailByDate() throws Exception {
		
		// Arrange
		Mockito.when(iDbNoSql.save(bill)).thenReturn(true);
		Mockito.when(iDbNoSql.findOne(parking.getId(), Parking.class)).thenReturn(parking);
		Mockito.when(iDateUtilities.getDayOfWeek()).thenReturn(Calendar.SUNDAY);
		Mockito.when(iDateUtilities.getDateStamp()).thenReturn(Calendar.getInstance().getTime());
		vehicle.setLicensePlate("ABC-123");
		
		// act
		try {
			Bill bill = ParkingImpl.registerVehicle(parking.getId(), vehicle);
		} catch (Exception e) {
			assertEquals("You are not authorized to in on sundays or mondays", e.getMessage());
			throw e;
		}
		
		
		// assert
		assertNotNull(bill);		
	}

	@Test
	public void testCharge() {
		fail("Not yet implemented");
	}


}
