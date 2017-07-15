package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Site;

public interface BuyFlightService {
	
	public List<Flight> findAllFlight();

	public List<Flight> findFlightsT(String fLocation, String fDeparture, String fStarttime);

	public List<Flight> findFlightsTC(String fLocation, String fDeparture, String fStarttime, String fCompany);

	public List<Site> findAllSite(Integer fid);
}
