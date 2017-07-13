<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>航班列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('toview','_self');this.blur();">查看</a></li>
	<li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li>
	<li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li>
	<li id="new"><a href="#" onclick="formSubmit('import','_self');this.blur();">导入</a></li>
	<li id="new"><a href="#" onclick="formSubmit('export','_self');this.blur();">导出</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    航班列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('flightId',this)"></td>
		<td class="tableHeader">航班编号</td>
		<td class="tableHeader">航程类型</td>
		<td class="tableHeader">航空公司</td>
		<td class="tableHeader">始发地代码</td>
		<td class="tableHeader">目的地代码</td>
		<td class="tableHeader">起飞时间</td>
		<td class="tableHeader">到达时间</td>
		<td class="tableHeader">票面价</td>
		<td class="tableHeader">税费</td>
		<td class="tableHeader">仓位折扣</td>
		<td class="tableHeader">代理费</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${flightList}" var="f" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="fId" value="${f.fId}"/></td>
		<td>${f.fId}</td>
		<td>${f.fType}</td>
		<td>${f.fCompany}</td>
		<td>${f.fLocation}</td>
		<td>${f.fDeparture}</td>
		<td><fmt:formatDate value="${f.fOvertime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><fmt:formatDate value="${f.fStarttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${f.fPrice}</td>
		<td>${f.fTax}</td>
		<td>${f.fRank}</td>
		<td>${f.fCommission}</td>
		
		
		
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

