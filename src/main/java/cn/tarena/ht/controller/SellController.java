package cn.tarena.ht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.service.SellService;

//报表controller
@Controller
@RequestMapping("/statement")
public class SellController {
	
	@Autowired
	private SellService sellService;
	
	
	@RequestMapping("/list")
	public String toSell(){
		return "/statement/jStatementList";
	}
	
	
	
	
}
