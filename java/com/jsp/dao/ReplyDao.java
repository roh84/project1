package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

@Mapper
public interface ReplyDao {

//	private int replyNum; // Primary Key 글쓴 순서대로 1씩 증가
//	private int boardListNum; // 외래키 
//	private String replyContents; // 댓글 내용
//	private String userNickname;
//	private String regDate;
	
	// boardlistNum 를 기준으로 댓글개수
	@Select("select count(*) from replyInfo where boardListNum =#{boardListNum}")
	public int getReplyInfoAllCnt(@Param("boardListNum") int boardListNum);
	
	// boardlistNum 를 기준으로 댓글이 달린 게시글을 찾아가서 보여주기
	@Select("select * from replyInfo where boardListNum =#{boardListNum} order by replyNum")
	public List<ReplyInfo> searchByBoardListNum(@Param("boardListNum") int boardListNum); 
	
	// 새로운 댓글을 추가하는 메서드. 
	@Insert("insert into replyInfo (replyNum, boardListNum, replyContents, userNickname, regDate) values (seqReplyNum.nextval, #{boardListNum}, #{replyContents}, #{userNickname}, to_char(sysdate,'yyyy.mm.dd hh24:mi'))")
	public void insertNewReply(@Param("boardListNum") int boardListNum, @Param("replyContents") String replyContents, @Param("userNickname") String userNickname);
		
	// ReplyInfo 에 글 지울때 replyNum 인 글을 지운다?
	@Delete("delete from replyInfo where replyNum = #{replyNum}")
	public void deleteReplyInfo(@Param("replyNum") int replyNum);
		
	// ReplyInfo 에 글 수정할때 replyNum 인 글에서 replyContents 를 수정한다
	@Update("update replyInfo set replyContents = #{replyContents} where replyNum =#{replyNum}")
	public void updateReplyInfo(@Param("replyContents") String replyContents, @Param("replyNum") int replyNum);
	
	// 댓글 id로 작성자 찾는 함수
	@Select("SELECT userNickname FROM replyInfo WHERE replyNum = #{replyNum}")
	public String getuserByReplyNum(@Param("replyNum") int replyNum);
	
	
	
}
