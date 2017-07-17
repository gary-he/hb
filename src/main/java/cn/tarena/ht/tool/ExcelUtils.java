package cn.tarena.ht.tool;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFWorkbook wb ;
	
	static{
		try {
			//通过类加载器读取配置文件的路径
			String path = ExcelUtils.class.getClassLoader().getResource("StatementStyle.xlsx").getPath();
			FileInputStream fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据key获取配置文件中的value
	 * @param string key
	 * @return string value
	 */
	public static XSSFWorkbook getWorkBook() {
		return wb;
	}
}
