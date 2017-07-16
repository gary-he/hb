package cn.tarena.ht.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.FlightMapper;
import cn.tarena.ht.mapper.OrderMapper;
import cn.tarena.ht.mapper.PassengerMapper;
import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Order;
import cn.tarena.ht.pojo.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	PassengerMapper passengerMapper;
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	FlightMapper flightMapper;
	
	@Override
	public void add(Passenger passenger, Order order) {
		
		orderMapper.add(order);
		
		passengerMapper.add(passenger);

	}

	@Override
	public void updateOrder(String orderId, Date date) {
		
		System.out.println(date);
		
		String state = "1" ; 
		
		orderMapper.updateOrder(orderId,date,state);
		
	}

	@Override
	public Order getOrderById(String orderId) {
		
		return orderMapper.getOrderById(orderId);
	}

	@Override
	public Passenger getPassengerByOrderId(String orderId) {
		
		return passengerMapper.getPassengerByOrderId(orderId);
	}

	@Override
	public Flight getFlightByOrderId(String orderId) {
		
		return flightMapper.getFlightByOrderId(orderId);
	}

	@Override
	public Flight findOne(String airlineType) {
		
		return flightMapper.findOne(airlineType);
	}

	

	

}
