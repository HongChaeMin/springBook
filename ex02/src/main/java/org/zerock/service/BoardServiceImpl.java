package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor // 모든파라미터를 이용하는 생성자 만듦
public class BoardServiceImpl implements BoardService{

	// spring 4.3이상부터 자동 처리
	@Setter(onMethod_ = @Autowired) // -> lombok을 이용하면 이렇게 만들어도 됨
	private BoardMapper boardMapper;
	
	@Override
	public void insertBoard(BoardVO board) {
		log.info("insert............." + board);
		boardMapper.inserSelectKey(board);
	}

	@Override
	public BoardVO selectBoard(Long bon) {
		log.info("select............." + bon);
		return boardMapper.selectBoard(bon);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		log.info("update............." + board);
		return boardMapper.updateBoard(board) == 1;
	}

	@Override
	public boolean deleteBoard(Long bon) {
		log.info("delete............." + bon);
		return boardMapper.deleteBoard(bon) == 1;
	}

	@Override
	public List<BoardVO> selectBoardList() {
		log.info("selectList.............");
		return boardMapper.getList();
	}

	
	
}
