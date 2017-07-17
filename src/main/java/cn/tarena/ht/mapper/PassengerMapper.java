package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Passenger;

public interface PassengerMapper {
	/**
	 * 添加乘客
	 * @param passenger
	 */
	public void add(Passenger passenger);

	public Passenger getPassengerByOrderId(String orderId);

}
