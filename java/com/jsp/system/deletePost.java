package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jsp.dao.BoardDao;

@WebServlet("/api/deletePost")
public class deletePost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject result = new JSONObject();
        	
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        try (DBConnector dbConnector = new DBConnector();) {
            int boardListNum = Integer.parseInt(request.getParameter("boardListNum"));
            BoardDao map = dbConnector.OpenMap(request, BoardDao.class);

            // 해당 ID의 게시물을 DB에서 삭제
            map.deleteBoardInfo(boardListNum);

            result.put("success", true);
            result.put("message", "게시글 삭제 성공");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "게시글 삭제 실패");
        }

        
        response.getWriter().write(result.toString());
    }
}  