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

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

@WebServlet("/api/replylist3")
public class Replylist3 extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setCharacterEncoding("utf-8");
     response.setContentType("application/json");

             try (DBConnector con = new DBConnector();) {
                 ReplyDao3 map = con.OpenMap(request, ReplyDao3.class);

                 List<ReplyInfo3> replyList3 = null;
                 int boardListNum3 = Integer.parseInt(request.getParameter("boardListNum3"));
                 System.out.println(boardListNum3);
                 if (boardListNum3 > 0) {
                     replyList3 = map.searchByBoardListNum3(boardListNum3);               
                 }
                 // 댓글 목록을 JSON 형식으로 변환
                 JSONObject jsonResponse = new JSONObject();
                 jsonResponse.put("replyList3", replyList3);
                 jsonResponse.put("success", true);
                 // JSON 응답 전송
                 response.getWriter().write(jsonResponse.toString());                 
                 System.out.println(replyList3);                 

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
   
     


