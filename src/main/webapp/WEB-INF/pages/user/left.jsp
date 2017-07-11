<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/staticfile/skin/default/css/left.css" media="all"/>

	<script language="javascript" src="${ctx}/staticfile/js/common.js"></script>
	<script language="javascript" src="${ctx}/staticfile/js/ajax/setFastMenu.js"></script>
	<script language="javascript" src="${ctx}/staticfile/js/pngfix_map.js"></script>
	<script type="text/javascript" src="${ctx}/staticfile/components/jquery-ui/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="${ctx}/staticfile/skin/default/js/toggle.js"></script>
 
 
    
</head>
 
<body id="left_frame">
 
 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
    <div class="panel">
    	<div class="panel_icon"><img src="${ctx}/staticfile/skin/default/images/icon/document_chart.png" /></div>
        <div class="panel-header">
        <div class="panel-title">
		用户
        </div>
        
        <div class="panel-content">
			<ul>
				<li><a href="${ctx}/user/buy/view" onclick="linkHighlighted(this)" target="main" id="aa_1">订票</a></li>
				<li><a href="${ctx}/user/info/xxx" onclick="linkHighlighted(this)" target="main" id="aa_1">我的订单</a></li>					
				<li><a href="${ctx}/user/order/xxx" onclick="linkHighlighted(this)" target="main" id="aa_1">个人信息</a></li>
			</ul>
        </div>
    </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>
</div>
<!-- end1 -->
 
</body>
</html>