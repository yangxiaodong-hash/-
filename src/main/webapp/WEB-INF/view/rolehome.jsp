<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<link rel="stylesheet" href="../boot3/css/bootstrap.min.css">
<script src="../js/jquery-1.8.2.js"></script>

<head>
    <title>员工信息页面</title>
</head>
<body>
<center>
    <div class="panel panel-primary">

        <!-- 面板头 -->
        <div class="panel-heading" align="center">员工信息表</div>

        <!-- 面板身体 -->
        <div class="panel-body">
            <table class="table table-striped table-bordered table-hover">
                <tr align="center" class="warning">
                    <td>职位编号</td>
                    <td>职位名称</td>
                    <td colspan="2">操作</td>
                </tr>
                <c:forEach items="${list }" var="s">

                    <tr align="center" class="info">
                        <td>${s.rid}</td>
                        <td>${s.rname}</td>
                        <td>
                            <a href="#" type="button" class="btn btn-primary">分配部门</a>
                        </td>
                        <td>
                            <a href="/toQianXian.do?rid=${s.rid}" type="button" class="btn btn-warning">权限分配</a>
                        </td>

                    </tr>

                </c:forEach>

            </table>

        </div>

        <!-- 面板的底部 -->
        <div class="panel-footer">

        </div>

    </div>
    </table>

</center>

</body>
</html>
