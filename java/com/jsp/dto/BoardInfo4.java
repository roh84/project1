package com.jsp.dto;

public class BoardInfo4 {
	
	private int boardListNum4; // Primary Key 글쓴 순서대로 1씩 증가
    private String userNickname4;
    private String title4; // 제목
    private String mainContents4; // 본문
    private int hitCount4; // 조회수
    private String regDate4;  // 게시글 등록일
	private int limit4;
    private int page4;
    private int pagenum4;

	
	public int getBoardListNum4() {
		return boardListNum4;
	}
	public void setBoardListNum4(int boardListNum4) {
		this.boardListNum4 = boardListNum4;
	}
	public String getUserNickname4() {
		return userNickname4;
	}
	public void setUserNickname4(String userNickname4) {
		this.userNickname4 = userNickname4;
	}
	public String getTitle4() {
		return title4;
	}
	public void setTitle4(String title4) {
		this.title4 = title4;
	}
	public String getMainContents4() {
		return mainContents4;
	}
	public void setMainContents4(String mainContents4) {
		this.mainContents4 = mainContents4;
	}
	public int getHitCount4() {
		return hitCount4;
	}
	public void setHitCount4(int hitCount4) {
		this.hitCount4 = hitCount4;
	}
	public String getRegDate4() {
		return regDate4;
	}
	public void setRegDate4(String regDate4) {
		this.regDate4 = regDate4;
	}
	public int getLimit4() {
		return limit4;
	}
	public void setLimit4(int limit4) {
		this.limit4 = limit4;
	}
	public int getPage4() {
		return page4;
	}
	public void setPage4(int page4) {
		this.page4 = page4;
	}
	public int getPagenum4() {
		return pagenum4;
	}
	public void setPagenum4(int pagenum4) {
		this.pagenum4 = pagenum4;
	}

}
