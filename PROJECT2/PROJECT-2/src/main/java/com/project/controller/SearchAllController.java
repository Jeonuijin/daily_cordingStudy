package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.dao.adminBookDAO;
import com.project.model.dao.userDAO;
import com.project.model.vo.BookVO;

@WebServlet("/user/searchAll")
public class SearchAllController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("search");
		System.out.println("검색한 값 " + search);
		//2. DB에서 해당 아이디(bookId) 책정보 조회(DAO사용)
		List<BookVO> list = userDAO.searchAll(search);
		System.out.println("검색한 값 으로 정보출력" + list);
		//2. 응답페이지(list.jsp)에 전달
		request.setAttribute("list", list);
		
		//3. 페이지 전환 - 응답할 페이지(list.jsp)로 포워딩(위임,전가)
		request.getRequestDispatcher("searchAllResult.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> ListController doPost() 시작");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		System.out.println("> ListController doPost() 끝");
	}
}