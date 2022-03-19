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
</head>
<body>
<pre>


</pre>
<%
	String context = request.getContextPath();
%>


<div class="container">
  <form action="${pageContext.request.contextPath}writeNotice" id="frm" name="frm" method="post">
	<input type="hidden" name="id"  value="${sessionScope.sessionId}" > 
	<input type="hidden" name="n_no" value="1">
	<div class="card border-light">
		
		<div class="card-header">
			<tr><th>제목</th><td><input class="card-title" id="n_title" name="n_title"  autofocus="autofocus" placeholder="제목을 입력하세요" type="text" required="required" /></td></tr> 
		</div>
		<h6 class="card-header"> 작성자 : admin  </h6></h6>
		
	
		<div class="card-content">
			<tr><th>내용</th><td><textarea rows="15" cols="147" id="n_content" name="n_content" placeholder="내용을 입력하세요" required="required"></textarea></td></tr>
		</div>	
			<tr><td colspan="2">
	   		<input type="submit" value="저장"  onclick="insertCheck();return false;" />
			<input type="button" value="취소" onclick="location.href='javascript:window.history.back();'" />
	   		
	   		</td>
	</div>
  </form>
</div>

<pre>


</pre>
</body>
</html>