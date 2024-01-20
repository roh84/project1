package com.jsp.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
// JSP, Servlet과 관련한 모든 기능은 javax라는 패키지에 포함
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; // request -> 요청
import javax.servlet.http.HttpServletResponse; // response -> 응답
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet; 

// /resources/년/월/일/파일명.jpg

@WebServlet(urlPatterns = {
		"/resources/*",
		"/resource/*"
		}, initParams = {
				@WebInitParam(name="key",value="값")
		})
public class ResourceMapping extends HttpServlet {
	
	   private String defaultPath = "C:\\eclip\\workspace\\JSPB\\src\\main\\webapp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
		resp.setCharacterEncoding("utf-8");
		// text/javascript -> 옛날거
		// application/javascript -> 최신거
		
		
		// getInitParameter("key");
		String info = req.getPathInfo();
		String token = info.substring(info.lastIndexOf('.') + 1);
		if(token.equalsIgnoreCase("js")) {
			resp.setContentType("application/javascript");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resources/" + token + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}	
		}
		else if(token.equalsIgnoreCase("css")) {
			resp.setContentType("text/css");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resources/" + token + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}	
		}
		  else if(token.equalsIgnoreCase("jpeg") || token.equalsIgnoreCase("jpg")) {
		         resp.setContentType("image/jpeg");
		         try(OutputStream out = resp.getOutputStream();){
		            Files.copy(Paths.get(defaultPath + "/WEB-INF/resources/img" + info), out);
		         }catch(Exception e) {}   
		      }
		      else if(token.equalsIgnoreCase("png")) {
		         resp.setContentType("image/png");
		         try(OutputStream out = resp.getOutputStream();){
		            Files.copy(Paths.get(defaultPath + "/WEB-INF/resources/img" + info), out);
		         }catch(Exception e) {}   
		      }
		      else if(token.equalsIgnoreCase("gif")) {
		         resp.setContentType("image/gif");
		         try(OutputStream out = resp.getOutputStream();){
		            Files.copy(Paths.get(defaultPath + "/WEB-INF/resources/img" + info), out);
		         }catch(Exception e) {}   
		      }
			else {
				try(OutputStream out = resp.getOutputStream();
						InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resources/" + "img" + info);){
					out.write(in.readAllBytes());
				}catch(Exception e) {}
			}
		}
		
//		String id = req.getParameter("id");
//		
//		getServletContext(); // Context 정보를 담은 클래스
//		InputStream a = getServletContext().getResourceAsStream("/WEB-INF/resources/js/a.js");
//		
//		resp.setContentType("text/html"); // 내용물의 MIME 정보를 세팅하는 메서드
//		resp.setCharacterEncoding("utf-8");
//		PrintWriter out = resp.getWriter();
//		out.append(new String(a.readAllBytes()));
//		a.close();
//		out.append("<div>"+id+"</div>");
//		out.append("<ol>");
//		for(int i = 0; i < 10; i +=1) {
//			out.append("<li>");
//			out.append(Integer.toString(i));
//			out.append("</li>");
//		}
//		out.append("</ol>");
		
		
		// text/html -> 기본값
//		resp.getWriter().append("<div>내용물</div>");
//		resp.getWriter().append("응답 내용2");
//		resp.getWriter().append("응답 내용3");
//		resp.getWriter().append("응답 내용4");
		
	}




/*
 * package com.jsp.mapping;
 * 
 * import java.io.IOException; import java.io.InputStream; import
 * java.io.OutputStream; import java.io.PrintWriter; import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * import javax.servlet.ServletException; // JSP, Servlet과 관련한 모든 기능은 javax라는
 * 패키지에 포함 import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; // request -> 요청 import
 * javax.servlet.http.HttpServletResponse; // response -> 응답 import
 * javax.servlet.annotation.WebInitParam; import
 * javax.servlet.annotation.WebServlet;
 * 
 * @WebServlet(urlPatterns = { "/resources/*", "/resource/*" }, initParams = {
 * 
 * @WebInitParam(name="key",value="값") }) public class ResourceMapping extends
 * HttpServlet { "C:/javaweb/JSPB/src/main/webapp" private String defaultPath =
 * "D:\\donghyeok\\web\\JSPB\\src\\main\\webapp";
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException { doPost(req,resp); }
 * 
 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * resp.setCharacterEncoding("utf-8"); // text/javascript -> 옛날거 //
 * application/javascript -> 최신거
 * 
 * 
 * // getInitParameter("key"); String info = req.getPathInfo(); String token =
 * info.substring(info.lastIndexOf('.') + 1); if(token.equalsIgnoreCase("js")) {
 * resp.setContentType("application/javascript"); try(OutputStream out =
 * resp.getOutputStream(); InputStream in =
 * getServletContext().getResourceAsStream("/WEB-INF/resources/" + token +
 * info);){ out.write(in.readAllBytes()); }catch(Exception e) {} } else
 * if(token.equalsIgnoreCase("css")) { resp.setContentType("text/css");
 * try(OutputStream out = resp.getOutputStream(); InputStream in =
 * getServletContext().getResourceAsStream("/WEB-INF/resources/" + token +
 * info);){ out.write(in.readAllBytes()); }catch(Exception e) {} } else
 * if(token.equalsIgnoreCase("jpeg") || token.equalsIgnoreCase("jpg")) {
 * resp.setContentType("image/jpeg"); try(OutputStream out =
 * resp.getOutputStream();){ Files.copy(Paths.get(defaultPath +
 * "/WEB-INF/resources/img" + info), out); }catch(Exception e) {} } else
 * if(token.equalsIgnoreCase("png")) { resp.setContentType("image/png");
 * try(OutputStream out = resp.getOutputStream();){
 * Files.copy(Paths.get(defaultPath + "/WEB-INF/resources/img" + info), out);
 * }catch(Exception e) {} } else if(token.equalsIgnoreCase("gif")) {
 * resp.setContentType("image/gif"); try(OutputStream out =
 * resp.getOutputStream();){ Files.copy(Paths.get(defaultPath +
 * "/WEB-INF/resources/img" + info), out); }catch(Exception e) {} }
 * 
 * // String id = req.getParameter("id"); // // getServletContext(); // Context
 * 정보를 담은 클래스 // InputStream a =
 * getServletContext().getResourceAsStream("/WEB-INF/resources/js/a.js"); // //
 * resp.setContentType("text/html"); // 내용물의 MIME 정보를 세팅하는 메서드 //
 * resp.setCharacterEncoding("utf-8"); // PrintWriter out = resp.getWriter(); //
 * out.append(new String(a.readAllBytes())); // a.close(); //
 * out.append("<div>"+id+"</div>"); // out.append("<ol>"); // for(int i = 0; i <
 * 10; i +=1) { // out.append("<li>"); // out.append(Integer.toString(i)); //
 * out.append("</li>"); // } // out.append("</ol>");
 * 
 * 
 * // text/html -> 기본값 // resp.getWriter().append("<div>내용물</div>"); //
 * resp.getWriter().append("응답 내용2"); // resp.getWriter().append("응답 내용3"); //
 * resp.getWriter().append("응답 내용4");
 * 
 * } }
 */
