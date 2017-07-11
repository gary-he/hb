<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>报表</title>
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
	<li id="new"><a href="#" onclick="formSubmit('start','_self');this.blur();">启用</a></li>
	<li id="new"><a href="#" onclick="formSubmit('stop','_self');this.blur();">停用</a></li>
	<li id="new"><a href="#" onclick="formSubmit('role','_self');this.blur();">角色</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    报表
  </div> 
  
<div>


<div class="eXtremeTable" style="position:absolute; height:400px; overflow:scroll">
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader" colspan="24" align="centre">票面信息</td>
	</tr>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('userId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">产品类型</td>
		<td class="tableHeader">票证状态</td>
		<td class="tableHeader">国际国内</td>
		<td class="tableHeader">航程类型</td>
		<td class="tableHeader">票证类型</td>
		<td class="tableHeader">承运人</td>
		<td class="tableHeader">承运人-票号</td>
		<td class="tableHeader">乘机人类型</td>
		<td class="tableHeader">乘机人</td>
		<td class="tableHeader">航司二字代码</td>
		<td class="tableHeader">航司名字</td>
		<td class="tableHeader">始发地三字代码</td>
		<td class="tableHeader">始发地名称</td>
		<td class="tableHeader">目的地三字代码</td>
		<td class="tableHeader">目的地名称</td>
		<td class="tableHeader">航班</td>
		<td class="tableHeader">舱位</td>
		<td class="tableHeader">起飞时间</td>
		<td class="tableHeader">到达时间</td>
		<td class="tableHeader">账单价</td>
		<td class="tableHeader">税费</td>
		<td class="tableHeader">票面小计</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${userList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="userId" value="${u.userId}"/></td>
		<td>${status.index+1}</td>
		<td>${u.username}</td>
		<td>${u.dept.deptName}</td>
		<td>${u.userInfo.name}</td>
		<td>${u.userInfo.cardNo}</td>
		<td>${u.userInfo.manager.name}</td>
		<td>${u.userInfo.salary}</td>
		<td><fmt:formatDate value="${u.userInfo.joinDate}" pattern="yyyy-MM-dd"/></td>
		<td>
			<c:if test="${u.state==1}"><a href="stop?userId=${u.userId}"><font color="green">启用</font></a></c:if>
			<c:if test="${u.state==0}"><a href="start?userId=${u.userId}"><font color="red">停用</font></a></c:if>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

