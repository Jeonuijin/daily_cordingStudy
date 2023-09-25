package com.mystudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Ex04 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">Ex04.doGet() 실행~~~");
		
		//request 객체로부터 파라미터 값 추출
		//getParameter(name) : 1개의 파라미터 값 추출(확인);
		//getParameterValues(name) : 동일이름의 여러개 데이터 추출시 사용
		// getParameterMap() : 파라미터 데이터 Map형태로 받기
		// getParameterNames() : 파라미터명 확인(추출)
		
		
		//전달받은 데이터 추출 후 응답처리
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String pwd2 = req.getParameter("pwd2");
		String email = req.getParameter("email");
		
		//체크박스 영역   
		//checkbox는 다음과 같이 파라미터값을 설정하면
		//체크를 안하면 null값이 출력되고, 여러개를 선택시 첫번째 값만 출력된다.
		//String hobby = req.getParameter("hobby");
		
		//취미(hobby - checkbox) 값 추출
		String[] hobby = req.getParameterValues("hobby");
		
		
		//서버 콘솔(console)에 값 출력
		System.out.println("=============");
		System.out.println("> name : " + name);
		System.out.println("> pwd : " + pwd);
		System.out.println("> pwd2 : " + pwd2);
		System.out.println("> email : " + email);
		
		System.out.println("> hobby : " + hobby);
		//System.out.println("> hobby 첫번째 : " + hobby[0]);
		System.out.println("> hobby 첫번째 : " + Arrays.toString(hobby));
		
		//=========================
		// 클라이언트(브라우저) 쪽으로 응답처리
		// 응답데이터 한글 깨짐 방지를 위한 문자셋 설정
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h2>회원가입정보<h2>");
		out.println("<ul>");
		out.println("<li>" + "이름 : " + name + "</li>");
		out.println("<li>" + "비밀번호 : " + pwd + "</li>");
		out.println("<li>" + "비밀번호 확인 : " + pwd2 + "</li>");
		out.println("<li>" + "이메일 : " + email + "</li>");
	
		//선택된 취미정보
		out.println("<li>취미 : ");
		if (hobby == null) {
			out.write("선택안함");
		}else {
			for (String str : hobby) {
				out.write(str + "&nbsp;&nbsp;");
			}
		}
		out.println("</li>");

		out.println("</ul>");
	}
}
