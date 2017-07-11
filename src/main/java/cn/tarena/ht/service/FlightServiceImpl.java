package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.FlightMapper;
import cn.tarena.ht.pojo.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightMapper flightMapper;

	@Override
	//查找所有航班信息
	public List<Flight> findAll() {
		return flightMapper.findAll();
	}

}
