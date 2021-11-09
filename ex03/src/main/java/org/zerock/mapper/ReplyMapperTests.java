package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	private Long[] bnoArr = {222L, 223L, 224L, 225L, 226L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Test
	public void testMapper() {
		log.info(replyMapper);
	}
	
	public void testInsert() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("테스터 " + i);
			
			replyMapper.insertReply(vo);
		});
	}
	
	public void testSelect() {
		Long targetRno = 5L;
		
		ReplyVO vo = replyMapper.selectReply(targetRno);
		
		log.info(vo);
	}
	
	public void testDelete() {
		Long targetRno = 1L;
		
		replyMapper.deleteReply(targetRno);
	}
	
	public void testUpdate() {
		Long targetRno = 10L;
		
		ReplyVO vo = replyMapper.selectReply(targetRno);
		
		vo.setReply("Update Reply ");
		
		int count = replyMapper.updateReply(vo);
		
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = replyMapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
}
