<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="32x32" href="/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/resources/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<link rel="stylesheet" href="/resources/myreset.css" />
<link rel="stylesheet" href="/resources/notepage.css" />
<title>Insert title here</title>
</head>
<body>

	<%@include file="../jsp/nav.jsp"%>
	 <div class="info_wrap">
      <div class="info">
        <div class="profile"><a href="mypage.jsp">프로필</a></div>
        <div class="notepage">
          <a href="mydocument.jsp">내가 작성한 글</a>
        </div>
        <div class="mydocument">
          <a href="notepage.html">쪽지함</a>
        </div>
      </div>

      <div class="mynote-box">
        <ul>
          <li>
            <div class="notes">받은 쪽지</div>
            <div class="noteDocs"></div>
          </li>
          <li>
            <div class="notes">보낸 쪽지</div>
            <div class="noteDocs"></div>
          </li>
        </ul>
      </div>
    </div>
	<%@include file="../jsp/footer.jsp"%>
</body>
</html>