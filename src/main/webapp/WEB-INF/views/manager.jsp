<%--
  Created by IntelliJ IDEA.
  User: nozomi
  Date: 2018/4/3
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
<%--<c:forEach items="${user}" var="item">--%>
    <%--${item.stdNum}--%>
<%--</c:forEach>--%>
<style type="text/css">
    td{text-align: center;}
    .td2{text-align: right;}
    .table1{
        border:1px solid #ddd;
        width:900px;
    }
    thead{
        background-color:lightblue;
    }
</style>
</head>
<body>
<%--<c:if test="${!empty requestScope.pagemsg}">--%>
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <thead>
        <tr>
            <td>学号</td>
            <td>性别</td>
            <td>年龄</td>
            <td>联系电话</td>
            <td>是否建档</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <c:forEach items="${requestScope.pagemsg.lists}" var="u">
            <tr>
                <th>${u.stdNum }</th>
                <th>${u.stdSex }</th>
                <th>${u.stdAge }</th>
                <th>${u.stdTel }</th>
                <th>${u.difference }</th>
                <th><a href="edit?id=${u.id}">Edit</a></th>
                <th><a href="delete?id=${u.id}" onclick="return confirm('确定要删除吗')">Delete</a></th>
            </tr>
        </c:forEach>
    </table>
<%--</c:if>--%>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
    <tr>
        <td class="td2">
            <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/manager.jsp?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/manager.jsp?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/manager.jsp?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/manager.jsp?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
        </td>
    </tr>
</table>
<script src="../bootstrap/js/jquery.js"></script>
</body>
</html>
