
package com.jsp.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jsp.dao.BoardDao;
import com.jsp.dto.*;

   @WebServlet("/api/boardList")
   public class Boardlist extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
          request.setCharacterEncoding("utf-8");
          response.setCharacterEncoding("utf-8");
          response.setContentType("application/json");
         
          try(DBConnector con = new DBConnector();){
             BoardDao map = con.OpenMap(request, BoardDao.class);
                          
             List<BoardInfo> exec = null;
             
               int page = 1; // 기본값 1로 설정 현재페이지
               int limit = 10; // 페이지당 아이템 수
               int totalItems = map.getBoardInfoAllCnt();
               int totalPages = (int) Math.ceil((double) totalItems / limit);
               System.out.println(request.getParameter("page"));
               if (request.getParameter("page") != null) {
                  page = Integer.parseInt(request.getParameter("page"));
               }


               // 아이템의 시작 위치 계산
                  
             
              if(request.getParameter("searchtype") == null||request.getParameter("searchtype").equalsIgnoreCase("all"))
                 exec = map.getBoardInfoPage(limit, page);
//                 exec = map.getBoardInfoAll();
//              if(request.getParameter("searchtype").equalsIgnoreCase("all"))
//                 exec = map.getBoardInfoPage(limit, page);
              else if(request.getParameter("searchtype").equalsIgnoreCase("userNickname")) {
                 System.out.println("userNickname in");
                 exec = map.searchByUserNicknamePaged("%"+request.getParameter("search")+"%", limit, page);
                 System.out.println(exec);
                 System.out.println("userNickname out");
                 }
             else if(request.getParameter("searchtype").equalsIgnoreCase("title")) {
                System.out.println("title in");
                exec = map.searchByTitlePaged("%"+request.getParameter("search")+"%", limit, page);
                System.out.println(exec);
                System.out.println("title out");
                }
             else {response.sendRedirect("/app/boardlist.jsp");}
             Map<String, Object> result = new HashMap<String, Object>();
                result.put("page", page);
                result.put("totalPages", totalPages);
                result.put("data", exec);
             System.out.println(new JSONObject(result).toString());
             response.getWriter().write(new JSONObject(result).toString());
          }
          catch(Exception e) {}
       }
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         this.doPost(req, resp);
      }
   }

          