<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>航班详情修改</title>
</head>
<script type="text/javascript" src="${ctx}/staticfile/js/datepicker/WdatePicker.js "></script>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="update"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    航班详情修改
  </div> 
  
<div>

<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
			<input type="hidden" name="id" value="${flight.id }"></input>
		<tr class="odd">
			<td>航班编号:</td>
			<td><input type="text" name="fId" value="${flight.fId}"/></td>
			<td>航程类型:</td>
			<td><input type="text" name="fType" value="${flight.fType}"/></td>
		</tr>
		
		<tr class="odd">
			<td>航空公司代码:</td>
			<td><input type="text" name="fCompany" value="${flight.fCompany}"/></td>
			<td>航空公司:</td>
			<td><input type="text" name="fCompanyName" value="${flight.fCompanyName}"/></td>
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
			 <td>税费:</td>
			<td><input type="text" name="fTax" value="${flight.fTax}"/></td>
			<td>代理费:</td>
			<td><input type="text" name="fCommission" value="${flight.fCommission}"/></td>
		</tr>
		
		<tr class="odd">
			<td>起飞时间:</td>
			<td><input type="text" name="fStarttime" value="<fmt:formatDate value="${flight.fStarttime}"
			 pattern="yyyy-MM-dd HH:mm:ss"/>" />
			 </td>
			<td>到达时间:</td>
			<td><input type="text" name="fOvertime" value="<fmt:formatDate value="${flight.fOvertime}" 
			pattern="yyyy-MM-dd HH:mm:ss"/>"/>
			</td>
		</tr>
		
		<tr class="odd">
				<td>航司票证:</td>
				<td><input type="text" name="fNumber" value="${flight.fNumber}"/></td>
				<td>票面价:</td>
				<td><input type="text" name="fPrice" value="${flight.fPrice}"/></td>
				<td>票面总价:</td>
				<td><input type="text" name="fTotal" value="${flight.fTotal}"/></td>
		</tr>
		
		
		<!-- 仓位信息 -->
		<c:if test="${empty sList }">
			<c:forEach begin="0" end="3" step="1" >
				<tr>
					<input type="hidden" name="sId" value="${site.sId }"></input>
					<input type="hidden" name="sFlightPId" value="${flight.id }"></input>
					<td>仓位类型</td>
					<td><input type="text" name="sType" ></td>
					<td>票率</td> 
					<td><input type="text" name="sRate" ></td>
					<td>仓位数量</td>
					<td><input type="text" name="sNum" ></td> 
				</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${!empty sList }">
			<c:forEach items="${sList }" var="site" >
				<tr>
					<input type="hidden" name="sId" value="${site.sId }"></input>
					<input type="hidden" name="sFlightPId" value="${flight.id }"></input>  
					<td>仓位类型</td>
					<td><input type="text" name="sType" value="${site.sType}"></td>
					<td>票率</td> 
					<td><input type="text" name="sRate" value="${site.sRate}"></td>
					<td>仓位数量</td>
					<td><input type="text" name="sNum" value="${site.sNum}"></td> 
				</tr>
			</c:forEach>
		</c:if>
		
		
		
	</table>
</div>
 
</div>
</form>
</body>
</html>

