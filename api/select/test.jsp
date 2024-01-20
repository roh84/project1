<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>


   
<%
  try(DBConnector con = new DBConnector();){
	UserDao map = con.OpenMap(request, UserDao.class);
	
		 
		 User realpassword=map.getuserpw("qlqlql");		
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("testapi", realpassword);
		
		response.getWriter().write(new JSONObject(result).toString());
	}
	catch(Exception e) {
		response.getWriter().write("오류다힝");
	}
%>