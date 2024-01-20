
package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface PostImageDao {
	
	//@지수 - 이미지를 넣을 때 최신 글? 
	@Insert("insert into PostImage (imageName, boardListNum) values (#{imageName}, #{boardListNum})")
	public void saveImage(@Param("imageName") String imageName, @Param("boardListNum") int boardListNum);

	@Select("SELECT * from PostImage WHERE boardListNum = #{boardListNum}")
	public List<String> searchImageByBoardListNum(@Param("boardListNum") int boardListNum); 

	@Select("SELECT MAX(boardListNum) FROM BoardInfo")
	public int getNewlyInsertedBoardId();
			
	@Select("SELECT imageName from PostImage where boardListNum = #{boardListNum}")
	public List<String> getImagePaths(@Param("boardListNum") int boardListNum);//이미지는 하나지만 그래도 마음은 리스트로
	
//	@Select("SELECT * from PostImage WHERE boardListNum = #{boardListNum}")
//	public List<String> searchImageByBoardListNum(@Param("boardListNum") int boardListNum); 
	
	
}
