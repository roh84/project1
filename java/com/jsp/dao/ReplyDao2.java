package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface ReplyDao2 {

//	private int replyNum; // Primary Key 글쓴 순서대로 1씩 증가
//	private int boardListNum; // 외래키 
//	private String replyContents; // 댓글 내용
//	private String userNickname;
//	private String regDate;
	
	// boardlistNum 를 기준으로 댓글개수
	@Select("select count(*) from replyInfo2 where boardListNum2 =#{boardListNum2}")
	public int getReplyInfoAllCnt2(@Param("boardListNum2") int boardListNum2);
	
	// boardlistNum 를 기준으로 댓글이 달린 게시글을 찾아가서 보여주기
	@Select("select * from replyInfo2 where boardListNum2 =#{boardListNum2} order by replyNum2")
	public List<ReplyInfo2> searchByBoardListNum2(@Param("boardListNum2") int boardListNum2); 
	
	// 새로운 댓글을 추가하는 메서드. 
	@Insert("insert into replyInfo2 (replyNum2, boardListNum2, replyContents2, userNickname2, regDate2) values (seqReplyNum2.nextval, #{boardListNum2}, #{replyContents2}, #{userNickname2}, to_char(sysdate,'yyyy.mm.dd hh24:mi'))")
	public void insertNewReply2(@Param("boardListNum2") int boardListNum2, @Param("replyContents2") String replyContents2, @Param("userNickname2") String userNickname2);
		
	// ReplyInfo 에 글 지울때 replyNum 인 글을 지운다?
	@Delete("delete from replyInfo2 where replyNum2 = #{replyNum2}")
	public void deleteReplyInfo2(@Param("replyNum2") int replyNum2);
		
	// ReplyInfo 에 글 수정할때 replyNum 인 글에서 replyContents 를 수정한다
	@Update("update replyInfo2 set replyContents2 = #{replyContents2} where replyNum2 =#{replyNum2}")
	public void updateReplyInfo2(@Param("replyContents2") String replyContents2, @Param("replyNum2") int replyNum2);
	
	// 댓글 id로 작성자 찾는 함수
	@Select("SELECT userNickname2 FROM replyInfo2 WHERE replyNum2 = #{replyNum2}")
	public String getuserByReplyNum2(@Param("replyNum2") int replyNum2);
	
	
	
}
