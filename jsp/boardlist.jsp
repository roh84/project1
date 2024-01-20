<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, org.json.*"%>
    <%@page import="org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch"%>
    
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>

    <link rel="icon" type="image/png" sizes="32x32" href="/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/resources/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<link rel="stylesheet" type="text/css" href="/resources/board.css">
<script defer src="/resources/boardlist.js"></script>
<script defer src="/resources/pagenumber.js"></script> 
</head>
<body>
      
		
	<%@include file="../jsp/nav.jsp"%>
	
	
	
        		 
        		 
<div class="main_board"> 
		
	<h3>자유게시판</h3>
	<div id="boards">
		<template>
		<div class="board">
			<div class="NumBox"><a href="/app/postview.jsp?id=0" class="boardListNum">0</a></div>
			<div>
				<div><a href="/app/postview.jsp?id=0" class="title">제목</a></div>
				<div class="board_contents"><a class="mainContents">본문</a></div>
			</div>
			<div class="writer"><a class="userNickname">작성자</a></div>
			<div class="hitBox"><a class="hitCount">조회수</a></div>
			<div class="date"><a class="regDate">등록일</a></div>
		</div>
		</template>
	</div>
		<div id="pages" class="pages">
		<template> 
			<span onclick="pageChange(this.innerText)">1</span>
		</template>
	</div> 
	
	
        
	
  		<form id="searchform" class="searchform" action="/api/boardlist" method="post" >
        	<select id="searches" name="searchtype">
        		<option value="all">== 선택 ==</option>
				<option value="title">제목</option>
				<option value="userNickname">작성자</option>
			</select> 
        		<input type="text" id="search" name="search">
        		<input type="text" id="page" name="page" value="1" style="display:none;"/>
        		<button type="button" onclick="submitSearch()" class="searchBtn">검색</button>
   		</form> 
   		
   		
   		<form id="refresh" class="refresh" action="/api/boardlist" method="post">
   			<button type="button" class="back" onClick="location.href='/app/boardlist.jsp'" >목록으로 돌아가기</button>
   		</form>  		
   		
   		

	</div>
		<c:if test = "${sessionScope.UserNickName==null }" >
  <div class="">
 	</div>
 </c:if>
 <c:if test = "${sessionScope.UserNickName!=null }" >
	<div style="position:fixed; bottom:4.7rem; right:3.5rem; ">
    	<div class="write-go" >
		<a href="insert.jsp" >
       		<i class="fa-solid fa-pen-to-square fa-2x"></i>
      	</a>
    </div>
 	<iframe src="./messagebox.jsp" style="position:fixed; bottom:7rem; right:-2rem; width:25rem; height:40rem; z-index: 1;">></iframe>
		
 	</div>
 </c:if>
	
	
	<%@include file="../jsp/footer.jsp"%>
	
<!-- <h1>Board List</h1>
		
		
	<div id="boards">
		<template>
			<a href="/postView.jsp?id=0" class="boardListNum">0</a>
			<a href="/postView.jsp?id=0" class="title">제목</a>
			<a class="mainContents">본문</a>
			<a class="userNickname">작성자</a>
			<a class="hitCount">조회수</a>
			<a class="regDate">등록일</a>
		</template>
	</div>
	<div id="pages">
		<template> 검색시 그대로 전체페이지가 남는 현상이 있는데 일단 후순위로
			<span onclick="pageChange(this.innerText)">1</span>
		</template>
	</div>
        
	
  		<form id="searchform" action="/api/boardlist" method="post">
        	<select id="searches" name="searchtype">
        		<option value="all">== 선택 ==</option>
				<option value="title">제목</option>
				<option value="userNickname">작성자</option>
			</select> 
        		<input type="text" id="search" name="search">
        		<input type="text" id="page" name="page" value="1" style="display:none;"/>
        		<button type="button" onclick="submitSearch()">검색</button>
   		</form> 
   		
   		
   		<form id="refresh" action="/api/boardlist" method="post">
   			<button type="button" class="back" onClick="location.href='/boardList.jsp'">목록으로 돌아가기</button>
   		</form>  		
   		<form action="/insert" method="post">
   			<button type="button" class="navyBtn" onClick="location.href='/insert.jsp'">글쓰기</button>
   		</form>   -->		
   
   
</body>
</html>