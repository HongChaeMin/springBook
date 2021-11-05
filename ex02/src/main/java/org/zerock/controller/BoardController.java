package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list");
		model.addAttribute("list", boardService.selectBoardList(cri));
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(BoardVO board, RedirectAttributes rttr) {
		log.info("insert : " + board);
		
		boardService.insertBoard(board);
		
		rttr.addFlashAttribute("result", board.getBon());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/selectBoard", "/updatePage"})
	public void selectBoard(@RequestParam("bon") Long bon, Model model) {
		log.info("/selectBoard or /updatePage");
		model.addAttribute("board", boardService.selectBoard(bon));
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO board, RedirectAttributes rttr) {
		log.info("update : " + board);
		
		if (boardService.updateBoard(board)) {
			rttr.addFlashAttribute("result", board.getBon());
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("bon") Long bon, RedirectAttributes rttr) {
		log.info("delete : " + bon);
		
		if (boardService.deleteBoard(bon)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/boardWrite")
	public void boardWrite() {
		
	}
	
	@GetMapping("/showBoard")
	public void showBoard(@RequestParam("bon") Long bon, Model model) {
		log.info("/showBoard");
		model.addAttribute("board", boardService.selectBoard(bon));
	}
	
}
