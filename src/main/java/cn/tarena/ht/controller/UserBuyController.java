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
	
	//订票页面
	@RequestMapping("/index")
	public String index(Model model){
		
		return "/hb/corptravel/search";
	}
	
	//订票-保险确认页面-insurance
	@RequestMapping("/pay/insurance")
	public String insurance(){
		
		return "/hb/corptravel/pay/insurance";
	}
	
	//订票 - 支付确认页面 - payment
	@RequestMapping("/pay/payment")
	public String payment(){
		
		
		return "/hb/corptravel/pay/payment";
	}
	
	//订票 - 支付成功页面 -succeed
	@RequestMapping("/pay/succeed")
	public String succeed(){
		
		
		return "/hb/corptravel/pay/succeed";
	}
	


}
