package cn.tarena.ht.pojo;

import java.sql.Time;
import java.util.Date;

public class Flight{
	private String Id;
	private String fId;           //航班编号
	private String fType;         //航程类型
	private String fCompany;      //航空公司代码
	private String fCompanyName;  //航空公司
	private Integer fNumber;	      //航司票证
	private String fRank;         //仓位代码,折扣率
	private String fLocation;     //始发地三字代码
	private String fLocationName; //始发地名称
	private String fLoAirport;  //始发地机场
	private String fDeparture;    //目的地三字代码
	private String fDepartureName;//目的地名称
	private String fDeAirport;    //目的地机场名
	private Date fStarttime;      //起飞时间  f_satrttime
	private Date fOvertime;       //到达时间
	private Double fPrice;        //票面价
	private Integer fTax;         //税费
	private Double fTotal;        //票面总价
	private Integer fReserve;         //仓位数量
	private Double fCommission;   //代理费
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfType() {
		return fType;
	}
	public void setfType(String fType) {
		this.fType = fType;
	}
	public String getfCompany() {
		return fCompany;
	}
	public void setfCompany(String fCompany) {
		this.fCompany = fCompany;
	}
	public String getfCompanyName() {
		return fCompanyName;
	}
	public void setfCompanyName(String fCompanyName) {
		this.fCompanyName = fCompanyName;
	}
	public Integer getfNumber() {
		return fNumber;
	}
	public void setfNumber(Integer fNumber) {
		this.fNumber = fNumber;
	}
	public String getfRank() {
		return fRank;
	}
	public void setfRank(String fRank) {
		this.fRank = fRank;
	}
	public String getfLocation() {
		return fLocation;
	}
	public void setfLocation(String fLocation) {
		this.fLocation = fLocation;
	}
	public String getfLocationName() {
		return fLocationName;
	}
	public void setfLocationName(String fLocationName) {
		this.fLocationName = fLocationName;
	}
	public String getfLoAirport() {
		return fLoAirport;
	}
	public void setfLoAirport(String fLoAirport) {
		this.fLoAirport = fLoAirport;
	}
	public String getfDeparture() {
		return fDeparture;
	}
	public void setfDeparture(String fDeparture) {
		this.fDeparture = fDeparture;
	}
	public String getfDepartureName() {
		return fDepartureName;
	}
	public void setfDepartureName(String fDepartureName) {
		this.fDepartureName = fDepartureName;
	}
	public String getfDeAirport() {
		return fDeAirport;
	}
	public void setfDeAirport(String fDeAirport) {
		this.fDeAirport = fDeAirport;
	}
	public Date getfStarttime() {
		return fStarttime;
	}
	public void setfStarttime(Date fStarttime) {
		this.fStarttime = fStarttime;
	}
	public Date getfOvertime() {
		return fOvertime;
	}
	public void setfOvertime(Date fOvertime) {
		this.fOvertime = fOvertime;
	}
	public Double getfPrice() {
		return fPrice;
	}
	public void setfPrice(Double fPrice) {
		this.fPrice = fPrice;
	}
	public Integer getfTax() {
		return fTax;
	}
	public void setfTax(Integer fTax) {
		this.fTax = fTax;
	}
	public Double getfTotal() {
		return fTotal;
	}
	public void setfTotal(Double fTotal) {
		this.fTotal = fTotal;
	}
	public Integer getfReserve() {
		return fReserve;
	}
	public void setfReserve(Integer fReserve) {
		this.fReserve = fReserve;
	}
	public Double getfCommission() {
		return fCommission;
	}
	public void setfCommission(Double fCommission) {
		this.fCommission = fCommission;
	}
	@Override
	public String toString() {
		return "Flight [fId=" + fId + ", fType=" + fType + ", fCompany=" + fCompany + ", fCompanyName=" + fCompanyName
				+ ", fNumber=" + fNumber + ", fRank=" + fRank + ", fLocation=" + fLocation + ", fLocationName="
				+ fLocationName + ", fLoAirport=" + fLoAirport + ", fDeparture=" + fDeparture + ", fDepartureName="
				+ fDepartureName + ", fDeAirport=" + fDeAirport + ", fStarttime=" + fStarttime + ", fOvertime="
				+ fOvertime + ", fPrice=" + fPrice + ", fTax=" + fTax + ", fTotal=" + fTotal + ", fReserve=" + fReserve
				+ ", fCommission=" + fCommission + "]";
	}
	
	
	
	

}
