<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=utf-8"%>
    <title>News</title>
</head>
<body>

    <p align="center">${addinfo}</p>
    <form method="post" action="addNews">
        <p align="center"><input type="text" placeholder="Title" name="title"></p>
        <p align="center"><textarea placeholder="Text" name="description"></textarea></p>
        <p align="center"><button name="addNews">Add news</button></p>
    </form>
    <form method="get" action="/">
        <p align="center"><button>To main</button></p>
    </form>
</body>
</html>