<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insertCheck(){
		if(n_title.value.length == 0){
			alert("제목을 입력해주세요.");
			n_title.focus();
			return;
		}
		if(n_content.value.length == 0){
			alert("내용을 입력해주세요.");
			n_content.focus();
			return;
		}
		$('#frm').submit();
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
  <form action="${pageContext.request.contextPath}noticeUpdate" id="frm" name="frm" method="post">
  <input type="hidden" name="n_no" value="${noticeDto.n_no}">
	<div class="card border-light">
		<tr><th>No</th><td>${noticeDto.n_no}</td></tr>
		<div class="card-header">
			<input class="card-title" id="n_title" name="n_title" placeholder="제목을 입력하세요" type="text" value="${noticeDto.n_title }" /> 
		</div>
		<h6 class="card-header"> 작성자 : ${noticeDto.id} &emsp;|&emsp;${noticeDto.n_date }&emsp;|&emsp;${noticeDto.n_hit} </h6></h6>
		
	
		<div class="card-content">
			<textarea rows="15" cols="147" id="n_content" name="n_content" placeholder="내용을 입력하세요" value="${noticeDto.n_content}">${noticeDto.n_content}</textarea>
		</div>	
			<tr><td colspan="2">
	   		<button type="submit" value="저장"  onclick="insertCheck();return false;">저장</button>
			<button type="button" value="취소" onclick="location.href='javascript:window.history.back();'">취소</button>
	   		
	   		</td>
  </form>
	</div>
</div>

<pre>


</pre>



</body>
</html>