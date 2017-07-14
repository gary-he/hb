package cn.tarena.ht.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.mapper.FlightMapper;
import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Order;
import cn.tarena.ht.pojo.Passenger;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.FlightService;
import cn.tarena.ht.service.OrderService;
import cn.tarena.ht.service.PassengerService;
import cn.tarena.ht.tool.PNRUtils;

@Controller
public class PassengerController {
	@Autowired
	PassengerService passengerService;
	@Autowired
	FlightService flightService;
	@Autowired
	OrderService orderService;
	@Autowired
	FlightMapper flightMapper;

	// 订票跳转至保险确认页面
	@RequestMapping("/pay/insurance/{airlineType}")
	public String insurance(@PathVariable Integer airlineType, Model model,HttpSession session) {
		
		Flight flight = flightService.findOne(airlineType);
		
		model.addAttribute("flight", flight);
		
		String remUserName=((User)session.getAttribute("userSession")).getUsername();
		
		model.addAttribute("remUserName",remUserName);

		return "/hb/corptravel/pay/insurance";
	}

	// 订票 - 支付确认页面
	@SuppressWarnings("null")
	@RequestMapping("/pay/payment")
	public String payment(String airlineType, Model model, Passenger pa, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// 检查是否输入为空
		if (StringUtils.isEmpty(pa.getpName()) || StringUtils.isEmpty(pa.getpIdentily())
				|| StringUtils.isEmpty(pa.getpPhone())) {

			model.addAttribute("msg", "用户名,身份证,手机号均不能为空");

			return "/hb/corptravel/pay/insurance";//有空值则返回页面
		}

		Date date = new Date();
		String pid = PNRUtils.getPNRUtils().getPNR();// 乘客Id
//		String pid = UUID.randomUUID().toString();// 乘客Id
//		String poid = UUID.randomUUID().toString();// 乘客--订单关联id
		String oid = UUID.randomUUID().toString();// 订单id
		Order order = new Order();// 声明订单
		String userId = ((User)session.getAttribute("userSession")).getUserId();//用户Id
		String remUserName=((User)session.getAttribute("userSession")).getUsername();
		
		//设置乘客信息
		pa.setpId(pid);
		pa.setpFId(airlineType);
		pa.setpOrderId(oid);
		
		//设置订单信息
		order.setoId(oid);
		order.setUserPId(userId);//要根据用户ID来查询order信息
		order.setoPayment("0");
		order.setoState("0");
		order.setoCreatetime(date);
		order.setoUpdatetime(date);
//		order.setoPaytime(null);

		passengerService.add(pa,order);// 添加乘客.订单信息至数据库
		
		//查询飞机详情
		Flight flight=flightMapper.findOne(airlineType);
		
		//回传乘客,订单信息
		model.addAttribute("pa", pa);
		model.addAttribute("order",order);
		model.addAttribute("flight",flight);
		
		
		
		
		

		return "/hb/corptravel/pay/payment";
	}

}
