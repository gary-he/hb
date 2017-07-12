package cn.tarena.ht.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.Md5Password;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tologin")
	public String toLogin(Model model){
		
		model.addAttribute("type", 0);
		return "/loginAndRegist/loginAndRegist";
	}
	
	@RequestMapping("/login")
	public String loginUser(String userName,String password,String remeberMe,
			Model model,HttpServletRequest request,HttpServletResponse response) 
					throws UnsupportedEncodingException{
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			//证明用户名或密码为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			model.addAttribute("type", 0);
			return "/loginAndRegist/loginAndRegist";
		}
		User user=userService.findUserByUserName(userName);
		password=Md5Password.getMd5HashPassword(password, userName);
		if(user==null||!user.getPassword().equals(password)){
			model.addAttribute("errorInfo", "用户名或密码不正确");
			model.addAttribute("type", 0);
			return "/loginAndRegist/loginAndRegist";
		}
		request.getSession().setAttribute("userSession", user);
		
		//处理记住用户
		if("remeber-me".equals(remeberMe)){
			Cookie rmCookie=new Cookie("rmCookie", URLEncoder.encode(userName, "utf-8"));
			rmCookie.setMaxAge(30*24*3600);
			rmCookie.setPath(request.getContextPath()+"/");
			response.addCookie(rmCookie);
			
		}else{
			Cookie rmCookie = new Cookie("remname", "");
			rmCookie.setMaxAge(0);
			rmCookie.setPath(request.getContextPath()+"/");
			response.addCookie(rmCookie);
		}
		return "redirect:"+request.getContextPath()+"/home";
	}
	
	
}
