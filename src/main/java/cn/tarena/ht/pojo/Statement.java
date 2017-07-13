package cn.tarena.ht.pojo;

import org.junit.Test;

import com.google.common.annotations.VisibleForTesting;

/**
 * 报表展示类 以乘客为主查询
 * @author Administrator
 *
 */
public class Statement {
	
	private String id;
	private String productType = "机票";  //产品类型
	private String abroadInland = "国内"; //国际国内
	private String tickerType = "BSP";   //票证类型
	private String haulierNomber = "999-112121212";//承运人-票号
	private Order order ;
	private Passenger passenger;
	private Flight flight;
	private Double commissionFreePercent;  // 代理费率
	private Double procurement;             //采购价
	private Double profit;   //利润
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAbroadInland() {
		return abroadInland;
	}
	public void setAbroadInland(String abroadInland) {
		this.abroadInland = abroadInland;
	}
	public String getTickerType() {
		return tickerType;
	}
	public void setTickerType(String tickerType) {
		this.tickerType = tickerType;
	}
	public String getHaulierNomber() {
		return haulierNomber;
	}
	public void setHaulierNomber(String haulierNomber) {
		this.haulierNomber = haulierNomber;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Double getCommissionFreePercent() {
		double price = flight.getfPrice();
		double commission = flight.getfCommission();
		double percent = commission/price;    // 采购率=代理费/票面价
		
		String num = String.valueOf(percent);
		String str = num.substring(0, 6);
		
		return Double.valueOf(str);
	}
	
	public void setCommissionFreePercent(Double commissionFreePercent) {
		this.commissionFreePercent = commissionFreePercent;
	}
	
	public Double getProcurement() {
		double total = flight.getfTotal();
		double commission = flight.getfCommission();
		return total-commission;
	}
	public void setProcurement(Double procurement) {
		this.procurement = procurement;
	}
	
	
	
	public Double getProfit() {
		double total = flight.getfTotal();
		return  total-getProcurement();
	
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "Statement [id=" + id + ", productType=" + productType + ", abroadInland=" + abroadInland
				+ ", tickerType=" + tickerType + ", haulierNomber=" + haulierNomber + ", order=" + order
				+ ", passenger=" + passenger + ", flight=" + flight + ", commissionFreePercent=" + commissionFreePercent
				+ ", procurement=" + procurement + ", profit=" + profit + "]";
	}
	
	/*
	 * 	票证类型	承运人	
	 * 承运人-票号	乘机人类型	乘客PNR	乘机人	航司二字代码	航司名字	始发地三字代码	目的地三字代码	始发地名称	目的地名称	
	 * 航班	舱位	起飞时间	到达时间	账单价	税费	票面小计	采购代理费率	采购代理费	采购金额	毛利小计	订单号	
	 * 建单用户	支付状态	建单时间	支付时间

	 */
	/**
	 * 提供导出Excel文件字段
	 * @return
	 */
	public String toExcelString() {
		return productType+","+order.getoState()+","+abroadInland+","+
				flight.getfType()+","+tickerType+","+flight.getfNumber()+","+haulierNomber+","+
				passenger.getpType()+","+passenger.getpId()+","+passenger.getpName()+","+
				flight.getfCompany()+","+flight.getfCompanyName()+","+flight.getfLocation()+
				","+flight.getfDeparture()+","+flight.getfLocationName()+","+flight.getfDepartureName()+
				","+flight.getfId()+","+flight.getfRank()+","+flight.getfStarttime()+","+
				flight.getfOvertime()+","+flight.getfPrice()+","+flight.getfTax()+","+flight.getfTotal()+
				","+getCommissionFreePercent()+","+flight.getfCommission()+","+getProcurement()+","+getProfit()+
				","+order.getoId()+","+order.getUserPId()+","+order.getoPayment()+","+order.getoCreatetime()+
				","+order.getoPaytime();
	}
	
	
	//private String pType;//乘机人类型
	//private String pName;//乘客名称
//	private String fCompany;      //航司名字二字代码
//	private String fCompanyName;  //航司名称
//	private String fLocation;     //始发地三字代码
//	private String fLocationName; //始发地名称
//	private String fDeparture;    //目的地三字代码
//	private String fDepartureName;//目的地名称
//	private String fId;     //航班编号
//	private String fRank;         //仓位
//	private String fStarttime;    //起飞时间
//	private String fOvertime;     //到达时间
//	private Double fPrice;        //票面价
//	private Double fTax;          //税费
//	private Double fTotal;        //票面小计
//	private Double fCommission;   // 代理费
	
	
	
	

	
	

	
	
}
