package com.jsp.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jsp.dao.*;
import com.jsp.dto.*;
import com.jsp.system.DBConnector;

@WebServlet("/api/writerSearch4")
public class WriterSearch4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String post4 = new String();
    	request.setCharacterEncoding("UTF-8");
    	try (DBConnector con = new DBConnector();) {
    		int boardListNum4 = Integer.parseInt(request.getParameter("boardListNum4"));
    		BoardDao4 map = con.OpenMap(request, BoardDao4.class);

    		
    		// 게시물 ID에 해당하는 정보를 DB에서 가져옴 , 메서드는 따로 추가했음
    		post4 = map.getuserByboardListNum4(boardListNum4);

    		System.out.println(post4 + "writerSearch");

    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    	}
       	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	
    	
    	response.getWriter().write(post4);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}



