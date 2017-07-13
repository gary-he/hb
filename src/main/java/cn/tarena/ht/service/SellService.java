package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;

import cn.tarena.ht.pojo.Statement;

public interface SellService {

	List<Statement> findAll();

	List<Statement> findByRules(String location, String departure, String passengerName, String pNR, String airlines,
			String ticketState, Date ticketTime1, Date ticketTime2);

}
