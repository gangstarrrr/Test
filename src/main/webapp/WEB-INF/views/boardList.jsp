<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardlist...</title>
</head>
<body>
	<a href="/test/resources/insert.html">글작성</a><br>
	<ul>
		<c:forEach var="row" items="${data.result}">
			<li><a href="/test/view/board/selectOne?boardNo=${row.boardNo}">${row.title}</a></li>
		</c:forEach>
	</ul>
</body>
</html>