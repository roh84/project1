//여기가 아닌거 같은데...

package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

@WebServlet("/api/newPost4")
public class InsertNewPost4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	
        request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	String userNickname4 = request.getParameter("userNickname4");
    	
        String title4 = request.getParameter("title4");
        String mainContents4 = request.getParameter("mainContents4");

        try (DBConnector con = new DBConnector();){
        	System.out.println("con 만들기");
        	BoardDao4 map = con.OpenMap(request, BoardDao4.class);
            map.insertNewBoard4(userNickname4,title4, mainContents4);
            
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
        	System.out.println(userNickname4);
        }

        response.setContentType("text/plain");
 
    	
        response.sendRedirect("/app/boardlist4.jsp");
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}

