<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>航班详情</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    航班详情
  </div> 
  
<div>

<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
	
		<tr class="odd">
			<td>航班ID:</td>
			<td>${flight.id}</td>
			<td>航班编号:</td>
			<td>${flight.fId}</td>
		</tr>
		
		<tr class="odd">
			<td>航空公司代码:</td>
			<td>${flight.fCompany}</td>
			<td>航空公司:</td>
			<td>${flight.fCompanyName}</td>
		</tr>
		
		<tr class="odd">
			<td>航司票证:</td>
			<td>${flight.fNumber}</td>
			<td>税费:</td>
			<td>${flight.fTax}</td>
		</tr>
		
		<tr class="odd">
			<td>始发地代码:</td>
			<td>${flight.fLocation}</td>
			<td>始发地名称:</td>
			<td>${flight.fLocationName}</td>
		</tr>
		
		<tr class="odd">
		    <td>始发地机场:</td>
			<td>${flight.fLoAirport}</td>
			<td>目的地代码:</td>
			<td>${flight.fDeparture}</td>
		</tr>
		
		<tr class="odd">	
			<td>目的地名称:</td>
			<td>${flight.fDepartureName}</td>
			<td>目的地机场:</td>
			<td>${flight.fDeAirport}</td>
		</tr>
		
		<tr class="odd">
			<td>航程类型:</td>
			<td>${flight.fType}</td>
			<td>代理费:</td>
			<td>${flight.fCommission}</td>
		</tr>
		
		<tr class="odd">
			<td>起飞时间:</td>
			<td><fmt:formatDate value="${flight.fStarttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>到达时间:</td>
			<td><fmt:formatDate value="${flight.fOvertime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		
		<tr class="odd">
			<td>票面价:</td>
			<td>${flight.fPrice}</td>
			<td>票面总价:</td>
			<td>${flight.fTotal}</td>
			
		</tr>
		
		<!-- 仓位信息 -->		
		<c:forEach items="${flight.sList }" var="site">
			<tr>
				<td>仓位类型</td>
				<td>${site.sType}</td>
				<td>票率</td> 
				<td>${site.sRate}</td>
				<td>仓位数量</td>
				<td>${site.sNum}</td> 
			</tr>
		</c:forEach>
	
	</table>
</div>
 
</div>
</form>
</body>
</html>

