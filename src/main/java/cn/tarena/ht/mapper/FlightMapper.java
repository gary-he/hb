package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Site;

public interface FlightMapper {

	public List<Flight> findAll();

	public Flight findOne(String id);
	
	public void updateFlight(Flight flight);

	public void deleteFlight(String[] ids);

	public void saveFlight(Flight flight);

}
