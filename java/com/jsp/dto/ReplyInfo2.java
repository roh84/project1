package com.jsp.dto;

public class ReplyInfo2 {
	
	private int replyNum2; // Primary Key 글쓴 순서대로 1씩 증가
	private int boardListNum2; // 외래키 
	private String replyContents2; // 댓글 내용
	private String userNickname2;
	private String regDate2;
	
	
	public int getReplyNum2() {
		return replyNum2;
	}
	public void setReplyNum2(int replyNum2) {
		this.replyNum2 = replyNum2;
	}
	public int getBoardListNum2() {
		return boardListNum2;
	}
	public void setBoardListNum2(int boardListNum2) {
		this.boardListNum2 = boardListNum2;
	}
	public String getReplyContents2() {
		return replyContents2;
	}
	public void setReplyContents2(String replyContents2) {
		this.replyContents2 = replyContents2;
	}
	public String getUserNickname2() {
		return userNickname2;
	}
	public void setUserNickname2(String userNickname2) {
		this.userNickname2 = userNickname2;
	}
	public String getRegDate2() {
		return regDate2;
	}
	public void setRegDate2(String regDate2) {
		this.regDate2 = regDate2;
	}


}
