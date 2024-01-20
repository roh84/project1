<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자랑게시판 글쓰기</h1>

        <input
          type="text"
          id="titleInput"
          name="title"
          placeholder="제목을 입력해주세요"
        />
        <textarea
          id="postTextarea"
          name="mainContents"
          placeholder="글 내용을 입력해주세요"
        ></textarea>
        
        <input type="file" class="file" >
        <div class="btns">
          <button type="button" onclick="submitPost()" class="insertok">
            확인
          </button>
          <input type="submit" value="취소" class="cancelbtn" onclick="delOk()"/>
      </div>
      </form> 
</body>
</html>