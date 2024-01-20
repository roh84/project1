package com.jsp.dto;

public class UserNoteSee {
	
	 private String notenum;//쪽지넘버
	 private String cansee;//쪽지 관리 유뮤 3전체 1수신안봐 2발신안봐 
	 
	 
	public String getNotenum() {
		return notenum;
	}
	public void setNotenum(String notenum) {
		this.notenum = notenum;
	}
	public String getCansee() {
		return cansee;
	}
	public void setCansee(String cansee) {
		this.cansee = cansee;
	}	 
}
   