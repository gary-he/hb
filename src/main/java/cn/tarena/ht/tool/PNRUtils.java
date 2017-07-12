package cn.tarena.ht.tool;

import java.util.Arrays;
import java.util.Random;

public class PNRUtils {
	
	private static PNRUtils pnr = new PNRUtils();
	
	private String [] PNR  = {"HNPWFB","KN4KCG","JQ48Y6","HFZH5C","KNRDY9","JTDW0G","HGKJPW","359QSF","54RH5F","PJ35EF",
			"PF5X84","PV28EM","NV99LW","NW980Z","MKG6QP","IKL68Z","WEC51J","KYUU5D","BIRD7Z","VESZH8","4DAXCX"};
	
	private  PNRUtils() {
		
	}
	
	
	
	public static PNRUtils getPNRUtils(){
		return pnr;
	}
	
	public String getPNR(){
		Random ran = new Random();
		int index = ran.nextInt(19);
		
		return PNR[index];
	}
	
	
	
}
