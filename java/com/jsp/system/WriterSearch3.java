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

@WebServlet("/api/writerSearch3")
public class WriterSearch3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String post3 = new String();
    	request.setCharacterEncoding("UTF-8");
    	try (DBConnector con = new DBConnector();) {
    		int boardListNum3 = Integer.parseInt(request.getParameter("boardListNum3"));
    		BoardDao3 map = con.OpenMap(request, BoardDao3.class);

    		
    		// 게시물 ID에 해당하는 정보를 DB에서 가져옴 , 메서드는 따로 추가했음
    		post3 = map.getuserByboardListNum3(boardListNum3);

    		System.out.println(post3 + "writerSearch");

    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    	}
       	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	
    	
    	response.getWriter().write(post3);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}



