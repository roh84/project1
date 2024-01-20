<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>쪽지 작성</title>
</head>
<body>

<h2>쪽지 작성</h2>
<form action="/MessageServlet" method="POST" accept-charset="UTF-8"> <!-- style="display:none" --> 
     <input type="text" name="sender" value="<%=session.getAttribute("UserNum")%>" required ><br>
     <input type="text" name="receiver" placeholder="받는사람" required><br>
     <textarea name="content" placeholder="내용" required ></textarea><br>
    <input type="submit" value="전송">
</form>

</body>
</html>