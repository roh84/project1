package com.jsp.system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

@WebServlet("/api/addReply4")
public class AddReply4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 request.setCharacterEncoding("utf-8");
    	 response.setCharacterEncoding("utf-8");
         response.setContentType("application/json");
    
    	 int boardListNum4 = Integer.parseInt(request.getParameter("boardListNum4"));
         String replyContents4 = request.getParameter("replyContents4");
         String userNickname4 = request.getParameter("userNickname4");
            
         System.out.println(request.getParameter("boardListNum"));
         System.out.println("111");
         System.out.println(request.getParameter("replyContents"));
         System.out.println("2222");
         System.out.println(request.getParameter("userNickname"));
         System.out.println(userNickname4);
         System.out.println("3333");
         
        try (DBConnector con = new DBConnector();) {
            ReplyDao4 rmap = con.OpenMap(request, ReplyDao4.class);
            System.out.println("con 만들기???");
            
           
            // 댓글 등록
           rmap.insertNewReply4(boardListNum4, replyContents4, userNickname4);
           System.out.println(rmap);
           System.out.println("보드에 들어갔나요?");
           System.out.println(boardListNum4);
        } catch (Exception e) {
           System.out.println("에러캐치");
        }
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("success", true);
        response.getWriter().write(jsonResponse.toString());  
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}