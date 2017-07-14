package cn.tarena.ht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.OrderMapper;
import cn.tarena.ht.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public void add(Order order) {
		
		orderMapper.add(order);

	}

}
