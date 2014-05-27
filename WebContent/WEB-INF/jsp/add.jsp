<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録</title>
</head>
<body>
<form action="insert" method="post">
ID　　　　           :<input type="text" name="id"/><br>
タイトル　      :<input type="text" name="title"/><br>
ISBNコード:<input type="text" name="isbn"/><br>
著者　　　      :<input type="text" name="author"/><br>
出版社　　 :<input type="text" name="publisher"/><br>
価格　　　      :<input type="text" name="price"/><br>
<input type="submit" value="登録"/>
</form>
</body>
</html>