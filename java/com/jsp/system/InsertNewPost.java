//여기가 아닌거 같은데...

package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jsp.dao.BoardDao;

@WebServlet("/api/newPost")
public class InsertNewPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    	
    	
    	String userNickname = request.getParameter("userNickname");
    
        String title = request.getParameter("title");
        String mainContents = request.getParameter("mainContents");

        try (DBConnector con = new DBConnector();){
        	System.out.println("con 만들기");
        	BoardDao map = con.OpenMap(request, BoardDao.class);
            map.insertNewBoard(userNickname ,title, mainContents);
            
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
        	System.out.println(userNickname);
        }

        response.setContentType("text/plain");
    
    	
        response.sendRedirect("/app/boardList.jsp");
    }
}

