package cn.tarena.ht.tool;

import java.util.HashMap;
import java.util.Map;

public class AirportCode {
	
	private Map<String,String> ac;
	private static AirportCode singleton = new AirportCode();
	private AirportCode() {
		ac = new HashMap<String,String>();
		ac.put("广州", "CAN");
		ac.put("上海", "SHA");
		ac.put("北京", "PEK");
		ac.put("深圳", "SZX");
		ac.put("成都", "CTU");
		ac.put("海口", "HAK");
		ac.put("南京", "NKG");
		ac.put("重庆", "CKG");
		ac.put("西安", "XIY");
		ac.put("长沙", "CSX");
		ac.put("杭州", "HGH");
		ac.put("哈尔滨", "HRB");
		ac.put("昆明", "KMG");
		ac.put("厦门", "XMN");
		ac.put("大连", "DLC");
		ac.put("武汉", "WUH");
		ac.put("青岛", "TAO");
		ac.put("乌鲁木齐", "URC");
		ac.put("济南", "TNA");
		ac.put("南宁", "NNG");
		ac.put("天津", "TSN");
		ac.put("沈阳", "KHE");
		ac.put("桂林", "KWL");
		ac.put("温州", "WNZ");
	}
	
	public static String findCode(String code){
		return singleton.ac.get(code);
	}
	
	

}
