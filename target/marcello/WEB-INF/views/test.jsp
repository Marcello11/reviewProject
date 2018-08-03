<%--
  Created by IntelliJ IDEA.
  User: nozomi
  Date: 2018/4/23
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ path +"/";
%>
<base href="<%=basePath%>">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/common.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <script src="<%=basePath%>/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <link rel="stylesheet" href="<%=basePath%>/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=basePath%>/assets/css/font-awesome.min.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>
    <!-- 显示信息 -->
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/common.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/news.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/posting.css" />
</head>
<body>
<i class="am-icon-home sidebar-nav-link-logo"></i>全部信息
<button
        type="button"
        class="am-btn am-btn-success"
        id="doc-prompt-toggle">
    Prompt
</button>
    <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">Amaze UI</div>
            <div class="am-modal-bd">
                来来来，吐槽点啥吧
                <input type="text" class="am-modal-prompt-input">
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                <span class="am-modal-btn" data-am-modal-confirm>提交</span>
            </div>
        </div>
    </div>


    <script type="text/javascript">
        $(function() {
            $('#doc-prompt-toggle').on('click', function() {
                $('#my-prompt').modal({
                    relatedTarget: this,
                    onConfirm: function(e) {
                        alert('你输入的是：' + e.data || '')
                    },
                    onCancel: function(e) {
                        alert('不想说!');
                    }
                });
            });
        });
    </script>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.datatables.min.js"></script>
<script src="<%=basePath%>/assets/js/dataTables.responsive.min.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>
</html>
