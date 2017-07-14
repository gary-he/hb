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
			String Airlines, String ticketState, String ticketTime1, String ticketTime2,String payTime1,String payTime2) {
		
		return sellMapper.findByRules(location,departure,passengerName,PNR,
				Airlines,ticketState,ticketTime1,ticketTime2,payTime1,payTime2);
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
        //"票面字段"
        HSSFCellStyle style1 = workbook.createCellStyle();
        
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);   // 字体增粗
        font.setFontHeightInPoints((short) 12);  // 字体大小  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//边框
        style.setBorderBottom(border);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        
        style1.setFont(font);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 23));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 24, 28));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 29, 33));
        
        HSSFRow row1 = sheet.createRow(1);
       
        HSSFCell cell1 =row1.createCell(1);
        cell1.setCellValue("票面信息");
        cell1.setCellStyle(style1);
        
        
        cell1 = row1.createCell(24);
        cell1.setCellValue("销售明细");
        cell1.setCellStyle(style1);
        
        cell1 = row1.createCell(29);
        cell1.setCellValue("备注信息");
        cell1.setCellStyle(style1);
        */
        //表单头  项目名
        String [] result = {"序号","产品类型","票证状态","国际国内","航程类型","票证类型","承运人","承运人-票号","乘机人类型","乘客PNR","乘机人","航司二字代码","航司名字","始发地三字代码","目的地三字代码","始发地名称","目的地名称","航班","舱位","起飞时间","到达时间","账单价","税费","票面小计","采购代理费率","采购代理费","采购金额","毛利小计","订单号","建单用户","支付状态","建单时间","支付时间"};
        HSSFRow row2 = sheet.createRow(1);
        for (int i = 0; i < result.length; i++) {
        	HSSFCell cell2 = row2.createCell(i);
        	cell2.setCellValue(result[i]); 
		}
       
        int rowIndex = 0;
        int num = 1;
        int cellcol = 0;
        //打印内容
        for (Statement state : list) {
			//  gei..() 赋值
        	HSSFRow row3 = sheet.createRow(2+rowIndex++);
        	HSSFCell cell3 = row3.createCell(cellcol++);
        	cell3.setCellValue(num++);
        	
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getProductType()==null){
        		cell3.setCellValue("空");
        	}
        	
        	cell3.setCellValue(state.getProductType());
        	
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getOrder().getoState().equals("0")){
        		cell3.setCellValue("未出票");
        	}
        	if(state.getOrder().getoState().equals("1")){
        		cell3.setCellValue("已出票");
        	}
        	if(state.getOrder().getoState().equals("2")){
        		cell3.setCellValue("改签");
        	}
        	if(state.getOrder().getoState().equals("3")){
        		cell3.setCellValue("退票");
        	}
        	//cell3.setCellValue(state.getOrder().getoState());
        	
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getAbroadInland()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getAbroadInland());
        	
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfType()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfType());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getTickerType()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getTickerType());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfNumber()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfNumber());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getHaulierNomber()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getHaulierNomber());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getPassenger().getpType()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getPassenger().getpType());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getPassenger().getpId()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getPassenger().getpId());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getPassenger().getpName()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getPassenger().getpName());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfCompany()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfCompany());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfCompanyName()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfCompanyName());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfLocation()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfLocation());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfDeparture()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfDeparture());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfLocationName()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfLocationName());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfDepartureName()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfDepartureName());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfId()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfId());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfRank()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfRank());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfStarttime()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(TimeTool.getExcelTime(state.getFlight().getfStarttime()));
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfOvertime()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(TimeTool.getExcelTime(state.getFlight().getfOvertime()));
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfPrice()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfPrice());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfTax()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfTax());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfTotal()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfTotal());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getCommissionFreePercent()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getCommissionFreePercent());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getFlight().getfCommission()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getFlight().getfCommission());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getProcurement()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getProcurement());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getProfit()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getProfit());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getPassenger().getpOrderId()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getPassenger().getpOrderId());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getOrder().getUserPId()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(state.getOrder().getUserPId());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getOrder().getoPayment()==null){
        		cell3.setCellValue("空");
        	}
        	if(state.getOrder().getoPayment().equals("0")){
        		cell3.setCellValue("未支付");
        	}
        	if(state.getOrder().getoPayment().equals("1")){
        		cell3.setCellValue("支付成功");
        	}
        	if(state.getOrder().getoPayment().equals("2")){
        		cell3.setCellValue("支付失败");
        	}
        	//cell3.setCellValue(state.getOrder().getoPayment());
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getOrder().getoCreatetime()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(TimeTool.getExcelTime(state.getOrder().getoCreatetime()));
        	
        	cell3 = row3.createCell(cellcol++);
        	if(state.getOrder().getoPaytime()==null){
        		cell3.setCellValue("空");
        	}
        	cell3.setCellValue(TimeTool.getExcelTime(state.getOrder().getoPaytime()));
        	
        	cellcol=0;
		}
		
		
		
		
		return workbook;
	}
	
}
