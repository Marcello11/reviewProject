
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ path +"/";
%>
<base href="<%=basePath%>">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商户注册页面</title>
    <meta name="description" content="这是一个注册页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="/html/assets/image/png" href="<%=basePath%>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>
	
	<style type="text/css">
		.tpl-login-content{
			margin-top:10%;
		}
		.aaa{
			float:left;
			margin-right:150px;
		}
		.bbb{
			float:left;
			margin-right:135px;
		}
	</style>
</head>

<body data-type="login">
    <script src="<%=basePath%>/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-title">注册用户</div>
                <span class="tpl-login-content-info">
                  创建一个新的用户
                </span>
				<!-- 注册表 -->
                <form class="am-form tpl-form-line-form" action="/business/sign-up1" method="post">
					<!-- 用户名 -->
                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="stdName" name="bssName" placeholder="请输入用户名">

                    </div>
					<!-- 年龄 -->
                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="stdAge" name="bssTel" placeholder="请输入联系方式">
                    </div>
					<!-- 设置密码 -->
					<div class="am-form-group">
                        <input type="password" class="tpl-form-input" name="bssPwd" placeholder="请输入密码">
                    </div>
					<!-- 确认密码 -->
                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" name="bssPwd" placeholder="再次输入密码">
                    </div>
					<!-- 注册协议 -->
                    <div class="am-form-group tpl-login-remember-me">
                        <input id="remember-me" type="checkbox">
                        <label for="remember-me">    我已阅读并同意 <a href="javascript:;">《用户注册协议》</a> </label>
                    </div>
					<!-- 提交 -->
                    <div class="am-form-group">

                        <button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>

                    </div>
					<!-- 跳转登录页面 -->
					<div class="am-form-group">		
						<a href="/page/login">已有账号？前往登录</a>
					</div>
                </form>
            </div>
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