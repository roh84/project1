<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>


   
<%
try(DBConnector con = new DBConnector();){
		UserDao map = con.OpenMap(request, UserDao.class);
		UserAnimalDao map2 = con.OpenMap(request, UserAnimalDao.class);
	
		String usernum = (String)session.getAttribute("UserNum");
		
		//저장 정보 삭제
		map.deleteUser(usernum);
		map2.deleteUserAnimal(usernum);
		session.removeAttribute("UserNum");
		session.removeAttribute("UserNickName");
		session.removeAttribute("UserEmail");
		session.removeAttribute("UserProfile");
		session.setMaxInactiveInterval(0);
		
		
		response.sendRedirect("/app/main.jsp");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
%>
