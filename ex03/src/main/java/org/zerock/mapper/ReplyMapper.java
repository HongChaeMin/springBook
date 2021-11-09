package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	public int insertReply(ReplyVO replyVo);
	
	public ReplyVO selectReply(Long rno);
	
	public int deleteReply(Long rno);
	
	public int updateReply(ReplyVO replyVo);
	
	public List<ReplyVO> getListWithPaging(@Param("cri")  Criteria cri, @Param("bno") Long bno);
	
}
