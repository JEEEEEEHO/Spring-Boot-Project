<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="utf-8" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="assets/"
	data-template="vertical-menu-template-free">
<head>
	<meta charset="utf-8" />
	<title>어드민 | 비숲</title>
	<jsp:include page="A_head.jsp"/>
</head>

<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<jsp:include page="A_menu.jsp"/>

			<!-- Layout container -->
			<div class="layout-page">

				<!-- Content wrapper -->
				<div class="content-wrapper">

					<!-- Content -->
					<div class="container-xxl flex-grow-1 container-p-y">
						<h4 class="fw-bold py-3 mb-4">공지사항 목록</h4>
						<div class="card">
							<!-- Account -->
							<div class="card-body">
								
		
<p>현재 등록된 공지사항  : ${total } 개

<table>
		<tr><th >번호</th><th>글목록</th><th>글유형</th><th>작성일</th></tr>
		<c:forEach var="faq" items="${listFaq }">
			<tr>
				<td>${faq.boardno }</td>
			    <td><a href="aSwFaqdetail?boardno=${faq.boardno}">${faq.board_title }</a></td>
			    <td><c:if test="${faq.board_category == 1}">회원정보 문의</c:if>
			    	<c:if test="${faq.board_category == 2}">주문 및 결제 문의</c:if>
			    	<c:if test="${faq.board_category == 3}">배송문의</c:if>
			    	<c:if test="${faq.board_category == 4}">교환 및 반품 문의</c:if>
				</td>
				<td><fmt:formatDate pattern = "yyyy/MM/dd" value="${faq.board_date }"/></td>
				
			</tr>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
		<tr><td colspan="2">
		<input type="button" value="등록" 
			onclick="location.href='aSwFaqwrite_view?boardno=${faq.boardno}'"></td></tr>
	</table>
	<c:if test="${pg.startPage > pg.pageBlock }">
		<a href="aSwFaqList?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
		<a href="aSwFaqList?currentPage=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${pg.endPage < pg.totalPage }">
		<a href="aSwFaqList?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
	</c:if>
							
							</div>
							<!-- /Account -->
						</div>
					</div>
					<!-- / Content -->

					<div class="content-backdrop fade"></div>
				</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->

	<jsp:include page="A_footer.jsp"/>
			
			

	
	
</body>
</html>