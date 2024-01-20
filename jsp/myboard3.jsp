<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jsp.system.Ajax, org.json.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Board List</title>
<link rel="stylesheet" href="/resources/myboard.css" />

<script defer src="/resources/myboard3.js"></script>
</head>
<body>



	<div id="boards3">
		<template>
			<div class="boardBox">
				<div class="NumBox"><a href="/app/postview3.jsp?id=0" class="boardListNum3">0</a></div> 
				<div class="titleBox"><a href="/app/postview3.jsp?id=0" class="title3 title">제목</a></div> 
				<div class="board_contents"><a class="mainContents3 mainContents" style="display:none;">본문</a></div>
				<div class="writer"><a class="userNickname3 userNickname" style="display:none;">작성자</a></div>
				<div class="hitCountBox"><a class="hitCount3 hitCount">조회수</a></div> 
				<div class="date"><a class="regDate3 regDate">등록일</a></div>
			</div>
		</template>
	</div>
	

	<form id="searchform3" class="searchform" action="/api/boardList3" method="post" style="display: none;">
		<select id="searches3" name="searchtype3">
			<option value="userNickname3">작성자</option>
		</select> 
		<input type="text" id="search3" name="search3" value='<%=session.getAttribute("UserNickName")%>'> 
		<input type="text" id="page3" name="page3" value="1" style="display: none;" />
		<button type="button" onclick="submitSearch3()">검색</button>
	</form>
   

</body>
</html>