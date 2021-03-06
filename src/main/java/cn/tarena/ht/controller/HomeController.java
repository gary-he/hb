package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	/*//转向前台首页
	@RequestMapping("/hb")
	public String hb(){
		return "/hb/corptravel/search";
	}*/
	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
	//转向home的左侧页面
	@RequestMapping("/home/Left")
	public String homeLeft(){
		return "/home/left";
	}
	
	//转向home的操作页面
	@RequestMapping("/home/Main")
	public String homeMain(){
		return "/home/main";
	}
	
	@RequestMapping("/{module}/Left")
	public String sysadminLeft(@PathVariable String module){
		return "/"+module+"/left";
	}
	
	@RequestMapping("/{module}/Main")
	public String sysadminMain(@PathVariable String module){
		return "/"+module+"/main";
	}
}
