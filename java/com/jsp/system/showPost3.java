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

@WebServlet("/api/showPost3")
public class showPost3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");
       
       JSONObject result = new JSONObject();
       int boardListNum3 = Integer.parseInt(request.getParameter("boardListNum3"));
      int hitCount3 = 0;
      if (request.getParameter("hitCount3") != null) {
         hitCount3 = Integer.parseInt(request.getParameter("hitCount3"));
      }
       
       try (DBConnector con = new DBConnector();) {
          HttpSession session3 = request.getSession();
         String sessionKey3 = "postHitCount3_" + boardListNum3;
         Boolean hitCountUpdated3 = (Boolean) session3.getAttribute(sessionKey3);
          BoardDao3 map = con.OpenMap(request, BoardDao3.class);

          if (hitCountUpdated3 == null || !hitCountUpdated3) {
            map.updateHitCount3(hitCount3, boardListNum3);

            session3.setAttribute(sessionKey3, true);
            
         }
          
          BoardInfo3 post3 = map.getBoardInfoById3(boardListNum3);
       

          // 가져온 정보를 JSON 형태로 전송
          result.put("success", true);
          result.put("post3", new JSONObject(post3));         
          result.put("userNickname3", post3.getUserNickname3());
          result.put("title3", post3.getTitle3());
          result.put("mainContents3", post3.getMainContents3());
          
          System.out.println(post3.getUserNickname3());

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