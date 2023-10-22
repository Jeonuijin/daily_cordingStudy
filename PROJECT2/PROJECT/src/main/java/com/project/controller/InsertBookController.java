package com.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.model.command.Command;
import com.project.model.command.DeptCommand;

import com.project.model.command.bookDeleteCommand;

import com.project.model.command.bookUpdateCommand;
import com.project.model.dao.adminBookDAO;
import com.project.model.vo.BookVO;

@WebServlet("/admin/InsertBook")
public class InsertBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일 저장위치
		String path = this.getServletContext().getRealPath("/upload");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, (10 * 1024 * 1024), "UTF-8",
				new DefaultFileRenamePolicy());

		// 전달받은 데이터 VO에 저장 후 DB에 입력 처리(DB 연동작업)
		BookVO vo = new BookVO();
		vo.setBookName(mr.getParameter("bookName"));
		vo.setPrice(Integer.parseInt(mr.getParameter("price")));
		
		vo.setPublisher(mr.getParameter("publisher"));
		vo.setPubDate(mr.getParameter("pubDate"));
		vo.setAuthor(mr.getParameter("author"));
		vo.setGradeAvg(Double.parseDouble(mr.getParameter("gradeAvg")));
		vo.setBookCnt(Integer.parseInt(mr.getParameter("bookCnt")));
		vo.setOrderCnt(Integer.parseInt(mr.getParameter("orderCnt")));
		vo.setDetails(mr.getParameter("details"));
		vo.setCategory(mr.getParameter("category"));
		  
		
		 // 파일 업로드 처리
        String uploadedFileName = mr.getFilesystemName("bookImage");
        if (uploadedFileName != null) {
            // 파일이 성공적으로 업로드되었을 때 파일 경로를 저장합니다.
            String filePath = uploadedFileName;
            vo.setBookImage(filePath);
        } else {
            // 파일 업로드 실패 또는 파일이 선택되지 않았을 때 처리
            vo.setBookImage(null);
        }
		// 파일 업로드 처리
//		if (mr.getFile("bookImage") != null) {
//			String uploadedFileName = mr.getFile("bookImage").getName();
//		    vo.setBookImage(uploadedFileName);
//		} else {
//		    // 파일 업로드 실패 또는 파일이 선택 되지 않은 경우 처리
//		    vo.setBookImage(null);
//		}
//		 
		System.out.println("> vo datas : " + vo);
		
		
		// DB에 입력(저장) 처리 
		if (adminBookDAO.insert(vo) == 1) {
		    // 성공했을 때 응답 메시지 출력
			System.out.println("성공했습니다");
		    response.sendRedirect("adminPage.jsp");
		} else {
		    // 실패했을 때 다른 메시지 출력 또는 오류 처리
		    response.getWriter().write("저장에 실패했습니다");
		}
		// 화면전환(목록페이지로 이동 - 첫페이지로 가기) response.sendRedirect("list.jsp");
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
