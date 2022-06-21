<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String context = request.getContextPath();    //콘텍스트명 얻어오기.
%>
<!DOCTYPE html>
<html lang="utf-8" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<title>비숲 | 상품 관리</title>
<script type="text/javascript" src="<%=context %>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<script type="text/javascript">
	var oEditors = [];
	$(function(){
	      nhn.husky.EZCreator.createInIFrame({
	          oAppRef: oEditors,
	          elPlaceHolder: "editorTxt", //textarea에서 지정한 id와 일치해야 합니다. 
	          //SmartEditor2Skin.html 파일이 존재하는 경로
	          sSkinURI: "smarteditor/SmartEditor2Skin.html",  
	          htParams : {
	              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseToolbar : true,             
	              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseVerticalResizer : true,     
	              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseModeChanger : true,         
	              fOnBeforeUnload : function(){
	                   
	              }
	          }, 
	          fOnAppLoad : function(){
	              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
	              oEditors.getById["editorTxt"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
	              // DB에 있는 걸 가져오면 에러남^^ 태그 때문인거같은데 해결해보시오
	              //oEditors.getById["editorTxt"].exec("PASTE_HTML", ["'<img alt="상품이미지" src="../upload/${product.prod_info}">'"]);
	          },
	          fCreator: "createSEditor2"
	      });
	      
	      //저장버튼 클릭시 form 전송
	      $("#save").click(function(){
	    	  if (!frm.brand_name.value) {
					alert("브랜드명을 입력해주세요.");
					frm.brand_name.focus();
					return false;
	    	  }
	    	  if (!frm.prod_name.value) {
					alert("상품명을 입력해주세요.");
					frm.prod_name.focus();
					return false;
	    	  }
	    	  if (!frm.price.value) {
					alert("판매가를 입력해주세요.");
					frm.price.focus();
					return false;
	    	  }
	    	  if (!frm.stock.value) {
					alert("재고수량을 입력해주세요.");
					frm.stock.focus();
					return false;
	    	  }
	    	  if (!frm.th_img.value) {
					alert("배너 이미지를 등록해주세요.");
					frm.th_img.focus();
					return false;
	    	  }
	    	  if (!frm.main_img1.value) {
					alert("대표 이미지를 등록해주세요.");
					frm.main_img1.focus();
					return false;
	    	  }
	    	  if (!frm.main_img2.value) {
					alert("대표 이미지를 등록해주세요.");
					frm.main_img2.focus();
					return false;
	    	  }
	    	  
	          oEditors.getById["editorTxt"].exec("UPDATE_CONTENTS_FIELD", []);
	          $("#frm").submit();
	      });    
	});
</script>
	
	
<link href="css/admin_product.css" rel="stylesheet" type="text/css">
<style type="text/css">
    td:nth-child(1) {
    	width: 150px;
    }
    table tr td span {
    	font-size: 20px;
    }
    .img_text {
    	font-size: 12px; 
    	color: #3b82f6;
    }
    .text {
    	font-size: 12px; 
    }
    .btn_wrapper {
    	text-align: right;
    }
</style>
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
						<h4 class="fw-bold py-3 mb-4">상품 관리</h4>
						<!-- Account -->

						<form action="prodUpdate" method="post" name="frm" enctype="multipart/form-data">
				            <div class="card mb-4">
				              <div class="table-responsive text-nowrap">
				                <table class="table table-borderless">
				                  <tr>
				                    <td>게시상태</td>
				                    <td>
				                    	<c:if test="${product.prod_poststs == 0}">
				                    		<span class="badge bg-label-secondary me-1">비게시 중</span>
				                    	</c:if>
				                    	<c:if test="${product.prod_poststs == 1}">
				                    		<span class="badge bg-label-primary me-1">게시 중</span>
				                    	</c:if>
				                    </td>
				                  </tr>
				                  <tr>
				                    <td>판매상태</td>
				                    <td>
				                    	<c:if test="${product.prod_salests == 0}">
					                        <span class="badge bg-label-danger me-1">판매 중지</span>
			                        	</c:if>
			                        	<c:if test="${product.prod_salests == 1}">
			                        		<span class="badge bg-label-primary me-1">판매 중</span>
			                        	</c:if>
			                        	<c:if test="${product.prod_salests == 2}">
					                        <span class="badge bg-label-secondary me-1">품절</span>
			                        	</c:if>
				                    </td>
				                  </tr>
				                  <tr>
				                    <td>카테고리</td>
				                    <td>
				                      <select class="form-select mt-3">
				                          <option value="1" selected="selected">비건식품</option>
				                          <option value="2">생활용품</option>
				                          <option value="3">고체뷰티</option>
				                          <option value="3">스킨케어</option>
				                      </select>
				                    </td>
				                  </tr>
				                  <tr>
				                    <td>브랜드명</td>
				                    <td colspan="3"><input name="brand_name" class="form-control mt-3" type="text" value="${product.brand_name}" required="required"/></td>
				                  </tr>
				                  <tr>
				                    <td>상품명</td>
				                    <td colspan="3"><input name="prod_name" class="form-control mt-3" type="text" value="${product.prod_name}" required="required"/></td>
				                  </tr>
				                  <tr>
				                    <td>판매가</td>
				                    <td><input name="price" class="form-control mt-3" type="text" placeholder="원단위 입력" value="${product.prod_price}" required="required"/></td>
				                    <td>할인율 : <span>${product.dc_rate}</span>%</td>
				                    <td>할인가 : <span><fmt:formatNumber value="${product.sale_price}" pattern="###,###,###"/></span>원</td>
				                  </tr>
				                  <tr>
				                    <td>재고수량</td>
				                    <td><input name="stock" class="form-control mt-3" type="text" placeholder="개수 입력" value="${product.stock}" required="required"/></td>
				                    <td>총 판매수량 : <span><fmt:formatNumber value="${product.sale_qty}" pattern="###,###,###"/></span>건</td>
				                    <td>남은 재고 수량 : <span><fmt:formatNumber value="${product.stock - product.sale_qty}" pattern="###,###,###"/></span>건</td>
				                  </tr>
				                  <tr>
				                    <td>배너 이미지</td>
				                    <td colspan="3">
									  <p class="text mt-3">기존 이미지 : ${product.th_img}
				                      <input name="th_img" class="form-control mt-1" type="file" accept=".gif, .jpg, .png" required="required"/>
				                    </td>
				                  </tr>
				                  <tr>
				                    <td>상품 이미지</td>
				                    <td colspan="3">
				                      <span class="mt-3 img_text">* 2장의 이미지를 첨부해주세요</span>
									  <p class="text mt-1">기존 이미지 : ${product.main_img1}, ${product.main_img2}
				                      <input name="main_img1" class="form-control mt-1" type="file" accept=".gif, .jpg, .png" required="required"/>
				                      <input name="main_img2" class="form-control mt-1" type="file" accept=".gif, .jpg, .png" required="required"/>
				                    </td>
				                  </tr>
				                  <tr>
				                    <td>상세정보</td>
				                    <td colspan="3">
				                      <p class="mt-3">
				                      <textarea 
				                      		name="editorTxt" id="editorTxt" style="width: 100%;" 
				                      		rows="12" cols="137" required="required"></textarea>
				                      <p>
				                    </td>
				                  </tr>
				                </table>
				              </div>
				            </div>
				            <div class="mb-3 btn_wrapper">
				                <input type="button" value="삭제" class="btn btn-secondary" onclick="location.href='prodDelete?prodno=${product.prodno}'"></button>
				                <input type="button" value="목록" class="btn btn-outline-secondary" onclick="location.href='prodSelect'"></button>
				                <input type="button" id="save" value="수정" class="btn btn-primary"></button>
				            </div>
				        </form>
						<!-- /Account -->
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