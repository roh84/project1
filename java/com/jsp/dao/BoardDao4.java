package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface BoardDao4 {
	
	// 조회수 증가 
	@Update("update boardInfo4 set hitCount4 = hitCount4+1 where boardListNum4 =#{boardListNum4}")
	public int updateHitCount4(@Param("hitCount4") int hitCount4, @Param("boardListNum4") int boardListNum4);
	
	@Select("select x.boardListNum4, x.title4, x.userNickname4,x.hitCount4, x.regDate4 from (select ROWNUM as num, result.* from (select * from boardInfo4 order by boardlistNum4 desc) result) x where num <= #{limit4}")
	public List<BoardInfo4> getBoardInfoLimit4(@Param("limit4") int limit4);
	
	@Select("select x.boardListNum4, x.title4, x.mainContents4, x.userNickname4,x.hitCount4, x.regDate4 from (select ROWNUM as num, result.* from (select * from boardInfo4 order by boardlistNum4 desc) result) x where num between #{limit4} * (#{page4} - 1) +1 and #{limit4} * #{page4}")
	public List<BoardInfo4> getBoardInfoPage4(@Param("limit4") int limit4, @Param("page4") int page4);

	// 페이징 board 에서 userNickName 으로 검색
	@Select("select x.boardListNum4, x.title4, x.mainContents4, x.userNickname4, x.hitCount4, x.regDate4 from (select ROWNUM as num, result.* from (select * from boardInfo4 where userNickname4 like #{userNickname4} order by boardListNum4 desc) result) x where x.num between #{limit4} * (#{page4} - 1) + 1 AND #{limit4} * #{page4}")
	public List<BoardInfo4> searchByUserNicknamePaged4(@Param("userNickname4") String userNickname4,
			@Param("limit4") int limit4, @Param("page4") int page4);

	@Select("select count(*) from boardInfo4 order by boardListNum4 desc")
	public int getBoardInfoAllCnt();
	// 페이징 board 에서 title 으로 검색
	@Select("select x.boardListNum4, x.title4, x.mainContents4, x.userNickname4, x.hitCount4, x.regDate4 from (select ROWNUM as num, result.* from (select * from boardInfo4 where title4 like #{title4}  order by boardListNum4 desc) result) x where x.num between #{limit4} * (#{page4} - 1) + 1 AND #{limit4} * #{page4}")
	public List<BoardInfo4> searchByTitlePaged4(@Param("title4") String title4, @Param("limit4") int limit4,
			@Param("page4") int page4);

	@Select("select count(*) from boardInfo4 order by boardListNum4 desc")
	public int getBoardInfoAllCnt4();

	@Select("select * from boardInfo4 order by boardListNum4 desc")
	public List<BoardInfo4> getBoardInfoAll4();

	@Select("SELECT * FROM boardInfo4 WHERE boardListNum4 = #{boardListNum4}")
	public BoardInfo4 getBoardInfoById4(@Param("boardListNum4") int boardListNum4);

	// @@지수-새로운 글을 추가하는 메서드.
	@Insert("insert into boardInfo4 (boardListNum4, title4, mainContents4, userNickname4, hitCount4, regDate4) values (seqBoardListNum4.nextval, #{title4}, #{mainContents4}, #{userNickname4}, 0, to_char(sysdate,'yy.mm.dd'))")
	public void insertNewBoard4(@Param("userNickname4") String userNickname4, @Param("title4") String title4,
			@Param("mainContents4") String mainContents4);

	//최근에 추가된 id값 돌려줌
	@Select("SELECT seqBoardListNum4.currval FROM dual")
    int getNewlyInsertedBoardId4();
	
	// board 에서 userNickName 으로 검색
	@Select("select * from boardInfo4 where userNickname4 like #{userNickname4} order by boardlistNum4 desc")
	public List<BoardInfo4> searchByUserNickname4(@Param("userNickname4") String userNickname4);

	// board 에서 title 로 검색
	@Select("select * from boardInfo4 where title like #{title4} order by boardlistNum4 desc")
	public List<BoardInfo4> searchByTitle4(@Param("title4") String title4);

	// 지수-게시글 id로 작성자 찾는 함수
	@Select("SELECT userNickname4 FROM boardInfo4 WHERE boardListNum4 = #{boardListNum4}")
	public String getuserByboardListNum4(@Param("boardListNum4") int boardListNum4);

	// board 에 글 쓸때 자동으로 seqBoardListNum 번호가 증가 title, mainContents
	@Insert("insert into boardInfo4 values(seqBoardListNum4.nextval, #{title4}, #{mainContents4})")
	public void insertBoardInfo4(@Param("title4") String title4, @Param("mainContents4") String mainContents4);

	// board 에 글 지울때 boardListNum 인 글을 지운다?
	@Delete("delete from boardInfo4 where boardListNum4 = #{boardListNum4}")
	public void deleteBoardInfo4(@Param("boardListNum4") int boardListNum4);

	// board 에 글 수정할때 boardListNum 인 글에서 title 과 mainContents 를 수정한다
	@Update("update boardInfo4 set title4 = #{title4}, mainContents4 = #{mainContents4} where boardlistNum4 =#{boardlistNum4}")
	public void updateBoardInfo4(@Param("title4") String title4, @Param("mainContents4") String mainContents4,
			@Param("boardlistNum4") int boardlistNum4);

}