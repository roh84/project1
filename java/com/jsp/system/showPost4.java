package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

@WebServlet("/api/showPost4")
public class showPost4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");
       
       JSONObject result = new JSONObject();
       int boardListNum4 = Integer.parseInt(request.getParameter("boardListNum4"));
      int hitCount4 = 0;
      if (request.getParameter("hitCount4") != null) {
         hitCount4 = Integer.parseInt(request.getParameter("hitCount4"));
      }
       
       try (DBConnector con = new DBConnector();) {
          HttpSession session4 = request.getSession();
         String sessionKey4 = "postHitCount4_" + boardListNum4;
         Boolean hitCountUpdated4 = (Boolean) session4.getAttribute(sessionKey4);
          BoardDao4 map = con.OpenMap(request, BoardDao4.class);

          if (hitCountUpdated4 == null || !hitCountUpdated4) {
            map.updateHitCount4(hitCount4, boardListNum4);

            session4.setAttribute(sessionKey4, true);
            
         }
          
          BoardInfo4 post4 = map.getBoardInfoById4(boardListNum4);
       

          // 가져온 정보를 JSON 형태로 전송
          result.put("success", true);
          result.put("post4", new JSONObject(post4));         
          result.put("userNickname4", post4.getUserNickname4());
          result.put("title4", post4.getTitle4());
          result.put("mainContents4", post4.getMainContents4());
          
          System.out.println(post4.getUserNickname4());

       } catch (Exception e) {
          e.printStackTrace();
          result.put("success", false);
          result.put("message", "게시글 조회에 실패했습니다.");
       }
//       response.setContentType("text/plain");
       response.setContentType("application/json");
       response.getWriter().write(result.toString());
    }
    @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doGet(req, resp);
   }
}