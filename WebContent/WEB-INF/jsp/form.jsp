<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索</title>
</head>
<body>
<form action="search" method="post">
<input type="text" name="title"/>
<input type="submit" value="検索"/>
</form>
<br>
<form action="jump" method="post">
<input type="submit" value="登録" name="mode">
<input type="submit" value="編集" name="mode">
<input type="submit" value="削除" name="mode">
</form>
</body>
</html>