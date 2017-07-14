package cn.tarena.ht.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Statement;
import cn.tarena.ht.service.SellService;
import cn.tarena.ht.tool.TimeTool;
import cn.tarena.ht.tool.TimeUtils;

//报表controller
@Controller
@RequestMapping("/admin/forms")
public class SellController extends BaseController{
	
	@Autowired
	private SellService sellService;
	
	/**
	 * 跳转至 报表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String toSell(Model model){
		List<Statement> list = sellService.findAll();
		model.addAttribute("statementList", list);
		return "/admin/forms/jStatementList";
	}
	
	/**String location,String departure,String passengerName,String PNR,
			String Airlines,String ticketState
	 * 按照日期查询 Date ticketTime1,Date ticketTime2
	 * @return
	 */
	@RequestMapping("/tofind")
	public String findAllByDay(String location,String departure,String passengerName,String PNR,
			String Airlines,String ticketState,Date ticketTime1,Date ticketTime2,Model model){

		location = location.trim();
		departure = departure.trim();
		passengerName = passengerName.trim();
		PNR = PNR.trim();
		Airlines = Airlines.trim();
		ticketState = ticketState.trim();
		
		List<Statement> list = sellService.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2);
		model.addAttribute("statementList",list);
		
		
		return "/admin/forms/jStatementList";
	}
	
	@RequestMapping("/download")
	public void download(String location,String departure,String passengerName,String PNR,
			String Airlines,String ticketState,Date ticketTime1,Date ticketTime2,HttpServletResponse response) throws IOException{
		
		
		
		List<Statement> list = sellService.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2);
		
		int num = 1;//序号
		String result="序号,产品类型,票证状态,国际国内,航程类型,票证类型,承运人,承运人-票号,乘机人类型,乘客PNR,乘机人,航司二字代码,航司名字,"
				+ "始发地三字代码,目的地三字代码,始发地名称,目的地名称,航班,舱位,起飞时间,到达时间,账单价,税费,票面小计,采购代理费率,"
				+ "采购代理费,采购金额,毛利小计,订单号,建单用户,支付状态,建单时间,支付时间\n";
		for (Statement statement : list) {
			System.out.println(statement.toCSVString());
			result = result +num+","+statement.toCSVString()+"\n";
			num++;
		}
		response.setCharacterEncoding("GBK");
		response.setHeader("Content-Disposition", 
				"attachment;filename="+TimeUtils.getTimeStamp("yyyyMMddHHmmssSSS")+".csv");
		response.getWriter().write(result);
		
	}
	
	@RequestMapping("/download/jj")
	public void download2(String location,String departure,String passengerName,String PNR,
			String Airlines,String ticketState,Date ticketTime1,Date ticketTime2,HttpServletResponse response){
		
		List<Statement> list = sellService.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2);
		
		HSSFWorkbook workbook = sellService.createExcel(list);
		//定义excle名称 ISO-8859-1防止名称乱码  
		try {
			String fileName = new String(
					("明细报表"+TimeTool.getExcelTime(new Date())+".xls").getBytes(),"ISO-8859-1");
			response.setCharacterEncoding("GBK");
			response.setHeader("Content-Disposition", 
					"attachment;filename="+fileName);
			workbook.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
