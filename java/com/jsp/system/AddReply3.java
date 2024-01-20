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

@WebServlet("/api/addReply3")
public class AddReply3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 request.setCharacterEncoding("utf-8");
    	 response.setCharacterEncoding("utf-8");
         response.setContentType("application/json");
    
    	 int boardListNum3 = Integer.parseInt(request.getParameter("boardListNum3"));
         String replyContents3 = request.getParameter("replyContents3");
         String userNickname3 = request.getParameter("userNickname3");
            
         System.out.println(request.getParameter("boardListNum3"));
         System.out.println("111");
         System.out.println(request.getParameter("replyContents3"));
         System.out.println("2222");
         System.out.println(request.getParameter("userNickname3"));
         System.out.println(userNickname3);
         System.out.println("3333");
         
        try (DBConnector con = new DBConnector();) {
            ReplyDao3 rmap = con.OpenMap(request, ReplyDao3.class);
            System.out.println("con 만들기???");
            
           
            // 댓글 등록
           rmap.insertNewReply3(boardListNum3, replyContents3, userNickname3);
           System.out.println(rmap);
           System.out.println("보드에 들어갔나요?");
           System.out.println(boardListNum3);
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