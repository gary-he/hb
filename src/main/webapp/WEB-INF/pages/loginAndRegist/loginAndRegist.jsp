<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜鸟航空</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/staticfile/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/staticfile/skin/default/css/loginAndRegist.css">
<script type="text/javascript" src="${ctx }/staticfile/hb/js/jquery-1.9.1.min.js"></script>
<script src="${ctx}/staticfile/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="header">
		<div class="h_container">
			<!-- 小导航 -->
			<nav class="navbar navbar-default" style=" min-height:30px; line-height:30px; margin-bottom:0px; border-radius:0;">
			  <div class="container font12">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			    </div>
			    <%-- <ul class="nav navbar-nav nav-top-small" style="margin-left:-15px;" >
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">您好，${userSession.username } <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="系统管理/修改密码.html">修改密码</a></li>
			            <li><a href="#">退出</a></li>
			          </ul>
			        </li>       
			      </ul> --%>
				<ul class="nav navbar-nav navbar-right nav-top-small">
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class="icon iconfont font14 " style=" vertical-align:middle;"  >&#xe62b;</i> 028-12345678 <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">（或）028-12345678</a></li>
			            <li><a href="#">（或）028-12345678</a></li>
			            <!--<li role="separator" class="divider"></li>-->
			          </ul>
			        </li>
			        
			      </ul>
			    <ul class="nav navbar-nav navbar-right nav-top-small">
			        <li><a href="帮助中心/help.html">帮助中心</a></li>
			        
			      </ul>
			  </div>
			</nav>
			<!-- 小导航结束 -->
			<div id="logo_box">
				<img alt="logo" src="${ctx }/staticfile/skin/default/images/login/hblogo2.png">
			</div>
		</div>
	</div>
	<div id="middle">
		<div class="container">
			<c:if test="${type==0 }">
				<div id="signin_box">
					<form class="form-signin" action="/login.action" method="POST">
						<h2 class="form-signin-heading">欢迎登录菜鸟航空</h2>
						<span style="color: red">${errorInfo }</span>
						<input type="text" id="inputEmail" class="form-control"
							placeholder="用户名" name="userName" required autofocus
							value="${rmCookie }"> 
						
						<input type="password" id="inputPassword" class="form-control"
							placeholder="密码"  name="password" required>
						<div class="checkbox">
							<label><input type="checkbox" name="remeberMe" value="remeber-me"
								<c:if test="${!empty rmCookie }">checked="checked"</c:if>>记住用户</label>
						</div>
						<button class="btn btn-lg btn-primary btn-block" type="submit">
						登录
						</button>
						<a href="toregist.action">
							<button class="btn btn-lg btn-primary btn-block" type="button">
								注册
							</button>
						</a>
					</form>
				</div>
			</c:if>
			<c:if test="${type==1 }">
				<div id="regist_box">
					<form class="form-regist" action="/regist.action" method="POST">
						<h2 class="form-regist-heading">欢迎注册菜鸟航空</h2>
						<span style="color: red">${errorInfo }</span>
						<input type="text" id="inputEmail" class="form-control"
							placeholder="用户名" name="userName" required autofocus> 
						<input type="password" id="inputPassword" class="form-control"
							placeholder="密码"  name="password" required>
						<input type="password" id="inputPassword2" class="form-control"
							placeholder="确认密码"  name="password" required>
						
						<button class="btn btn-lg btn-primary btn-block" type="submit">
						注册
						</button>
						<div>
							<a href="tologin">已有账号，去登录</a>
						</div>
					</form>
				</div>
			</c:if>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>