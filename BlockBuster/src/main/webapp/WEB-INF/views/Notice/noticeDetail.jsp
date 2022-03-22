<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!-- <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세내용</title>
<script type="text/javascript">

/* 게시글 삭제 전 check */
function chk(){
	
	if (confirm("정말 삭제하시겠습니까? 삭제할 경우, 게시글 복원은 불가합니다.") == true){   
	    location.href="noticeDelete?n_no=${noticeDto.n_no}"
	}else{  
	 	   return false;	
		 }
}

/* 댓글 리스트 출력 - 호출 */
$(function(){
	listComment("1");
}); 

/*  댓글 입력 검증하기  */
function insertComment1(){
	nc_content.value = nc_content.value.trim();
	
	if(nc_content.value.length==0){
		alert("문의사항을 입력하세요");
		nc_content.focus();
		return;
	}
	insertComment2();
}

/*  검증 완료 후 등록 */
function insertComment2(){
	
	var n_no ="${noticeDto.n_no}"; //게시판 글 번호
	var nc_content=$("nc_content").val(); //댓글 내용
	
		$.ajax({
			type : 'post',
			url : "${pageContext.request.contextPath}/noticeComment",
			data : {'n_no' : n_no , 'nc_content' : nc_content },
			dataType : 'text',
			
			success : function(data){
				if(data>0){
					alert("문의사항이 등록 되었습니다.");
				}else{
					alert("문의사항 등록에 실패하였습니다.");
				}
				listComment("1");
				$('#nc_content').val("");
			}
		});
}


</script>

<style type="text/css">

</style>

</head>
<body>
<pre>


</pre>
<%
	String context = request.getContextPath();
%>


<div class="container">

	<!-- 게시글 상세내용 -->
	<div>
		<h3 class="card-header">${noticeDto.n_no }  &emsp;${noticeDto.n_title }</h3>
		<h6 class="card-header"> 작성자 : ${noticeDto.id} &emsp;|&emsp;${noticeDto.n_date }&emsp;|&emsp;${noticeDto.n_hit} </h6></h6>
		
	
		<div>
			<h6 class="card-body">${noticeDto.n_content}</h6>
			<%-- <input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath}/Notice/updateFormNotice?n_no=${noticeDto.n_no}'"> --%>
			<%-- <input type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}noticeDelete?n_no=${noticeDto.n_no}'"> --%>
			<!-- <button type="button" value="목록" onclick="location.href='javascript:window.history.back();'">목록</button> -->
			
			<a href="${pageContext.request.contextPath}/Notice/updateFormNotice?n_no=${noticeDto.n_no}" >수정</a>
			<a href="" class="text-muted" onclick="chk(); return false;">삭제</a>&emsp;
			<a href="javascript:window.history.back();" >목록</a>
		</div>	
	</div>
	
	
	<!-- 게시글 댓글 폼 -->
	<div class="card-body col-sm-12" style="padding-left: 0px;">		
		<div class="form-group">
			<div class="col-sm-10" style="float: left; padding-left: 0px;">
				<textarea mexlength="300" id="nc_content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></textarea>
			</div> 
		</div> 


		 <div class="col-sm-2" style="float: left;">
			<button type="button" class="btn btn-warning" id="commentSubmit1" onclick="insertComment1()" style="width: 100%; margin-top: 10px"> 댓글문의 </button>
		</div>
	</div>
	
</div>

<pre>


</pre>

</body>
</html>