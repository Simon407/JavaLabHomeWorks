<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Опрос</title>
</head>
<body>

<form method="post" action="/poll">
    <p>
        ${poll.title}
    </p>
    <p>
        <input type="hidden" name="id" value="${poll.id}"/>
        <input style="width:430px; height:15px;" type="text" name="result" required/>
    </p>

    <input type="submit" value="Голосовать">
</form>
</body>
</html>
