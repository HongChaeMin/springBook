package org.zerock.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService;
	
	@Test
	public void testExist() {
		log.info(boardService);
		assertNotNull(boardService);
	}
	
	@Test
	public void testInsertBoard() {
		BoardVO board = new BoardVO();
		board.setTitle("안녕하세요");
		board.setContent("요세하녕안");
		board.setWriter("민홍");
		boardService.insertBoard(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBon());
	}
	
	@Test
	public void testSelectBoardList() {
		boardService.selectBoardList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testSelectBoard() {
		log.info(boardService.selectBoard(5L));
	}
	
	@Test
	public void testUpdateBoard() {
		BoardVO board = boardService.selectBoard(4L);
		
		if (board == null) return;
		
		board.setContent("내용 수정하기!");
		log.info("UPDATE BOARD : " + boardService.updateBoard(board));
		
	}
	
	@Test
	public void testDeteleBoard() {
		log.info("DETELE BOARD : " + boardService.deleteBoard(2L));
	}
	
}
