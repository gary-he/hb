package cn.tarena.ht.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Order;

public interface OrderMapper {


	public void add(Order order);

	public void updateOrder(@Param("orderId")String orderId,@Param("date")Date date,@Param("state") String state);

	public Order getOrderById(String orderId);

}
