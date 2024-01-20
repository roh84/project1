package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;
   
@Mapper
public interface UserDao {
	

	//회원가입 시 등록 할 (이름,닉네임,아이디,비번) usernum은 시퀀스로 
	@Insert("INSERT INTO Member3(userNum,userName,userNickName,userId,userPw,userEmail,userJoinDay) VALUES(seqbd.NEXTVAL, #{name}, #{nickname}, #{userid}, #{password},#{userEmail},#{dateString})")
	public void joinmember(
	        @Param("name") String name,
	        @Param("nickname") String nickname,
	        @Param("userid") String userid,
	        @Param("password") String password,
	        @Param("userEmail") String userEmail,
	        @Param("dateString") String dateString
	        );

	//모든 유저
	@Select( "select * from Member3  order by userNum asc")
	public List<User> getAllUser();
	
	//아이디로 유저번호찾기
	@Select( "select userNum from Member3 where userid=#{userid}")
	public User getuserNum(@Param("userid") String userid);
	
	
	
	//아이디로 유저닉네임 찾기
	@Select( "select userNickName from Member3 where userid=#{userid}")
	public User getuserNickName(@Param("userid") String userid);
		
	//아이디로 이메일 찾기	
	@Select( "select userEmail from Member3 where userid=#{userid}")
	public User getuserEmail(@Param("userid") String userid);
	
	//유저 넘버로 프로파일 찾기	
	@Select( "select userProfile from Member3 where userNum = #{usernum}")
	public User getuserProfile(@Param("usernum") String usernum);		
			
	//모든 유저닉네임찾기 
	@Select( "select userNickName from Member3")
	public List<User> getuserNicknameAll();

	//유저아이디찾기 
	@Select( "select userId from Member3")
	public List<User> getuseridAll();
	
	//이메일로 아뒤찾기
	@Select( "select userId from Member3 where userEmail = #{useremial}")
	public String getuseridAsEmail(@Param("useremial") String useremail);
	
	
	//유저넘버 아이디
	@Select( "select userNum,userNickName from Member3")
	public List<User> getuserNumNick();
		
	//유저비밀번호찾기 이건 api안뿌리게 
	@Select("select userPw from Member3 where userid=#{userid}")
	public User getuserpw(@Param("userid") String userid);
	
	//이메일로 유저번호찾기
	@Select( "select userPw from Member3 where userEmail = #{email}")
	public User getuserNumAsEmail(@Param("email") String email);
	
	
	
	//가장 높은 유저 넘버
	@Select("SELECT MAX(userNum) FROM member3")
	public int getHighestUserNum();
	

	
	
	//유저넘버로 유저 닉네임 업데이트
	@Update("UPDATE Member3 SET userNickName = #{nickname} WHERE userNum = #{usernum}")
	public int udtNickname(@Param("usernum") String usernum,@Param("nickname") String nickname);
	
	//넘버로 유저 이메일 업데이트
	@Update("UPDATE Member3 SET userEmail = #{userEmail} WHERE userNum = #{usernum}")
	public int udtemail(@Param("usernum") String usernum,@Param("userEmail") String userEmail);
	
	//넘버로 유저 프로파일 주소 업데이트
	@Update("UPDATE Member3 SET userProfile = #{userProfile} WHERE userNum = #{usernum}")
	public int udtprofile(@Param("usernum") String usernum,@Param("userProfile") String userProfile);
	
	
	
	//유저 넘버로 삭제
	@Delete("delete from Member3 where userNum = #{usernum}")
	public void deleteUser(@Param("usernum") String usernum);
	
	//유저 아이디 ,바꿀 비밀번호 비밀번호 변경
	@Update("update Member3 set userPw=#{newPassword} where userid=#{userid}")
	public void updateUserPassword(@Param("userid") String userid, @Param("newPassword") String newPassword);
	
	
	
	
	
	
	
	
}





