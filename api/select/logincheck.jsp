<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>



<%            
     try(DBConnector con = new DBConnector();){
      if( ! request.getMethod().equalsIgnoreCase("GET")) throw new Exception();      
      UserDao map = con.OpenMap(request, UserDao.class);
      
      String userid = request.getParameter("userid");                         
      String nopassword = request.getParameter("password");
      
if(userid != null){   
   
      if(map.getuserpw(userid)!=null){         
            String realpassword=map.getuserpw(userid).toStringPW();      
          if(nopassword.equals(realpassword)){
             //로그인성공
             String loginError = (String) session.getAttribute("loginError");
             if(loginError !=null){
             session.removeAttribute("loginError");
             }
                String UserNum = map.getuserNum(userid).toStringNum();
                String UserNickName = map.getuserNickName(userid).toStringNick();
                String UserEmail = map.getuserEmail(userid).toStringEmail();
                /* String UserProfile = map.getuserProfile(userid).toStringProfile(); */
                //세션에 유저 번호,닉네임 저장
                session.setAttribute("UserNum",UserNum);
                session.setAttribute("UserNickName",UserNickName);
                session.setAttribute("UserEmail",UserEmail);
                session.setMaxInactiveInterval(60 * 30);
                response.sendRedirect("/app/main.jsp");
           }else{ 
               session.setAttribute("loginError","매치하는 비밀번호x");
               response.sendRedirect("/app/login.jsp");
               }      
	      }else{
	         session.setAttribute("loginError", "비밀번호에 맞는 아이디 x"); 
	         response.sendRedirect("/app/login.jsp");
	      }
	}else{
	session.setAttribute("loginError","아이디를 잘못입력");
	response.sendRedirect("/app/login.jsp");
        }   
        } 

   catch(Exception e) {
      response.getWriter().write("오류오류0");
      
      /* session.setMaxInactiveInterval(0);
      response.sendRedirect("/app/home.jsp"); */
   }
%>