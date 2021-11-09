package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {

	public int insertReply(ReplyVO vo);
	
	public ReplyVO selectReply(Long rno);
	
	public int updateReply(ReplyVO vo);
	
	public int deteleReply(Long rno);
	
	public List<ReplyVO> selectReplyList(Criteria cri, Long bno);
	
}
