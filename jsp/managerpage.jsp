<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
List<User> allUser = new LinkedList<User>();
int allboard= 0;
try(DBConnector con = new DBConnector();){
	UserDao map = con.OpenMap(request, UserDao.class);
	BoardDao map2 = con.OpenMap(request, BoardDao.class);
	BoardDao2 map3 = con.OpenMap(request, BoardDao2.class);
	BoardDao3 map4 = con.OpenMap(request, BoardDao3.class);
	BoardDao4 map5 = con.OpenMap(request, BoardDao4.class);
	allboard  = map2.getBoardInfoAllCnt() + 
			map3.getBoardInfoAllCnt()+
	map4.getBoardInfoAllCnt()+
	map5.getBoardInfoAllCnt();
	 allUser = map.getAllUser();
}catch(Exception e) { e.printStackTrace();}

JSONArray array = new JSONArray();
for(User user : allUser){
	JSONObject targetUser = new JSONObject();
	targetUser.put("userNum",user.getUserNum());
	targetUser.put("userName",user.getUserName()); 
	targetUser.put("userNickName",user.getUserNickname());
	targetUser.put("userId",user.getUserId());
	targetUser.put("userEmail",user.getUserEmail());
	targetUser.put("userJoinDay",user.getUserJoinDay());
	array.put(targetUser);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/resources/myreset.css"> 
<link rel="stylesheet" type="text/css" href="/resources/managerpage.css"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js" defer></script>
<script src="/resources/manager.js" defer></script>
<script>
var users = <%=array.toString()%>;

</script>
</head>
<body>

<%@include file="../jsp/nav.jsp"%>





    <div class="manager-box">
      <h2 class="manager-title">관리자페이지</h2>
      
      <div class="manager-top">
      
        <h3 class="manager-join">회원유동 그래프</h3>
      <div class="chart-btn">
      <button id="btdate">일</button ><button id="btmonth">월</button> <button id="btyear">년</button>
      </div>
        <div class="manager">
        <canvas id="bar-chart"></canvas>
        
        <!-- <canvas id="bar-chart"></canvas> -->
        </div>
      </div>

      <div class="document">
        <ul>
          <li>
            <div class="boardDocs">
              <div class="boards">회원수</div>
              <div class="boards-people"><%=array.length()%>명</div>
            </div>
          </li>
          <li>
            <div class="boardDocs">
              <div class="boards">등록된 게시글 수</div>
              <div class="boards-wrtie"><%=allboard%>개</div>
            </div>
          </li>
        </ul>
      </div>

      <div class="manaber-box">
        <div class="manaber-title">회원관리</div>
        <div id="table-scroll" class="table-scroll">
        
	       <div class="manager222">
	        <table class="manager-membership">
	        
	          <tr>
	            <th>회원넘버</th>
	            <th>닉네임</th>
	            <th>가입날짜</th>
	            <th></th>
	          </tr>
	             <%for (User user : allUser){%>
	             
	          <tr class="manager-tr">
	            <td><%=user.getUserNum()%></td>
	            <td><%=user.getUserNickname()%></td>
	            <td><%=user.getUserJoinDay()%></td>
	            <td><button value="<%=user.getUserNum()%>"  onclick="deleteButtonClickHandler(this)">회원삭제</button></td>
	          </tr>
	          <%}%>	
	          
	        </table> 
	        </div>
	          </div>
        
      </div>
    </div>
    

    
    
    <%@include file="../jsp/footer.jsp"%>
</body>
</html>