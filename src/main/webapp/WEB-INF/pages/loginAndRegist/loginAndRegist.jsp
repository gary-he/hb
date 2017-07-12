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
<script type="text/javascript" src="${ctx }/staticfile/js/jquery-1.6.2.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="header">
<!-- 		<div class="h_container"></div> -->
	</div>
	<div id="middle">
		<div class="container">
			<c:if test="${type==0 }">
				<div id="signin_box">
					<form class="form-signin" action="/login.action">
						<h2 class="form-signin-heading">欢迎登录菜鸟航空</h2>
						
						<input type="text" id="inputEmail" class="form-control"
							placeholder="用户名" name="userName" required autofocus> 
						
						<input type="password" id="inputPassword" class="form-control"
							placeholder="密码"  name="password" required>
						<div class="checkbox">
							<label><input type="checkbox" name="remeberMe" value="remember-me">记住用户</label>
						</div>
						<button class="btn btn-lg btn-primary btn-block" type="submit">
						登录
						</button>
						<a href="toregist">
							<button class="btn btn-lg btn-primary btn-block" type="button">
								注册
							</button>
						</a>
					</form>
				</div>
			</c:if>
			<c:if test="${type==1 }">
				<div id="regist_box">
					<form class="form-regist" action="/regist.action">
						<h2 class="form-regist-heading">欢迎注册菜鸟航空</h2>
						
						<input type="text" id="inputEmail" class="form-control"
							placeholder="用户名" name="userName" required autofocus> 
						<input type="password" id="inputPassword" class="form-control"
							placeholder="密码"  name="password" required>
						<input type="password" id="inputPassword2" class="form-control"
							placeholder="确认密码"  name="password2" required>
						
					
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