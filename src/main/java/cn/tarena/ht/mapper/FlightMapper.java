package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.Flight;

public interface FlightMapper {

	public List<Flight> findAll();

	public Flight findOne(Integer id);
	
	public void updateFlight(Flight flight);

	public void deleteFlight(String[] fIds);

	public void saveFlight(Flight flight);

}
