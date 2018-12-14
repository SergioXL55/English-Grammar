<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/checkWord.js" %>
        <%@include file="/WEB-INF/js/refresh.js" %>
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <style>
        <%@include file="/WEB-INF/css/word.css" %>
    </style>
</head>
<body>
<div id="title">
    <H3>Составьте слова в предложения в правильном порядке:</H3>
</div>
<div id="mainForm">
    <c:forEach begin="0" end="${sentence.size()-1}" var="row">
        <c:forEach begin="0" end="${sentence.get(row).randomSentence.size()-1}" var="i">
            <a href="#" onclick="clickMe(${row},${i})" title="${sentence.get(row).randomSentence.get(i)}"
               id="link${row}word${i}">${sentence.get(row).randomSentence.get(i)}</a>
        </c:forEach>
        <br>
        <input style="background-color: #fb009726" type="text" id="row${row}" size="128"
               placeholder="составьте предложение из слов" readonly>
        <br>
        <br>
    </c:forEach>
    <a href="${pageContext.servletContext.contextPath}/word"><input type="button" value="Refresh"></a>
</div>
<div id="results">
    <input type="hidden" id="answer">
</div>

<footer id="footer">
    Copyright Ушаков С.А. / <a href="https://newsapi.org" >"Powered by News API"</a>
</footer>
</body>
</html>