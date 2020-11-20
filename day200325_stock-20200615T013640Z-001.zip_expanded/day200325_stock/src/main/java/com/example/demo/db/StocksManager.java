package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.HoldingVO;
import com.example.demo.vo.StocksVO;
import com.example.demo.vo.StockuserVO;

public class StocksManager {

	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//stocks
	public static List<StocksVO> listStocks(){
		SqlSession session = factory.openSession();
		List<StocksVO> list = session.selectList("stocks.selectAll");
		session.close();
		return list;
	}
	
	//stockuser
	public static int insertUser(StockuserVO u) {
		SqlSession session = factory.openSession();
		int re = session.insert("stockuser.insert", u);
		session.commit();
		session.close();
		return re;
	}
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("stockuser.nextNo");
		session.close();
		return no;
	}
	
	public static int updateUser(StockuserVO u) {
		SqlSession session = factory.openSession();
		int re = session.update("stockuser.update", u);
		session.commit();
		session.close();
		return re;
	}
	
	//holding
	public static int insertHolding(HoldingVO h) {
		SqlSession session = factory.openSession();
		int re = session.insert("holding.insert", h);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<HoldingVO> listHolding(int userno){
		SqlSession session = factory.openSession();
		List<HoldingVO> list = session.selectList("holding.selectAll", userno);
		session.close();
		return list;
	}
	
	public static int getNextId() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("holding.nextNo");
		session.close();
		return no;
	}
	
	public static boolean isExist(HoldingVO h) {
		SqlSession session = factory.openSession();
		int cnt = session.selectOne("holding.isExist", h);
		boolean re = false;
		if( cnt > 0 ) {
			re = true;
		}
		session.close();
		return re;
	}
	
	public static int updateHolding(HoldingVO h) {
		SqlSession session = factory.openSession();
		int re = session.update("holding.update", h);
		session.commit();
		session.close();
		return re;
	}
	
	public static HoldingVO getHolding(HoldingVO v) {
		SqlSession session = factory.openSession();
		HoldingVO h = session.selectOne("holding.getHolding", v);
		session.close();
		return h;
	}
	
	public static int deleteHolding(HoldingVO h) {
		SqlSession session = factory.openSession();
		int re = session.delete("holding.delete", h);
		session.commit();
		session.close();
		return re;
	}
}
