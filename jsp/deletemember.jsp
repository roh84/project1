<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>   
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="32x32" href="/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/resources/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<title>petpeople</title>
<style>
		.wrap{
	        height:50vh;     
	        padding:auto;
			
		}
        .title{
            text-align: center;
            padding: 2rem 0;
            margin-top:20rem;
         }

        .deleteWrap{
        text-align: center;
      
        }
    </style>
    <script type="text/javascript">         
    	function checkvalue(){
    		if(!document.deletemember.password.value){
    			alert("비밀번호를 입력하지않았습니다.");
    			return false;
    		}
    }  
    </script>

</head>
<body>
<%@include file="./nav.jsp"%>
	<div class='wrap'>
	    <h2 class='title'>회원탈퇴</h2>
	    <form name = 'deletemember' method='post' action="" onsubmit="return checkValue()">
	        <div class="deleteWrap">
	            <span>비밀번호확인</span>
	            <input type="password" name="password" class="passwordCheck" placeholder="비밀번호 입력" >
	            <input type="submit" value='탈퇴' /> 

	        </div>
	    </form>
	</div>
<%@include file="./footer.jsp"%>
    
</body>
</html>