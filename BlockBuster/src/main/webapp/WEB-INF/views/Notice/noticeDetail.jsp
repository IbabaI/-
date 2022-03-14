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
		<h3 class="card-header">${notice.n_title }</h3>
		<h6 class="card-cubtitle">작성자 : ${notice.nickName }&emsp;|&emsp;${notice.n_hit }&emsp;|&emsp;${notice.n_date }</h6>
	
		<div>
			${notice.n_content }
		</div>
	
	</div>
<pre>


</pre>

</body>
</html>