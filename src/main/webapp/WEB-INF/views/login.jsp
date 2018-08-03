<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ path +"/";
%>
<base href="<%=basePath%>">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录页面</title>
    <meta name="description" content="这是一个登陆页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>
	<style type="text/css">
		.xxx{
			float:left;
			margin-right:40px;
		}
	</style>
</head>

<body data-type="login" class="skiner-color skiner-white" data-color="theme-white">
    <script src="<%=basePath%>/assets/js/theme.js"></script>
	<div class="tpl-login" id="top">
		<!--登录页面-->
		<div class="tpl-login-content">
			<div class="tpl-login-title">登录页面</div>
			<span class="tpl-login-content-info">
			  进入系统，发现生活！
			</span>

			<form class="am-form tpl-form-line-form"  method="post" name="form1" action="/std/login">
				<div class="am-form-group">
					<input type="text" class="tpl-form-input" id="user-name" name="username" placeholder="请输入账号">

				</div>
				<!--密码-->
				<div class="am-form-group">
					<input type="password" class="tpl-form-input" id="user-password" name="password" placeholder="请输入密码">

				</div>
				<!-- 选择进入页面 -->
				<div class="am-form-group tpl-login-remember-me">
					<div class="xxx">
						<input class="remember-me" type="radio" name="radio" value="1"   onclick="document.form1.action='/std/login'" checked />
						<label class="remember-me">学生</label>
					</div>
					<div class="xxx">
						<input class="remember-me" type="radio" name="radio" value="2"  onclick="document.form1.action='/manager/sectionLogin'"/>
						<label class="remember-me">部门</label>
					</div>
					<div class="xxx">
						<input class="remember-me" type="radio" name="radio" value="3"  onclick="document.form1.action='/business/businessLogin'"/>
						<label class="remember-me">商户</label>
					</div>
					<div class="xxx">
						<input class="remember-me" type="radio" name="radio" value="4"  onclick="document.form1.action='/manager/managerLogin'"/>
						<label class="remember-me" >管理员</label><br />
					</div>
				</div>

				<div class="am-form-group">
					<button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" >提交</button>
				</div>

				<div class="am-form-group">
					<a href="/page/signup">学生注册入口</a>
				</div>
				<div class="am-form-group">
					<a href="/page/signup1">商户注册入口</a>
				</div>

		  </form>
		</div>
		<!-- 风格切换 -->
		<div class="tpl-skiner">
			<div class="tpl-skiner-toggle am-icon-cog">
			</div>
			<div class="tpl-skiner-content">
				<div class="tpl-skiner-content-title">
					选择主题
				</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
	</div>
    <script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
    <script src="<%=basePath%>/assets/js/app.js"></script>

</body>

</html>