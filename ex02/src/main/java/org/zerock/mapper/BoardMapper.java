package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	// @Select("select * from tbl_board where bon > 0")
	public List<BoardVO> getList();
	
	// Create
	public void insert(BoardVO board);
	
	public void inserSelectKey(BoardVO board);
	
	// Read
	public BoardVO selectBoard(Long bon);
	
	// Delete
	public int deleteBoard(Long bon);
	
	// Update
	public int updateBoard(BoardVO board);
	
	// paging
	public List<BoardVO> getListWithPaging(Criteria cri);
	
}
