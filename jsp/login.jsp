<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <% String loginError = (String)session.getAttribute("loginError");%>
    <script>
      let loginErrors = null;
       <% if (loginError != null) { %>
          loginErrors ="<%=loginError%>";
       <% } %>
    </script>

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
    <title>petpeople</title>
    <link rel="stylesheet" type="text/css" href="/resources/login.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
    <script>
      console.log("왔어!");
         document.addEventListener("DOMContentLoaded", function() {
             // 페이지가 로드될 때 SweetValue 값을 확인하고 SweetAlert을 표시
             if (loginErrors != null) {
                 Swal.fire({
                     title: '',
                     text: loginErrors,
                     icon: 'warning',
                 });
                <%session.removeAttribute("loginError");%>
             }
           });
    </script>
  </head>
  <body>
    <%@include file="../jsp/nav.jsp"%>
    <div class="login-box">
      <div class="loginimg">
        <img src="/resources/logindog.jpg" alt="이미지" class="login-img" />
      </div>
      <div class="login-title">로그인</div>
      <div class="login-box2">
        <form class="login-form" action="../api/select/logincheck.jsp">
          <input
            type="text"
            name="userid"
            class="login-ipbox"
            placeholder="아이디"
          />
          <input
            type="password"
            name="password"
            class="login-ipbox"
            placeholder="비밀번호"
          />
          <input type="submit" value="로그인" class="loginbtn" />
        </form>
        <!-- 로그인 실패 시 에러 메시지가 있으면 표시 -->
        <div class="gojoin">
          <a href="http://localhost:4885/app/findidpassword.jsp"
            >아이디/비밀번호 찾기</a
          >
          <a href="http://localhost:4885/app/joinmembership.jsp">회원가입</a>
        </div>
      </div>
    </div>

    <%@include file="../jsp/footer.jsp"%>
  </body>
</html>
