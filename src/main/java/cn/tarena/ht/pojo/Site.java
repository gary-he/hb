package cn.tarena.ht.pojo;

public class Site {
	
	private int sId;
	private Integer sFlightPId;
	private String sType;
	private Integer sRate;
	private Integer sNum;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public Integer getsFlightPId() {
		return sFlightPId;
	}
	public void setsFlightPId(Integer sFlightPId) {
		this.sFlightPId = sFlightPId;
	}
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public Integer getsRate() {
		return sRate;
	}
	public void setsRate(Integer sRate) {
		this.sRate = sRate;
	}
	public Integer getsNum() {
		return sNum;
	}
	public void setsNum(Integer sNum) {
		this.sNum = sNum;
	}
	@Override
	public String toString() {
		return "Site [sId=" + sId + ", sFlightPId=" + sFlightPId + ", sType=" + sType + ", sRate=" + sRate + ", sNum="
				+ sNum + "]";
	}
	
	
	
}
