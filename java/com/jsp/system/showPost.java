package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;

import com.jsp.dao.BoardDao;
import com.jsp.dto.BoardInfo;

@WebServlet("/api/showPost")
public class showPost extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");

      JSONObject result = new JSONObject();
      int boardListNum = Integer.parseInt(request.getParameter("boardListNum"));
      int hitCount = 0;
      if (request.getParameter("hitCount") != null) {
         hitCount = Integer.parseInt(request.getParameter("hitCount"));
      }

      try (DBConnector con = new DBConnector();) {

         HttpSession session = request.getSession();
         String sessionKey = "postHitCount_" + boardListNum;
         Boolean hitCountUpdated = (Boolean) session.getAttribute(sessionKey);
         BoardDao map = con.OpenMap(request, BoardDao.class);

         if (hitCountUpdated == null || !hitCountUpdated) {
            map.updateHitCount(hitCount, boardListNum);

            // 조회수가 업데이트되었음을 세션에 표시
            session.setAttribute(sessionKey, true);
         }

         BoardInfo post = map.getBoardInfoById(boardListNum);

         // 가져온 정보를 JSON 형태로 전송
         result.put("success", true);
         result.put("post", new JSONObject(post));
         result.put("userNickname", post.getUserNickname());
         result.put("title", post.getTitle());
         result.put("mainContents", post.getMainContents());

      } catch (Exception e) {
         e.printStackTrace();
         result.put("success", false);
         result.put("message", "게시글 조회에 실패했습니다.");
      }
//       response.setContentType("text/plain");
      response.setContentType("application/json");
      response.getWriter().write(result.toString());
   }
}