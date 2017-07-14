package cn.tarena.ht.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	public String toLogin(Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		//控制页面显示的模块	0显示登录	1显示注册
		model.addAttribute("type", 0);
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			if("rmCookie".equals(cookie.getName())){
				model.addAttribute("rmCookie", URLDecoder.decode(cookie.getValue(), "utf-8"));
			}
		}
		return "/loginAndRegist/loginAndRegist";
	}
	
	@RequestMapping("/login")
	public String loginUser(String userName,String password,String remeberMe,
			Model model,HttpServletRequest request,HttpServletResponse response) 
					throws UnsupportedEncodingException{
		//非空校验
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			//证明用户名或密码为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			model.addAttribute("type", 0);
			return "/loginAndRegist/loginAndRegist";
		}
		
		//shiro的登录校验
		Subject subjetct=SecurityUtils.getSubject();
		
		//将用户的数据封装为令牌
		UsernamePasswordToken token =new UsernamePasswordToken(userName,password);
		
		try {
			//通过subject实现登录
			subjetct.login(token);
			
			//登录成功，获取真实用户对象
			User user=(User) subjetct.getPrincipal();
			
			//保存用户进session
			subjetct.getSession().setAttribute("userSession", user);
			
			//“记住用户”功能，用cookie实现
			if("remeber-me".equals(remeberMe)){
				Cookie rmCookie=new Cookie("rmCookie", URLEncoder.encode(userName, "utf-8"));
				rmCookie.setMaxAge(30*24*3600);
				rmCookie.setPath(request.getContextPath()+"/");
				response.addCookie(rmCookie);
			}else{
				Cookie rmCookie = new Cookie("rmCookie", "");
				rmCookie.setMaxAge(0);
				rmCookie.setPath(request.getContextPath()+"/");
				response.addCookie(rmCookie);
			}
			
			//转跳到前台首页
			return "redirect:/hb.action";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			//登录失败，输出信息到页面
			model.addAttribute("errorInfo", "用户名或密码错误");
			model.addAttribute("type", 0);
			return "/loginAndRegist/loginAndRegist";
		}
		

		/*//验证用户登录信息
		User user=userService.findUserByUserName(userName);
		password=Md5Password.getMd5HashPassword(password, userName);
		if(user==null||!user.getPassword().equals(password)){
			model.addAttribute("errorInfo", "用户名或密码不正确");
			model.addAttribute("type", 0);
			return "/loginAndRegist/loginAndRegist";
		}
		//登录成功，保存用户到session
		request.getSession().setAttribute("userSession", user);
		
		//“记住用户”功能，用cookie实现
		if("remeber-me".equals(remeberMe)){
			Cookie rmCookie=new Cookie("rmCookie", URLEncoder.encode(userName, "utf-8"));
			rmCookie.setMaxAge(30*24*3600);
			rmCookie.setPath(request.getContextPath()+"/");
			response.addCookie(rmCookie);
		}else{
			Cookie rmCookie = new Cookie("rmCookie", "");
			rmCookie.setMaxAge(0);
			rmCookie.setPath(request.getContextPath()+"/");
			response.addCookie(rmCookie);
		}
		return "redirect:"+request.getContextPath()+"/home";*/
	}
	
	@RequestMapping("/logout")
	public String logoutUser(Model model,HttpSession session){
		session.removeAttribute("sessionUser");
		model.addAttribute("type", 0);
		return "/loginAndRegist/loginAndRegist";
	}
}
