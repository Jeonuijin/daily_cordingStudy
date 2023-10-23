package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.dao.adminBookDAO;
import com.project.model.vo.BookVO;

@WebServlet("/admin/bookDelete")
public class BookDeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookId = request.getParameter("bookId");
		
		//2. DB에서 해당 아이디(bookId) 책정보 조회(DAO사용)
		
		// DB에 입력(저장) 처리 
		if (adminBookDAO.delete(bookId) == 1) {
		    // 성공했을 때 응답 메시지 출력
			System.out.println("삭제 성공했습니다");
		    response.sendRedirect("adminPage.jsp");
		} else {
		    // 실패했을 때 다른 메시지 출력 또는 오류 처리
		    response.getWriter().write("저장에 실패했습니다");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> ListController doPost() 시작");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		System.out.println("> ListController doPost() 끝");
	}
}
