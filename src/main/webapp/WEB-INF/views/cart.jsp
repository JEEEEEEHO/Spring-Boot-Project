<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cart_payment">
		<c:forEach var="basket" items="${b_list }">
			<input type="checkbox" name="prodno" value="${basket.prodno }">${basket.prodno }
		</c:forEach>
		<input type="submit" value="결제">
	</form>
</body>
</html>