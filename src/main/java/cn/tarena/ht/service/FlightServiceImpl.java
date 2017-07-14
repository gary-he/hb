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

	@Override
	//根据fId查询航班详情
	public Flight findOne(Integer id) {
		return flightMapper.findOne(id);
	}
	
	@Override
	//更新航班信息
	public void updateflight(Flight flight) {
		flightMapper.updateFlight(flight);
		
	}

	@Override
	//删除航班信息
	public void deleteFlight(String[] fIds) {
		flightMapper.deleteFlight(fIds);
		
	}
	//航班的新增
	@Override
	public void saveFlight(Flight flight) {
		
		flightMapper.saveFlight(flight);
		
	}

}
