package cn.tarena.ht.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
//		if(flight.getfPrice() == null){
//			return 0.0;
//		}
//		
//		if(flight.getfCommission() == null){
//			return 0.0;
//		}
		
		Double price = flight.getNoNullPrice();
		Double commission = flight.getNoNullCommission();
		if(price == 0.0 || commission == 0.0){
			return 0.0;
		}
		double percent = commission/price;    // 采购率=代理费/票面价
		
		BigDecimal  b = new BigDecimal(percent); 
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		this.commissionFreePercent = Double.valueOf(f1);
		return this.commissionFreePercent;
	}
	
	public void setCommissionFreePercent(Double commissionFreePercent) {
		this.commissionFreePercent = commissionFreePercent;
	}
	
	public Double getProcurement() {
		
//		if(flight.getfTotal() == null){
//			return 0.0;
//		}
//		if(flight.getfCommission()==null){
//			return 0.0;
//		}
		
		double total = flight.getNoNullTotal();
		double commission = flight.getNoNullCommission();
		return total-commission;
	}
	public void setProcurement(Double procurement) {
		this.procurement = procurement;
	}
	
	
	
	public Double getProfit() {
		if(flight.getNoNullTotal()==null){
			return 0.0;
		}
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
	
	/**
	 * 提供导出Excel文件字段
	 * @return
	 */
	public String toCSVString() {
		return getProductType()+","+order.getoState()+","+getAbroadInland()+","+
				flight.getfType()+","+tickerType+","+flight.getfNumber()+","+getHaulierNomber()+","+
				passenger.getpType()+","+passenger.getpId()+","+passenger.getpName()+","+
				flight.getfCompany()+","+flight.getfCompanyName()+","+flight.getfLocation()+
				","+flight.getfDeparture()+","+flight.getfLocationName()+","+flight.getfDepartureName()+
				","+flight.getfId()+","+flight.getfRank()+","+flight.getfStarttime()+","+
				flight.getfOvertime()+","+flight.getfPrice()+","+flight.getfTax()+","+flight.getfTotal()+
				","+getCommissionFreePercent()+","+flight.getfCommission()+","+getProcurement()+","+getProfit()+
				","+order.getoId()+","+order.getUserPId()+","+order.getoPayment()+","+order.getoCreatetime()+
				","+order.getoPaytime();
	}
	
	/**
	 * 提供数据 数组
	 * @return
	 */
	public String [] toExcelString(){
		
		String [] date = {productType,order.getoState(),abroadInland,
				flight.getfType(),tickerType,flight.getfNumber().toString(),haulierNomber,
				passenger.getpType(),passenger.getpId(),passenger.getpName(),
				flight.getfCompany(),flight.getfCompanyName(),flight.getfLocation()
				,flight.getfDeparture(),flight.getfLocationName(),flight.getfDepartureName()
				,flight.getfId(),flight.getfRank(),"'"+flight.getfStarttime()+"'",
				flight.getfOvertime().toString(),flight.getfPrice().toString(),flight.getfTax().toString(),flight.getfTotal().toString()
				,getCommissionFreePercent().toString(),flight.getfCommission().toString(),getProcurement().toString(),getProfit().toString()
				,order.getoId(),order.getUserPId(),order.getoPayment(),order.getoCreatetime().toString()
				,order.getoPaytime().toString()
				};
		
	
		
		
		return date;
	}
	
	
	

	
	

	
	
}
