package com.jsp.system;

import java.io.IOException;
import java.util.Collection;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.dao.UserAnimalDao;
import com.jsp.dao.UserDao;
import com.jsp.dto.*;

@WebServlet(urlPatterns = {
	"/infomodify/*"
})
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 5,
	maxFileSize = 1024 * 1024 * 100,
	maxRequestSize = 1024 * 1024 * 500
)
public class Infomodify extends HttpServlet{
	
	
	   private static final long serialVersionUID = 1L;
	   
	   @Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);
		}
	   @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)    
	            throws ServletException, IOException {
		   HttpSession session = request.getSession(true);
		 //인코딩으로 글자 안깨지게  
		   request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/plain;charset=UTF-8");
			  try(DBConnector con = new DBConnector();){
				  
				  response.getWriter().write("1");
						UserDao map = con.OpenMap(request, UserDao.class);
						
						UserAnimalDao map2 =con.OpenMap(request, UserAnimalDao.class);
   
						   
					     String usernum = (String)session.getAttribute("UserNum");			    
					   //유저 닉네임 이메일 수정
					   
					   String nickname = request.getParameter("nickname");
					   String email = request.getParameter("email");
					   response.getWriter().write("2");
					 
					    map.udtNickname(usernum, nickname);
					    map.udtemail(usernum,email);
					    response.getWriter().write("3");
					   //동물 수정 이름 생일 성별 무게
					   String petName = request.getParameter("petName");
					   String birth = request.getParameter("birth");
					   String gender = request.getParameter("gender");
					   String weight = request.getParameter("weight");
					   //db업데이트
					   response.getWriter().write("4");
					   map2.aniname(usernum, petName);
					   map2.anibirth(usernum, birth);
					   map2.anigender(usernum, gender); 
					   map2.aniweight(usernum, weight);
					   response.getWriter().write("5");
					   
						//이미지가 있으면
					   
    if(request.getPart("image").getSize() > 0 || request.getPart("petimage").getSize() > 0 ) {
    	
    	       response.getWriter().write("6");
    	         System.out.println("우저이미지");
						if(request.getPart("image") != null && request.getPart("image").getSize() > 0){
						
							Part imagePart = request.getPart("image"); // 유저 profile
							//사용자가 업로드한 이미지 이름 담고 
							   String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString(); 
							    // 파일 이름에서 확장자 추출
							    String fileExtension = "";
							    int lastDotIndex = fileName.lastIndexOf('.');
							    if (lastDotIndex != -1) {
							        fileExtension = fileName.substring(lastDotIndex + 1);
							    }
							//랜덤이름 생성
							String random4 =RandomStringGenerator.generateRandomString(4);  
							//저장할 랜덤이름.확장자 리퀘스트 저장
							request.setAttribute("userprofile","userprofile/"+random4+"."+fileExtension);
							//유저 먼저 경로를 db에 저장
							map.udtprofile(usernum ,"/resources/userprofile/"+random4 +"."+fileExtension);
						}
						
						if(request.getPart("petimage") != null && request.getPart("petimage").getSize() > 0){
	
							Part petimage = request.getPart("petimage");// 유저의 동물 profiles
							//사용자가 업로드한 이미지 이름 담고 
							   String fileName = Paths.get(petimage.getSubmittedFileName()).getFileName().toString(); 
							    // 파일 이름에서 확장자 추출
							    String fileExtension = "";
							    int lastDotIndex = fileName.lastIndexOf('.');
							    if (lastDotIndex != -1) {
							        fileExtension = fileName.substring(lastDotIndex + 1);
							    }
							
							String random4 =RandomStringGenerator.generateRandomString(4);
							request.setAttribute("animalprofile","animalprofile/"+random4+"."+fileExtension);
							map2.aniprofile(usernum, "/resources/animalprofile/"+random4+"."+fileExtension);
						}
					        // 모든 처리끝나고 db에 저장했으면 실제로 이미지 저장은 다른 서블릿으로 ㄱㄱ 
						
					        RequestDispatcher dispatcher = request.getRequestDispatcher("/upload");
					        dispatcher.forward(request, response);
						  } 
    
				  //수정된 정보 세션에 다시 주입
    			  //db는 바꼈지만 웹세션은 값이라 실시간 x
					session.setAttribute("UserNickName",nickname);
					session.setAttribute("UserEmail",email);
					session.setMaxInactiveInterval(60 * 30);	    		
					response.sendRedirect("/app/mypage.jsp");
    
			  }catch(Exception e) {
						response.getWriter().write("이미지 있고 택스트 업데이트 처리하는 오류");
					}
			    
			} 
	   
	 
       }
	   








