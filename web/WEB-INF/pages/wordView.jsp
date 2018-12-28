<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/pages/header/include.jsp" %>
</head>
<body>
<div id="title">
    <H3>Составьте слова в предложения в правильном порядке:</H3>
</div>
<div id="mainForm">
    <c:forEach begin="0" end="${sentences.size()-1}" var="row">
        <c:forEach begin="0" end="${sentences.get(row).randomSentence.size()-1}" var="i">
            <a href="#" onclick="clickMe(${row},${i})" onmousemove="focus()" onmouseenter="translateWord('link${row}word${i}')"
               id="link${row}word${i}">${sentences.get(row).randomSentence.get(i)}</a>
        </c:forEach>
        <br>
        <input style="background-color: #fb009726" type="text" id="row${row}" size="128"
               placeholder="составьте предложение из слов" readonly>
        <br>
        <br>
    </c:forEach>
    <a href="${pageContext.servletContext.contextPath}/word"><input type="button" value="Refresh"></a>
</div>
<footer id="footer">
    Copyright Ушаков С.А. / <a href="https://newsapi.org">"Powered by News API"</a> /
    <a href=" http://translate.yandex.ru/">"Переведено сервисом «Яндекс.Переводчик"</a>
</footer>
</body>
</html>