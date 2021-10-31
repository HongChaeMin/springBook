package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	// @Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("오늘 저녁에 뭐먹을까용 ?");
		board.setContent("오늘은 뭐 먹을까요 ㅎㅎ 추천 받아요! 느끼한건 싫고 얼큰한거 먹고 싶어요 ㅎㅎ");
		board.setWriter("챔챔");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	// @Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("오늘 저녁에 뭐먹을까용 ? selectKey");
		board.setContent("오늘은 뭐 먹을까요 ㅎㅎ 추천 받아요! 느끼한건 싫고 얼큰한거 먹고 싶어요 ㅎㅎ selectKey");
		board.setWriter("챔챔 selectKey");
		
		mapper.inserSelectKey(board);
		
		log.info(board);
	}
	
	// @Test
	public void testSelectBoard() {
		log.info(mapper.selectBoard((long) 6));
	}
	
	// @Test
	public void testDeleteBoard() {
		log.info(mapper.deleteBoard(3L));
	}
	
	// @Test
	public void testUpdateBoard() {
		BoardVO board = new BoardVO();
		board.setBon(3L);
		board.setTitle("여러분은 어떤 치킨을 좋아하시나요 ?");
		board.setContent("저는... 다 좋아해여... 그런 김에 오늘 저녁 치킨 추천 해주세요...ㅎㅎ");
		board.setWriter("챔챔 아님");
		
		log.info(mapper.updateBoard(board));
	}
	
}
