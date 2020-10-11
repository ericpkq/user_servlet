<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/11
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function ba() {
            history.back();
        }
    </script>
</head>
<body>
<form action="list.jsp" method="post">

    <table align="center" width="500px" border="1">
        <tr height="40px" align="center">
            <td colspan="2"><strong>用户信息</strong></td>
        </tr>
        <tr height="40px">
            <td align="right">编号：</td>
            <td>${us.id}</td>
        </tr>
        <tr height="40px">
            <td align="right">姓名：</td>
            <td>${us.username}</td>
        </tr>
        <tr height="40px">
            <td align="right">密码：</td>
            <td>${us.password}</td>
        </tr>
        <tr height="40px">
            <td align="right">性别：</td>
            <td>${us.sex}</td>
        </tr>
        <tr height="40px">
            <td align="right">出生日期：</td>
            <td><fmt:formatDate value="${us.bornDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
        </tr>
        <tr height="40px">
            <td></td>
            <td>
                <input type="button" value="返回" onclick="ba()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
