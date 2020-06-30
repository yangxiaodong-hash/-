<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="../boot3/css/bootstrap.min.css">
<script src="../js/jquery-1.8.2.js"></script>
<script src="../js/calendarTime.js"></script>

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
            <form action="/findAll.do" class="form-inline" method="post">
                <div class="form-group">
                    <input type="hidden" name="fenye">
                    <label>员工名称</label>
                    <input type="text" class="form-control" name="username" placeholder="查询员工">
                    <input class="btn btn-default" type="submit" value="查询">

                    <label>日期查询</label>
                    <input type="text" class="form-control" name="sdate" onclick="setDay(this)" placeholder="查询日期">--至--
                    <input type="text" class="form-control" name="adate" onclick="setDay(this)" placeholder="查询日期">
                    <input class="btn btn-default" type="submit" value="查询">
                </div>
            </form>
            <div class="form-group" align="left">
                <a href="/toaddUser.do" type="button"class="btn btn-primary">新增员工</a>
            </div>
            <table class="table table-striped table-bordered table-hover">
                <tr align="center" class="warning">
                    <td>员工编号</td>
                    <td>员工名称</td>
                    <td>员工密码</td>
                    <td>员工年龄</td>
                    <td>入职日期</td>
                    <td>员工部门</td>
                    <td>员工职位</td>
                    <td colspan="222">操作</td>
                </tr>
                <c:forEach items="${list}" var="s">

                    <tr align="center" class="info">
                        <td>${s.id}</td>
                        <td>${s.username}</td>
                        <td>${s.password}</td>
                        <td>${s.age}</td>
                        <td><fmt:formatDate value="${s.userdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${s.dname}</td>
                        <td>${s.rname}</td>
                        <td>
                            <a href="/findUserRoleDept.do?id=${s.id}" type="button" class="btn btn-info">选择部门职位</a>
                        </td>
                        <td>
                            <a href="/deleteUser.do?id=${s.id}" type="button" class="btn btn-danger">删除该员工</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>

                <a href="/findpage.do" class="btn btn-default">
                    <button>第一页</button>
                </a>
                <a href="/findpage.do?pageNum=${currentPage-1 }" class="btn btn-default">上一页</a>
                <a href="/findpage.do?pageNum=${currentPage+1 }" class="btn btn-default">下一页</a>
                <a href="/findpage.do?pageNum=${totalPage }" class="btn btn-default">最后一页</a>
                当前第${currentPage }页，共${totalPage }页，总条数为${count }
                跳转到：<input type="text" size="1" id="tz" value="${page.currentPage}"/>页
                <button onclick="paging('go')">go</button>




        </div>

        <%--<!-- 面板的底部 -->--%>
        <%--<div class="panel-footer">--%>

        <%--</div>--%>

    </div>
    </table>

</center>

</body>
</html>
