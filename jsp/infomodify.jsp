<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.util.*, org.json.*"%>
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="32x32" href="/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/resources/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<link rel="stylesheet" type="text/css" href="/resources/infomodify.css"> 
<script src="/resources/infomodify.js" defer></script>
<title>petpeople</title>

</head>
<body>
<%@include file="../jsp/nav.jsp"%>
	<div class="modify">
        <h2>정보수정</h2>
        <!-- ../api/update/infomodify.jsp -->
            	<%try(DBConnector con = new DBConnector();){
        		UserAnimalDao map = con.OpenMap(request, UserAnimalDao.class);
        		 String usernum = (String)session.getAttribute("UserNum");
        		   String gender = map.getAnimalGender(usernum).toStringPatGender();
        		   UserDao map2 = con.OpenMap(request, UserDao.class);
        		   
        		 %>    
        		               
  <form action="/infomodify" method="post" enctype="multipart/form-data"> 
        <div class="info_modi">
            <div class="user_modi">
                <span class='user'>회원</span>
                <div class="modi_image"><img class='infomodi_img' src="<%=map2.getuserProfile(usernum).toStringProfile()%>" alt=""></div>
                <input  type="file" class='file' name="image">
       <div class="modiWrap">
                   
         <!-- 이름 -->
	     <label for="name"><%=session.getAttribute("UserNickName")%></label>
	     <input id="name" style="display:none" type="text" name="nickname" class="modiBox" placeholder="닉네임" value="<%=session.getAttribute("UserNickName")%>">
	     
         <!-- 이메일 -->
        <label for="email"><%=session.getAttribute("UserEmail")%></label>              
        <input id="email" style="display:none" type="email" name="email" class="modiBox" placeholder="이메일" value="<%=session.getAttribute("UserEmail")%>">
        
       </div>
            </div>                   
            	
        		           
            <div class="pet_modi">
                <span class='pet'>반려동물</span>
                <div class="modi_image"><img class='infomodi_img' src="<%=map.getAnimalProfile(usernum).getAnimalProfile()%>" alt=""></div>
             
                <input type="file" class="file" name="petimage">
                <div class="modiWrap">
                
                <!-- 동물 이름 -->
                <label for="aniname"><%= map.getAnimalName(usernum).toStringPatName()%></label>
                <input id="aniname" style="display:none" type="text" name="petName" class="modiBox" placeholder="이름" value="<%= map.getAnimalName(usernum).toStringPatName()%>">
                        
                <!-- 동물생일 -->
                <label for="date"><%= map.getAnimalBirth(usernum).toStringPatBirth()%></label>      
                <input id="date" style="display:none" type="date" name="birth" class="modiBox" value="<%= map.getAnimalBirth(usernum).toStringPatBirth()%>">
                        
                <label for="gender"><%= map.getAnimalGender(usernum).toStringPatGender()%></label>     
                        <div class="radioBoxWrap" style="display:none">                    
                            <div class="radioBox">
                                <input type="radio" name="gender" id="man" value="수컷" <%= "수컷".equals(gender)? "checked": "" %>>
                                <label for="man">수컷</label>
                            </div>
                            <div class="radioBox">
                                <input type="radio" name="gender" id="woman" value="암컷" <%= "암컷".equals(gender)? "checked": "" %>>
                                <label for="woman">암컷</label>
                            </div>
                            <div class="radioBox">
                                <input type="radio" name="gender" id="neu" value="중성" <%= "중성".equals(gender)? "checked": "" %>>
                                <label for="neu">중성</label>
                            </div>
                        </div>
                   <!--  몸무게  -->   
                   <label for="weight"><%=map.getAnimalWeight(usernum).toStringPatWeight()%></label> 
                   <input id="weight" style="display:none" type="text" name="weight" class="modiBox" placeholder="몸무게" value="<%=map.getAnimalWeight(usernum).toStringPatWeight()%>">
                </div>   
            </div>
        </div>
        <input type="submit" value="제출" class="modi_submit">
         </form>
         <form action="../api/delet/withdrawal.jsp">
	        <input type="submit" value="회원탈퇴" class="withdraw">
         </form>
    </div>
    <script>
  			document.getElementById('date').value = new Date().toISOString().substring(0, 10); 
</script>
    	<%
}
            	
        	catch(Exception e) {
        		e.printStackTrace();
        	} 
        	%>
            
    
<%@include file="../jsp/footer.jsp"%>

</body>
</html>
</html>