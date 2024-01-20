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
<title>petpeople</title>
    <link rel="stylesheet" type="text/css" href="/resources/detail.css"> 

<script>
    var valueId=<%=request.getParameter("id")%>;
    var sessionUser='<%=session.getAttribute("UserNickName")%>';
</script>
<script src="/resources/postings2.js"></script>
<script defer src="/resources/reply2.js"></script>



</head>
<body>

	<%@include file="../jsp/nav.jsp"%>
	
	<div class="detail">
	<h3>자랑게시판</h3>
	<div class="detail_board">
		<div id="userNickname2">작성자</div>
		<div id="viewTitle2">글 제목</div>
		<div id="viewTextarea2">글</div>
	</div>

       <div id="imageContainer2" class="imageContainer"></div>
	<% session.getAttribute("UserNickName"); %>


	<div class="detail_btn">
		<form action="/app/boardlist2.jsp" method="post" class="btnform">
			<div id="buttonContainer2" class="buttonContainer"></div>
			<button type="submit" class="goback">게시판가기</button>
		</form>
	</div>
	
	<div class="comment_box">
     <h4>댓글</h4>
	
	<div id="replyContainer2"  class="modi_btn">
		<template>
			<div class="replyWrap">
				<div>
					<div class="userNickname2 userNicname">작성자</div>
					<div class="regDate2 regDate">등록일</div>
				</div>
				<div class="modi_btnWrap">
		<%-- 	<button class="editReply" name="editReply"
				onclick="editReply(${data.replyNum})">수정</button> --%>
				<button class="deleteReply2" name="deleteReply2"
					onclick="deleteReply2(${data.replyNum2})">삭제</button>
				</div>
			</div>
					<div class="replyContents2 replyContents">본문</div>
		</template>
	</div>   
   
	<form id="replyForm2" action="/api/addReply2" method="post">
     
		 <div class="writing_field">
			<input type="text" id="boardListNumInput2" name="boardListNum2"
			value="<%=request.getParameter("id")%>" readonly style="display:none;">
	 		<input type="text" id="userNickname2" name="userNickname2"
			value="<%=session.getAttribute("UserNickName")%>"
			placeholder="작성자 닉네임" style="display:none;">
    <c:if test = "${sessionScope.UserNickName==null }" >
     </c:if>
    <c:if test = "${sessionScope.UserNickName!=null}">
		<textarea id="replyContents2" name="replyContents2" placeholder="댓글 내용"  class="text"></textarea>
		<button type="button" id="addReplyBtn2"  class="writing_btn">등록</button>
		 </c:if>
		</div>
	</form>
		</div>
	</div>
		<%@include file="../jsp/footer.jsp"%>
	
</body>
</html>
