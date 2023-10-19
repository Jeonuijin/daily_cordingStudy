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
		int result = ss.insert("admin_book.insert", vo);
		ss.close();
		return result;
	}
	
}





