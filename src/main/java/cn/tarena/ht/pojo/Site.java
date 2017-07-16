package cn.tarena.ht.pojo;

public class Site {
	
	private Integer sId;
	private String sFlightPId;
	private String sType;
	private Integer sRate;
	private Integer sNum;
	
	
	public Integer getsId() {
		return sId;
	}


	public void setsId(Integer sId) {
		this.sId = sId;
	}


	public String getsFlightPId() {
		return sFlightPId;
	}


	public void setsFlightPId(String sFlightPId) {
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
