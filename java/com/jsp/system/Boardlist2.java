
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

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

	@WebServlet("/api/boardList2")
	public class Boardlist2 extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    	request.setCharacterEncoding("utf-8");
	    	response.setCharacterEncoding("utf-8");
	    	response.setContentType("application/json");
	   	
	    	try(DBConnector con = new DBConnector();){
	    		BoardDao2 map = con.OpenMap(request, BoardDao2.class);
	    			    		
	    		List<BoardInfo2> exec = null;
	    		
	    		int page2 = 1; // 기본값 1로 설정 현재페이지
	            int limit2 = 10; // 페이지당 아이템 수
	            int totalItems2 = map.getBoardInfoAllCnt2();
	            int totalPages2 = (int) Math.ceil((double) totalItems2 / limit2);
	            System.out.println(request.getParameter("page2"));
	            if (request.getParameter("page2") != null) {
	            	page2 = Integer.parseInt(request.getParameter("page2"));
	            }

	            // 아이템의 시작 위치 계산
	            
	    		
	     		if(request.getParameter("searchtype2") == null||request.getParameter("searchtype2").equalsIgnoreCase("all2"))
	     			exec = map.getBoardInfoPage2(limit2, page2);
//	     			exec = map.getBoardInfoAll();
//	     		if(request.getParameter("searchtype").equalsIgnoreCase("all"))
//	     			exec = map.getBoardInfoPage(limit, page);
	     		else if(request.getParameter("searchtype2").equalsIgnoreCase("userNickname2")) {
		     		System.out.println("userNickname in");
		     		exec = map.searchByUserNicknamePaged2("%"+request.getParameter("search2")+"%", limit2, page2);
		     		System.out.println(exec);
		     		System.out.println("userNickname out");
		     		}
		    	else if(request.getParameter("searchtype2").equalsIgnoreCase("title2")) {
		    		System.out.println("title in");
		    		exec = map.searchByTitlePaged2("%"+request.getParameter("search2")+"%", limit2, page2);
		    		System.out.println(request.getParameter("search2"));
		    		System.out.println(exec);
		    		System.out.println("title out");
		    		}
		    	else {response.sendRedirect("/app/boardlist2.jsp");}
	    		Map<String, Object> result = new HashMap<String, Object>();
	    			result.put("page2", page2);
	    			result.put("totalPages2", totalPages2);
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

          
