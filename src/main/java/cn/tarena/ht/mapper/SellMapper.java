package cn.tarena.ht.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Statement;

public interface SellMapper {

	List<Statement> findAll();

	List<Statement> findByRules(
			@Param("location")String location, 
			@Param("departure")String departure, 
			@Param("passengerName")String passengerName, 
			@Param("PNR")String PNR, 
			@Param("Airlines")String Airlines,
			@Param("ticketState")String ticketState, 
			@Param("ticketTime1")Date ticketTime1, 
			@Param("ticketTime2")Date ticketTime2);

}
