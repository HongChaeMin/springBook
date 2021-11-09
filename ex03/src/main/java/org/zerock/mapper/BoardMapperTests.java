package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {

	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria();
		cri.setKeyword("민홍");
		cri.setType("TC");
		
		cri.setPageNum(1);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
	
		list.forEach(board -> log.info(board));
		
	}
}
