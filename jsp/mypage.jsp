<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, org.json.*"%> <%@ page
import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>
        <%@page import="org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>petpeople</title>
    <link
      rel="icon"
      type="image/png"
      sizes="32x32"
      href="/resources/favicon-32x32.png"
    />   
    <link
      rel="icon"
      type="image/png"
      sizes="16x16"
      href="/resources/favicon-16x16.png"
    />
    <link rel="manifest" href="/site.webmanifest" />
    <link rel="stylesheet" href="/resources/myreset.css" />
    <link rel="stylesheet" href="/resources/mypage.css" />
  </head>
  <body>
    <%@include file="../jsp/nav.jsp"%> <%try(DBConnector con = new
    DBConnector();){ UserAnimalDao map = con.OpenMap(request,
    UserAnimalDao.class); String usernum =
    (String)session.getAttribute("UserNum"); UserDao map2 = con.OpenMap(request,
    UserDao.class); %>

    <div class="info_wrap">
      <div class="info">
        <div class="profile"><a href="mypage.jsp">프로필</a></div>
        <div class="mydocument">
          <a href="mydocument.jsp">내가 작성한 글</a>
        </div>
<!--         <div class="notepage"><a href="notepage.jsp">쪽지함</a></div>
 -->      </div>
      <div class="userPet_info">
        <div class="user_info">
          <span>회원</span> <%--
          <%=map2.getuserProfile(usernum).toStringProfile()%> --%>
          <div class="info_image">
            <img
              class="profile_img"
              src="<%=map2.getuserProfile(usernum).toStringProfile()%>"
              alt=""
            />
          </div>
          <div class="info_box">
            <span class="write">이름</span>
            <span class="content"
              ><%=session.getAttribute("UserNickName")%></span
            >
          </div>
          <div class="info_box">
            <span class="write">이메일</span>
            <span class="content"><%=session.getAttribute("UserEmail") %></span>
          </div>
        </div>

        <div class="pet_info">
          <span class="pet">반려동물</span>
          <div class="info_image">
            <img
              class="profile_img"
              src="<%=map.getAnimalProfile(usernum).getAnimalProfile()%>"
              alt="pet_image"
            />
          </div>
          <div class="info_box">
            <span class="write">이름</span>
            <span class="content"
              ><%= map.getAnimalName(usernum).toStringPatName()%>
            </span>
          </div>
          <div class="info_box">
            <span class="write">생일</span>
            <span class="content"
              ><%= map.getAnimalBirth(usernum).toStringPatBirth()%></span
            >
          </div>
          <div class="info_box">
            <span class="write">성별</span>
            <span class="content"
              ><%= map.getAnimalGender(usernum).toStringPatGender()%></span
            >
          </div>
          <div class="info_box">
            <span class="write">몸무게(kg)</span>
            <span class="content">
              <%= map.getAnimalWeight(usernum).toStringPatWeight()%></span
            >
          </div>
        </div>
      </div>

      <% } catch(Exception e) { e.printStackTrace(); } %>

      <div class="info_menu">
        <button class="Modifybtn">
          <a href="infomodify.jsp">정보 수정</a>
        </button>
        <form action="../api/select/logout.jsp">
          <button type="submit" value="로그아웃" class="logoutbtn">
            로그아웃</button
          ><input type="hidden" name="logoutAction" value="true" />
        </form>
      </div>
    </div>
    <c:if test = "${sessionScope.UserNickName==null }" >
  <div class="">
 	</div>
 </c:if>
 <c:if test = "${sessionScope.UserNickName!=null }" >
	<div style="position:fixed; bottom:4.7rem; right:3.5rem; ">
    	<div class="write-go" >
		<a href="insertpage.jsp" >
       		<i class="fa-solid fa-pen-to-square fa-2x"></i>
      	</a>
    </div>
 	<iframe src="./messagebox.jsp" style="position:fixed; bottom:7rem; right:-2rem; width:25rem; height:40rem; z-index: 1;">></iframe>
		
 	</div>
 </c:if>

    <%@include file="../jsp/footer.jsp"%>
  </body>
</html>
