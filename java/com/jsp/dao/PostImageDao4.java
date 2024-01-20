
package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface PostImageDao4 {
	
	//@지수 - 이미지를 넣을 때 최신 글? 
	@Insert("insert into PostImage4 (imageName4, boardListNum4) values (#{imageName4}, #{boardListNum4})")
	public void saveImage4(@Param("imageName4") String imageName4, @Param("boardListNum4") int boardListNum4);

	@Select("SELECT * from PostImage4 WHERE boardListNum4 = #{boardListNum4}")
	public List<String> searchImageByBoardListNum4(@Param("boardListNum4") int boardListNum4); 

	@Select("SELECT MAX(boardListNum4) FROM BoardInfo4")
	public int getNewlyInsertedBoardId4();
			
	@Select("SELECT imageName4 from PostImage4 where boardListNum4 = #{boardListNum4}")
	public List<String> getImagePaths4(@Param("boardListNum4") int boardListNum4);//이미지는 하나지만 그래도 마음은 리스트로
	
//	@Select("SELECT * from PostImage WHERE boardListNum = #{boardListNum}")
//	public List<String> searchImageByBoardListNum(@Param("boardListNum") int boardListNum); 
	
	
}