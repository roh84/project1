<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page import="java.util.*, org.json.*,java.sql.Timestamp,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<%    
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
try(DBConnector con = new DBConnector();){
	    
	  
	     
		UserDao map = con.OpenMap(request, UserDao.class);
		UserAnimalDao map2 = con.OpenMap(request, UserAnimalDao.class);
		String name= request.getParameter("name");
		String nickname= request.getParameter("nickname");
		String userid= request.getParameter("userid");
		String password= request.getParameter("password");
		String useremail= request.getParameter("useremail");

		Date currentDate = new Date();
	    	Timestamp timestamp = new Timestamp(currentDate.getTime());
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	String dateString = sdf.format(timestamp);
		
		map.joinmember(name,nickname,userid,password,useremail,dateString);
		map2.meberanimal();
		/*   int usernum =(map.getHighestUserNum() + 1);
		  String userNumString = String.valueOf(usernum);
	      session.setAttribute("UserNum",userNumString);
          session.setAttribute("UserNickName",nickname);
          session.setAttribute("UserEmail",useremail);
          session.setMaxInactiveInterval(60 * 30);
		 response.sendRedirect("/app/main.jsp"); */
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("../select/logincheck.jsp");
        dispatcher.forward(request, response);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
%>

