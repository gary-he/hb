package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Flight;

public interface FlightService {

	List<Flight> findAll();

	Flight findOne(Integer id);

	void updateflight(Flight flight);

	void deleteFlight(String[] ids);

	void saveFlight(Flight flight);

}
