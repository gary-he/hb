package cn.tarena.ht.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
	
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 导出Excel表 提供时间作为名字
	 * @param date
	 * @return
	 */
	public static String getExcelTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 表头设计时间
	 * @param date
	 * @return
	 */
	public static String getExcelTop(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	
}	
