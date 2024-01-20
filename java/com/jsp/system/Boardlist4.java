
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

	@WebServlet("/api/boardList4")
	public class Boardlist4 extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    	request.setCharacterEncoding("utf-8");
	    	response.setCharacterEncoding("utf-8");
	    	response.setContentType("application/json");
	   	
	    	try(DBConnector con = new DBConnector();){
	    		BoardDao4 map = con.OpenMap(request, BoardDao4.class);
	    			    		
	    		List<BoardInfo4> exec = null;
	    		
	    		int page4 = 1; // 기본값 1로 설정 현재페이지
	            int limit4 = 10; // 페이지당 아이템 수
	            int totalItems4 = map.getBoardInfoAllCnt4();
	            int totalPages4 = (int) Math.ceil((double) totalItems4 / limit4);
	            System.out.println(request.getParameter("page4"));
	            if (request.getParameter("page4") != null) {
	            	page4 = Integer.parseInt(request.getParameter("page4"));
	            }

	            // 아이템의 시작 위치 계산
	            
	    		
	     		if(request.getParameter("searchtype4") == null||request.getParameter("searchtype4").equalsIgnoreCase("all4"))
	     			exec = map.getBoardInfoPage4(limit4, page4);
//	     			exec = map.getBoardInfoAll();
//	     		if(request.getParameter("searchtype").equalsIgnoreCase("all"))
//	     			exec = map.getBoardInfoPage(limit, page);
	     		else if(request.getParameter("searchtype4").equalsIgnoreCase("userNickname4")) {
		     		System.out.println("userNickname in");
		     		exec = map.searchByUserNicknamePaged4("%"+request.getParameter("search4")+"%", limit4, page4);
		     		System.out.println(exec);
		     		System.out.println("userNickname out");
		     		}
		    	else if(request.getParameter("searchtype4").equalsIgnoreCase("title4")) {
		    		System.out.println("title in");
		    		exec = map.searchByTitlePaged4("%"+request.getParameter("search4")+"%", limit4, page4);
		    		System.out.println(request.getParameter("search4"));
		    		System.out.println(exec);
		    		System.out.println("title out");
		    		}
		    	else {response.sendRedirect("/app/boardlist4.jsp");}
	    		Map<String, Object> result = new HashMap<String, Object>();
	    			result.put("page4", page4);
	    			result.put("totalPages4", totalPages4);
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

          
