
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

	@WebServlet("/api/boardList3")
	public class Boardlist3 extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    	request.setCharacterEncoding("utf-8");
	    	response.setCharacterEncoding("utf-8");
	    	response.setContentType("application/json");
	   	
	    	try(DBConnector con = new DBConnector();){
	    		BoardDao3 map = con.OpenMap(request, BoardDao3.class);
	    			    		
	    		List<BoardInfo3> exec = null;
	    		
	    		int page3 = 1; // 기본값 1로 설정 현재페이지
	            int limit3 = 10; // 페이지당 아이템 수
	            int totalItems3 = map.getBoardInfoAllCnt3();
	            int totalPages3 = (int) Math.ceil((double) totalItems3 / limit3);
	            System.out.println(request.getParameter("page3"));
	            if (request.getParameter("page3") != null) {
	            	page3 = Integer.parseInt(request.getParameter("page3"));
	            }

	            // 아이템의 시작 위치 계산
	            
	    		
	     		if(request.getParameter("searchtype3") == null||request.getParameter("searchtype3").equalsIgnoreCase("all3"))
	     			exec = map.getBoardInfoPage3(limit3, page3);
 
	     		else if(request.getParameter("searchtype3").equalsIgnoreCase("userNickname3")) {
		     		System.out.println("userNickname3 in");
		     		exec = map.searchByUserNicknamePaged3("%"+request.getParameter("search3")+"%", limit3, page3);
		     		System.out.println(exec);
		     		System.out.println("userNickname3 out");
		     		}
		    	else if(request.getParameter("searchtype3").equalsIgnoreCase("title3")) {
		    		System.out.println("title3 in");
		    		exec = map.searchByTitlePaged3("%"+request.getParameter("search3")+"%", limit3, page3);
		    		System.out.println(request.getParameter("search3"));
		    		System.out.println(exec);
		    		System.out.println("title3 out");
		    		}
		    	else {response.sendRedirect("/app/boardlist3.jsp");}
	    		Map<String, Object> result = new HashMap<String, Object>();
	    			result.put("page3", page3);
	    			result.put("totalPages3", totalPages3);
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

          
