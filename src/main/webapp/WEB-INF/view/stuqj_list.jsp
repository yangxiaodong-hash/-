<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/25
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td colspan="111">我的请假</td>
        </tr>
        <tr>
            <td>编号</td>
            <td>请假时长</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td>请假原因</td>
            <td>角色</td>
            <td>操作人</td>
            <td>审批状态</td>
            <td>
                <a href="/tostuqj.do">新增请假</a>
            </td>
        </tr>
        <c:forEach var="q" items="${list}">
            <tr>
                <td>${q.id}</td>
                <td>${q.qjtime}</td>
                <td><fmt:formatDate value="${q.ktime}" pattern="yyyy-MM-dd HH"/>
                </td>
                <td>
                    <fmt:formatDate value="${q.jtime}" pattern="yyyy-MM-dd HH"/>
                </td>
                <td>${q.qjcause}</td>
                <td>${q.rname}</td>
                <td>${q.uname}</td>
                <td>${q.statusStr}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
