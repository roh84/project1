<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기 페이지</title>
    <script src="https://cdn.jsdelivr.net/npm/dropzone@6.0.0-beta.2/dist/dropzone-min.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/dropzone@6.0.0-beta.2/dist/dropzone.min.css">
    <script defer src="/resources/boardWrite.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/insertpage.css"> 
    
    
</head>
<body>
    
   	<%@include file="../jsp/nav.jsp"%>
   	
   	
   <div class="insertpage">
   	<div class="insert-box">
   	<div class="insertpagebox">
         <ul  class="insertbtn">
           <li>
             <a href="insert.jsp">자유게시판</a>
             <ul class="insertul">
               <li><a href="insert2.jsp">자랑게시판</a></li>
               <li><a href="insert3.jsp">산책게시판</a></li>
               <li><a href="insert4.jsp">애완용품거래</a></li>
             </ul>
           </li>
          </ul>
       </div>
    <form id="writeForm" action="/api/newPost" method="post">
        <input type="text" id="userNickname" name="userNickname" class="userNickname" value='<%=session.getAttribute("UserNickName")%>' readonly>
        <input type="text" id="titleInput" name="title" placeholder="제목을 입력해주세요" class="titleInput">
        <textarea id="postTextarea" name="mainContents" placeholder="글 내용을 입력해주세요" class="postTextarea"></textarea>
        
        <div class="dropzone"></div>
        
          <div class="btns">
           <button type="submit" id="submit" class="insertok">확인</button>
           <button type="button" onclick="cancelPost()" class="cancelbtn">취소</button>
           <form action="/app/boardlist" method="post">
               <button type="button" onclick="location.href='/app/boardlist.jsp'" class="backbtn">게시판</button>
           </form> 
           </div> 
           </div>
    </form>
    </div>
       <%@include file="../jsp/footer.jsp"%>
</body>
</html>

   