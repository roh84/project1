package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface ReplyDao3 {

//	private int replyNum; // Primary Key 글쓴 순서대로 1씩 증가
//	private int boardListNum; // 외래키 
//	private String replyContents; // 댓글 내용
//	private String userNickname;
//	private String regDate;
	
	// boardlistNum 를 기준으로 댓글개수
	@Select("select count(*) from replyInfo3 where boardListNum3 =#{boardListNum3}")
	public int getReplyInfoAllCnt3(@Param("boardListNum3") int boardListNum3);
	
	// boardlistNum 를 기준으로 댓글이 달린 게시글을 찾아가서 보여주기
	@Select("select * from replyInfo3 where boardListNum3 =#{boardListNum3} order by replyNum3")
	public List<ReplyInfo3> searchByBoardListNum3(@Param("boardListNum3") int boardListNum3); 
	
	// 새로운 댓글을 추가하는 메서드. 
	@Insert("insert into replyInfo3 (replyNum3, boardListNum3, replyContents3, userNickname3, regDate3) values (seqReplyNum3.nextval, #{boardListNum3}, #{replyContents3}, #{userNickname3}, to_char(sysdate,'yyyy.mm.dd hh24:mi'))")
	public void insertNewReply3(@Param("boardListNum3") int boardListNum3, @Param("replyContents3") String replyContents3, @Param("userNickname3") String userNickname3);
		
	// ReplyInfo 에 글 지울때 replyNum 인 글을 지운다?
	@Delete("delete from replyInfo3 where replyNum3 = #{replyNum3}")
	public void deleteReplyInfo3(@Param("replyNum3") int replyNum3);
		
	// ReplyInfo 에 글 수정할때 replyNum 인 글에서 replyContents 를 수정한다
	@Update("update replyInfo3 set replyContents3 = #{replyContents3} where replyNum3 =#{replyNum3}")
	public void updateReplyInfo3(@Param("replyContents3") String replyContents3, @Param("replyNum3") int replyNum3);
	
	// 댓글 id로 작성자 찾는 함수
	@Select("SELECT userNickname3 FROM replyInfo3 WHERE replyNum3 = #{replyNum3}")
	public String getuserByReplyNum3(@Param("replyNum3") int replyNum3);
	
	
	
}
