package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.BuyFlightMapper;
import cn.tarena.ht.pojo.Flight;

@Service
public class BuyFlightServiceImpl implements BuyFlightService {

	@Autowired
	BuyFlightMapper buyFlightMapper;
	
	@Override
	public List<Flight> findAllFlight() {
		return buyFlightMapper.findAllFlight();
	}

	//默认当天时间查询所有航班
	@Override
	public List<Flight> findFlights(String fLocation, String fDeparture) {
		
		List<Flight> flightList = buyFlightMapper.findFlights(fLocation,fDeparture);
		for (Flight flight : flightList) {
			System.out.println(flight);
		}
		System.out.println("1");
		return buyFlightMapper.findFlights(fLocation,fDeparture);
	}

	//默认当天时间 查询指定 航司航班
	@Override
	public List<Flight> findFlightsOneF_C(String fLocation, String fDeparture, String fCompany) {
		List<Flight> flightList = buyFlightMapper.findFlightsOneF_C(fLocation,fDeparture,fCompany);
		for (Flight flight : flightList) {
			System.out.println(flight);
		}
		System.out.println("2");
		return buyFlightMapper.findFlightsOneF_C(fLocation,fDeparture,fCompany);
	}

}
