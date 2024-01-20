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

@WebServlet("/api/updateReply4")
public class UpdateReply4 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		int replyNum4 = Integer.parseInt(request.getParameter("replyNum4"));
		String updatedContents4 = request.getParameter("updatedContents4");

		System.out.println(request.getParameter("replyNum4"));
		System.out.println(replyNum4);
		System.out.println(request.getParameter("updatedContents4"));
		System.out.println(updatedContents4);

		try (DBConnector con = new DBConnector();) {
			ReplyDao4 rmap = con.OpenMap(request, ReplyDao4.class);

			// 댓글 수정
			rmap.updateReplyInfo4(updatedContents4, replyNum4);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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
