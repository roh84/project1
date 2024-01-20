<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.jsp.system.Ajax, org.json.*"%>
<%@ page import="com.jsp.dto.ReplyInfo"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 글 확인 페이지</title>
	  <link rel="stylesheet" type="text/css" href="/resources/detail.css"> 

<script>
    var valueId=<%=request.getParameter("id")%>;
    var sessionUser='<%=session.getAttribute("UserNickName")%>';
</script>
<script src="/resources/postings4.js"></script>
<script defer src="/resources/reply4.js"></script>

    

</head>
<body>
	<%@include file="../jsp/nav.jsp"%>
	<div class="detail">
	<h3>애완용품거래</h3>
	<div class="detail_board">
       	<div id="imageContainer4" class="imageContainer"></div>
		<div id="userNickname4">작성자</div>
		<div id="viewTitle4">글 제목</div>
		<div class="box">
		<div id="viewTextarea4">글 내용</div>
		</div>
	</div>
	<% session.getAttribute("UserNickName"); %>

   

		<div class="detail_btn">
			<form action="/app/boardlist4.jsp" method="post" class="btnform">
				<div id="buttonContainer4" class="buttonContainer"></div>
				<button type="submit" class="goback">뒤로가기</button>
			</form>
		</div>
	<div class="comment_box">
		    <h4>댓글</h4>
	<div id="replyContainer4" class="modi_btn">
		<template>
			<div class="replyWrap">
				<div>
					<div class="userNickname4">작성자</div>
					<div class="regDate4">등록일</div>
				</div>
				<div class="modi_btnWrap">
		<%-- 	<button class="editReply" name="editReply"
				onclick="editReply(${data.replyNum})">수정</button> --%>
			<button class="deleteReply4" name="deleteReply4"  
				onclick="deleteReply4(${data.replyNum4})">삭제</button>
				</div>
			</div>
					<div class="replyContents4 replyContents" >본문</div>
		</template>
	</div>


	<form id="replyForm4" action="/api/addReply4" method="post">
         
	<div class="writing_field">
		<input type="text" id="boardListNumInput4" name="boardListNum4"
			value="<%=request.getParameter("id")%>" readonly style="display:none;"> 
		 <input type="text" id="userNickname4" name="userNickname4"
			value="<%=session.getAttribute("UserNickName")%>"
			placeholder="작성자 닉네임" style="display:none;"> 
		
     <c:if test = "${sessionScope.UserNickName==null }" >
     </c:if>
    <c:if test = "${sessionScope.UserNickName!=null}">
		<textarea id="replyContents4" name="replyContents4" placeholder="댓글 내용" class="text"></textarea>
	
		<button type="button" id="addReplyBtn4" onclick="addReply()" class="writing_btn">등록</button>
		</c:if>
		</div>
	</form>
	</div>
	</div>
		<%@include file="../jsp/footer.jsp"%>
		    

</body>
</html>
