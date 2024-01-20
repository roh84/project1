package com.jsp.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jsp.dto.UserNote;

public interface UserNoteSeeDao {
		   
	    //메시지 저장
		@Insert("INSERT INTO UserNoteSee (notenum) VALUES(notesee.NEXTVAL)")
		public void insertUserNoteSee();
	
	  @Select("Select cansee from UserNoteSee Where notenum = #{notenum}")
		public String GetcanSee(@Param("notenum") String notenum);
	  
	   @Update("UPDATE UserNoteSee SET cansee = ${seenum} WHERE notenum = #{notenum}")
		public void SetcanSee(@Param("notenum") String notenum,@Param("seenum") String seenum);
	  
	  
	 
		
		
	  
}
