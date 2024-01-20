<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jsp.system.Ajax, org.json.*" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정 페이지3</title>
    <link rel="stylesheet" type="text/css" href="/resources/editpost.css"> 

    <script>
    var valueId=<%=request.getParameter("id")%>;
    var sessionUser='<%=session.getAttribute("UserNickName")%>';
    </script>
    
    <script src="/resources/postings3.js"></script>
    
</head>
<body>
   
    <%@include file="../jsp/nav.jsp"%>
    
        <div class="editContainer">
    
          <h2>글 수정하기</h2>
          <form id="editForm3" action="/api/editPost3" method="post" class="editForm">
             <input type="hidden" name="boardListNum3" value="<%= request.getParameter("id") %>">
             <textarea id="userNickname3" name="userNickname3" placeholder="작성자" class="userNickname" ></textarea>
             <br>
             <textarea id="viewTitle3" name="title3" placeholder="글 제목" class="viewTitle" ></textarea>
             <br><br>
             <textarea id="viewTextarea3" name="mainContents3" placeholder="글 내용" class="viewTextarea"></textarea>
             <br><br><br>
             
              <div class="editbtnWrap">
         
                <button type="button" onclick="editPost3()">수정 확인</button>
                   <form id="refresh" action="/api/boardList3" method="post">
            <button type="button" onClick="location.href='/app/postview3.jsp?id=<%= request.getParameter("id") %>'">돌아가기</button>
         </form>
         <%-- 수정했던 글로 가도록 변경함 --%>
               </div>
   
         </form>
        </div>
    
    
           <%@include file="../jsp/footer.jsp"%>   
    

</body>
</html>