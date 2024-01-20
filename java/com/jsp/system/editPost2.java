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

@WebServlet("/api/editPost2")
public class editPost2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");
       int boardListNum2=0;

        try (DBConnector con = new DBConnector();){
           String userNickname2 = request.getParameter("userNickname2");
           
           BoardDao2 map = con.OpenMap(request, BoardDao2.class);
           System.out.println("map이 안되니");

            boardListNum2 = Integer.parseInt(request.getParameter("boardListNum2"));
            String title2 = request.getParameter("title2");
            String mainContents2 = request.getParameter("mainContents2");
           
           map.updateBoardInfo2(title2, mainContents2,boardListNum2);
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
           System.out.println("editPost api 에러");
        }
        
        response.setContentType("text/plain");
        response.sendRedirect("/app/postview.jsp?id="+boardListNum2);
       
       
    }
    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req, resp);
   }
}