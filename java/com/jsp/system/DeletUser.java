

package com.jsp.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.jsp.dao.*;
import com.jsp.dto.UserNoteSee;

@WebServlet("/DeletUser/*")
public class DeletUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		this.doPost(request, response);
    } 
    @Override
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
    		throws ServletException, IOException {
    	   req.setCharacterEncoding("UTF-8");
    	   resp.setCharacterEncoding("UTF-8");
    	   resp.setContentType("application/json");
    	 try (DBConnector con = new DBConnector();) {
    		 UserDao map = con.OpenMap(req, UserDao.class);
    			UserAnimalDao map2 = con.OpenMap(req, UserAnimalDao.class);
    		 
    		 String buttonValue = req.getParameter("buttonValue");
    		 System.out.println(buttonValue);
    		 map.deleteUser(buttonValue);
    		 map2.deleteUserAnimal(buttonValue);
    		 
    	 }
    
}
}