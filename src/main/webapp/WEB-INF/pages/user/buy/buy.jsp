<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
	<title>订票页面</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('buy','_self');this.blur();">购买</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    订票页面
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('roleId',this)"></td>
		<td class="tableHeader">航班</td>
		<td class="tableHeader">航空公司</td>
		<td class="tableHeader">出发地机场</td>
		<td class="tableHeader">目的地机场</td>
		<td class="tableHeader">出发时间</td>
		<td class="tableHeader">到达时间</td>
		<td class="tableHeader">价格</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${flightList}" var="f" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td>下拉框</td>
		<td>${f.fId}</td>
		<td>${f.fCompanyName}</td>
		<td>${f.fLoAirport}</td>
		<td>${f.fDeAirport}</td>
		<td>开始时间</td>
		<td>结束时间</td>
		<td>${f.fPrice}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

