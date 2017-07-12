package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Flight;

public interface BuyFlightService {
	
	public List<Flight> findAllFlight();

	public Flight findFlights(String fLocation, String fDeparture,String fCompany);
}
