package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jsp.dao.BoardDao;
import com.jsp.dto.BoardInfo;

@WebServlet("/api/writerSearch")
public class WriterSearch extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String post = new String();
    	request.setCharacterEncoding("UTF-8");
    	try (DBConnector con = new DBConnector();) {
    		int boardListNum = Integer.parseInt(request.getParameter("boardListNum"));
    		BoardDao map = con.OpenMap(request, BoardDao.class);

    		
    		// 게시물 ID에 해당하는 정보를 DB에서 가져옴 , 메서드는 따로 추가했음
    		post = map.getuserByboardListNum(boardListNum);

    		System.out.println(post + "writerSearch");

    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    	}
       	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	
    	
    	response.getWriter().write(post);
    }
}

   