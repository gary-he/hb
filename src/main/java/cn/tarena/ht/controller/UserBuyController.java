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
import cn.tarena.ht.tool.AirportCode;

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
	public String index(Model model){
		Date date = new Date();
		model.addAttribute("date", date);
		return "/hb/corptravel/index";
	}
	@RequestMapping("/search")
	public String search(String fLocationName,String fDepartureName,String fStarttime,String fCompany,Model model){
		System.out.println("fLocationName："+fLocationName);
		System.out.println("fDepartureName："+fDepartureName);
		System.out.println("fStarttime："+fStarttime);
		System.out.println("fCompany："+fCompany);
		//回显数据
		model.addAttribute("fLocationName",fLocationName);
		model.addAttribute("fDepartureName",fDepartureName);
		//存储时间
		Date date = new Date();
		for (int i = 0; i < 7; i++) {
			model.addAttribute("date"+i, date);
			date = new Date(date.getTime()+1000*60*60*24);
		}
		//根据城市名称 查找 机场三字代码
		String fLocation = AirportCode.findCode(fLocationName);
		String fDeparture = AirportCode.findCode(fDepartureName);
		
		//查询操作
		//1.默认查询当天航班
		List<Flight> flightList = null;
		
		
		if(fCompany == null || fCompany == ""){
			//1.1全部航司
			flightList = buyFlightService.findFlights(fLocation,fDeparture);
			model.addAttribute("f", flightList);
		}else{
			//1.2指定航司
			flightList = buyFlightService.findFlightsOneF_C(fLocation,fDeparture,fCompany);
			model.addAttribute("f", flightList);
		}
		
		//将查询到的数据存到页面
		return "/hb/corptravel/search";
	}
	
	
	//订票-保险确认页面-insurance
	@RequestMapping("/pay/insurance/{fId}")
	public String insurance(@PathVariable String fId){
		System.out.println(fId);
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
