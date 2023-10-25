package com.project.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.project.model.vo.BookVO;
import com.project.mybatis.DBService;

public class adminBookDAO {

	//상품등록(입력처리)
	public static int insert (BookVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("Book.insert", vo);
		ss.close();
		return result;
	}
	 
	//상품리스트 조회
	public static List<BookVO> getList() {
		SqlSession ss = DBService.getFactory().openSession();
		List<BookVO> list = ss.selectList("Book.list");
		ss.close();
		return list;
	}
	
	//상품리스트 책 아이디로 조회
		public static List<BookVO> selectBookId(String bookId) {
			SqlSession ss = DBService.getFactory().openSession();
			List<BookVO> list = ss.selectList("Book.selectBookId", bookId);
			ss.close();
			return list;
		}
		
	//상품정보수정
	public static int update(BookVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("Book.update", vo);
		ss.close();
		return result;
	}
	
	//상품삭제
	public static int delete(String bookId) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.delete("Book.delete", bookId);
		ss.close();
		return result;
	}
	
	//----------------------------------------------------
}





