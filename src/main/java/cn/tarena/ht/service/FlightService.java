package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Flight;

import cn.tarena.ht.pojo.Site;

public interface FlightService {

	List<Flight> findAll();

	Flight findOne(String id);

	void updateflight(Flight flight, List<Site> sList);

	void deleteFlight(String[] ids);

	void saveFlight(Flight flight, List<Site> sList);

	List<Site> findSiteById(String id);

}
