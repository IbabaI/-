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
			<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath}/Notice/updateFormNotice?n_no=${noticeDto.n_no}'">
			
			<a href="${pageContext.request.contextPath}/Notice/updateFormNotice?n_no=${noticeDto.n_no}" >수정</a>
		</div>	
	</div>
</div>

<pre>


</pre>

</body>
</html>