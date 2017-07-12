package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/tologin")
	public String toLogin(Model model){
		model.addAttribute("type", 0);
		return "/loginAndRegist/loginAndRegist";
	}
	
	@RequestMapping("/login")
	public String loginUser(String userName,String password,String remeberMe){
		System.out.println(userName+":"+password+remeberMe);
		return "redirect:/home";
	}
	
	
}
