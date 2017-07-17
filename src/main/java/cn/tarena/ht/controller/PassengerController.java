package cn.tarena.ht.controller;

import java.text.SimpleDateFormat;
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


	// 订票跳转至保险确认页面
	@RequestMapping("/pay/insurance/{airlineType}")
	public String insurance(@PathVariable String airlineType, Model model,HttpSession session) {
		
		//获取航班
		Flight flight = flightService.findOne(airlineType);
		
		//航班耗时
		Date pTakeTime = new Date(flight.getfOvertime().getTime()-flight.getfStarttime().getTime()-28800000);//东八区减少8小时
		
		//回显用户名
		String remUserName=((User)session.getAttribute("userSession")).getUsername();
		
		//回显用户
		model.addAttribute("remUserName",remUserName);
		
		model.addAttribute("flight", flight);
		
		model.addAttribute("pTakeTime",pTakeTime);

		return "/hb/corptravel/pay/insurance";
	}

	// 订票 - 支付确认页面
	//@SuppressWarnings("null")
	@RequestMapping("/pay/payment")
	public String payment(String airlineType, Model model, Passenger pa
			, HttpSession session) {
		
		System.out.println(pa);
		// 检查是否输入为空
		if (StringUtils.isEmpty(pa.getpName()) || StringUtils.isEmpty(pa.getpIdentily())
				|| StringUtils.isEmpty(pa.getpPhone())) {

			model.addAttribute("msg", "用户名,身份证,手机号均不能为空");
			model.addAttribute("pa",pa);

			return "/hb/corptravel/pay/insurance";//有空值则返回页面
		}
		
		

		Date date = new Date();
		//String pid = PNRUtils.getPNRUtils().getPNR();// 乘客Id
		String pid = PNRUtils.getPNR();// 乘客Id
		String oid = UUID.randomUUID().toString();// 订单id
		Order order = new Order();// 声明订单
		String userId = ((User)session.getAttribute("userSession")).getUserId();//用户Id
		String remUserName=((User)session.getAttribute("userSession")).getUsername();
		
		//获取航班信息
		Flight flight=passengerService.findOne(airlineType);
		
		//设置乘客信息
		pa.setpId(pid);
		pa.setpFId(flight.getId().toString());
		pa.setpOrderId(oid);
		
		//设置订单信息
		order.setoId(oid);
		order.setUserPId(pid);//要根据用户ID来查询order信息
		order.setoPayment("0");
		order.setoState("0");
		order.setoCreatetime(date);
		order.setoUpdatetime(date);

		passengerService.add(pa,order);// 添加乘客.订单信息至数据库
		
		//回传乘客,订单信息
		model.addAttribute("pa", pa);
		model.addAttribute("order",order);
		model.addAttribute("flight",flight);
		model.addAttribute("remUserName",remUserName);//用户回显
		
		System.out.println("/pay/payment");
		System.out.println(flight);
		
		return "/hb/corptravel/pay/payment";
	}

	@RequestMapping("/pay/succeed")
	public String payOrder(String orderId,String totalPrice,Model model){
		
		System.out.println(orderId);
		System.out.println(totalPrice);
		//设置更改和支付时间
		Date date=new Date();
		
		
		passengerService.updateOrder(orderId,date);
		
		System.out.println(1);
		
		//获取订单Id和价格
		model.addAttribute("orderId", orderId);
		model.addAttribute("totalPrice",totalPrice);
		
		System.out.println("paySuccess");
		System.out.println(orderId);
		System.out.println(totalPrice);
		
		return "/hb/corptravel/pay/succeed";
	}
	
	
	@RequestMapping("/order/orderInfo")
	public String orderList(String orderId,String totalPrice,Model model,HttpSession session){
		
		String remUserName=((User)session.getAttribute("userSession")).getUsername();
		System.out.println(remUserName);
		
		//获取Order信息
		Order orderInfo=passengerService.getOrderById(orderId);
		Passenger passenger=passengerService.getPassengerByOrderId(orderId);
		Flight flight=passengerService.getFlightByOrderId(orderId);
		
		//回传
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("passenger", passenger);
		model.addAttribute("flight",flight);
		model.addAttribute("remUserName",remUserName);
		
		
		return "/hb/corptravel/order/orderInfo";
	}
		
	


}
