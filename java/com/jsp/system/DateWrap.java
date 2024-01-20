package com.jsp.system;

import java.util.Date;

public class DateWrap {
	private final Date date;
	public DateWrap(Date date) {
		this.date = date;
	}
	
	public String toDayString() {
		return "%d/%d".formatted(date.getMonth(),date.getDay());
	}
	
	public String toString() {
		return "%d/%d/%d".formatted(date.getYear(),date.getMonth(),date.getDay());
	}
}
   