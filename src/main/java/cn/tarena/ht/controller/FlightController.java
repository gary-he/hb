package cn.tarena.ht.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.FlightSite;
import cn.tarena.ht.pojo.Site;
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
	public String toView(String id,Model model){
		Flight flight=flightService.findOne(id);
		model.addAttribute("flight", flight);
		return "/admin/flight/fFlightView";
		
	}
	
	//3.修改航班信息
	@RequestMapping("toupdate")
	public String toUpdate(String id,Model model){
		Flight flight=flightService.findOne(id);
		List<Site> sList=flightService.findSiteById(id);
		model.addAttribute("flight", flight);
		model.addAttribute("sList", sList);
		return"/admin/flight/fFlightUpdate";
	}
	@RequestMapping("/update")
	public String UpdateDept(Flight flight,Model model,Integer[] sId,String[] sType,String[]sFlightPId,String[] sRate,String[] sNum){
		List<Site> sList=new ArrayList<Site>();
		for (int i=0;i<sType.length;i++) {
			if(sType[i]==null || sType[i].trim().equals("")){
				
				continue;
			}
			if(sRate[i]==null || sRate[i].trim().equals("")){
				continue;
			}
			if(sNum[i]==null || sNum[i].trim().equals("")){
				continue;
			}
			Site site=new Site();
			site.setsId(sId[i]);
			site.setsFlightPId(sFlightPId[i]);
			site.setsType(sType[i]);
			site.setsRate(Integer.parseInt(sRate[i]));
			site.setsNum(Integer.parseInt(sNum[i]));
			sList.add(site);
		}
		System.out.println("集合sList"+sList);
		flightService.updateflight(flight,sList);
		return "redirect:/admin/flight/list";
	}
	
	//4.删除航班信息s
	@RequestMapping("/delete")
	public String toDelete(@RequestParam(value="id",required=true)String[] ids){
		flightService.deleteFlight(ids);
		return "redirect:/admin/flight/list";
		
	}
	
	//5.航班的新增---页面跳转
	@RequestMapping("/tocreate")
	public String toCreate(){
		return "/admin/flight/fFlightCreate";
		
	}
	@RequestMapping("/save")
	public String saveFlight(Flight flight,Model model,String[] sType,String[] sRate,String[] sNum){
		String id=UUID.randomUUID().toString();
		List<Site> sList=new ArrayList<Site>();
		for (int i=0;i<sType.length;i++) {
			if(sType[i]==null || sType[i].trim().equals("")){
				
				continue;
			}
			if(sRate[i]==null || sRate[i].trim().equals("")){
				continue;
			}
			if(sNum[i]==null || sNum[i].trim().equals("")){
				continue;
			}
			Site site=new Site();
			site.setsFlightPId(id);
			site.setsType(sType[i]);
			site.setsRate(Integer.parseInt(sRate[i]));
			site.setsNum(Integer.parseInt(sNum[i]));
			sList.add(site);
			
		}
		flight.setId(id);
		System.out.println(sList);
		flightService.saveFlight(flight,sList);
		return "redirect:/admin/flight/list";
	}
	
	
	
	

}
