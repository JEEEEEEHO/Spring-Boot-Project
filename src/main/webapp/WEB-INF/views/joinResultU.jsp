<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${result == 1}">
		<script type="text/javascript">
			alert("회원가입이 완료되었습니다. 로그인 후 이용해주세요.")
			location.href="jhLoginFormU"
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("회원가입에 실패했습니다. 다시 시도해주세요")
			location.href="jhJoinFormU"
		</script>
	</c:otherwise>

</c:choose>

</body>
</html>