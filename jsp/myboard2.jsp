<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jsp.system.Ajax, org.json.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Board List</title>
<link rel="stylesheet" href="/resources/myboard.css" />

<script defer src="/resources/myboard2.js"></script>
</head>
<body>



	<div id="boards2">
		<template>
			<div class="boardBox">
				<div class="NumBox"><a href="/app/postview2.jsp?id=0" class="boardListNum2 boardListNum">0</a></div> 
				<div class="titleBox"><a href="/app/postview2.jsp?id=0" class="title2 title">제목</a></div>
				<div class="board_contents"><a class="mainContents2 mainContents" style="display:none;">본문</a></div>
				<div class="writer"><a class="userNickname2 userNickname" style="display:none;">작성자</a> </div>
				<div class="hitCountBox"><a class="hitCount2 hitCount">조회수</a></div> 
				<div class="date"><a class="regDate2 regDate">등록일</a></div>
			</div>
		</template>
	</div>
	
	<form id="searchform2" class="searchform" action="/api/boardList2" method="post" style="display: none;">
		<select id="searches2" name="searchtype2">
			<option value="userNickname2">작성자</option>
		</select> 
		<input type="text" id="search2" name="search2" value='<%=session.getAttribute("UserNickName")%>'> 
		<input type="text" id="page2" name="page2" value="1" style="display: none;" />
		<button type="button" onclick="submitSearch2()" class="searchBtn">검색</button>
	</form>
   

</body>
</html>