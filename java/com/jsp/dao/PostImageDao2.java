
package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface PostImageDao2 {
	
	//@지수 - 이미지를 넣을 때 최신 글? 
	@Insert("insert into PostImage2 (imageName2, boardListNum2) values (#{imageName2}, #{boardListNum2})")
	public void saveImage2(@Param("imageName2") String imageName2, @Param("boardListNum2") int boardListNum2);

	@Select("SELECT * from PostImage2 WHERE boardListNum2 = #{boardListNum2}")
	public List<String> searchImageByBoardListNum2(@Param("boardListNum2") int boardListNum2); 

	@Select("SELECT MAX(boardListNum2) FROM BoardInfo2")
	public int getNewlyInsertedBoardId2();
			
	@Select("SELECT imageName2 from PostImage2 where boardListNum2 = #{boardListNum2}")
	public List<String> getImagePaths2(@Param("boardListNum2") int boardListNum2);//이미지는 하나지만 그래도 마음은 리스트로
	
//	@Select("SELECT * from PostImage WHERE boardListNum = #{boardListNum}")
//	public List<String> searchImageByBoardListNum(@Param("boardListNum") int boardListNum); 
	
	
}
