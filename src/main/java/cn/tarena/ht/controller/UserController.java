package cn.tarena.ht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/user/info")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//查看当前用户信息
	@RequestMapping("/userinfo")
	public String list(User user,Model model){
		
		User userOne=userService.findOne(user.getUserId());
		
		System.out.println(userOne);
		model.addAttribute("userOne", userOne);
		
		
		return "/user/info/juser";
		
		
	}
	
	//修改当前用户信息
	@RequestMapping("/update")
	public String udpate(User user){
		
		userService.updateUser(user);
		
		return "redirect:/user/info/userinfo";
	}
	
	@RequestMapping("/productBrand")
	public String toProduct(){
		return "/user/info/product-brand";
	}
	
}
