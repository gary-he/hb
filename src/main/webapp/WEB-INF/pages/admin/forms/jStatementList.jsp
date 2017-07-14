<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>报表</title>
	<script type="text/javascript" src="${ctx}/staticfile/js/datepicker/WdatePicker.js "></script>
	<script type="text/javascript">
		 function wol(){
			var mydateInput = document.getElementById("mydate");
			var date = new Date();
			var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
			mydateInput.value=dateString;
			document.getElementById(elementId)
		 }
		 
</script>
	<style type="text/css">
		.eXtremeTable {
			padding:10px;
		}
	</style>
</head>
<body  onload="wol();">
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
 <!--  <div id="navMenubar">
<ul>
	
</ul>

		
  </div>-->
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    报表
  </div> 
<!-- 		/hb/src/main/webapp/WEB-INF/pages/admin/forms/ -->
			<form action="tofind"  method="POST">
				出票时间: <input id="qq" type="text" name="ticketTime1" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" />
				至
				<input type="text" name="ticketTime2" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" />
				&nbsp;
				&nbsp;
				始发地: <input type="text" name="location"/>&nbsp;&nbsp; 目的地: <input type="text" name="departure"/>
				<br/>
				<br/>
				乘客名: <input type="text" name="passengerName" />
				PNR: <input type="text" name="PNR" />
				&nbsp;
				&nbsp;
				航空公司:
				<select id="dropAirlines" name="Airlines" class="form-control">
                            <option value="">全部航司</option>
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
                        </select>
				&nbsp;
				&nbsp;
				客票状态:
				<select name="ticketState">
					<option value="">---无---</option>
					<option value="1">已出票</option>
					<option value="2">改签</option>
					<option value="3">已退票</option>
					<option value="0">未支付</option>
				</select>
				
				<input type="submit" value="查询"/>
				<h1>销售榜单</h1>
				<a href="download/jj">销售下载</a>
			</form>



  
<div >


<div class="eXtremeTable" style="position:absolute; height:400px;width:100%"  >
<table id="ec_table" class="tableRegion"    >
	<thead>
	<tr>
		<td class="tableHeader" colspan="24" align="centre">票面信息</td>
	</tr>
	<tr>
		
		<td class="tableHeader">序号</td>
		<td class="tableHeader">产品类型</td>
		<td class="tableHeader">票证状态</td>
		<td class="tableHeader">国际国内</td>
		<td class="tableHeader">航程类型</td>
		<td class="tableHeader">票证类型</td>
		<td class="tableHeader">承运人</td>
		<td class="tableHeader">承运人-票号</td>
		<td class="tableHeader">乘机人类型</td>
		<td class="tableHeader">乘客PNR</td>
		<td class="tableHeader">乘机人</td>
		<td class="tableHeader">航司二字代码</td>
		<td class="tableHeader">航司名字</td>
		<td class="tableHeader">始发地三字代码</td>
		<td class="tableHeader">目的地三字代码</td>
		<td class="tableHeader">始发地名称</td>
		<td class="tableHeader">目的地名称</td>
		<td class="tableHeader">航班</td>
		<td class="tableHeader">舱位</td>
		<td class="tableHeader">起飞时间</td>
		<td class="tableHeader">到达时间</td>
		<td class="tableHeader">账单价</td>
		<td class="tableHeader">税费</td>
		<td class="tableHeader">票面小计</td>
		<tr>
		<td class="tableHeader" colspan="4" align="centre">销售明细</td>
		</tr>
		<td class="tableHeader">采购代理费率</td>
		<td class="tableHeader">采购代理费</td>
		<td class="tableHeader">采购金额</td>
		<td class="tableHeader">毛利小计</td>
		<tr>
		<td class="tableHeader" colspan="5" align="centre">备注信息</td>
		</tr>
		<td class="tableHeader">订单号</td>
		<td class="tableHeader">建单用户</td>
		<td class="tableHeader">支付状态</td>
		<td class="tableHeader">建单时间</td>
		<td class="tableHeader">支付时间</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${statementList}" var="s" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td>${status.index+1}</td>
		<td>${s.productType}</td>
		<td>
			<c:if test="${s.order.oState == 0}">未出票</c:if>
			<c:if test="${s.order.oState == 1}">已出票</c:if>
			<c:if test="${s.order.oState == 2}">改签</c:if>
			<c:if test="${s.order.oState == 3}">退票</c:if>
		</td>
		
		<td>${s.abroadInland}</td>
		<td>${s.flight.fType}</td>
		<td>${s.tickerType}</td>
		<td>${s.flight.fNumber}</td>
		<td>${s.haulierNomber}</td>
		<td>${s.passenger.pType}</td>
		<td>${s.passenger.pId}</td>
		<td>${s.passenger.pName}</td>
		<td>${s.flight.fCompany}</td>
		<td>${s.flight.fCompanyName}</td>
		<td>${s.flight.fLocation}</td>
		<td>${s.flight.fDeparture}</td>
		<td>${s.flight.fLocationName}</td>
		<td>${s.flight.fDepartureName}</td>
		<td>${s.flight.fId}</td>
		<td>${s.flight.fRank}</td>
		<td><fmt:formatDate value="${s.flight.fStarttime}" type="time" pattern="yyyy-MM-dd HH-mm-ss"/></td>
		<td><fmt:formatDate value="${s.flight.fOvertime}" type="time" pattern="yyyy-MM-dd HH-mm-ss"/></td>
		<td>${s.flight.fPrice}</td>
		<td>${s.flight.fTax}</td>
		<td>${s.flight.fTotal}</td>
		<!-- 销售明细:采购代理费率/采购代理费/采购金额/毛利小计 -->
		<td>${s.commissionFreePercent}</td>
		<td>${s.flight.fCommission}</td>
		<td>${s.procurement}</td>
		<td>${s.profit}</td>
		<!-- 备注信息:订单号/建单用户/支付状态/建单时间/支付时间 -->
		<td>${s.passenger.pOrderId}</td>
		<td>${s.order.userPId}</td>
		<td>
		<c:if test="${s.order.oPayment == 0}"><font color="red">未支付</font></c:if>
		<c:if test="${s.order.oPayment == 1}"><font color="green">已支付</font></c:if>
		</td>
		<td><fmt:formatDate value="${s.order.oCreatetime}" pattern="yyyy-MM-dd HH-mm-ss"/></td> 
		<td><fmt:formatDate value="${s.order.oPaytime}" pattern="yyyy-MM-dd HH-mm-ss"/></td>
		
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
 
</div>
 
 
	


</body>
</html>

