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

@WebServlet("/api/replylist2")
public class Replylist2 extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setCharacterEncoding("utf-8");
     response.setContentType("application/json");

             try (DBConnector con = new DBConnector();) {
                 ReplyDao2 map = con.OpenMap(request, ReplyDao2.class);

                 List<ReplyInfo2> replyList2 = null;
                 int boardListNum2 = Integer.parseInt(request.getParameter("boardListNum2"));
                 System.out.println(boardListNum2);
                 if (boardListNum2 > 0) {
                     replyList2 = map.searchByBoardListNum2(boardListNum2);               
                 }
                 // 댓글 목록을 JSON 형식으로 변환
                 JSONObject jsonResponse = new JSONObject();
                 jsonResponse.put("replyList2", replyList2);
                 jsonResponse.put("success", true);
                 // JSON 응답 전송
                 response.getWriter().write(jsonResponse.toString());                 
                 System.out.println(replyList2);                 

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
   
     


