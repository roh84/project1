<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="32x32" href="/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/resources/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<title>petpeople</title>
  <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css"
    />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<script src="/resources/joinmembership.js" defer></script>
<link rel="stylesheet" type="text/css" href="/resources/joinmembership.css"> 
</head>
<body>
<%@include file="../jsp/nav.jsp"%>
 <form action="../api/insert/joinmember.jsp" class="join-box" id="signupForm">
      <div class="join-img"> 
       <img src="/resources/joincat2.png" alt="이미지" class="joinpic" />
      </div> 
      
      <div class="join-title">회원가입</div>
      <div class="join-labelbox">
        <input type="text" name="name" class="ipbox" id="name" placeholder="이름" minlength="2" required/>
        <div class="nick-box">
          <input
            type="text"
            name="nickname"
            id="nickname"
            placeholder="닉네임"
            class="ipbox"
            minlength="2"
            required
          />
          <button class="ckbox" type="button"  onclick="logincheckName()">중복체크</button>
        </div>
        <div class="id-box">
          <input type="text"  id="userid" name="userid" class="ipbox" placeholder="아이디" required/>
          <button class="ckbox" type="button"  onclick="logincheckID()">중복체크</button>
        </div>
        
        <div class="email-box">
          <input type="text"  id="useremail" name="useremail" class="ipbox" placeholder="이메일" required/>
        </div>
        
        <input
          type="password"
          id="password" name="password"
          class="ipbox"
          placeholder="비밀번호"
          minlength="3"
          required
        />
        <input 
          type="password"
          placeholder="비밀번호 확인"
          id="passwordcheck" 
          name="passwordcheck"
          minlength="4"
          required
          class="ipbox" required/>
        <div id="passwordMatchStatus"></div>
        <input type="submit" value="회원가입" class="submitbtn" id="signupButton" />
      </div>
      <!-- 동의버튼 넣을건지? -->
    </form>
      
<%@include file="../jsp/footer.jsp"%>
  <!--  <div id="formWrap">
 	<form id="signupForm" action="../api/insert/joinmember.jsp">
 	<label for="name">이름:</label><input type="text" placeholder="*" id="name" name="name">
 	
 	<label for="nickname">닉네임:</label><input type="text" placeholder="*" id="nickname" name="nickname"><button type="button"  onclick="logincheckName()">닉네임 중복체크</button>
 	<label for="userid">아이디:</label><input type="text" placeholder="*" id="userid" name="userid"><button type="button"  onclick="logincheckID()">아이디 중복체크</button>
 	<label for="password">비밀번호:</label><input type="text" placeholder="*" id="password" name="password">	
 	<label for="passwordcheck">비밀번호 확인:</label><input type="text" placeholder="*" id="passwordcheck" name="passwordcheck">
 	<div id="passwordMatchStatus"></div>
 	<input id="signupButton" type="submit" value="회원 가입">
 	</form>
 	</div>
</body>
</html>
 -->