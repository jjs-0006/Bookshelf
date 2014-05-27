<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
</head>
<body>
<form action="update" method="post">
元のタイトル:<input type="text" name="oldtitle"/><br><br>
編集する項目をチェック<br>
<input type="checkbox" name="titlec" value="1"/>タイトル<input type="text" name="title"/><br>
<input type="checkbox" name="isbnc" value="1"/>ISBN<input type="text" name="isbn"/><br>
<input type="checkbox" name="authorc" value="1"/>著者<input type="text" name="author"/><br>
<input type="checkbox" name="publisherc" value="1"/>出版社<input type="text" name="publisher"/><br>
<input type="checkbox" name="pricec" value="1"/>価格<input type="text" name="price"/><br>
<input type="submit" value="編集"/>
</form>
</body>
</html>