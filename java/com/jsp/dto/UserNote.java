package com.jsp.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;


public class UserNote {
	private String notenum; //쪽지 넘버
	private String sender; //아마유저 발신자 닉네임
    private String receiver;//아마 수신자 닉네임
    private String notecontent;// 내용 
    private Timestamp notetime;// 시간까지 날짜
       
    
	public String getNotenum() {
		return notenum;
	}
	public void setNotenum(String notenum) {
		this.notenum = notenum;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getNotecontent() {
		return notecontent;
	}
	public void setNotecontent(String notecontent) {
		this.notecontent = notecontent;
	}
	public Timestamp getNotetime() {
		return notetime;
	}
	public void setNotetime(Timestamp notetime) {
		this.notetime = notetime;
	}
	
  
}
