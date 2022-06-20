<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div id="wrap">
	
		<jsp:include page="/WEB-INF/views/header.jsp"/>
		
		<!-- ----------------------------------------------------------------------main시작----------------------------------- -->
		<div class="margin_wrap">
			<div id="main">
				<div id="slideShow">
				    <ul class="slides">
				      <li><img src="images/event1.jpg" alt=""></li>
				      <li><img src="images/event2.jpg" alt=""></li>
				      <li><img src="images/event3.png" alt=""></li>
				    </ul>  
				    <p class="controller">
				      
				      <!-- &lang: 왼쪽 방향 화살표
							&rang: 오른쪽 방향 화살표 -->
				    <span class="prev">&lang;</span>  
				    <span class="next">&rang;</span>
				  </p>
				</div>
				<script src="js/slideshow.js"></script>
				
				
				<!-- best 상품 -->
				<h3 id="best">BEST 상품</h3>
				
				<ul class="clearfix" id="bestItems">
					<c:forEach var="product" items="${p_list }">
						<li>
							<div onclick="location.href='#'"></div>
							<span class="text_box">
									<h4 onclick="location.href='#'">[${product.brand_name }]${product.prod_name }</h4>
									<c:if test="${product.dc_rate != 0}">
										<span style="color:#c0c0c0;text-decoration:line-through">
											<fmt:formatNumber value="${product.prod_price }" groupingUsed="true"></fmt:formatNumber>원
										</span> <br>
										<span style="color:red">
											<fmt:formatNumber value="${product.sale_price }" groupingUsed="true"></fmt:formatNumber>원
										</span>
									</c:if>
									
									<c:if test="${product.dc_rate == 0}">
										<span style="color:red">
											<fmt:formatNumber value="${product.prod_price }" groupingUsed="true"></fmt:formatNumber>원
										</span>
									</c:if>
									
									
							</span>
						</li>
					</c:forEach>
				</ul>
				
				<div class="marginBtn">
					<button type="button" class="btn btn-outline-success" id="allProductBtn">더 보기</button>
				</div>
			</div> <!-- main끝 -->
		</div>
		<!-- ----------------------------------------------------------------------main끝----------------------------------- -->
		
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
		
	</div> <!-- wrap -->
</body>
</html>