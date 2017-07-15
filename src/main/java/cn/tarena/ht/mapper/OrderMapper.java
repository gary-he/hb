package cn.tarena.ht.mapper;

import java.util.Date;

import cn.tarena.ht.pojo.Order;

public interface OrderMapper {


	public void add(Order order);

	public void payOrder(String orderId,Date date);

}
