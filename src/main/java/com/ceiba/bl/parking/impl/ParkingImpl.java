package com.ceiba.bl.parking.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.bl.parking.IParking;
import com.ceiba.bl.parking.models.Bill;
import com.ceiba.bl.parking.models.Parking;
import com.ceiba.bl.parking.models.Vehicle;
import com.ceiba.repository.nosqldb.IDbNoSql;
import com.ceiba.utilities.IDateUtilities;

@Service
public class ParkingImpl implements IParking{

	@Autowired
	IDbNoSql iDbNoSql;
	
	@Autowired
	IDateUtilities iDateUtilities;
	
	@Override
	public Bill registerVehicle(String parkingId, Vehicle vehicle) throws Exception {
		
		Parking parking = searchParking(parkingId);
		
		if(parking.getCars().size() >= parking.getCarsCapacity()) {
			throw new Exception("There is not capacity for cars");
		}
		
		if (parking.getMotorcycles().size() >= parking.getMotorcyclesCapacity()) {
			throw new Exception("There is not capacity for motorcycles");
		}		
		
		if (vehicle.getLicensePlate().substring(0, 1).toLowerCase().equals("a")) {
			if(iDateUtilities.getDayOfWeek() == Calendar.SUNDAY || iDateUtilities.getDayOfWeek() == Calendar.MONDAY) {
				throw new Exception("You are not authorized to in on sundays or mondays");
			}
		}
		
		Bill bill = new Bill();
		bill.setVehicle(vehicle);
		bill.setDateIn(iDateUtilities.getDateStamp());
		
		iDbNoSql.save(bill);
		
		return bill;
	}
	

	@Override
	public synchronized Bill charge(String parkingId, String licensePlate) throws Exception{
		
		Parking parking = searchParking(parkingId);
		Map<String, String> field_values = new HashMap<>();
		field_values.put("licensePlate", licensePlate);
		field_values.put("state", "true");
		
		List<Bill> bills  = iDbNoSql.findByFieldValues(field_values, Bill.class);
		Bill bill = bills.get(0);
		Double total = 0d;
		if (bill != null) {
			
			if (bill.getVehicle().getType().equals("motorcycle") &&
					bill.getVehicle().getDisplacement() > 500) {
				total += 2000;
			}
			Float numHours = iDateUtilities.calculateNumHoursBetweenDates (bill.getDateIn(), iDateUtilities.getDateStamp()); 
			Map<String, Float> pricesTable = parking.getPriceTable().getPricesTable().get(bill.getVehicle()); 
			
			bill.setValue(calcucalateBillBalue(numHours, pricesTable));
			iDbNoSql.save(bill);
			return bill;
			
		} else {
			throw new Exception("There is not registered car with this license plate");
		}
	}	
	
	private Parking searchParking(String parkingId) throws Exception {
		Parking parking = iDbNoSql.findOne(parkingId, Parking.class);
		
		if (parking != null){ return parking;} else throw new Exception("Parking not found");
	}
	
	private Double calcucalateBillBalue(Float numHours, Map<String, Float> pricesTable) {
		// TODO Auto-generated method stub
		return 0d;
	}

	private int countMotorcycles() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private int countCars() {
		int res = 0;		
		return res;
	}

	public IDbNoSql getiDbNoSql() {
		return iDbNoSql;
	}

	public void setiDbNoSql(IDbNoSql iDbNoSql) {
		this.iDbNoSql = iDbNoSql;
	}


	public IDateUtilities getiDateUtilities() {
		return iDateUtilities;
	}


	public void setiDateUtilities(IDateUtilities iDateUtilities) {
		this.iDateUtilities = iDateUtilities;
	}
	
}
