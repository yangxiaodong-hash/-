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
<script>
    function deptchange(obj) {
        $("#rid").empty();
        $("#rid").append('<option>--请选择职位--</option>')
        var dept=$("#deptid").val();
        if (dept!=null){
            $.ajax({
                type:"post",
                url:"findRole1.do",
                data:{deptid:obj.value},
                success:function (j) {
                    for (var i = 0; i <j.length ; i++) {
                        $("#rid").append('<option value="'+j[i].rid+'">'+j[i].rname+'</option>')
                    }
                }
            })
        }

    }
</script>
<html>
<head>
    <title>员工新增页面</title>
</head>
<body>


    <center>
        <div class="panel panel-primary">

            <!-- 面板头 -->
            <div class="panel-heading" align="center">员工信息新增表</div>

            <!-- 面板身体 -->
            <div class="panel-body">
              <form class="form-inline" action="/addUser.do" method="post">
                <div class="form-group">
                    <label >员工名称</label>
                    <input type="text" class="form-control"  placeholder="请输入员工名称" name="username" id="username">
                </div><br><br>
                <div class="form-group">
                    <label >员工密码</label>
                    <input type="text" class="form-control"  placeholder="请输入员工密码" name="password" id="password">
                </div><br><br>
                <div class="form-group">
                    <label >员工年龄</label>
                    <input type="text" class="form-control"  placeholder="请输入员工年龄" name="age" id="age">
                </div><br><br>
                <div class="form-group">
                    <label >员工入职日期</label>
                    <input type="text" class="form-control"  placeholder="请输入员工入职日期" name="userdate" id="userdate">
                </div><br><br>
                <div class="form-group">
                    <label>部门</label>
                    <select class="form-control" name="deptid" id="deptid" onchange="deptchange(this)">
                        <option value="-1">--请选择部门--</option>
                        <c:forEach var="d" items="${deptList}">
                            <option value="${d.deptid}">${d.dname}</option>
                        </c:forEach>
                    </select><br>
                </div><br><br>
                <div class="form-group">
                    <label >职位</label>
                    <select class="form-control" name="rid" id="rid">
                        <option value="-1">--请选择职位--</option>
                        <c:forEach var="r" items="${roleList}">
                            <option value="${r.rid}">${r.rname}</option>
                        </c:forEach>
                    </select><br>
                </div><br><br>
                <button type="submit" class="btn btn-primary">提交</button>
              </form>
            </div>


            <!-- 面板的底部 -->
            <div class="panel-footer">

            </div>

        </div>
    </center>


</body>
</html>
