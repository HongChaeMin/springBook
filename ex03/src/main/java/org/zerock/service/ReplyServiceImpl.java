package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;

	@Override
	public int insertReply(ReplyVO vo) {
		log.info("insert.........");
		return replyMapper.insertReply(vo);
	}

	@Override
	public ReplyVO selectReply(Long rno) {
		log.info("select...........");
		return replyMapper.selectReply(rno);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		log.info("update............");
		return replyMapper.updateReply(vo);
	}

	@Override
	public int deteleReply(Long rno) {
		log.info("delete...........");
		return replyMapper.deleteReply(rno);
	}

	@Override
	public List<ReplyVO> selectReplyList(Criteria cri, Long bno) {
		log.info("selectList.........");
		return replyMapper.getListWithPaging(cri, bno);
	}
	
	
}
