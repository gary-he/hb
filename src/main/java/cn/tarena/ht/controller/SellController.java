package cn.tarena.ht.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Statement;
import cn.tarena.ht.service.SellService;

//报表controller
@Controller
@RequestMapping("/admin/forms")
public class SellController extends BaseController{
	
	@Autowired
	private SellService sellService;
	
	/**
	 * 跳转至 报表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String toSell(Model model){
		List<Statement> list = sellService.findAll();
		model.addAttribute("statementList", list);
		return "/admin/forms/jStatementList";
	}
	
	/**String location,String departure,String passengerName,String PNR,
			String Airlines,String ticketState
	 * 按照日期查询 Date ticketTime1,Date ticketTime2
	 * @return
	 */
	@RequestMapping("/tofind")
	public String findAllByDay(String location,String departure,String passengerName,String PNR,
			String Airlines,String ticketState,Date ticketTime1,Date ticketTime2,Model model){
		
		
		List<Statement> list = sellService.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2);
		model.addAttribute("statementList",list);
		
		
		return "/admin/forms/jStatementList";
	}
	
	
	
}
