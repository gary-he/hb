package cn.tarena.ht.pojo;

/**
 * 
 * @author Administrator
 *
 */
public class SysStatement {
	/*
	 * 
FieldTypeComment
product_type  varbinary(5) NULL产品类型
ticket_state  varchar(5) NULL票证状态
abroad_inland   varchar(5) NULL国际国内
flight_type   varchar(5) NULL航程类型
ticker_type   varchar(5) NULL票证类型
passneger_id   varchar(6) NOT NULLPNR单号
haulier   varchar(3) NULL承运人
haulier_nomber   varchar(14) NULL承运人-票号
passneger_type   varchar(5) NULL乘机人类型
passneger_name   varchar(10) NULL乘机人
company   varchar(2) NULL航司二字代码
company_name   varchar(10) NULL航司名字
location   varchar(3) NULL始发地三字代码
location_name   varchar(10) NULL始发地名称
departure   varchar(3) NULL目的地三字代码
departure_name   varchar(10) NULL目的地名称
flight_id   varchar(6) NULL航班
rank   varchar(2) NULL舱位
start_time   datetime NULL起飞时间
over_time   datetime NULL到达时间
price   double NULL账单价
tax   double NULL机建
total   double NULL票面小
	 */
	private String productType;  //产品类型
	private String ticketState;  //票证状态
	private String abroadInland; //国际国内
	private String flightType;   //航程类型
	private String tickerType;   //票证类型
	private String passnegerId;  //PNR单号
	private String haulier;      //承运人
	private String haulierNomber;//承运人-票号
	private String passnegerType;//乘机人类型
	private String passnegerName;//航司二字代码
	private String company;      //航司名字二字代码
	private String companyName;  //航司名称
	private String location;     //始发地三字代码
	private String locationName; //始发地名称
	private String departure;    //目的地三字代码
	private String departureName;//目的地名称
	private String flightId;     //航班编号
	private String rank;         //仓位
	private String startTime;    //起飞时间
	private String overTime;     //到达时间
	private Double price;        //票面价
	private Double tax;          //税费
	private Double total;        //票面小计
	
	
	
	
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




	public String getFlightType() {
		return flightType;
	}




	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}




	public String getTickerType() {
		return tickerType;
	}




	public void setTickerType(String tickerType) {
		this.tickerType = tickerType;
	}




	public String getPassnegerId() {
		return passnegerId;
	}




	public void setPassnegerId(String passnegerId) {
		this.passnegerId = passnegerId;
	}




	public String getHaulier() {
		return haulier;
	}




	public void setHaulier(String haulier) {
		this.haulier = haulier;
	}




	public String getHaulierNomber() {
		return haulierNomber;
	}




	public void setHaulierNomber(String haulierNomber) {
		this.haulierNomber = haulierNomber;
	}




	public String getPassnegerType() {
		return passnegerType;
	}




	public void setPassnegerType(String passnegerType) {
		this.passnegerType = passnegerType;
	}




	public String getPassnegerName() {
		return passnegerName;
	}




	public void setPassnegerName(String passnegerName) {
		this.passnegerName = passnegerName;
	}




	public String getCompany() {
		return company;
	}




	public void setCompany(String company) {
		this.company = company;
	}




	public String getCompanyName() {
		return companyName;
	}




	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getLocationName() {
		return locationName;
	}




	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}




	public String getDeparture() {
		return departure;
	}




	public void setDeparture(String departure) {
		this.departure = departure;
	}




	public String getDepartureName() {
		return departureName;
	}




	public void setDepartureName(String departureName) {
		this.departureName = departureName;
	}




	public String getFlightId() {
		return flightId;
	}




	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}




	public String getRank() {
		return rank;
	}




	public void setRank(String rank) {
		this.rank = rank;
	}




	public String getStartTime() {
		return startTime;
	}




	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}




	public String getOverTime() {
		return overTime;
	}




	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}




	public Double getPrice() {
		return price;
	}




	public void setPrice(Double price) {
		this.price = price;
	}




	public Double getTax() {
		return tax;
	}




	public void setTax(Double tax) {
		this.tax = tax;
	}




	public Double getTotal() {
		return total;
	}




	public void setTotal(Double total) {
		this.total = total;
	}




	@Override
	public String toString() {
		return "SysStatement [productType=" + productType + ", ticketState=" + ticketState + ", abroadInland="
				+ abroadInland + ", flightType=" + flightType + ", tickerType=" + tickerType + ", passnegerId="
				+ passnegerId + ", haulier=" + haulier + ", haulierNomber=" + haulierNomber + ", passnegerType="
				+ passnegerType + ", passnegerName=" + passnegerName + ", company=" + company + ", companyName="
				+ companyName + ", location=" + location + ", locationName=" + locationName + ", departure=" + departure
				+ ", departureName=" + departureName + ", flightId=" + flightId + ", rank=" + rank + ", startTime="
				+ startTime + ", overTime=" + overTime + ", price=" + price + ", tax=" + tax + ", total=" + total + "]";
	}
	
	
	
}
