<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.jsp.system.Ajax, org.json.*,java.util.*" %>
<%@ page import="com.jsp.dto.ReplyInfo" %>
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
    <script src="/resources/postings.js"></script>
    <script defer src="/resources/reply.js"></script>
    
</head>
<body>
	<%@include file="../jsp/nav.jsp"%>

	<div class="detail">
    <h3>자유게시판</h3>
    <div class="detail_board">
	    <div id="userNickname" class="detail_writer" >작성자</div>
	    <div id="viewTitle" class="detail_title">글 제목</div>
	    <div>
       		<div id="imageContainer" class="imageContainer"></div>
	    	<div id="viewTextarea" class="detail_contents">글</div>
	    </div>
    </div>
    
    
	<% session.getAttribute("UserNickName"); %>

	
    <div class="detail_btn">

    <form action="/app/boardlist.jsp" method="post" class="btnform">
		<div id="buttonContainer" class="buttonContainer" ></div>
        <button type="submit" class='goback'>게시판가기</button>
    </form>
    </div>
       
    
    <div class="comment_box">
     <h4>댓글</h4>
    

    <div id="replyContainer" class="modi_btn">
		<template>
			<div class="replyWrap">
				<div>
					<div class="userNickname">작성자</div>
					<div class="regDate">등록일</div>
				</div>
				<div class="modi_btnWrap">
					
					<button class="deleteReply" name="deleteReply"
						onclick="deleteReply(${data.replyNum})">삭제</button>
						
<!-- 						<div id ="replyDeleteButtonContainer"></div>  
 -->				</div>
			</div>     
				<div class="replyContents">본문</div>
		</template>
	</div>
    
    <form id="replyForm" action="/api/addReply" method="post">
       <div class="writing_field">
       		<input type="text" id="boardListNumInput" name="boardListNum"
			value="<%=request.getParameter("id")%>" readonly style="display:none;">
			<input type="text" id="userNickname" name="userNickname"
			value="<%=session.getAttribute("UserNickName")%>"
			placeholder="작성자 닉네임" style="display:none;">
     <c:if test = "${sessionScope.UserNickName==null }" >
     </c:if>
    <c:if test = "${sessionScope.UserNickName!=null}">
     
        	<textarea id="replyContents" name="replyContents" placeholder="댓글 내용을 입력하세요" class="text"></textarea>
        	<button type="button" onclick="addReply()" class="writing_btn">등록</button>
     </c:if>   
       </div>   
      </form>
    </div>
      </div>
	<%@include file="../jsp/footer.jsp"%>
	    
      
</body>
</html>