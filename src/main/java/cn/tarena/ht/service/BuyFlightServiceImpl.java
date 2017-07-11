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

}
