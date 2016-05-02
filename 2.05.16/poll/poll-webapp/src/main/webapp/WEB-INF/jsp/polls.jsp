<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Опросы</title>
</head>
<body>

<h1>Опросы</h1>


<ul>
    <c:forEach var="poll" items="${polls}">
        <li>
            <c:url var="pollUrl" value="/poll">
                <c:param name="id" value="${poll.id}"/>
            </c:url>
            <a href="${pollUrl}">
                    ${poll.title}
            </a>
        </li>
    </c:forEach>
</ul>

</body>
</html>
