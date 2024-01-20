<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>



<%            
		
	  try(DBConnector con = new DBConnector();){
		if( ! request.getMethod().equalsIgnoreCase("GET")) throw new Exception();		
		UserDao map = con.OpenMap(request, UserDao.class);
		UserAnimal map2 =con.OpenMap(request, UserAnimal.class);
		request.getParameter("");
	     String usernum = (String)session.getAttribute("usernum");
		
	
		  } 
	catch(Exception e) {
		response.getWriter().write("오류오류0");
		
		/* session.setMaxInactiveInterval(0);
		response.sendRedirect("/app/home.jsp"); */
	}
%>