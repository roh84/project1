package com.jsp.dto;

public class ReplyInfo4 {
	
	private int replyNum4; // Primary Key 글쓴 순서대로 1씩 증가
	private int boardListNum4; // 외래키 
	private String replyContents4; // 댓글 내용
	private String userNickname4;
	private String regDate4;
	
	public int getReplyNum4() {
		return replyNum4;
	}
	public void setReplyNum4(int replyNum4) {
		this.replyNum4 = replyNum4;
	}
	public int getBoardListNum4() {
		return boardListNum4;
	}
	public void setBoardListNum4(int boardListNum4) {
		this.boardListNum4 = boardListNum4;
	}
	public String getReplyContents4() {
		return replyContents4;
	}
	public void setReplyContents4(String replyContents4) {
		this.replyContents4 = replyContents4;
	}
	public String getUserNickname4() {
		return userNickname4;
	}
	public void setUserNickname4(String userNickname4) {
		this.userNickname4 = userNickname4;
	}
	public String getRegDate4() {
		return regDate4;
	}
	public void setRegDate4(String regDate4) {
		this.regDate4 = regDate4;
	}

}
