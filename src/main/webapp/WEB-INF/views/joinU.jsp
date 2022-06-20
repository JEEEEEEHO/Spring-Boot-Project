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
<style type="text/css">
	button {
	border: 1px;
	}
</style>



<!-- 2. 비밀번호 일치 및 조건 검사 -->
<!-- 3. 이메일 양식 검사 -->
<!-- 4. 전화번호 양식 검사 -->
<script type="text/javascript">
	function chkAll() {
		var pw1=$('#pw').val();
		alert('pw1->'+pw1);
		var pw2=$('#pw2').val();
		alert('pw2->'+pw2);
		var email=$('#email').val();
		alert('email->'+email);
		var tel=$('#tel').val();
		alert('tel->'+tel);
		var idcheckb=$('#idcheckb').val();
		alert('idcheckb->'+idcheckb);
	
		
		if($('#idcheckb').val()=="N"){
			$('#fontid').html('id 중복체크를 해주세요.');
			$('#fontid').css('color','red');
			$('#id').focus();
			return false;
		}
		
		
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		
		if(!reg.test(pw1)){
			$('#fontpw1').html('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
			$('#fontpw1').css('color','red');
			$('#pw').val("");
			$('#pw').focus();
			return false;
		};
		
		if(pw1!=pw2){
			$('#fontpw2').html('비밀번호가 일치하지 않습니다.')
			$('#fontpw2').css('color','red');
			$('#pw2').val("");
			$('#pw2').focus();
			return false;
		};
		
	
		var reg = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
		
		if(!reg.test(email)){
			$('#fontemail').html("이메일 형식이 올바르지 않습니다!");
			$('#fontemail').css('color','red');
			$('#email').val("");
			$('#email').focus();
			 return false;
		}
		
		var reg =/^01[0179][0-9]{7,8}$/;
		if(!reg.test(tel)){ 
			$('#fonttel').html("전화번호 양식을 확인해주세요");
			$('#fonttel').css('color','red');
			$('#tel').val("");
			$('#tel').focus();
		 	return false;
		}
		$('#join_form').submit();
	}
</script>


<title>회원가입</title>
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
						<form action="jhJoinSucU" id="join_form">
						<h2>필수 정보 입력</h2>
						<br>
							<table>
								<tr>
									<td>아이디 </td>
									<td>
										<input type="text" name="id" id="id" placeholder="영문 대소문자와 숫자 4~12자리"  required="required" >
										<button type="button" id="idcheckb" value="N" onclick="idCheck();">중복체크</button>
										<font id="fontid"></font>
										<!-- 1. 아이디 조건 검사 및 존재 여부 검사 -->
										<script type="text/javascript">
											function idCheck() {
												var id= $('#id').val();
													alert('id->'+id);
													
											  	var reg = /^[a-zA-z0-9]{4,12}$/; 
												if(!reg.test(id)){
												 alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
												$('#id').val("");
												$('#id').focus();
												} else{
													$.ajax(
														{
															url:"<%=context%>/jhFindPwIdCheckU",
															data: {id:id},
															dataType: 'text',
															success: function(data){
																alert('data->'+data);
																if(data==1){
																	$('#fontid').html('사용할 수 없는 아이디 입니다.')
																	$('#fontid').css('color','red');
																}else{
																	$('#fontid').html('사용할 수 있는 아이디 입니다');
																	$('#fontid').css('color','green');
																	$('#idcheckb').attr("value","Y")
																}
															}
															
														}		
													)
												}
											
											}
										</script>
									</td>
								</tr>
								<tr>
									<td>비밀번호 </td>
									<td>
										<input type="password" name="pw" id="pw" required="required">
										<font id="fontpw1"></font>
										비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.
									</td>
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td>
										<input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인" required="required">
										<font id="fontpw2"></font>
									</td>
								</tr>								
								<tr>
									<td>이름 </td>
									<td><input type="text" name="name" id="name" required="required"></td>
								</tr>								
								<tr>
									<td>생년월일 </td>
									<td>
										<input type="number" name="birth" id="birth" placeholder="ex_920727" title="6자리로 입력하세요" required="required" >
										<font id="fontbirth"></font>
									</td>
								</tr>
								<tr>
									<td>이메일 </td>
									<td>
										<input type="email" name="email" id="email" required="required">
										<font id="fontemail"></font>
									</td>
								</tr>
								<tr>
									<td>휴대전화 </td>
									<td>
										<input type="text" name="tel" id="tel" placeholder="-없이 입력 " required="required">
										<font id="fonttel"></font>
									</td>
								</tr>		
							</table>
							<br>
							<h3>선택 정보 입력</h3>
							<table>
								<tr>
									<td>우편번호</td>
									<td><input type="number" name="post_code" placeholder="5자리 입력"></td>
								</tr>
								<tr>
									<td>주소</td>
									<td><input type="text" name="address"></td>
								</tr>
								<tr>
									<td>상세주소</td>
									<td><input type="text" name="det_address"></td>
								</tr>															
							</table>		
							<button type="button" onclick="chkAll();">가입하기</button>
							<button type="reset">다시 입력하기</button>
						</form>
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