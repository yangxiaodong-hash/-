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
    <title>部门选择职位页面</title>
</head>
<body>
<center>
    <h2>目前在给:${dept.dname}选择职位</h2>
    <div class="panel panel-primary">

        <!-- 面板头 -->
        <div class="panel-heading" align="center">选择职位表</div>

        <!-- 面板身体 -->
        <div class="panel-body">

            <form action="/saveDeptRole.do" method="post">
                <input name="deptid" type="hidden" value="${dept.deptid}">
                <%--<select class="form-control" name="roleid" id="roleid" onchange="deptchange(this)">--%>
                <%--<option value="-1">--请选择职位--</option>--%>
                <%--<c:forEach var="d" items="${roleList}">--%>
                <%--<option value="${d.rid}"${dept.deptid==d.deptid?'selected':''}>${d.rname}</option>--%>
                <%--</c:forEach>--%>
                <%--</select>--%>
                <c:forEach items="${roleList}" var="r">

                    <label class="checkbox-inline">
                        <input type="checkbox" name="rids" value="${r.rid}"<c:forEach items="${list}" var="rr">${r.rid==rr?'checked':''}</c:forEach>> ${r.rname}
                    </label>

                </c:forEach>
                <button type="submit" class="btn btn-info btn-primary">提交</button>

            </form>
        </div>

        <%--<!-- 面板的底部 -->--%>
        <%--<div class="panel-footer">--%>

        <%--</div>--%>

    </div>
    </table>

</center>

</body>
</html>
