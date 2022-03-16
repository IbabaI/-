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
	<div>
		<h3 class="card-header">${noticeDto.n_no }</h3>
		<h3 class="card-header">${noticeDto.n_title }</h3>
		<h6 class="card-cubtitle">작성자 : admin  &emsp;|&emsp;${noticeDto.n_date }&emsp;|&emsp;${noticeDto.n_hit} </h6>
	
		<div>
			<h6>${notice.n_content }</h6>
		</div>
	
	</div>
<pre>


</pre>

</body>
</html>