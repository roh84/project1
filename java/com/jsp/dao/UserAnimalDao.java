package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;
  
@Mapper
public interface UserAnimalDao {
	

//회원가입 시 디폴트로 유저 동물이 들어간다  
	@Insert("INSERT INTO memberAnimal(userNum) VALUES (seqbd2.NEXTVAL)")
   public void meberanimal();		
	
	//아이디로 동물 이름찾기
	@Select("SELECT animalname FROM memberAnimal WHERE userNum = #{userNum}")
	public UserAnimal getAnimalName(@Param("userNum") String userNum);
	
	//유저넘버로 동물 생일찾기
	    @Select( "select animalBirth from memberAnimal where userNum=#{userNum}")
	    public UserAnimal getAnimalBirth(@Param("userNum") String userNum);
	
	//유저넘버로 동물 성별찾기
		@Select( "select animalgender from memberAnimal where userNum=#{userNum}")
		public UserAnimal getAnimalGender(@Param("userNum") String userNum);
		
	//유저넘버로 동물 몸무게
		@Select( "select animalweight from memberAnimal where userNum=#{userNum}")
		public UserAnimal getAnimalWeight(@Param("userNum") String userNum);

		  //유저넘버로 동물 프로필
			@Select( "select animalProfile from memberAnimal where userNum=#{userNum}")
			public UserAnimal getAnimalProfile(@Param("userNum") String userNum);
		
		   //유저넘버로 동물 이름 업데이트
		   @Update("UPDATE memberAnimal SET animalname = #{animalname} WHERE userNum = #{usernum}")
			public int aniname(@Param("usernum") String usernum,@Param("animalname") String animalname);
			
			//넘버로 동물 생일 업데이트
			@Update("UPDATE memberAnimal SET animalBirth = #{animalBirth} WHERE userNum = #{usernum}")
			public int anibirth(@Param("usernum") String usernum,@Param("animalBirth") String animalBirth);
			
			//넘버로 동물 성별 업데이트
			@Update("UPDATE memberAnimal SET animalgender = #{animalgender} WHERE userNum = #{usernum}")
			public int anigender(@Param("usernum") String usernum,@Param("animalgender") String animalgender);	
			
			//넘버로 동물 무게 업데이트
			@Update("UPDATE memberAnimal SET animalweight = #{animalweight} WHERE userNum = #{usernum}")
			public int aniweight(@Param("usernum") String usernum,@Param("animalweight") String animalweight);
			
			//넘버로 동물 프로파일 업데이트
			@Update("UPDATE memberAnimal SET animalProfile = #{animalProfile} WHERE userNum = #{usernum}")
			public int aniprofile(@Param("usernum") String usernum,@Param("animalProfile") String animalProfile);
			
			
			//유저 넘버로 삭제
			@Delete("delete memberAnimal where userNum = #{usernum}")
			public void deleteUserAnimal(@Param("usernum") String usernum);
	
	
	
	}