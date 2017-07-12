package cn.tarena.ht.pojo;

/**
 * 报表展示类 以乘客为主查询
 * @author Administrator
 *
 */
public class Statement {
	
	private String id;
	private String productType = "机票";  //产品类型
	private String ticketState = "正常票";  //票证状态
	private String abroadInland = "国内"; //国际国内
	//private String fType ;   //航程类型
	private String tickerType = "BSP";   //票证类型
//	private String passnegerId ;  //PNR单号 主键
	//private String haulier;      //承运人
	private String haulierNomber = "999-112121212";//承运人-票号
	private Order order ;
	private Passenger passenger;
	private Flight flight;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTicketState() {
		return ticketState;
	}
	public void setTicketState(String ticketState) {
		this.ticketState = ticketState;
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
	@Override
	public String toString() {
		return "Statement [productType=" + productType + ", ticketState=" + ticketState + ", abroadInland="
				+ abroadInland + ", tickerType=" + tickerType + ", haulierNomber=" + haulierNomber + ", order=" + order
				+ ", passenger=" + passenger + ", flight=" + flight + "]";
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
