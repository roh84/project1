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

@WebServlet("/api/deleteReply")
public class DeleteReply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");		
    	
    	
    	JSONObject result = new JSONObject();
    	  
    	try (DBConnector con = new DBConnector();) {
    		int replyNum = Integer.parseInt(request.getParameter("replyNum"));
            ReplyDao rmap = con.OpenMap(request, ReplyDao.class);


            // 댓글 삭제
            rmap.deleteReplyInfo(replyNum);
            result.put("success", true);
            result.put("message", "게시글 삭제 성공");
           
        } catch (Exception e) {
        	 e.printStackTrace();
             result.put("success", false);
             result.put("message", "게시글 삭제 실패");
        }
    	 response.getWriter().write(result.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
   