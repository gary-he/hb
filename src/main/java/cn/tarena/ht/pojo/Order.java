package cn.tarena.ht.pojo;

import java.util.Date;

public class Order {
	
	private String oId;
	private String userPId;
	private String oPayment;
	private String oState;
	private Date oCreatetime;
	private Date oUpdatetime;
	private Date oPaytime;
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getUserPId() {
		return userPId;
	}
	public void setUserPId(String userPId) {
		this.userPId = userPId;
	}
	public String getoPayment() {
		return oPayment;
	}
	public void setoPayment(String oPayment) {
		this.oPayment = oPayment;
	}
	public String getoState() {
		return oState;
	}
	public void setoState(String oState) {
		this.oState = oState;
	}
	public Date getoCreatetime() {
		return oCreatetime;
	}
	public void setoCreatetime(Date oCreatetime) {
		this.oCreatetime = oCreatetime;
	}
	public Date getoUpdatetime() {
		return oUpdatetime;
	}
	public void setoUpdatetime(Date oUpdatetime) {
		this.oUpdatetime = oUpdatetime;
	}
	public Date getoPaytime() {
		return oPaytime;
	}
	public void setoPaytime(Date oPaytime) {
		this.oPaytime = oPaytime;
	}
	@Override
	public String toString() {
		return "Order [oId=" + oId + ", userPId=" + userPId + ", oPayment=" + oPayment + ", oState=" + oState
				+ ", oCreatetime=" + oCreatetime + ", oUpdatetime=" + oUpdatetime + ", oPaytime=" + oPaytime + "]";
	}
	
	
	
	
}
