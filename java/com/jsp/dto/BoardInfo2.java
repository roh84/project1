package com.jsp.dto;

public class BoardInfo2 {
	
	private int boardListNum2; // Primary Key 글쓴 순서대로 1씩 증가
    private String userNickname2;
    private String title2; // 제목
    private String mainContents2; // 본문
    private int hitCount2; // 조회수
    private String regDate2;  // 게시글 등록일
	private int limit2;
    private int page2;
    private int pagenum2;
    
    
    public int getBoardListNum2() {
		return boardListNum2;
	}
	public void setBoardListNum2(int boardListNum2) {
		this.boardListNum2 = boardListNum2;
	}
	public String getUserNickname2() {
		return userNickname2;
	}
	public void setUserNickname2(String userNickname2) {
		this.userNickname2 = userNickname2;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getMainContents2() {
		return mainContents2;
	}
	public void setMainContents2(String mainContents2) {
		this.mainContents2 = mainContents2;
	}
	public int getHitCount2() {
		return hitCount2;
	}
	public void setHitCount2(int hitCount2) {
		this.hitCount2 = hitCount2;
	}
	public String getRegDate2() {
		return regDate2;
	}
	public void setRegDate2(String regDate2) {
		this.regDate2 = regDate2;
	}
	public int getLimit2() {
		return limit2;
	}
	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}
	public int getPage2() {
		return page2;
	}
	public void setPage2(int page2) {
		this.page2 = page2;
	}
	public int getPagenum2() {
		return pagenum2;
	}
	public void setPagenum2(int pagenum2) {
		this.pagenum2 = pagenum2;
	}

}
