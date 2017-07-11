package cn.tarena.ht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(User user,Model model){
		
		User userOne=userService.findOne(user.getUserId());
		
		model.addAttribute("userOne", userOne);
		
		return "/sysadmin/user/listOne";
		
	}
	
	@RequestMapping("/update")
	public String update(User user){
		
		userService.update(user);
		
		return "Redirect:/sysadmin/user/list";
	}
	
	
	
	
}
