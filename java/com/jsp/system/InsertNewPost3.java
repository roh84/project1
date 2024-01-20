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

@WebServlet("/api/newPost3")
public class InsertNewPost3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	
        request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	String userNickname3 = request.getParameter("userNickname3");
    	
        String title3 = request.getParameter("title3");
        String mainContents3 = request.getParameter("mainContents3");

        try (DBConnector con = new DBConnector();){
        	System.out.println("con 만들기");
        	BoardDao3 map = con.OpenMap(request, BoardDao3.class);
            map.insertNewBoard3(userNickname3,title3, mainContents3);
            
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
        	System.out.println(userNickname3);
        }

        response.setContentType("text/plain");
 
    	
        response.sendRedirect("/app/boardlist3.jsp");
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}

