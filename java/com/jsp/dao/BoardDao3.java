package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface BoardDao3 {
	
	// 조회수 증가 
	@Update("update boardInfo3 set hitCount3 = hitCount3+1 where boardListNum3 =#{boardListNum3}")
	public int updateHitCount3(@Param("hitCount3") int hitCount3, @Param("boardListNum3") int boardListNum3);
		
	@Select("select x.boardListNum3, x.title3, x.userNickname3,x.hitCount3, x.regDate3 from (select ROWNUM as num, result.* from (select * from boardInfo3 order by boardlistNum3 desc) result) x where num <= #{limit3}")
	public List<BoardInfo3> getBoardInfoLimit3(@Param("limit3") int limit3);
	
	@Select("select x.boardListNum3, x.title3, x.mainContents3, x.userNickname3,x.hitCount3, x.regDate3 from (select ROWNUM as num, result.* from (select * from boardInfo3 order by boardlistNum3 desc) result) x where num between #{limit3} * (#{page3} - 1) +1 and #{limit3} * #{page3}")
	public List<BoardInfo3> getBoardInfoPage3(@Param("limit3") int limit3, @Param("page3") int page3);

	// 페이징 board 에서 userNickName 으로 검색
	@Select("select x.boardListNum3, x.title3, x.mainContents3, x.userNickname3, x.hitCount3, x.regDate3 from (select ROWNUM as num, result.* from (select * from boardInfo3 where userNickname3 like #{userNickname3} order by boardListNum3 desc) result) x where x.num between #{limit3} * (#{page3} - 1) + 1 AND #{limit3} * #{page3}")
	public List<BoardInfo3> searchByUserNicknamePaged3(@Param("userNickname3") String userNickname3,
			@Param("limit3") int limit3, @Param("page3") int page3);

	@Select("select count(*) from boardInfo3 order by boardListNum3 desc")
	public int getBoardInfoAllCnt();
	// 페이징 board 에서 title 으로 검색
	@Select("select x.boardListNum3, x.title3, x.mainContents3, x.userNickname3, x.hitCount3, x.regDate3 from (select ROWNUM as num, result.* from (select * from boardInfo3 where title3 like #{title3}  order by boardListNum3 desc) result) x where x.num between #{limit3} * (#{page3} - 1) + 1 AND #{limit3} * #{page3}")
	public List<BoardInfo3> searchByTitlePaged3(@Param("title3") String title3, @Param("limit3") int limit3,
			@Param("page3") int page3);

	@Select("select count(*) from boardInfo3 order by boardListNum3 desc")
	public int getBoardInfoAllCnt3();

	@Select("select * from boardInfo3 order by boardListNum3 desc")
	public List<BoardInfo3> getBoardInfoAll3();

	@Select("SELECT * FROM boardInfo3 WHERE boardListNum3 = #{boardListNum3}")
	public BoardInfo3 getBoardInfoById3(@Param("boardListNum3") int boardListNum3);

	// @@지수-새로운 글을 추가하는 메서드.
	@Insert("insert into boardInfo3 (boardListNum3, title3, mainContents3, userNickname3, hitCount3, regDate3) values (seqBoardListNum3.nextval, #{title3}, #{mainContents3}, #{userNickname3}, 0, to_char(sysdate,'yy.mm.dd'))")
	public void insertNewBoard3(@Param("userNickname3") String userNickname3, @Param("title3") String title3,
			@Param("mainContents3") String mainContents3);

	//최근에 추가된 id값 돌려줌
	@Select("SELECT seqBoardListNum3.currval FROM dual")
    int getNewlyInsertedBoardId3();
	
	// board 에서 userNickName 으로 검색
	@Select("select * from boardInfo3 where userNickname3 like #{userNickname3} order by boardlistNum3 desc")
	public List<BoardInfo3> searchByUserNickname3(@Param("userNickname3") String userNickname3);

	// board 에서 title 로 검색
	@Select("select * from boardInfo3 where title like #{title3} order by boardlistNum3 desc")
	public List<BoardInfo3> searchByTitle3(@Param("title3") String title3);

	// 지수-게시글 id로 작성자 찾는 함수
	@Select("SELECT userNickname3 FROM boardInfo3 WHERE boardListNum3 = #{boardListNum3}")
	public String getuserByboardListNum3(@Param("boardListNum3") int boardListNum3);

	// board 에 글 쓸때 자동으로 seqBoardListNum 번호가 증가 title, mainContents
	@Insert("insert into boardInfo3 values(seqBoardListNum3.nextval, #{title3}, #{mainContents3})")
	public void insertBoardInfo3(@Param("title3") String title3, @Param("mainContents3") String mainContents3);

	// board 에 글 지울때 boardListNum 인 글을 지운다?
	@Delete("delete from boardInfo3 where boardListNum3 = #{boardListNum3}")
	public void deleteBoardInfo3(@Param("boardListNum3") int boardListNum3);

	// board 에 글 수정할때 boardListNum 인 글에서 title 과 mainContents 를 수정한다
	@Update("update boardInfo3 set title3 = #{title3}, mainContents3 = #{mainContents3} where boardlistNum3 =#{boardlistNum3}")
	public void updateBoardInfo3(@Param("title3") String title3, @Param("mainContents3") String mainContents3,
			@Param("boardlistNum3") int boardlistNum3);

}