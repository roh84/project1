package com.jsp.dto;

public class ReplyInfo3 {

	private int replyNum3; // Primary Key 글쓴 순서대로 1씩 증가
	private int boardListNum3; // 외래키 
	private String replyContents3; // 댓글 내용
	private String userNickname3;
	private String regDate3;
	
	public int getReplyNum3() {
		return replyNum3;
	}
	public void setReplyNum3(int replyNum3) {
		this.replyNum3 = replyNum3;
	}
	public int getBoardListNum3() {
		return boardListNum3;
	}
	public void setBoardListNum3(int boardListNum3) {
		this.boardListNum3 = boardListNum3;
	}
	public String getReplyContents3() {
		return replyContents3;
	}
	public void setReplyContents3(String replyContents3) {
		this.replyContents3 = replyContents3;
	}
	public String getUserNickname3() {
		return userNickname3;
	}
	public void setUserNickname3(String userNickname3) {
		this.userNickname3 = userNickname3;
	}
	public String getRegDate3() {
		return regDate3;
	}
	public void setRegDate3(String regDate3) {
		this.regDate3 = regDate3;
	}

	
}
