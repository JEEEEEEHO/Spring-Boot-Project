<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String context = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/mypage.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	function valueCheck() {
		
		var isSubmit=false;
		var id= $('#id').val();
			alert('id->'+id)
		var pw= $('#pw').val();
			alert('pw->'+pw)

		$.ajax(
			{
				url:"<%=context%>/jhLoginCheckU",
				data: {id:id, pw:pw},
				dataType: 'text',
				async:false,
				success: function(data){
					alert('data->'+data)
					if(data==1){
						isSubmit=true;
						
					}else{
						alert('아이디 비밀번호를 확인하세요')
						isSubmit= false;
					}
				}
				
			}		
		
		)
		if(!isSubmit) return false;
		
	}
</script>

<title>로그인</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/views/header.jsp"/>
<!-- ----------------------------------------------------------------------main시작----------------------------------- -->
		<div class="margin_wrap">
			<div class="main clearfix">
<!-- ----------------------------------------------------------------------여기에 코딩 시작----------------------------------->
				<section class="sectionmy">
					<div class="contents_wrap">
					<!-- 작업 영역 -->
						<h2>로그인</h2>
						<form action="jhLoginSucU" onsubmit="return valueCheck()">
							<table>
								<tr>
									<td>아이디 </td>
									<td><input type="text" name="id" id="id" required="required" ></td>
								</tr>
								<tr>
									<td>비밀번호 </td>
									<td><input type="password" name="pw" id="pw" required="required"></td>
								</tr>
							</table>
							<input type="submit" value="로그인">
						</form>
						<br>
						<br>
						<h1>비밀번호를 잊으셨나요? </h1>
						<br>
						<a href="jhFindPwFormU" >비밀번호 찾기</a>
						<br>
						<br>				
						<br>		
						<h1>아직 회원이 아니신가요?</h1>
						<br>
						<a href="jhJoinFormU" >회원가입하러 가기</a>
	
					<!-- 작업 영역 -->
					</div>
				</section>	
			</div>
		</div>
		<!-- ----------------------------------------------------------------------여기에 코딩 끝------------------------------------>
		<!-- ----------------------------------------------------------------------main끝----------------------------------- -->
		
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
	</div> <!-- wrap -->
</body>
</html>