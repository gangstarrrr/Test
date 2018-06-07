<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
</head>
<body>
	<form action="/test/view/board/update">
		<input type="text" name="title" value="${data.result.title}" placeholder="제목"><br>
		<input type="text" name="content" value="${data.result.content}" placeholder="내용"><br>
		<input type="hidden" name="boardNo" value="${data.result.boardNo}"><br>
		<input type="submit" value="수정"> 
		<a href="/test/view/board/selectList">돌아가기</a>
	</form>
</body>
</html>