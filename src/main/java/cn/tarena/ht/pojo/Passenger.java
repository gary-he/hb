package cn.tarena.ht.pojo;

public class Passenger {
	private String pId;//乘客Id
	private String pName;//乘客姓名
	private String pSex;//乘客性别
	private String pIdentily;//身份证号码
	private String pPhone;//手机号
	private String pFId;//乘客--飞机ID
	private String pType;//乘客类型(成人,儿童)
	private String pOrderId;//乘客--订单Id
	

	public String getpOrderId() {
		return pOrderId;
	}
	public void setpOrderId(String pOrderId) {
		this.pOrderId = pOrderId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpSex() {
		return pSex;
	}
	public void setpSex(String pSex) {
		this.pSex = pSex;
	}
	public String getpIdentily() {
		return pIdentily;
	}
	public void setpIdentily(String pIdentily) {
		this.pIdentily = pIdentily;
	}
	public String getpPhone() {
		return pPhone;
	}
	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}
	public String getpFId() {
		return pFId;
	}
	public void setpFId(String pFId) {
		this.pFId = pFId;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	@Override
	public String toString() {
		return "Passenger [pId=" + pId + ", pName=" + pName + ", pSex=" + pSex + ", pIdentily=" + pIdentily
				+ ", pPhone=" + pPhone + ", pFId=" + pFId + ", pType=" + pType + ", pOrderId=" + pOrderId + "]";
	}
	
	
	
	
	
}
