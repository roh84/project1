
package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface BoardDao {
	
	// 조회수 증가 
	@Update("update boardInfo set hitCount = hitCount+1 where boardListNum =#{boardListNum}")
	public int updateHitCount(@Param("hitCount") int hitCount, @Param("boardListNum") int boardListNum);

	@Select("select x.boardListNum, x.title, x.userNickname,x.hitCount, x.regDate from (select ROWNUM as num, result.* from (select * from boardInfo order by boardlistNum desc) result) x where num <= #{limit}")
	public List<BoardInfo> getBoardInfoLimit(@Param("limit") int limit);
	
	@Select("select x.boardListNum, x.title, x.mainContents, x.userNickname,x.hitCount, x.regDate from (select ROWNUM as num, result.* from (select * from boardInfo order by boardlistNum desc) result) x where num between #{limit} * (#{page} - 1) +1 and #{limit} * #{page}")
	public List<BoardInfo> getBoardInfoPage(@Param("limit") int limit, @Param("page") int page);

	// 페이징 board 에서 userNickName 으로 검색
	@Select("select x.boardListNum, x.title, x.mainContents, x.userNickname, x.hitCount, x.regDate from (select ROWNUM as num, result.* from (select * from boardInfo where userNickname like #{userNickname} order by boardListNum desc) result) x where x.num between #{limit} * (#{page} - 1) + 1 AND #{limit} * #{page}")
	public List<BoardInfo> searchByUserNicknamePaged(@Param("userNickname") String userNickname,
			@Param("limit") int limit, @Param("page") int page);

	// 페이징 board 에서 title 으로 검색
	@Select("select x.boardListNum, x.title, x.mainContents, x.userNickname, x.hitCount, x.regDate from (select ROWNUM as num, result.* from (select * from boardInfo where title like #{title}  order by boardListNum desc) result) x where x.num between #{limit} * (#{page} - 1) + 1 AND #{limit} * #{page}")
	public List<BoardInfo> searchByTitlePaged(@Param("title") String title, @Param("limit") int limit,
			@Param("page") int page);

	@Select("select count(*) from boardInfo order by boardListNum desc")
	public int getBoardInfoAllCnt();

	@Select("select * from boardInfo order by boardListNum desc")
	public List<BoardInfo> getBoardInfoAll();

	@Select("SELECT * FROM boardInfo WHERE boardListNum = #{boardListNum}")
	public BoardInfo getBoardInfoById(@Param("boardListNum") int boardListNum);
	
	
	
	//지수-새로운 글을 추가하는 메서드. 
	@Insert("insert into boardInfo (boardListNum, title, mainContents, userNickname, hitCount, regDate) values (seqBoardListNum.nextval, #{title}, #{mainContents}, #{userNickname}, 0, sysdate)")
	public void insertNewBoard(@Param("userNickname") String userNickname, @Param("title") String title, @Param("mainContents") String mainContents);
	
	//최근에 추가된 id값 돌려줌
	@Select("SELECT seqBoardListNum.currval FROM dual")
    public int getNewlyInsertedBoardId();
	
	
	// board 에서 userNickName 으로 검색
	@Select("select * from boardInfo where userNickname like #{userNickname} order by boardlistNum desc")
	public List<BoardInfo> searchByUserNickname(@Param("userNickname") String userNickname);

	// board 에서 title 로 검색
	@Select("select * from boardInfo where title like #{title} order by boardlistNum desc")
	public List<BoardInfo> searchByTitle(@Param("title") String title);

	// 지수-게시글 id로 작성자 찾는 함수
	@Select("SELECT userNickname FROM boardInfo WHERE boardListNum = #{boardListNum}")
	public String getuserByboardListNum(@Param("boardListNum") int boardListNum);

	// board 에 글 쓸때 자동으로 seqBoardListNum 번호가 증가 title, mainContents
	@Insert("insert into boardInfo values(seqBoardListNum.nextval, #{title}, #{mainContents})")
	public void insertBoardInfo(@Param("title") String title, @Param("mainContents") String mainContents);

	// board 에 글 지울때 boardListNum 인 글을 지운다?
	@Delete("delete from boardInfo where boardListNum = #{boardListNum}")
	public void deleteBoardInfo(@Param("boardListNum") int boardListNum);

	// board 에 글 수정할때 boardListNum 인 글에서 title 과 mainContents 를 수정한다
	@Update("update boardInfo set title = #{title}, mainContents = #{mainContents} where boardlistNum =#{boardlistNum}")
	public void updateBoardInfo(@Param("title") String title, @Param("mainContents") String mainContents,
			@Param("boardlistNum") int boardlistNum);

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