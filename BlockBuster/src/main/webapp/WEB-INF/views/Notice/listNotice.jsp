<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!-- <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
</head>
<body>
<pre>


</pre>
<%
	String context = request.getContextPath();
%>
	<!-- 게시글 총 개수 -->
	<h2>게시판 list</h2><a href="writeFormNotice">입력</a>
	게시판 총 개수 : ${total }<p>
	
	<!-- 게시글 리스트 출력 -->
	<table>
		<tr class="table-active">
			<th scope="row"><b>글번호</b></th>
			<th scope="row"><b>제 목</b></th>
			<th scope="row"><b>작성자</b></th>
			<th scope="row"><b>조회수</b></th>
			<th scope="row"><b>등록일</b></th>
		</tr>
		<c:forEach var="notice" items="${listNotice }">
		<tr class="list2">
			<td onclick="location.href='${pageContext.request.contextPath}/Notice/noticeDetail?r_no=${notice.n_no}'">${notice.n_no }</td>
			<td onclick="location.href='${pageContext.request.contextPath}/Notice/noticeDetail?r_no=${notice.n_no}'">${notice.n_title }</td>
			<td onclick="location.href='${pageContext.request.contextPath}/Notice/noticeDetail?r_no=${notice.n_no}'">${notice.id }</td>
			<td>${notice.n_hit }</td>
			<td>${notice.n_date }</td>
		</tr>
		</c:forEach>
		
	<!-- paging -->	
<ul class="pag">
	<c:set var="num" value="${pg.total-pg.start+1 }"></c:set>
	<c:set var="num" value="${num - 1 }"></c:set>
	<c:if test="${pg.startPage > pg.pageBlock }">
	 	<li class="page-item"><a href="${pageContext.request.contextPath}/Notice/listNotice?currentPage=${pg.startPage-pg.pageBlock }&search_option=${Search_option}">⬅︎</a>
	 </c:if>
	 <c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
	 	<a href="${pageContext.request.contextPath}/Notice/listNotice?currentPage=${i }&search_option=${Search_option}"> [${i}]</a>
	 </c:forEach>
	 <c:if test="${pg.endPage < pg.totalPage }">
	 	<a href="${pageContext.request.contextPath}/Notice/listNotice?currentPage=${pg.startPage+pg.pageBlock }&search_option=${Search_option}">➡︎︎</a></li>
	 </c:if>
</ul> 
	</table>
</body>
</html>