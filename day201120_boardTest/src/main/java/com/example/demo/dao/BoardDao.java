package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.BoardManager;
import com.example.demo.vo.BoardVo;

@Repository
public class BoardDao {

	public List<BoardVo> listBoard(){
		return BoardManager.listBoard();
	}
	
	public BoardVo getBoard(int no) {
		return BoardManager.getBoard(no);
	}
	
	public int insertBoard(BoardVo b) {
		return BoardManager.insertBoard(b);
	}
	
	public int updateBoard(BoardVo b) {
		return BoardManager.updateBoard(b);
	}
	
	public int plusHit(BoardVo b) {
		return BoardManager.plusHit(b);
	}
	
	public int deleteBoard(int no) {
		return BoardManager.deleteBoard(no);
	}
	
}
