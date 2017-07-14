<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>新增航班</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="update"><a href="#" onclick="formSubmit('save','_self');this.blur();">添加</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    新增航班
  </div> 
  
<div>

<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
	
		<tr class="odd">
			<td>航班编号:</td>
			<td><input type="text" name="fId" value="${flight.fId}"/></td>
			<td>航程类型:</td>
			<!-- <select id="fType">
			<option value="">单程</option>
			<option value="">往返</option>
			</select> -->
			<td><input type="text" name="fType" value="${flight.fType}"/></td>
		</tr>
		
		<tr class="odd">
			<td>航空公司代码:</td>
			<td><input type="text" name="fCompany" value="${flight.fCompany}"/></td>
			<td>航空公司:</td>
			<td><select id="dropAirlines" name="Airlines" class="form-control">
                            <option value="" >全部航司</option>
                                <option value="3U">3U-川航</option>
                                <option value="8C">8C-东星</option>
                                <option value="8L">8L-祥鹏</option>
                                <option value="9C">9C-春秋</option>
                                <option value="BK">BK-奥凯</option>
                                <option value="CA">CA-国航</option>
                                <option value="CN">CN-新华</option>
                                <option value="CZ">CZ-南航</option>
                                <option value="DR">DR-瑞丽航空</option>
                                <option value="DZ">DZ-东海</option>
                                <option value="EU">EU-成都(鹰联)</option>
                                <option value="FM">FM-上航</option>
                                <option value="FU">FU-福州航空</option>
                                <option value="G5">G5-华夏</option>
                                <option value="GJ">GJ-长龙航空</option>
                                <option value="GS">GS-天津</option>
                                <option value="GX">GX-广西航空</option>
                                <option value="GY">GY-多彩贵州航空</option>
                                <option value="HO">HO-吉祥</option>
                                <option value="HU">HU-海航</option>
                                <option value="JD">JD-首都(金鹿)</option>
                                <option value="JR">JR-幸福</option>
                                <option value="KN">KN-联航</option>
                                <option value="KY">KY-昆航</option>
                                <option value="MF">MF-厦航</option>
                                <option value="MU">MU-东航</option>
                                <option value="NS">NS-河北</option>
                                <option value="PN">PN-西部</option>
                                <option value="QW">QW-青岛</option>
                                <option value="SC">SC-山东</option>
                                <option value="TV">TV-西藏</option>
                                <option value="UQ">UQ-乌鲁木齐航空</option>
                                <option value="VD">VD-鲲鹏</option>
                                <option value="Y8">Y8-扬子江快运航空</option>
                                <option value="YI">YI-英安</option>
                                <option value="ZH">ZH-深航</option>
                        </select></td>
			<%-- <td><input type="text" name="fCompanyName" value="${flight.fCompanyName}"/></td> --%>
		</tr>
		
		<tr class="odd">
			<td>航司票证:</td>
			<td><input type="text" name="fNumber" value="${flight.fNumber}"/></td>
			<td>仓位代码:</td>
			<td><input type="text" name="fRank" value="${flight.fRank}"/></td>
		</tr>
		
		<tr class="odd">
			<td>始发地代码:</td>
			<td><input type="text" name="fLocation" value="${flight.fLocation}"/></td>
			<td>始发地名称:</td>
			<td><input type="text" name="fLocationName" value="${flight.fLocationName}"/></td>
			
		</tr>
		
		<tr class="odd">
		    <td>始发地机场:</td>
		    <td><input type="text" name="fLoAirport" value="${flight.fLoAirport}"/></td>
			<td>目的地代码:</td>
			<td><input type="text" name="fDeparture" value="${flight.fDeparture}"/></td>
		</tr>
		
		<tr class="odd">	
			<td>目的地名称:</td>
			<td><input type="text" name="fDepartureName" value="${flight.fDepartureName}"/></td>
			<td>目的地机场:</td>
			<td><input type="text" name="fDeAirport" value="${flight.fDeAirport}"/></td>
		</tr>
		
		<tr class="odd">
			<td>代理费:</td>
			<td><input type="text" name="fCommission" value="${flight.fCommission}"/></td>
			<td>起飞日期:</td>
			<td><input type="text" name="fStartDate" value="<fmt:formatDate value="${flight.fStartDate}"
			 pattern="yyyy-MM-dd"/>" />
			 </td>
		</tr>
		
		<tr class="odd">
			<td>起飞时间:</td>
			<td><input type="text" name="fStarttime" value="<fmt:formatDate value="${flight.fStarttime}"
			 pattern="HH:mm:ss"/>" />
			 </td>
			
			<td>到达时间:</td>
			<td><input type="text" name="fOvertime" value="<fmt:formatDate value="${flight.fOvertime}" 
			pattern="HH:mm:ss"/>"/>
			</td>
			
		</tr>
		
		<tr class="odd">
			<td>票面价:</td>
			<td><input type="text" name="fPrice" value="${flight.fPrice}"/></td>
			<td>税费:</td>
			<td><input type="text" name="fTax" value="${flight.fTax}"/></td>
		</tr>	
		
		<tr class="odd">
			<td>票面总价:</td>
			<td><input type="text" name="fTotal" value="${flight.fTotal}"/></td>
			<td>仓位数量:</td>
			<td><input type="text" name="fReserve" value="${flight.fReserve}"/></td>
			
		</tr>
		
	</table>
</div>
 
</div>
</form>
</body>
</html>

