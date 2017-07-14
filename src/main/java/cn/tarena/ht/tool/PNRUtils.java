package cn.tarena.ht.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class PNRUtils {
	
	private static PNRUtils pnr = new PNRUtils();
	
	private String [] PNR  = {"HNPWFB","KN4KCG","JQ48Y6","HFZH5C","KNRDY9","JTDW0G","HGKJPW","359QSF","54RH5F","PJ35EF",
			"PF5X84","PV28EM","NV99LW","NW980Z","MKG6QP","IKL68Z","WEC51J","KYUU5D","BIRD7Z","VESZH8","4DAXCX"};
	
	
	private  PNRUtils() {
		
	}
	
	
	
	public static PNRUtils getPNRUtils(){
		return pnr;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			String str = getPNR();
			System.out.println(str);
			
		}
	}
	@Test
	public static String getPNR(){
		 char c = 'i';
         StringBuffer sb = new StringBuffer();
         
         for (int i = 0; i < 6; i++) {
             int a = Math.abs((new Random()).nextInt(33));// 产生0~57的随机数
             if (a <= 9) {// 将0~9转为char的0~9
                 sb.append((char) (a + 48));
             } else if (a < 33) {// 将10~33转为char的A~Z
                 if((a + 55) == 79 || (a + 55) == 73){
                     sb.append((char) (a + 63));
                 }else{
                     sb.append((char) (a + 55));
                 }
             } 
         }
         String ss  = sb.toString();
		return ss;
	}
	

	
}
