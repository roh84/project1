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

@WebServlet("/api/newPost2")
public class InsertNewPost2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	
        request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	String userNickname2 = request.getParameter("userNickname2");
    	
        String title2 = request.getParameter("title2");
        String mainContents2 = request.getParameter("mainContents2");

        try (DBConnector con = new DBConnector();){
        	System.out.println("con 만들기");
        	BoardDao2 map = con.OpenMap(request, BoardDao2.class);
            map.insertNewBoard2(userNickname2,title2, mainContents2);
            
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
        	System.out.println(userNickname2);
        }

        response.setContentType("text/plain");
 
    	
        response.sendRedirect("/app/boardlist2.jsp");
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}

