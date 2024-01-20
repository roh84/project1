<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>


   
<%
	try(DBConnector con = new DBConnector();){
		UserDao map = con.OpenMap(request, UserDao.class);
		System.out.println(map.hashCode());
		System.out.println(map.getuseridAll());	
		//null값처리
		List<User> userid = new ArrayList<>();
		for (User id : map.getuseridAll()) {
		    if (id != null) {
		        userid.add(id);
		    }
		}
		System.out.println("Hello");
		//null값처리
		List<User> usernickname = new ArrayList<>();
		for (User nick : map.getuserNicknameAll()) {
		    if (nick != null) {
		    	usernickname.add(nick);
		    }
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("userids", userid);
		result.put("userNicknames", usernickname);
		response.getWriter().write(new JSONObject(result).toString());
	}
	catch(Exception e) {
		//e.printStackTrace();
	}
%>
