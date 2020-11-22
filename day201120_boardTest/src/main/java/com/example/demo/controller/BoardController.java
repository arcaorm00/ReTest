package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listBoard.do")
	public ModelAndView listBoard() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listBoard());
		return mav;
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(int no) {
		ModelAndView mav = new ModelAndView();
		dao.plusHit(no);
		mav.addObject("b", dao.getBoard(no));
		return mav;
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public ModelAndView insertBoard(BoardVo b) {
		ModelAndView mav = new ModelAndView();
		int re = dao.insertBoard(b);
		mav.addObject("re", re);
		return mav;
	}
	
	@RequestMapping(value="/updateBoard.do", method = RequestMethod.POST)
	public ModelAndView updateBoard(BoardVo b) {
		ModelAndView mav = new ModelAndView();
		int re = dao.updateBoard(b);
		mav.addObject("re", re);
		return mav;
	}
	
	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
	public ModelAndView deleteBoard(int no) {
		ModelAndView mav = new ModelAndView();
		int re = dao.deleteBoard(no);
		mav.addObject("re", re);
		return mav;
	}
}
