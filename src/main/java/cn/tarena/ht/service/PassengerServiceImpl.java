package cn.tarena.ht.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.OrderMapper;
import cn.tarena.ht.mapper.PassengerMapper;
import cn.tarena.ht.pojo.Order;
import cn.tarena.ht.pojo.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	PassengerMapper passengerMapper;
	
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public void add(Passenger passenger, Order order) {
		
		orderMapper.add(order);
		
		passengerMapper.add(passenger);

	}

	

	

}
