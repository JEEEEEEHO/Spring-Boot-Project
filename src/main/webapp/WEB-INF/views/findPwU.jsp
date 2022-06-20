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
	function idCheck() {
		var id= $('#id').val();
			alert('id->'+id)

			$.ajax(
				{
					url:"<%=context%>/jhFindPwIdCheckU",
					data: {id:id},
					dataType: 'text',
					success: function(data){
						alert('data->'+data)
						if(data==1){
							alert('존재하는 아이디 입니다')
							$('#id').val(id);
							
						}else{
							alert('존재하지 않는 아이디 입니다. 회원가입을 진행해주세요')
						}
					}
					
				}		
			)
		}
</script>

<script type="text/javascript">
	function pwEmail() {
		var id= $('#id').val();
		alert('id->'+id)
		
		$.ajax(
			{
				url:"<%=context%>/jhFindPwEmailGetU",
				data: {id:id},
				dataType: 'text',
				success:function(data){
					if(data==1){
						alert('data->'+data);
						alert('가입하신 이메일로 임시번호를 발송해드렸습니다.')
						location.replace("jhLoginFormU")
					}else{
						alert('이메일 전송에 실패했습니다. 다시 시도해주세요.')
					}
				}
			}		
		)
	}

</script>


<title>비밀번호 찾기</title>
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
						<h2>비밀번호 찾기</h2>
							<table>
								<tr>
									<td>아이디 </td>
									<td><input type="text" name="id" id="id" required="required" ></td>
								</tr>
							</table>
							<input type="button" value="id 검증" onclick="idCheck()">
							<input type="submit" value="이메일로 비밀번호 받기" onclick="pwEmail()">
	
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