package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistController {
	
	@RequestMapping("/toregist")
	public String toRegist(Model model){
		model.addAttribute("type", 1);
		return "/loginAndRegist/loginAndRegist";
	}
	
	@RequestMapping("/regist")
	public String registUser(String userName,String password){
		System.out.println(userName+":"+password);
		return "";
	}
	
}
