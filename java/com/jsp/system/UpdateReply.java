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

@WebServlet("/api/updateReply")
public class UpdateReply extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		int replyNum = Integer.parseInt(request.getParameter("replyNum"));
		String updatedContents = request.getParameter("updatedContents");

		System.out.println(request.getParameter("replyNum"));
		System.out.println(replyNum);
		System.out.println(request.getParameter("updatedContents"));
		System.out.println(updatedContents);

		try (DBConnector con = new DBConnector();) {
			ReplyDao rmap = con.OpenMap(request, ReplyDao.class);

			// 댓글 수정
			rmap.updateReplyInfo(updatedContents, replyNum);

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
   