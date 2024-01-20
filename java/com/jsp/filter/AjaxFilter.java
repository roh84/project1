package com.jsp.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.json.JSONObject;

import com.jsp.system.Ajax;

public class AjaxFilter implements Filter{
	   
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String result = "";
		// 전처리
		if(request.getContentType() != null) {
			if(request.getContentType().equalsIgnoreCase("application/json")) {
				BufferedReader reader = request.getReader();
				String line;
				while((line = reader.readLine()) != null) {
					result += line;
				}
				JSONObject obj = Ajax.JsonToObj(result);
				request.setAttribute("json", obj);
			}
		}
		if(request.getParameter("password") != null) {
			// 복호화 작업
			String temp = request.getParameter("password");
			temp = temp.replace("+EncodeData", "");
			request.setAttribute("password_decoded", 
					temp);
			
			System.out.println(request.getAttribute("password_decoded"));
		}
		
		System.out.println(result);
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		// 후처리
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
