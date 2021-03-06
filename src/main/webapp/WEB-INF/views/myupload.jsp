<%--本页面用于学生 商户 部门的我发布的信息页面--%>
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
    <title>个人主页</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<!-- 原页面 -->
    <script src="<%=basePath%>/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
	<script src="<%=basePath%>/assets/js/jquery.min.js"></script>
	<!-- 显示信息 -->
	<link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.css" />
	<link rel="stylesheet" href="<%=basePath%>/assets/css/common.min.css" />
	<link rel="stylesheet" href="<%=basePath%>/assets/css/news.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/posting.css" />
</head>

<body data-type="index">
    <script src="<%=basePath%>/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="<%=basePath%>/myupload.jsp">个人主页</a>
            </div>
            <!-- 右侧内容 -->
            <div class="tpl-header-fluid">
                <!-- 侧边切换 -->
                <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
                </div>
                <!-- 其它功能-->
                <div class="am-fr tpl-header-navbar">
                    <ul>
                        <!-- 欢迎语 -->
                        <li class="am-text-sm tpl-header-navbar-welcome">
                            <%--此处需从session中取出当前用户名--%>
                            <a href="javascript:;">欢迎你, <span>${sessionScope.std.stdNum}</span> </a>
                        </li>
                        <!-- 退出 -->
                        <li class="am-text-sm">
                            <a href="/page/login">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
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
        <!-- 侧边导航栏 -->
        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="<%=basePath%>/assets/img/user01.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
						<i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
							Marcello
					</span>
                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
                <li class="sidebar-nav-link">
                    <a href="/posting/getPosting" >
                        <i class="am-icon-home sidebar-nav-link-logo"></i>全部信息
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/posting/myPosting" class="active">
                        <i class="am-icon-table sidebar-nav-link-logo" ></i>我发布的
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/posting/upload">
                        <i class="am-icon-wpforms sidebar-nav-link-logo"></i>我要发布

                    </a>
                </li>
            </ul>
        </div>


        <!-- 内容区域 -->
		<div class="tpl-content-wrapper">
			<div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span>我发布的</div>
                    </div>
                </div>
            </div>
			<div class="row-content am-cf">
				<!--引入失效-->
                <c:forEach items="${myPosting}" var="item">
                <ul class="messageArea">
                    <li class="smallArea">
                        <header class="mmm">
                            <div class="xxx">
                                <figure class="tpl-user-panel-profile-picture"><img src="<%=basePath%>/assets/img/user01.png" alt=""></figure>
                            </div>
                            <div class="yyy">
                                <strong class="">${item.bssName}</strong>
                                <div class="yyy1"></div>
                                <div class="yyy2"><p>${item.date}</p></div>
                            </div>
                        </header>
                        <div class="say">
                            <p>${item.bssMsg}</p>
                        </div>
                        <c:forEach items="${item.replys}" var="item1">
                        <ul class="">
                            <li class="">
                                <header class="mmm">
                                    <div class="xxx">
                                        <figure class="tpl-user-panel-profile-picture"><img src="<%=basePath%>/assets/img/user04.png" alt=""></figure>
                                    </div>
                                    <div class="yyy">
                                        <div class="yyy1"><strong class=""><a href="#">${item1.name}</a></strong></div>
                                        <div class="yyy2"><time class="">${item1.date}</time></div>
                                    </div>
                                </header>
                                <div class="say">
                                    <p>${item1.content}</p>
                                </div>
                            </li>
                        </ul>
                        </c:forEach>
                    </li>
                </ul>
                </c:forEach>
            </div>
        </div>
    </div>
	<!-- 显示信息 -->
	<script src="<%=basePath%>/assets/js/jquery-2.1.0.js" charset="utf-8"></script>
	<script src="<%=basePath%>/assets/js/amazeui.js" charset="utf-8"></script>
	<!-- 原页面  -->
    <script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
    <script src="<%=basePath%>/assets/js/amazeui.datatables.min.js"></script>
    <script src="<%=basePath%>/assets/js/dataTables.responsive.min.js"></script>
    <script src="<%=basePath%>/assets/js/app.js"></script>
</body>
</html>