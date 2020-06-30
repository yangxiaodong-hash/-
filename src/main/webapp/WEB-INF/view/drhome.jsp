<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link rel="stylesheet" href="../boot3/css/bootstrap.min.css">
<script src="../../js/jquery-1.8.2.js"></script>


<head>
    <title>部门职位下拉框</title>
</head>
<script>
    function deptchange(obj) {
        $("#rid").empty();
        $("#rid").append('<option>--部门发生改变请选择--</option>')
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
<body>
<center>
    <h1>目前在给${user.username}进行分配</h1>
    <form  class="form-inline" action="/saveUserDeptRole.do">
        <input type="hidden" name="id" value="${user.id}">
        <%--部门下拉框--%>
        <select class="form-control" name="deptid" id="deptid" onchange="deptchange(this)">
            <option value="-1">--请选择部门--</option>
            <c:forEach var="d" items="${deptList}">
                <option value="${d.deptid}"${user.deptid==d.deptid?'selected':''}>${d.dname}</option>
            </c:forEach>
        </select><br>
         <%--职业下拉框   --%>
        <select class="form-control" name="rid" id="rid">
            <option value="-1">--请选择职位--</option>
            <c:forEach var="r" items="${roleList}">
                <option value="${r.rid}"${user.rid==r.rid?'selected':''}>${r.rname}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="提交" class="btn btn-primary btn-lg">

    </form>

</center>

</body>
</html>
