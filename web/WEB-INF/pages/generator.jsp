<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sushakov
  Date: 20.11.2018
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/pages/header/include.jsp" %>
    <title>Title</title>
</head>
<body>
<div id="mainDiv">
    <h1>${title}</h1>
    <br>
    <p>
    <h3>Введите текст:</h3></p>
    <input id="inputText" type="text" name="text" size="64" placeholder="введите текст"/>
    <br>
        <input type="button" value="Encode" onclick="encode()"/>
        <input type="button" value="Decode" onclick="decode()"/>
    <p>
    <h3>Резльтат:</h3></p>
    <span id="outputText"></span>
</div>
</body>


</html>
