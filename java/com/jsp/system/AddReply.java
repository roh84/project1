//등록
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

@WebServlet("/api/addReply")
public class AddReply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 request.setCharacterEncoding("utf-8");
    	 response.setCharacterEncoding("utf-8");
         response.setContentType("application/json");
    
    	 int boardListNum = Integer.parseInt(request.getParameter("boardListNum"));
         String replyContents = request.getParameter("replyContents");
         String userNickname = request.getParameter("userNickname");
            
         System.out.println(request.getParameter("boardListNum"));
         System.out.println("111");
         System.out.println(request.getParameter("replyContents"));
         System.out.println("2222");
         System.out.println(request.getParameter("userNickname"));
         System.out.println(userNickname);
         System.out.println("3333");
         
        try (DBConnector con = new DBConnector();) {
            ReplyDao rmap = con.OpenMap(request, ReplyDao.class);
            System.out.println("con 만들기???");
            
              
            // 댓글 등록
           rmap.insertNewReply(boardListNum, replyContents, userNickname);
           System.out.println(rmap);
           System.out.println("보드에 들어갔나요?");
           System.out.println(boardListNum);
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