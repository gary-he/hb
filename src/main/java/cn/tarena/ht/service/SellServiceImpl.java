package cn.tarena.ht.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.SellMapper;
import cn.tarena.ht.pojo.Statement;
import cn.tarena.ht.tool.TimeTool;

@Service
public class SellServiceImpl implements SellService {
	
	@Autowired
	private SellMapper sellMapper;
	
	
	@Override
	public List<Statement> findAll() {
		
		return sellMapper.findAll();
	}

	
	
	@Override
	public List<Statement> findByRules(String location, String departure, String passengerName, String PNR,
			String Airlines, String ticketState, Date ticketTime1, Date ticketTime2) {
		
		return sellMapper.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2);
	}


	/**
	 * 根据list 打印Excel
	 */
	@Override
	public HSSFWorkbook createExcel(List<Statement> list) {
		
		// 创建一个webbook，对应一个excel文件  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        // 在webbook中添加一个sheet,对应excel文件中的sheet  
        HSSFSheet sheet = workbook.createSheet("明细报表");  
        // 在sheet中添加文件信息第0行  
        HSSFRow row = sheet.createRow(0);
        //设置表头style
        HSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体  
        HSSFFont font = workbook.createFont();  
        // 字体增粗  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);  
        // 把字体应用到当前的样式  
        style.setFont(font);  
        
        HSSFCell cell =row.createCell(0);
        cell.setCellValue(TimeTool.getExcelTop(new Date())+":销售毛利统计");
        
        
        
        /*
         * 创建第二行   表单基本信息      全边框   字体微软雅黑   字体大小12
         * 	1.票面信息 合并 23列 
         *  2.利润明细 合并 5列 
         *  3.备注信息 合并 5列
        HSSFRow row1 = sheet.createRow(1);
        HSSFCellStyle style1 = workbook.createCellStyle();
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
        style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
        style1.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
        style1.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框   
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //居中
        sheet.addMergedRegion(new CellRangeAddress(1, 1, (short)1,(short)23));
       // sheet.addMergedRegion(new CellRangeAddress(1, 1, 2,5));
       // sheet.addMergedRegion(new CellRangeAddress(1, 1,3,5));
        style.setFont(font);  
        HSSFFont font1 = workbook.createFont(); 
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
        font.setFontHeightInPoints((short) 12);  
        HSSFCell cell1 =row1.createCell(1);
        cell1.setCellValue("票面信息");
        String result="序号,产品类型,票证状态,国际国内,航程类型,票证类型,承运人,承运人-票号,乘机人类型,乘客PNR,乘机人,航司二字代码,航司名字,"
				+ "始发地三字代码,目的地三字代码,始发地名称,目的地名称,航班,舱位,起飞时间,到达时间,账单价,税费,票面小计,采购代理费率,"
				+ "采购代理费,采购金额,毛利小计,订单号,建单用户,支付状态,建单时间,支付时间\n";
         */
        //表单头  项目名
        String [] result = {"序号","产品类型","票证状态","国际国内","航程类型","票证类型","承运人","承运人-票号","乘机人类型","乘客PNR","乘机人","航司二字代码","航司名字","始发地三字代码","目的地三字代码","始发地名称","目的地名称","航班","舱位","起飞时间","到达时间","账单价","税费","票面小计","采购代理费率","采购代理费","采购金额","毛利小计","订单号","建单用户","支付状态","建单时间","支付时间"};
        HSSFRow row2 = sheet.createRow(2);
        for (int i = 0; i < result.length; i++) {
        	HSSFCell cell2 = row2.createCell(i+1);
        	cell2.setCellValue(result[i]); 
		}
       
        int rowIndex = 0;
        int num = 1;
        //打印内容
        for (Statement state : list) {
			//  gei..() 赋值
        	HSSFRow row3 = sheet.createRow(3+rowIndex++);
        	HSSFCell cell3 = row3.createCell(1);
        	cell3.setCellValue(num++);
        	
        	cell3 = row3.createCell(2);
        	cell3.setCellValue(state.getProductType());
        	
        	cell3 = row3.createCell(3);
        	cell3.setCellValue(state.getOrder().getoState());
        	
        	cell3 = row3.createCell(4);
        	cell3.setCellValue(state.getAbroadInland());
        	
        	cell3 = row3.createCell(5);
        	cell3.setCellValue(state.getFlight().getfType());
        	
        	cell3 = row3.createCell(6);
        	cell3.setCellValue(state.getTickerType());
        	
        	cell3 = row3.createCell(7);
        	cell3.setCellValue(state.getFlight().getfNumber());
        	
        	cell3 = row3.createCell(8);
        	cell3.setCellValue(state.getHaulierNomber());
        	
        	cell3 = row3.createCell(9);
        	cell3.setCellValue(state.getPassenger().getpType());
        	
        	cell3 = row3.createCell(10);
        	cell3.setCellValue(state.getPassenger().getpId());
        	
        	cell3 = row3.createCell(11);
        	cell3.setCellValue(state.getPassenger().getpName());
        	
        	cell3 = row3.createCell(12);
        	cell3.setCellValue(state.getFlight().getfCompany());
        	
        	cell3 = row3.createCell(13);
        	cell3.setCellValue(state.getFlight().getfCompanyName());
        	
        	cell3 = row3.createCell(14);
        	cell3.setCellValue(state.getFlight().getfLocation());
        	
        	cell3 = row3.createCell(15);
        	cell3.setCellValue(state.getFlight().getfDeparture());
        	
        	cell3 = row3.createCell(16);
        	cell3.setCellValue(state.getFlight().getfLocationName());
        	
        	cell3 = row3.createCell(17);
        	cell3.setCellValue(state.getFlight().getfDepartureName());
        	
        	cell3 = row3.createCell(18);
        	cell3.setCellValue(state.getFlight().getfId());
        	
        	cell3 = row3.createCell(19);
        	cell3.setCellValue(state.getFlight().getfRank());
        	
        	cell3 = row3.createCell(20);
        	cell3.setCellValue(state.getFlight().getfStarttime());
        	
        	cell3 = row3.createCell(21);
        	cell3.setCellValue(state.getFlight().getfOvertime());
        	
        	cell3 = row3.createCell(22);
        	cell3.setCellValue(state.getFlight().getfPrice());
        	
        	cell3 = row3.createCell(23);
        	cell3.setCellValue(state.getFlight().getfTax());
        	
        	cell3 = row3.createCell(24);
        	cell3.setCellValue(state.getFlight().getfTotal());
        	
        	cell3 = row3.createCell(25);
        	cell3.setCellValue(state.getCommissionFreePercent());
        	
        	cell3 = row3.createCell(26);
        	cell3.setCellValue(state.getFlight().getfCommission());
        	
        	cell3 = row3.createCell(27);
        	cell3.setCellValue(state.getProcurement());
        	
        	cell3 = row3.createCell(28);
        	cell3.setCellValue(state.getProfit());
        	
        	cell3 = row3.createCell(29);
        	cell3.setCellValue(state.getPassenger().getpOrderId());
        	
        	cell3 = row3.createCell(30);
        	cell3.setCellValue(state.getOrder().getUserPId());
        	
        	cell3 = row3.createCell(31);
        	cell3.setCellValue(state.getOrder().getoPayment());
        	
        	cell3 = row3.createCell(32);
        	cell3.setCellValue(state.getOrder().getoCreatetime());
        	
        	cell3 = row3.createCell(33);
        	cell3.setCellValue(state.getOrder().getoPaytime());
        	
        	
		}
		
		
		
		
		return workbook;
	}
	
}
