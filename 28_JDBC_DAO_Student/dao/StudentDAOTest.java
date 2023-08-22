package com.mystudy.student.dao;

import com.mystudy.student.vo.StudentVO;

public class StudentDAOTest {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		String id = "2023001";
		StudentVO stu1 = dao.selectOne(id);
		System.out.println("stu1 : " + stu1);
		
		System.out.println("---- selectOne(VO) ----");
		StudentVO stu2 = new StudentVO("2023002", "", 0, 0, 0);
		System.out.println("검색용 전달vo : " + stu2);
		
		StudentVO student = dao.selectOne(stu2);
		System.out.println("DB 검색된 student : " + student);

	}

}









