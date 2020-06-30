<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../boot3/css/bootstrap.min.css">
<script src="../js/jquery-1.8.2.js"></script>
<html>
<head>
    <title>员工登录页面</title>
</head>
<body>


<center>
    <div class="panel panel-primary">

        <!-- 面板头 -->
        <div class="panel-heading" align="center">员工登录</div>
        <br><br><br><br><br><br><br><br><br><br>

        <!-- 面板身体 -->

        <div>
            ${tishi}
            <form class="form-horizontal" action="/userLogin.do" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" value="登录" class="btn btn-primary">登录</button>
                    </div>
                </div>
            </form>

        </div>


        <%--<!-- 面板的底部 -->--%>
        <%--<div class="panel-footer">--%>

        <%--</div>--%>

    </div>
</center>


</body>
</html>
