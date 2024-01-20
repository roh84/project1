package com.jsp.dto;


	public class User {
	    private String userNum; //유저번호
	    private String userName;//유저이름
	    private String userNickName;//유저닉네임
	    private String userId;//유저 아이디
	    private String userPw;//유저페스워드
	    private String userEmail;//유저 이메일
	    private String userProfile;//유저 이미지
	    private String userJoinDay;
	        
		public String getUserNum() {
			return userNum;
		}
		public void setUserNum(String userNum) {
			this.userNum = userNum;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserNickname() {
			return userNickName;
		}
		public void setUserNickname(String userNickname) {
			this.userNickName = userNickname;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPw() {
			return userPw;
		}
		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserImage() {
			return userProfile;
		}
		public void setUserImage(String userImage) {
			this.userProfile = userImage;
		}
		
		public String getUserJoinDay() {
			return userJoinDay;
		}
		public void setUserJoinDay(String userJoinDay) {
			this.userJoinDay = userJoinDay;
		}
		
	
	public String toStringNum() {
		 return this.userNum;
	 }
		
	  public String toStringPW() {
		 return this.userPw;
	 }
  
	  public String toStringNick() {
		  return this.userNickName;
	  }
    public String toStringEmail() {
    	return this.userEmail;
    }
    
    public String toStringProfile() {
    	return this.userProfile;
    }
    
   
    
	}
