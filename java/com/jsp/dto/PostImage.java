package com.jsp.dto;

public class PostImage {

	private String imageName; //랜덤생성될 예정
	private int boardListNum; //외래키
	
	public String getImageName() {
		return imageName;
	}
	//이미지 이름은 조작 할 일 없겠죠?
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	public int getBoardListNum() {
		return boardListNum;
	}
	public void setBoardListNum(int boardListNum) {
		this.boardListNum = boardListNum;
	}
	
}

