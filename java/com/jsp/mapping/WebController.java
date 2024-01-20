package com.jsp.mapping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/app/*"
})
public class WebController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		String path = req.getPathInfo().toLowerCase();
		if(path.endsWith(".jsp")) 
			dispatcher = req.getRequestDispatcher("/WEB-INF/jsp" + path);
		else 
			dispatcher = req.getRequestDispatcher("/WEB-INF/jsp" + path + ".jsp");
		dispatcher.forward(req, resp);
	}
}




   





