package cn.tarena.ht.tool;

import java.util.Arrays;

public class PNRUtils {
	
	
	private char [] letter  = new char[36];
	
	private  PNRUtils() {
		for (int i = 0; i < 9; i++) {
			letter[i] = (char) (i+49);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		char i = 65;//A
		char u = 49;//1
		char u1 = 57;
		System.out.println(u1);
		
		PNRUtils r = new PNRUtils();
		System.out.println(Arrays.toString(r.letter));
	}
	
	
	public static String createPNR(){
		
		
		
		return "";
	}
	
	
}
