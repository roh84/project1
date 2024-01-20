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

@WebServlet("/api/addReply2")
public class AddReply2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 request.setCharacterEncoding("utf-8");
    	 response.setCharacterEncoding("utf-8");
         response.setContentType("application/json");
    
    	 int boardListNum2 = Integer.parseInt(request.getParameter("boardListNum2"));
         String replyContents2 = request.getParameter("replyContents2");
         String userNickname2 = request.getParameter("userNickname2");
            
         System.out.println(request.getParameter("boardListNum"));
         System.out.println("111");
         System.out.println(request.getParameter("replyContents"));
         System.out.println("2222");
         System.out.println(request.getParameter("userNickname"));
         System.out.println(userNickname2);
         System.out.println("3333");
         
        try (DBConnector con = new DBConnector();) {
            ReplyDao2 rmap = con.OpenMap(request, ReplyDao2.class);
            System.out.println("con 만들기???");
            
           
            // 댓글 등록
           rmap.insertNewReply2(boardListNum2, replyContents2, userNickname2);
           System.out.println(rmap);
           System.out.println("보드에 들어갔나요?");
           System.out.println(boardListNum2);
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