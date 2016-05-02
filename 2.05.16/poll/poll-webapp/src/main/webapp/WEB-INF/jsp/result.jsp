<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Результаты</title>
</head>
<body>

<h1>Результаты</h1>

<c:forEach items="${polls}" var="entry">
     ${entry.key} - ${entry.value} человек <br>
</c:forEach>
<br>
<a href="/polls">На главную</a>

</body>
</html>
