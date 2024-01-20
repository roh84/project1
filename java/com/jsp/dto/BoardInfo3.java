package com.jsp.dto;

public class BoardInfo3 {
	
	private int boardListNum3; // Primary Key 글쓴 순서대로 1씩 증가
    private String userNickname3;
    private String title3; // 제목
    private String mainContents3; // 본문
    private int hitCount3; // 조회수
    private String regDate3;  // 게시글 등록일
	private int limit3;
    private int page3;
    private int pagenum3;

	public int getBoardListNum3() {
		return boardListNum3;
	}
	public void setBoardListNum3(int boardListNum3) {
		this.boardListNum3 = boardListNum3;
	}
	public String getUserNickname3() {
		return userNickname3;
	}
	public void setUserNickname3(String userNickname3) {
		this.userNickname3 = userNickname3;
	}
	public String getTitle3() {
		return title3;
	}
	public void setTitle3(String title3) {
		this.title3 = title3;
	}
	public String getMainContents3() {
		return mainContents3;
	}
	public void setMainContents3(String mainContents3) {
		this.mainContents3 = mainContents3;
	}
	public int getHitCount3() {
		return hitCount3;
	}
	public void setHitCount3(int hitCount3) {
		this.hitCount3 = hitCount3;
	}
	public String getRegDate3() {
		return regDate3;
	}
	public void setRegDate3(String regDate3) {
		this.regDate3 = regDate3;
	}
	public int getLimit3() {
		return limit3;
	}
	public void setLimit3(int limit3) {
		this.limit3 = limit3;
	}
	public int getPage3() {
		return page3;
	}
	public void setPage3(int page3) {
		this.page3 = page3;
	}
	public int getPagenum3() {
		return pagenum3;
	}
	public void setPagenum3(int pagenum3) {
		this.pagenum3 = pagenum3;
	}
 
}
