package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.service.FlightService;

@Controller
@RequestMapping("/sysadmin/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	//1.请求展示航班信息列表
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Flight> flightList=flightService.findAll();
		return"/sysadmin/flight/fFlightList";
		
	}

}
