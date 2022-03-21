<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Notice</title>

<style type="text/css">

.list1 td{

}


.pag{
	text-align: center;
	
}
.pag a{
	color: #333;
	text-decoration: none;
}

.pag a:hover{
	color: #ff7f00;
}
</style>
</head>
<body>
<pre>


</pre>
<%
	String context = request.getContextPath();
%>

<div class="container">
	<!-- 게시글 총 개수 -->
	<h2>공지사항</h2>
	<%-- 게시판 총 개수 : ${total }<p> --%>
	
	<!-- 게시글 리스트 출력 -->	
	<table>
		<tr class="hader">
			<th><b>번호</b></th>
			<th><b>제 목</b></th>
			<th><b>작성자</b></th>
			<th><b>조회수</b></th>
			<th><b>등록일</b></th>
		</tr>
		<c:forEach var="notice" items="${listNotice }">
		<tr class="list1">
			<td onclick="location.href='${pageContext.request.contextPath}/Notice/noticeDetail?n_no=${notice.n_no}'">${notice.n_no }</td>
			<td onclick="location.href='${pageContext.request.contextPath}/Notice/noticeDetail?n_no=${notice.n_no}'">${notice.n_title }</td>
			<td onclick="location.href='${pageContext.request.contextPath}/Notice/noticeDetail?n_no=${notice.n_no}'">${notice.id }</td>
			<td>${notice.n_hit }</td>
			<td>${notice.n_date }</td>
		</tr>
		</c:forEach>
	</table>
	
	<div>
		<a href="writeFormNotice">입력</a>
	</div>	
		
	<!-- paging -->	
<ul class="pag">
	<c:set var="num" value="${pg.total-pg.start+1 }"></c:set>
	<c:set var="num" value="${num - 1 }"></c:set>
	<c:if test="${pg.startPage > pg.pageBlock }">
	 	<li><a href="${pageContext.request.contextPath}/Notice/listNotice?currentPage=${pg.startPage-pg.pageBlock }&search_option=${Search_option}">⬅︎</a>
	 </c:if>
	 <c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
	 	<a href="${pageContext.request.contextPath}/Notice/listNotice?currentPage=${i }&search_option=${Search_option}"> [${i}]</a>
	 </c:forEach>
	 <c:if test="${pg.endPage < pg.totalPage }">
	 	<a href="${pageContext.request.contextPath}/Notice/listNotice?currentPage=${pg.startPage+pg.pageBlock }&search_option=${Search_option}">➡︎︎</a></li>
	 </c:if>
</ul> 
	
</div>
</body>
</html>