package cn.tarena.ht.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.service.BuyFlightService;

@Controller
public class UserBuyController {
	
	@Autowired
	BuyFlightService buyFlightService;
	
	@RequestMapping("demo")
	public String demo(){
		return "/hb/corptravel/demo";
	}
	
	//订票页面
	@RequestMapping("/index")
	public String index(){
		Date date = new Date();
		System.out.println(date);
		return "/hb/corptravel/index";
	}
	@RequestMapping("/search")
	public String search(String fLocationName,String fDepartureName,String fStarttime,String fCompany,Model model){
		System.out.println(fLocationName);
		System.out.println(fDepartureName);
		System.out.println(fStarttime);
		System.out.println(fCompany);
		String fLocation = "CAN";
		String fDeparture = "PEK";
		Flight flightList = buyFlightService.findFlights(fLocation,fDeparture,fCompany);
		System.out.println(flightList);
		model.addAttribute("f", flightList);
		return "/hb/corptravel/search";
	}
	
	
	/*//订票-保险确认页面-insurance
	@RequestMapping("/pay/insurance/{fId}")
	public String insurance(@PathVariable String fId){
		System.out.println(fId);
		return "/hb/corptravel/pay/insurance";
	}*/
	
/*	//订票 - 支付确认页面 - payment
	@RequestMapping("/pay/payment")
	public String payment(){
		
		
		return "/hb/corptravel/pay/payment";
	}*/
	
	//订票 - 支付成功页面 -succeed
	@RequestMapping("/pay/succeed")
	public String succeed(){
		
		
		return "/hb/corptravel/pay/succeed";
	}
	


}
