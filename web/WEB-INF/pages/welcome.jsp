<%--
  Created by IntelliJ IDEA.
  User: Sushakov
  Date: 28/12/2018
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/pages/header/include.jsp" %>
    <title>Welcome</title>
</head>
<body>
<div id="mainDiv">
    <form id="mainForm">
        <a href="/test"><input type="button" value="PressMe"></a>
        <a href="/two"><input type="button" value="Second"></a>
    </form>
</div>
</body>
</html>
