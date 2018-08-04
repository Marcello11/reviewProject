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
    <title>商户信息审核</title>
    <meta name="description" content="这是一个审核页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="<%=basePath%>/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>
    <style type="text/css">
        #logo{
            text-indent:4px;
        }
    </style>
    <script type="text/javascript">
        function addData(id) {
            $.ajax({
                url:"/business/passBusiness",
                type:"post",
                data:{id:id},
                success:function(data){
                    window.location.reload();
                    console.log("success......")
                },
                error:function(data, status, e){
                    console.log(e);
                }


            });
        }

        function deleteData(id){
            $.ajax({
                url:"/business/refuseBusiness",
                type:"post",
                data:{id:id},
                success:function(data){
                     window.location.reload();
                     console.log("success......")
                },
                error:function(data, status, e){
                    console.log(e);
                }
            });
        }

    </script>
</head>

<body data-type="index">
<script src="<%=basePath%>/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo" >
            <a href="/posting/getPosting"><h2>首页</h2></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <div class="am-fl tpl-header-switch-button am-icon-list">
                <span></span>
            </div>
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span>Marcello</span> </a>
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
    </header>
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <!--头像-->
                <div class="tpl-user-panel-profile-picture">
                    <img src="<%=basePath%>/assets/img/user01.png" alt="">
                </div>
                <!-- 当前用户 -->
                <span class="user-panel-logged-in-text">
						<i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
						Marcello
					</span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <li class="sidebar-nav-link">
                <a href="/user/student-list">
                    <i class="am-icon-table sidebar-nav-link-logo"></i>学生信息审核
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="/business/business-list" class="active">
                    <i class="am-icon-table sidebar-nav-link-logo"></i>商户信息审核
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="/posting/postOccasion">
                    <i class="am-icon-table sidebar-nav-link-logo"></i>发布信息审核
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="/std/allstudent-list">
                    <i class="am-icon-table sidebar-nav-link-logo"></i>学生信息管理

                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="/business/allbusiness-list">
                    <i class="am-icon-table sidebar-nav-link-logo"></i>商户信息管理

                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="/managerA/allsection-list">
                    <i class="am-icon-table sidebar-nav-link-logo"></i>部门信息管理

                </a>
            </li>

        </ul>
    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">信息列表</div>


                        </div>

                        <div class="am-u-sm-12">
                            <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                <thead>
                                <tr>
                                    <th>商户名称</th>
                                    <th>联系电话</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.occasionPage.lists}" var="u" >
                                    <tr class="gradeX">
                                        <td>${u.bssName}</td>
                                        <td>${u.bssTel}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                    <input type="button" name="action" value="通过" onclick="addData(${u.id})">
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i>
                                                    <input  type="button" name="action" class="delete" value="删除" onclick="deleteData(${u.id})">
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <!-- more data -->
                                </tbody>
                            </table>
                        </div>
                        <div class="am-u-lg-12 am-cf">

                            <div class="am-fr">
                                <table  border="0" cellspacing="0" cellpadding="0"  width="900px">
                                    <tr>
                                        <td class="td2">
                                            <span>第${requestScope.occasionPage.currPage }/ ${requestScope.occasionPage.totalPage}页</span>&nbsp;&nbsp;
                                            <span>总记录数：${requestScope.occasionPage.totalCount }&nbsp;&nbsp;每页显示:${requestScope.occasionPage.pageSize}</span>&nbsp;&nbsp;
                                            <span>
                                                    <c:if test="${requestScope.occasionPage.currPage != 1}">
                                                        <a href="/business/business-list?currPage=1">[首页]</a>&nbsp;&nbsp;
                                                        <a href="/business/business-list?currPage=${requestScope.occasionPage.currPage-1}">[上一页]</a>&nbsp;&nbsp;
                                                    </c:if>

                                                       <c:if test="${requestScope.occasionPage.currPage != requestScope.occasionPage.totalPage}">
                                                           <a href="/business/business-list?currPage=${requestScope.occasionPage.currPage+1}">[下一页]</a>&nbsp;&nbsp;
                                                           <a href="/business/business-list?currPage=${requestScope.occasionPage.totalPage}">[尾页]</a>&nbsp;&nbsp;
                                                       </c:if>
   </span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.datatables.min.js"></script>
<script src="<%=basePath%>/assets/js/dataTables.responsive.min.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>

</body>

</html>