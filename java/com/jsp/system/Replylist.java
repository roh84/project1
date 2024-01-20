//댓글보기
package com.jsp.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;

import com.jsp.dao.BoardDao;
import com.jsp.dao.ReplyDao;
import com.jsp.dto.BoardInfo;
import com.jsp.dto.ReplyInfo;

@WebServlet("/api/replylist")
public class Replylist extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setCharacterEncoding("utf-8");
     response.setContentType("application/json");

             try (DBConnector con = new DBConnector();) {
                 ReplyDao map = con.OpenMap(request, ReplyDao.class);

                 List<ReplyInfo> replyList = null;
                 int boardListNum = Integer.parseInt(request.getParameter("boardListNum"));
                 System.out.println(boardListNum);
                 if (boardListNum > 0) {
                     replyList = map.searchByBoardListNum(boardListNum);               
                 }
                 // 댓글 목록을 JSON 형식으로 변환
                 JSONObject jsonResponse = new JSONObject();
                 jsonResponse.put("replyList", replyList);
                 jsonResponse.put("success", true);
                 // JSON 응답 전송
                 response.getWriter().write(jsonResponse.toString());                 
                 System.out.println(replyList);                 

             } catch (Exception e) {
                 e.printStackTrace();
                 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
             }
         }

         @Override
         protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             this.doPost(req, resp);
         }
     }
   
        


