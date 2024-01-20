package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface ReplyDao4 {

//	private int replyNum; // Primary Key 글쓴 순서대로 1씩 증가
//	private int boardListNum; // 외래키 
//	private String replyContents; // 댓글 내용
//	private String userNickname;
//	private String regDate;
	
	// boardlistNum 를 기준으로 댓글개수
	@Select("select count(*) from replyInfo4 where boardListNum4 =#{boardListNum4}")
	public int getReplyInfoAllCnt4(@Param("boardListNum4") int boardListNum4);
	
	// boardlistNum 를 기준으로 댓글이 달린 게시글을 찾아가서 보여주기
	@Select("select * from replyInfo4 where boardListNum4 =#{boardListNum4} order by replyNum4")
	public List<ReplyInfo4> searchByBoardListNum4(@Param("boardListNum4") int boardListNum4); 
	
	// 새로운 댓글을 추가하는 메서드. 
	@Insert("insert into replyInfo4 (replyNum4, boardListNum4, replyContents4, userNickname4, regDate4) values (seqReplyNum4.nextval, #{boardListNum4}, #{replyContents4}, #{userNickname4}, to_char(sysdate,'yyyy.mm.dd hh24:mi'))")
	public void insertNewReply4(@Param("boardListNum4") int boardListNum4, @Param("replyContents4") String replyContents4, @Param("userNickname4") String userNickname4);
		
	// ReplyInfo 에 글 지울때 replyNum 인 글을 지운다?
	@Delete("delete from replyInfo4 where replyNum4 = #{replyNum4}")
	public void deleteReplyInfo4(@Param("replyNum4") int replyNum4);
		
	// ReplyInfo 에 글 수정할때 replyNum 인 글에서 replyContents 를 수정한다
	@Update("update replyInfo4 set replyContents4 = #{replyContents4} where replyNum4 =#{replyNum4}")
	public void updateReplyInfo4(@Param("replyContents4") String replyContents, @Param("replyNum4") int replyNum);
	
	// 댓글 id로 작성자 찾는 함수
	@Select("SELECT userNickname4 FROM replyInfo4 WHERE replyNum4 = #{replyNum4}")
	public String getuserByReplyNum4(@Param("replyNum4") int replyNum);
	
	
	
}
