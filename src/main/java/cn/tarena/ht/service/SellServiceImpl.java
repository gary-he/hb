package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.SellMapper;
import cn.tarena.ht.pojo.Statement;

@Service
public class SellServiceImpl implements SellService {
	
	@Autowired
	private SellMapper sellMapper;
	
	/**
	 * test
	 */
	@Override
	public List<Statement> findAll() {
		
		return sellMapper.findAll();
	}

	
	
	@Override
	public List<Statement> findByRules(String location, String departure, String passengerName, String PNR,
			String Airlines, String ticketState, Date ticketTime1, Date ticketTime2) {
		// TODO Auto-generated method stub
		return sellMapper.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2);
	}
	
}
