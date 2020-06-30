<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/27
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>我的请假审核</title>
</head>
<body>
<h1>请假审核</h1>
<table cellspacing="0" cellpadding="10" border="1">
    <tr>
        <th>编号</th>
        <th>学生姓名</th>
        <th>学生班级</th>
        <th>请假时长</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>请假原因</th>
        <th colspan="100">操作</th>
    </tr>
    <c:forEach var="pro" items="${list}">
        <tr align="center">
            <td>
                    ${pro.id}
            </td>
            <td>
                    ${pro.uname}
            </td>
            <td>
                    ${pro.gname}
            </td>
            <td>
                    ${pro.qjtime}
            </td>

            <td>
                <fmt:formatDate value="${pro.ktime}" pattern="yyyy-MM-dd HH"/>
            </td>
            <td>
                <fmt:formatDate value="${pro.jtime}" pattern="yyyy-MM-dd HH"/>
            </td>
            <td>
                    ${pro.qjcause}
            </td>

            <td>
                通过<input type="radio" value="1" name="shstatus"/>&nbsp;&nbsp;&nbsp;
                不通过<input type="radio" value="2" name="shstatus"/>&nbsp;&nbsp;
                <button onclick="savewdsh(${pro.id})">确认</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
<script>
    function savewdsh(fid) {
        var obj = document.getElementsByName("shstatus");
        for (var x=0;x<obj.length;x++){
            if(obj[x].checked){
                var shstatus = obj[x].value;
                location.href="saveWdsh.do?fid="+fid+"&shstatus="+shstatus;
            }
        }
    }
</script>
</html>
