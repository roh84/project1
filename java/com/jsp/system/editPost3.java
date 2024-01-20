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

@WebServlet("/api/editPost3")
public class editPost3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");
       int boardListNum3=0;

        try (DBConnector con = new DBConnector();){
           String userNickname3 = request.getParameter("userNickname3");
           
           BoardDao3 map = con.OpenMap(request, BoardDao3.class);
           System.out.println("map이 안되니");

            boardListNum3 = Integer.parseInt(request.getParameter("boardListNum3"));
            String title3 = request.getParameter("title3");
            String mainContents3 = request.getParameter("mainContents3");
           
           map.updateBoardInfo3(title3, mainContents3,boardListNum3);
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
           System.out.println("editPost api 에러");
        }
        
        response.setContentType("text/plain");
        response.sendRedirect("/app/postview.jsp?id="+boardListNum3);
       
       
    }
    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req, resp);
   }
}