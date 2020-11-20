package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.StocksManager;
import com.example.demo.vo.HoldingVO;
import com.example.demo.vo.StocksVO;
import com.example.demo.vo.StockuserVO;

@Repository
public class StocksDAO {
	
	//stocks
	public List<StocksVO> listStocks(){
		return StocksManager.listStocks();
	}
	
	//stockuser
	public int insertUser(StockuserVO u) {
		return StocksManager.insertUser(u);
	}
	
	public int getNextNo() {
		return StocksManager.getNextNo();
	}
	
	public int updateUser(StockuserVO u) {
		return StocksManager.updateUser(u);
	}
	
	//holding
	public int insertHolding(HoldingVO h) {
		return StocksManager.insertHolding(h);
	}
	
	public List<HoldingVO> listHolding(int userno){
		return StocksManager.listHolding(userno);
	}
	
	public int getNextId() {
		return StocksManager.getNextId();
	}
	
	public boolean isExist(HoldingVO h) {
		return StocksManager.isExist(h);
	}
	
	public int updateHolding(HoldingVO h) {
		return StocksManager.updateHolding(h);
	}
	
	public HoldingVO getHolding(HoldingVO h) {
		return StocksManager.getHolding(h);
	}
	
	public int deleteHolding(HoldingVO h) {
		return StocksManager.deleteHolding(h);
	}
}
