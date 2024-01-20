<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jsp.system.Ajax, org.json.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Board List</title>
<link rel="stylesheet" href="/resources/myboard.css" />
<script defer src="/resources/myboard.js"></script>
</head>
<body>


	<div id="boards">
		<template>
		<div class="boardBox">
			<div class="NumBox"><a href="/app/postview.jsp?id=0" class="boardListNum">0</a></div>
			<div class="titleBox"><a href="/app/postview.jsp?id=0" class="title">제목</a></div>
			<div class="board_contents"><a class="mainContents" style="display:none;">본문</a></div>
			<div class="writer"><a class="userNickname" style="display:none;">작성자</a></div>
			<div class="hitCountBox"><a class="hitCount">조회수</a></div>
			<div class="date"><a class="regDate">등록일</a></div>
		</div>
		</template>
	</div>
	
	
  		<form id="searchform" class="searchform" action="/api/boardlist" method="post" style="display: none;">
        	<select id="searches" name="searchtype">
				<option value="userNickname">작성자</option>
			</select> 
        		<input type="text" id="search" name="search" value='<%=session.getAttribute("UserNickName")%>'>
        		<input type="text" id="page" name="page" value="1" style="display:none;"/>
        		<button type="button" onclick="submitSearch()" class="searchBtn">검색</button>
   		</form> 

   
</body>
</html>