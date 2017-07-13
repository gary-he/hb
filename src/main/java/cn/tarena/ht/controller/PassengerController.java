package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Passenger;
import cn.tarena.ht.service.PassengerService;

@Controller
public class PassengerController {
	
	PassengerService passengerService;
	
	//订票跳转至保险确认页面
	@RequestMapping("/pay/insurance")
	public String insurance(String airlineType,Model model){
		
		model.addAttribute("airlineType", airlineType);
		
		return "/hb/corptravel/pay/insurance";
	}
	
	//订票 - 支付确认页面 - payment
		@RequestMapping("/pay/payment")
		public String payment(Passenger passenger,Model model){
			
			passengerService.add(passenger);
			
						
			return "/hb/corptravel/pay/payment";
		}
	
}
