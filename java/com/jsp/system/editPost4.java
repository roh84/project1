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

@WebServlet("/api/editPost4")
public class editPost4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");
       int boardListNum4=0;

        try (DBConnector con = new DBConnector();){
           String userNickname4 = request.getParameter("userNickname4");
           
           BoardDao4 map = con.OpenMap(request, BoardDao4.class);
           System.out.println("map이 안되니");

            boardListNum4 = Integer.parseInt(request.getParameter("boardListNum4"));
            String title4 = request.getParameter("title4");
            String mainContents4 = request.getParameter("mainContents4");
           
           map.updateBoardInfo4(title4, mainContents4,boardListNum4);
            System.out.println("보드에 들어갔나요?");
        } catch(Exception e) {
           System.out.println("editPost api 에러");
        }
        
        response.setContentType("text/plain");
        response.sendRedirect("/app/postview.jsp?id="+boardListNum4);

       
    }
    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req, resp);
   }
}
