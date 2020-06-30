<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/25
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../js/calendarTime.js"></script>
</head>
<body>
<center>

    <form action="saveStuQj.do" method="post">
        <table>
            <tr>
                <td><h1>${us.username}请假</h1>
                <input type="hidden" name="sid" value="${us.id}">
                </td>
            </tr>
            <tr>
                <td>请假时间</td>
                <td>
                    <input type="text" name="qjtime">
                </td>
            </tr>
            <tr>
                <td>开始时间</td>
                <td>
                    <input type="text" name="ktime" onclick="setDayH(this)">
                </td>
            </tr>
            <tr>
                <td>结束时间</td>
                <td>
                    <input type="text" name="jtime" onclick="setDayH(this)">
                </td>
            </tr>
            <tr>
                <td>请假原因</td>
                <td>
                    <input type="text" name="qjcause">
                </td>
            </tr>
            <tr>
                <td colspan="111">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
