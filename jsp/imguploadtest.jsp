<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page import="com.jsp.system.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 
</head>
<body>
   
    <form action="/info" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="파일 업로드">
    </form>
 
</body>
