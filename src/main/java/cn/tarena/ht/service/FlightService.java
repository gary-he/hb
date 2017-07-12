package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Flight;

public interface FlightService {

	List<Flight> findAll();

	Flight findOne(String fId);

	void updateflight(Flight flight);

	void deleteFlight(String[] fIds);

	void saveFlight(Flight flight);

}
