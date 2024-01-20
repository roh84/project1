<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jsp.system.Ajax, org.json.*" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정 페이지4</title>
    <link rel="stylesheet" type="text/css" href="/resources/editpost.css"> 

    <script>
    var valueId=<%=request.getParameter("id")%>;
    var sessionUser='<%=session.getAttribute("UserNickName")%>';
    </script>
    
    <script src="/resources/postings4.js"></script>
    
</head>
<body>
    
   <%@include file="../jsp/nav.jsp"%>
       
    <div class="editContainer">
    
       <h2>글 수정하기</h2>
       <form id="editForm4" action="/api/editPost4" method="post" class="editForm">
          <input type="hidden" name="boardListNum4" value="<%= request.getParameter("id") %>">
          <textarea id="userNickname4" name="userNickname4" placeholder="작성자" class="userNickname" ></textarea>
          <br>
          <textarea id="viewTitle4" name="title4" placeholder="글 제목" class="viewTitle"></textarea>
          <br><br>
          <textarea id="viewTextarea4" name="mainContents4" placeholder="글 내용" class="viewTextarea"></textarea>
          <br><br><br>
          
          <div class="editbtnWrap">
            <button type="button" onclick="editPost4()">수정 확인</button>
            <form id="refresh" action="/api/boardList4" method="post">
            <button type="button" onClick="location.href='/app/postview4.jsp?id=<%= request.getParameter("id") %>'">돌아가기</button>
         </form>
         <%-- 수정했던 글로 가도록 변경함 --%>
          </div>
      </form>
    
    </div>
    
    
           <%@include file="../jsp/footer.jsp"%>    

</body>
</html>