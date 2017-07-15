package cn.tarena.ht.controller;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Site;
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
	@RequestMapping("/search/{fLocationName}/{fDepartureName}/{time}")
	public String searchTime(@PathVariable String fLocationName,@PathVariable String fDepartureName,@PathVariable Date time,String fCompany,Model model) throws Exception{
		//手动编解码
		byte[] bytes = fLocationName.getBytes("ISO8859-1");
		fLocationName = new String(bytes,"utf-8");
		bytes = fDepartureName.getBytes("ISO8859-1");
		fDepartureName = new String(bytes,"utf-8");
		time = new Date(time.getTime()-1000*60*60*24);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String fStarttime = sd.format(time);
		model.addAttribute("time", time);
		return search(fLocationName,fDepartureName,fStarttime,fCompany,model);
	}
	
	@RequestMapping("/search")
	public String search(String fLocationName,String fDepartureName,String fStarttime,String fCompany,Model model){
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
		
		System.out.println(fLocation);
		System.out.println(fDeparture);
		//查询操作
		//1.查询
		List<Flight> flightList = null;
		List<Site> siteList = null;
		int fid = 4;
		if(fStarttime == null || fStarttime == ""){
			//默认当天时间
			Date date1 = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			fStarttime = sd.format(date1);
			if(fCompany == null || fCompany == ""){
				//1.1 出发地+目的地+全部航司
				flightList = buyFlightService.findFlightsT(fLocation,fDeparture,fStarttime);
				siteList = buyFlightService.findAllSite(fid);
				model.addAttribute("f", flightList);
				model.addAttribute("s", siteList);
				System.out.println("出发地+目的地+全部航司");
			}else{
				//1.2 出发地+目的地+指定航司
				flightList = buyFlightService.findFlightsTC(fLocation,fDeparture,fStarttime,fCompany);
				model.addAttribute("f", flightList);
				model.addAttribute("s", siteList);
				System.out.println("出发地+目的地+指定航司");
			}
		}else{//指定时间
			if(fCompany == null || fCompany == ""){
				//1.2 出发地+目的地+指定时间+全部航司
				flightList = buyFlightService.findFlightsT(fLocation,fDeparture,fStarttime);
				siteList = buyFlightService.findAllSite(fid);
				model.addAttribute("f", flightList);
				model.addAttribute("s", siteList);
				System.out.println("出发地+目的地+指定时间+全部航司");
			}else{
				//1.4 出发地+目的地+指定时间+指定航司
				flightList = buyFlightService.findFlightsTC(fLocation,fDeparture,fStarttime,fCompany);
				siteList = buyFlightService.findAllSite(fid);
				model.addAttribute("f", flightList);
				model.addAttribute("s", siteList);
				System.out.println("出发地+目的地+指定时间+指定航司");
			}
		}
		//将查询到的数据存到页面
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
	/*@RequestMapping("/pay/succeed")
	public String succeed(){
		
		
		return "/hb/corptravel/pay/succeed";
	}
	*/


}