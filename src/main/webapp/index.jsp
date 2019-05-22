<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>

    <%@ page contentType="text/html;charset=utf-8"%>
    <title>Main</title>
</head>

<body>
    <form method="get" action="/addNews">
        <p align="center"><button>Add news</button></p>
    </form>

<c:forEach items="${allnews}" var="item">
    <h3 align="center">${item.title}</h3>
    <p align="center">${item.newsText}</p>
    <a href="<c:url value = "readnews?id=${item.id}"/>">Read news</a>
</c:forEach>

</body>

</html>