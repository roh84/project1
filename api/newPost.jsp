
<%-- 이거 작동안함 ㅠㅠ --%>

<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>


<%
    String userNickname = request.getParameter("userNickname");
    String title = request.getParameter("title");
    String mainContents = request.getParameter("mainContents");

    JSONObject result = new JSONObject();
    try (DBConnector con = new DBConnector();){
        
        BoardDao map = con.OpenMap(request, BoardDao.class);

        
        map.insertNewBoard(title, mainContents, userNickname);

        result.put("success", true);
        result.put("message", "게시글이 성공적으로 작성되었습니다.");
    } catch (Exception e) {
        e.printStackTrace();
        result.put("success", false);
        result.put("message", "게시글 작성에 실패했습니다.");
    }

    response.getWriter().write(result.toString());
%>
