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
<script defer src="/resources/pagenumber.js"></script> 
<script defer src="/resources/boardlist4.js"></script>
</head>   
<body>
	<%@include file="../jsp/nav.jsp"%>
	
	  <%try(DBConnector con = new DBConnector();){
        		UserAnimalDao map = con.OpenMap(request, UserAnimalDao.class);
        		 String usernum = (String)session.getAttribute("UserNum"); 
        			UserDao map2 = con.OpenMap(request, UserDao.class);
        		 
        		 %>
       	 <div class="main_board"> 
			<h3>애완용품거래</h3>
   

	<div id="boards4">
		<template>
		<div class="board">
			<div class="NumBox"><a href="/app/postview4.jsp?id=0" class="boardListNum4 boardListNum">0</a></div> 
			<div>
				<div ><a href="/app/postview4.jsp?id=0" class="title4 title">제목</a></div> 
				<div class="board_contents"><a class="mainContents4 mainContents">본문</a></div> 
			</div>
			<div class="writer"><a class="userNickname4 userNickname">작성자</a></div> 
			<div><a class="hitCount4 hitCount">조회수</a></div> 
			<div class="date"><a class="regDate4 regDate">등록일</a></div>
		</div>
		</template>
	</div>
	<div id="pages4" class="pages">
		<template>
			<span onclick="pageChange4(this.innerText)">1</span>
		</template>
	</div>


	<form id="searchform4" class="searchform" action="/api/boardList4" method="post">
		<select id="searches4" name="searchtype4">
			<option value="all4">== 선택 ==</option>
			<option value="title4">제목</option>
			<option value="userNickname4">작성자</option>
		</select> 
		<input type="text" id="search4" name="search4"> 
		<input type="text" id="page4" name="page4" value="1" style="display: none;" />
		<button type="button" onclick="submitSearch4()">검색</button>
	</form>


	<form id="refresh4" class="refresh" action="/api/boardList4" method="post">
		<button type="button" class="back4 back"
			onClick="location.href='/app/boardlist4.jsp'">목록으로 돌아가기</button>
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
	      <%
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	} %>
	<%@include file="../jsp/footer.jsp"%>

</body>
</html>