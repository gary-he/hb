package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.tarena.ht.pojo.Statement;

public interface SellService {

	List<Statement> findAll();

	List<Statement> findByRules(String location, String departure, String passengerName, String pNR, String airlines,
			String ticketState, String ticketTime1, String ticketTime2, String payTime1, String payTime2);

	HSSFWorkbook createExcel(List<Statement> list);

	XSSFWorkbook createXSSFExcel(List<Statement> list, String path) throws Exception;

}
