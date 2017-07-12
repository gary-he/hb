package cn.tarena.ht.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.Md5Password;

@Controller
public class RegistController {
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping("/toregist")
	public String toRegist(Model model){
		//控制页面显示的模块	0显示登录	1显示注册
		model.addAttribute("type", 1);
		return "/loginAndRegist/loginAndRegist";
	}
	
	@RequestMapping("/regist")
	public String registUser(String userName,String[] password,Model model,HttpServletResponse response) throws IOException{
		User user=UserService.findUserByUserName(userName);
		if(user!=null){
			model.addAttribute("errorInfo", "用户名已存在");
			model.addAttribute("type", 1);
			return "/loginAndRegist/loginAndRegist";
		}
		if(!password[0].equals(password[1])){
			model.addAttribute("errorInfo", "两次密码不一致");
			model.addAttribute("type", 1);
			return "/loginAndRegist/loginAndRegist";
		}
		password[0]=Md5Password.getMd5HashPassword(password[0], userName);
		user=new User();
		user.setUsername(userName);
		user.setPassword(password[0]);
		UserService.saveUser(user);
		//注册成功，定时刷新3秒转跳首页
		response.setContentType("text/htm;charset=UTF-8");
		response.setHeader("Refresh", "3;URL=/home");
		response.getWriter().write("注册成功，3秒后转跳到首页！");
		return null;
	}
	
}
