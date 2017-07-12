package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.service.FlightService;

@Controller
@RequestMapping("/admin/flight")
public class FlightController extends BaseController{
	@Autowired
	private FlightService flightService;
	
	//1.请求展示航班信息列表
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Flight> flightList=flightService.findAll();
		model.addAttribute("flightList", flightList);
		return"/admin/flight/fFlightList";	
		
	}
	
	//2.查看航班详情信息
	@RequestMapping("/toview")
	public String toView(String fId,Model model){
		Flight flight=flightService.findOne(fId);
		model.addAttribute("flight", flight);
		return "/admin/flight/fFlightView";
		
	}
	
	//3.修改航班信息
	@RequestMapping("toupdate")
	public String toUpdate(String fId,Model model){
		Flight flight=flightService.findOne(fId);
		model.addAttribute("flight", flight);
		return"/admin/flight/fFlightUpdate";
	}
	@RequestMapping("/update")
	public String UpdateDept(Flight flight){
		flightService.updateflight(flight);
		return "redirect:/admin/flight/list";
	}
	
	//4.删除航班信息
	@RequestMapping("/delete")
	public String toDelete(@RequestParam("fId")String[] fIds){
		flightService.deleteFlight(fIds);
		return "redirect:/admin/flight/list";
		
	}
	
	//5.航班的新增---页面跳转
	@RequestMapping("/tocreate")
	public String toCreate(){
		return "/admin/flight/fFlightCreate";
		
	}
	@RequestMapping("/save")
	public String saveFlight(Flight flight){
		flightService.saveFlight(flight);
		return "redirect:/admin/flight/list";
		
	}
	

}
