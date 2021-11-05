package org.zerock.mapper;

import org.junit.Test;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {

	private BoardService mapper;
	
	@Test
	public void testGetList() {
		mapper.selectBoardList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
}
