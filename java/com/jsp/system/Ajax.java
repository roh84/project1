package com.jsp.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

public class Ajax {
	public static JSONObject JsonToObj(String json) {
		return new JSONObject(json);
	}
	
	
	//JPA - Java Persistence API
	// MyBatis  
	
	public static String GET(String url) {
		url = "http://localhost:4885" + url;
		String result = "";
		try{
			URL to = new URL(url);
			HttpURLConnection con = (HttpURLConnection)to.openConnection();
			con.setRequestMethod("GET");
			try(BufferedReader file = 
					new BufferedReader(new InputStreamReader(con.getInputStream()));){
				String line;
				while((line = file.readLine()) != null) {
					result += line;
				}
			}
			catch(Exception e) {}
		}catch(Exception e) {}
		return result;
	}
}

   




