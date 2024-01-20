package com.jsp.dto;

public class ReplyInfo {
	private int replyNum; // Primary Key 글쓴 순서대로 1씩 증가
	private int boardListNum; // 외래키 
	private String replyContents; // 댓글 내용
	private String userNickname;
	private String regDate;
	   
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getBoardListNum() {
		return boardListNum;
	}
	public void setBoardListNum(int boardListNum) {
		this.boardListNum = boardListNum;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
