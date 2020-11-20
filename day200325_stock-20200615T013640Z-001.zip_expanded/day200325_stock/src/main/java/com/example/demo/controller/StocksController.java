package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StocksDAO;
import com.example.demo.vo.HoldingVO;
import com.example.demo.vo.StockuserVO;
import com.google.gson.Gson;

@RestController
public class StocksController {
	
	@Autowired
	private StocksDAO dao;
	@Autowired

	public void setDao(StocksDAO dao) {
		this.dao = dao;
	}
	
	//stocks
	@RequestMapping(value="listStocks", produces = "application/json;charset=UTF-8")
	public String ListStocks() {
		String str = "";
		str = (new Gson()).toJson(dao.listStocks());
		return str;
	}
	
	public String getPrice() {
		String str = "";
		String addr = "https://finance.naver.com/item/main.nhn?code=005930";
		//#content > div.section.trade_compare > table > tbody > tr:nth-child(1) > td:nth-child(2)
		return str;
	}
	
	//stockuser
	@RequestMapping("/insertUser")
	public int insertUser(long amount) {
		String str = "";
		int userno = dao.getNextNo();
		dao.insertUser(new StockuserVO(userno, amount));
		return userno;
	}
	@RequestMapping("/updateUser")
	public String updateUser(StockuserVO u) {
		String str = "";
		dao.updateUser(u);
		return str;
	}
	
	//holding
	@RequestMapping("/insertHolding")
	public String insertHolding(HoldingVO h) {
		String str = "매수에 실패했습니다.";
		h.setHoldingid(dao.getNextId());
		int re = dao.insertHolding(h);
		if(re > 0) {
			str = "매수되었습니다.";
		}
		return str;
	}
	
	@RequestMapping(value="/listHolding", produces = "application/json;charset=UTF-8")
	public String listHolding(int userno) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.listHolding(userno));
		return str;
	}
	
	@RequestMapping("/isExist")
	public boolean isExist(HoldingVO h) {
		boolean re = dao.isExist(h);
		return re;
	}
	@RequestMapping("/updateHolding")
	public String update(HoldingVO h) {
		String str = "매수에 실패했습니다.";
		int re = dao.updateHolding(h);
		if( re > 0 ) {
			str = "매수되었습니다.";
		}
		return str;
	}
	@RequestMapping(value="/getHolding", produces = "application/json;charset=UTF-8")
	public String getHolding(HoldingVO h) {
		String str = "";
		str = (new Gson()).toJson(dao.getHolding(h));
		return str;
	}
	@RequestMapping("/deleteHolding")
	public String delete(HoldingVO h) {
		String str = "매도에 실패했습니다.";
		int re = dao.deleteHolding(h);
		if( re > 0 ) {
			str = "매도되었습니다.";
		}
		return str;
	}
}
