package cn.tarena.ht.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.service.BuyFlightService;

@Controller
public class UserBuyController {
	
	@Autowired
	BuyFlightService buyFlightService;
	
	//准备数据
	@RequestMapping("/user/buy/view")
	public String BuyFlight(Model model){
		List<Flight> flightList = buyFlightService.findAllFlight();
		
		model.addAttribute("flightList", flightList);
		
		return "/user/buy/buy";
	}

}
