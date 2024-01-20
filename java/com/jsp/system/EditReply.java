//수정

package com.jsp.system;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.jsp.dao.ReplyDao;
import com.jsp.dto.ReplyInfo;

@WebServlet("/api/editReply")
public class EditReply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    	

  	    int replyNum = Integer.parseInt(request.getParameter("replyNum"));
        String replyContents = request.getParameter("replyContents");

        try (DBConnector con = new DBConnector()) {        
        	ReplyDao map = con.OpenMap(request, ReplyDao.class);

            // 댓글 수정
            map.updateReplyInfo(replyContents, replyNum);

            // 성공 여부를 JSON으로 응답
//            response.setContentType("application/json");
//            response.getWriter().write("{\"success\": true}");
        } catch (Exception e) {
            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
	response.sendRedirect("/WEB-INF/jsp/postview.jsp");
    }
}
   