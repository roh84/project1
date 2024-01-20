<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jsp.system.Ajax, org.json.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Board List</title>
<link rel="stylesheet" href="/resources/myboard.css" />

<script defer src="/resources/myboard4.js"></script>
</head>
<body>



	<div id="boards4">
		<template>
		<div class="boardBox">
			<div class="NumBox"><a href="/app/postview4.jsp?id=0" class="boardListNum4 boardListNum">0</a></div> 
			<div class="titleBox"><a href="/app/postview4.jsp?id=0" class="title4 title">제목</a></div> 
			<div class="board_contents"><a class="mainContents4 mainContents" style="display:none;">본문</a></div> 
			<div class="writer"><a class="userNickname4 userNickname" style="display:none;">작성자</a></div> 
			<div class="hitCountBox"><a class="hitCount4 hitCount">조회수</a></div> 
			<div class="date"><a class="regDate4 regDate">등록일</a></div>
		</div>
		</template>
	</div>


	<form id="searchform4" class="searchform" action="/api/boardList4" method="post" style="display: none;">
		<select id="searches4" name="searchtype4">
			<option value="userNickname4">작성자</option>
		</select> 
		<input type="text" id="search4" name="search4" value='<%=session.getAttribute("UserNickName")%>'> 
		<input type="text" id="page4" name="page4" value="1" style="display: none;" />
		<button type="button" onclick="submitSearch4()">검색</button>
	</form>
   

</body>
</html>