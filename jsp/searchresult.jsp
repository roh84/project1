<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/myreset.css" />
<link rel="stylesheet" href="/resources/searchresult.css" />
</head> 
<body>
	<%@include file="../jsp/nav.jsp"%>
    <div class="searchresult">
      <div class="searchresult-title">검색결과</div>
      <div class="searchresult-box">
        <ul>
          <li>
            <div class="content-title">자유게시판</div>
            <div class="content">내용</div>
          </li>
          <li>
            <div class="content-title">자랑게시판</div>
            <div class="content">내용</div>
          </li>
          <li>
            <div class="content-title">산책게시판</div>
            <div class="content">내용</div>
          </li>
          <li>
            <div class="content-title">애완용품거래게시판</div>
            <div class="content">내용</div>
          </li>
        </ul>
      </div>
    </div>
	<%@include file="../jsp/footer.jsp"%>
  </body>
</html>