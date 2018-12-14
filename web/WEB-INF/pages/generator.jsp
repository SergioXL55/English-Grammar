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
    <title>Title</title>
</head>
<body>


<div style="position: center" >
    <h1>${title}</h1>
    <br>
    <form action="${pageContext.servletContext.contextPath}/${perfix}" method="post" onsubmit="return validate_form();" name="mainForm">
        <p>
        <h3>Введите текст:</h3></p>
        <input type="text" name="text"/>
        <button type="submit" value="Click">Закодировать</button>
    </form>
</div>
<div>
    <p>
    <h3>Резльтат:</h3></p>
    <p>${decode}</p>
</div>
</body>

<script type="text/javascript">
    function validate_form() {
        valid = true;
        if (document.mainForm.text.value == "") {
            alert("Пожалуйста введите текст");
            valid = false;
        }
        return valid;
    }
</script>

</html>
