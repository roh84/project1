
package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface PostImageDao3 {
	
	//@지수 - 이미지를 넣을 때 최신 글? 
	@Insert("insert into PostImage3 (imageName3, boardListNum3) values (#{imageName3}, #{boardListNum3})")
	public void saveImage3(@Param("imageName3") String imageName3, @Param("boardListNum3") int boardListNum3);

	@Select("SELECT * from PostImage3 WHERE boardListNum3 = #{boardListNum3}")
	public List<String> searchImageByBoardListNum3(@Param("boardListNum3") int boardListNum3); 

	@Select("SELECT MAX(boardListNum3) FROM BoardInfo3")
	public int getNewlyInsertedBoardId3();
			
	@Select("SELECT imageName3 from PostImage3 where boardListNum3 = #{boardListNum3}")
	public List<String> getImagePaths3(@Param("boardListNum3") int boardListNum3);//이미지는 하나지만 그래도 마음은 리스트로
	
//	@Select("SELECT * from PostImage WHERE boardListNum = #{boardListNum}")
//	public List<String> searchImageByBoardListNum(@Param("boardListNum") int boardListNum); 
	
	
}