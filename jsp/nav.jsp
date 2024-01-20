<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="32x32" href="/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/resources/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<link rel="stylesheet" type="text/css" href="/resources/myreset.css"> 
<link rel="stylesheet" type="text/css" href="/resources/nav.css"> 
 <link  
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
      integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />   
<title>petpeople</title>
</head>
<body>
 <header>
  <%try(DBConnector con = new DBConnector();){
        		 String usernum = (String)session.getAttribute("UserNum"); 
        			UserDao map2 = con.OpenMap(request, UserDao.class);
        		 
        		 %>
      <nav>
        <h1>
         <a href="main.jsp"><img src="/resources/logo.png" alt="Logo" style= "width:350px" /></a>
        </h1>
        <div class="menu">
  			<a href="main.jsp"><div class="logo_img"><img src="/resource/logo.png" alt="logo" /></div></a>
          <div class="box">
            <div class="board">
              <ul>
                <li><a href="boardlist.jsp">자유게시판</a></li>
                <li><a href="boardlist2.jsp">자랑게시판</a></li>
                <li><a href="boardlist3.jsp">산책게시판</a></li>
                <li><a href="boardlist4.jsp">애완용품거래</a></li>
              </ul>
            </div>
              
              
              <c:if test = "${sessionScope.UserNickName=='관리자'}" >
              
              	<div class="myprofile">
	            	<div class="myprofile_wrap" style="width:40px; height:40px;text-align: center;border-radius: 50%; overflow: hidden;	"><img style="width:100%; height:100%" class="myprofile_img" src=<%=map2.getuserProfile(usernum).toStringProfile()%> alt="유저프로필" />
	            	</div>
	            	<div><p><%=session.getAttribute("UserNickName") %> 님</p></div>
            	</div>
              
	           <div class="login">
	              <div><form action="../api/select/logout.jsp"><input type="submit" value="로그아웃" class="logout"/><input type="hidden" name="logoutAction" value="true"/></form></div>
	              <div><a href="managerpage.jsp">관리자페이지</a></div>
            	</div>
            </c:if>
              
            <c:if test = "${sessionScope.UserNickName==null }" >
	            <div class="login">
	              <div><a href="login.jsp">로그인</a></div>
	              <div><a href="joinmembership.jsp">회원가입</a></div>
            	</div>
            </c:if>
            <c:if test = "${sessionScope.UserNickName!=null && sessionScope.UserNickName != '관리자'}" >
            <div class="myprofile">

            	
            	<div class="myprofile_wrap" style="width:40px; height:40px;text-align: center;border-radius: 50%; overflow: hidden;	"><img style="width:100%; height:100%" class="myprofile_img" src=<%=map2.getuserProfile(usernum).toStringProfile()%> alt="유저프로필" />
            	</div>
            	<div><p><%=session.getAttribute("UserNickName") %> 님</p></div>
      
            </div> <!-- 로그인하면 이름 뜨게 -->
	            <div class="login">
	              <div><form action="../api/select/logout.jsp"><input type="submit" value="로그아웃" class="logout"/><input type="hidden" name="logoutAction" value="true"/></form></div>
	              <div><a href="mypage.jsp">마이페이지</a></div>
            	</div>
            </c:if>
            
          </div>    
        </div>     
      </nav>
      <%
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	} %>
    </header>
</body>
</html>