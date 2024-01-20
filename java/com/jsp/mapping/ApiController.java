package com.jsp.mapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import com.jsp.system.DBConnector;

@WebServlet(urlPatterns = {
		"/api/*"
})
public class ApiController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    
		
		RequestDispatcher dispatcher = null;
		String path = req.getPathInfo().toLowerCase();
		if(path.endsWith(".jsp")) 
			dispatcher = req.getRequestDispatcher("/WEB-INF/api" + path);
		else 
			dispatcher = req.getRequestDispatcher("/WEB-INF/api" + path + ".jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}











