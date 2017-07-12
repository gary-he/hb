package cn.tarena.ht.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.PassengerMapper;
import cn.tarena.ht.pojo.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	PassengerMapper passengerMapper;
	
	@Override
	public void add(Passenger passenger) {
		
		String id=UUID.randomUUID().toString();
		//Date date=new Date();
		
		passenger.setpOrderId(id);
		
		passengerMapper.add(passenger);

	}

}
