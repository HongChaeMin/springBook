package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void insertBoard(BoardVO board);
	
	public BoardVO selectBoard(Long bon);
	
	public boolean updateBoard(BoardVO board);
	
	public boolean deleteBoard(Long bon);
	
	// public List<BoardVO> selectBoardList();
	
	public List<BoardVO> selectBoardList(Criteria cri);
	
}
