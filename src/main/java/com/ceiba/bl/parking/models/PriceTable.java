package com.ceiba.bl.parking.models;

import java.util.Map;

public class PriceTable {

	private Map <Vehicle, Map<String, Float>> pricesTable;

	public Map<Vehicle, Map<String, Float>> getPricesTable() {
		return pricesTable;
	}

	public void setPricesTable(Map<Vehicle, Map<String, Float>> pricesTable) {
		this.pricesTable = pricesTable;
	}
	
}
