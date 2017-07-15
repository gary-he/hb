package cn.tarena.ht.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	public String registUser(String userName,String[] password,Model model,HttpServletResponse response,HttpSession session) throws IOException{
		User user=UserService.findUserByUserName(userName);
		model.addAttribute("type", 1);
		//判断用户是否存在
		if(user!=null){
			model.addAttribute("errorInfo", "用户名已存在");
			return "/loginAndRegist/loginAndRegist";
		}
		//判断两次密码是否一致
		if(!password[0].equals(password[1])){
			model.addAttribute("errorInfo", "两次密码不一致");
			return "/loginAndRegist/loginAndRegist";
		}
		//对密码进行MD5hash算法加密
		String md5Password=Md5Password.getMd5HashPassword(password[0], userName);
		//注册信息正确，准备user对象
		user=new User();
		user.setUsername(userName);
		user.setPassword(md5Password);
		//注册
		UserService.saveUser(user);
		//注册成功，保存为登录状态，定时刷新3秒转跳首页
//		session.setAttribute("userSession", user);
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(userName,password[0]);
		try {
			subject.login(token);
			subject.getSession().setAttribute("userSession", user);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/htm;charset=UTF-8");
		response.setHeader("Refresh", "3;URL=/hb.action");
		response.getWriter().write("注册成功，3秒后转跳到首页！");
		return null;
	}
	
}
