package com.jsp.dto;


public class BoardInfo {
	// seqBoard
    private int boardListNum; // Primary Key 글쓴 순서대로 1씩 증가
    private String userNickname;
    private String title; // 제목
    private String mainContents; // 본문
    private int hitCount; // 조회수
    private String regDate;  // 게시글 등록일
	private int limit;
    private int page;
    private int pagenum;
    
    
    
	public int getBoardListNum() {
		return boardListNum ;
	}
	public String getTitle() {
		return title;
	}
	public String getMainContents() {
		return mainContents;
	}

	public String getUserNickname() {
		return userNickname;
	}
	public int getLimit() {
		return limit;
	}
	public int getPage() {
		return page;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getHitCount() {
		return hitCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setBoardListNum(int boardListNum) {
		this.boardListNum  = boardListNum ;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMainContents(String mainContents) {
		this.mainContents = mainContents;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}