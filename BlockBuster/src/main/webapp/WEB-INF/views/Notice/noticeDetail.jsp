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
</div>

<pre>


</pre>

</body>
</html>