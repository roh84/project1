package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

@WebServlet("/api/deletePost3")
public class deletePost3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject result = new JSONObject();

        
        try (DBConnector dbConnector = new DBConnector();) {
            int boardListNum3 = Integer.parseInt(request.getParameter("boardListNum3"));
            BoardDao3 map = dbConnector.OpenMap(request, BoardDao3.class);

            // 해당 ID의 게시물을 DB에서 삭제
            map.deleteBoardInfo3(boardListNum3);

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