package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface BoardDao2 {
	
	// 조회수 증가 
	@Update("update boardInfo2 set hitCount2 = hitCount2+1 where boardListNum2 =#{boardListNum2}")
	public int updateHitCount2(@Param("hitCount2") int hitCount2, @Param("boardListNum2") int boardListNum2);
	
	@Select("select x.boardListNum2, x.title2, x.userNickname2,x.hitCount2, x.regDate2 from (select ROWNUM as num, result.* from (select * from boardInfo2 order by boardlistNum2 desc) result) x where num <= #{limit2}")
	public List<BoardInfo2> getBoardInfoLimit2(@Param("limit2") int limit2);
	
	@Select("select x.boardListNum2, x.title2, x.mainContents2, x.userNickname2,x.hitCount2, x.regDate2 from (select ROWNUM as num, result.* from (select * from boardInfo2 order by boardlistNum2 desc) result) x where num between #{limit2} * (#{page2} - 1) +1 and #{limit2} * #{page2}")
	public List<BoardInfo2> getBoardInfoPage2(@Param("limit2") int limit2, @Param("page2") int page2);

	// 페이징 board 에서 userNickName 으로 검색
	@Select("select x.boardListNum2, x.title2, x.mainContents2, x.userNickname2, x.hitCount2, x.regDate2 from (select ROWNUM as num, result.* from (select * from boardInfo2 where userNickname2 like #{userNickname2} order by boardListNum2 desc) result) x where x.num between #{limit2} * (#{page2} - 1) + 1 AND #{limit2} * #{page2}")
	public List<BoardInfo2> searchByUserNicknamePaged2(@Param("userNickname2") String userNickname2,
			@Param("limit2") int limit2, @Param("page2") int page2);

	@Select("select count(*) from boardInfo2 order by boardListNum2 desc")
	public int getBoardInfoAllCnt();
	
	// 페이징 board 에서 title 으로 검색
	@Select("select x.boardListNum2, x.title2, x.mainContents2, x.userNickname2, x.hitCount2, x.regDate2 from (select ROWNUM as num, result.* from (select * from boardInfo2 where title2 like #{title2}  order by boardListNum2 desc) result) x where x.num between #{limit2} * (#{page2} - 1) + 1 AND #{limit2} * #{page2}")
	public List<BoardInfo2> searchByTitlePaged2(@Param("title2") String title2, @Param("limit2") int limit2,
			@Param("page2") int page2);

	@Select("select count(*) from boardInfo2 order by boardListNum2 desc")
	public int getBoardInfoAllCnt2();

	@Select("select * from boardInfo2 order by boardListNum2 desc")
	public List<BoardInfo2> getBoardInfoAll2();

	@Select("SELECT * FROM boardInfo2 WHERE boardListNum2 = #{boardListNum2}")
	public BoardInfo2 getBoardInfoById2(@Param("boardListNum2") int boardListNum2);

	// @@지수-새로운 글을 추가하는 메서드.
	@Insert("insert into boardInfo2 (boardListNum2, title2, mainContents2, userNickname2, hitCount2, regDate2) values (seqBoardListNum2.nextval, #{title2}, #{mainContents2}, #{userNickname2}, 0, to_char(sysdate,'yy.mm.dd'))")
	public void insertNewBoard2(@Param("userNickname2") String userNickname2, @Param("title2") String title2,
			@Param("mainContents2") String mainContents2);

	//최근에 추가된 id값 돌려줌
	@Select("SELECT seqBoardListNum2.currval FROM dual")
    int getNewlyInsertedBoardId2();
	
	// board 에서 userNickName 으로 검색
	@Select("select * from boardInfo2 where userNickname2 like #{userNickname2} order by boardlistNum2 desc")
	public List<BoardInfo2> searchByUserNickname2(@Param("userNickname2") String userNickname2);

	// board 에서 title 로 검색
	@Select("select * from boardInfo2 where title like #{title2} order by boardlistNum2 desc")
	public List<BoardInfo2> searchByTitle2(@Param("title2") String title2);

	// 지수-게시글 id로 작성자 찾는 함수
	@Select("SELECT userNickname2 FROM boardInfo2 WHERE boardListNum2 = #{boardListNum2}")
	public String getuserByboardListNum2(@Param("boardListNum2") int boardListNum2);

	// board 에 글 쓸때 자동으로 seqBoardListNum 번호가 증가 title, mainContents
	@Insert("insert into boardInfo2 values(seqBoardListNum2.nextval, #{title2}, #{mainContents2})")
	public void insertBoardInfo2(@Param("title2") String title2, @Param("mainContents2") String mainContents2);

	// board 에 글 지울때 boardListNum 인 글을 지운다?
	@Delete("delete from boardInfo2 where boardListNum2 = #{boardListNum2}")
	public void deleteBoardInfo2(@Param("boardListNum2") int boardListNum2);

	// board 에 글 수정할때 boardListNum 인 글에서 title 과 mainContents 를 수정한다
	@Update("update boardInfo2 set title2 = #{title2}, mainContents2 = #{mainContents2} where boardlistNum2 =#{boardlistNum2}")
	public void updateBoardInfo2(@Param("title2") String title2, @Param("mainContents2") String mainContents2,
			@Param("boardlistNum2") int boardlistNum2);

	/*
	 * @Results( id = "BoardInfo",value = {
	 * 
	 * @Result(property="boardListNum", column="boardListNum"),
	 * 
	 * @Result(property="title", column="title"),
	 * 
	 * @Result(property="usernickname", column="usernickname",
	 * one=@One(select="getUserByUserNickName")),
	 * 
	 * @Result(property="hitCount", column="hitCount"),
	 * 
	 * @Result(property="regDate", column="regDate") })
	 */

}