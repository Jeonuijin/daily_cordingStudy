package com.mystudy.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.student.vo.StudentVO;

// XxxxDAO, XxxxDao : Data Access Object
// 데이터베이스(Database)와 연동해서 CRUD를 구현하는 클래스
// 데이터베이스(Database)와 연동해서 CRUD를 작업을 할 수 있는 기능을 제공하는 클래스
public class StudentDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// static 초기화 구문
	static {
		//1. JDBC 드라이버 로딩
		try {
			Class.forName(DRIVER);
			System.out.println(">> JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] JDBC 드라이버 로딩 실패!!!");
		}
	}
	
	//SELECT : 데이터 1개 조회(id) - selectOne : StudentVO
	public StudentVO selectOne(String id) {
		StudentVO vo = null;
		
		//(할일) DB연결하고 SQL문 실행해서 결과값을 vo 변수에 저장하고 리턴
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			if (rs.next()) {
				vo = new StudentVO(
						rs.getString("ID"),
						rs.getString("NAME"), 
						rs.getInt("KOR"), 
						rs.getInt("ENG"), 
						rs.getInt("MATH"),
						rs.getInt("TOT"),
						rs.getDouble("AVG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//SELECT : 데이터 1개 조회(VO) - selectOne : StudentVO
	public StudentVO selectOne(StudentVO student) {
		return selectOne(student.getId());		
	}
	
	private void close(Connection conn, PreparedStatement pstmt, 
			ResultSet rs) {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SELECT : 테이블 전체 데이터 조회 - selectAll : List<StudentVO>
		public List<StudentVO> selectAll() {
			List<StudentVO> list = null;
			
			try {
				//2. DB연결 - Connection 객체 생성 <- DriverManager
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				//3. Statement 문 실행(SQL 문 실행)
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
				sb.append("  FROM STUDENT ");
				sb.append(" ORDER BY ID ");
				
				pstmt = conn.prepareStatement(sb.toString());
				
				rs = pstmt.executeQuery();
				
				list = new ArrayList<StudentVO>();
				//4. SQL 실행 결과에 대한 처리
				//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
				while (rs.next()) {
					StudentVO vo = new StudentVO(
							rs.getString("ID"),
							rs.getString("NAME"), 
							rs.getInt("KOR"), 
							rs.getInt("ENG"), 
							rs.getInt("MATH"),
							rs.getInt("TOT"),
							rs.getDouble("AVG"));
					
					list.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//5. 클로징 처리에 의한 자원 반납
				close(conn, pstmt, rs);
			}
			
			return list;
		}
		
	//INSERT : VO 데이터를 받아서 입력 - insert : int
	public int insert(StudentVO vo) {
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("	(ID, NAME, KOR, ENG, MATH, TOT, AVG) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			//? 값 설정
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[예외발생] 작업중 예외가 발생 : " + e.getMessage());
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt, null);
		}
		
		
		
		return result;
	}	
	
	//UPDATE : VO 데이터를 받아서 수정 - update : int
	//성명,국어,영어,수학,총점,평균
	public int update(StudentVO vo) {
		int result = 0;
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE STUDENT ");
			sql.append("   SET NAME = ? ");
			sql.append("     , KOR = ? ");
			sql.append("     , ENG = ? ");
			sql.append("     , MATH = ? ");
			sql.append("     , TOT = ? ");
			sql.append("     , AVG = ? ");
			sql.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			// ? 값 설정
//			pstmt.setString(1, vo.getName());
//			pstmt.setInt(2, vo.getKor());
//			pstmt.setInt(3, vo.getEng());
//			pstmt.setInt(4, vo.getMath());
//			pstmt.setInt(5, vo.getTot());
//			pstmt.setDouble(6, vo.getAvg());
//			pstmt.setString(7, vo.getId());
			
			int i = 1;
			pstmt.setString(i++, vo.getName());
			pstmt.setInt(i++, vo.getKor());
			pstmt.setInt(i++, vo.getEng());
			pstmt.setInt(i++, vo.getMath());
			pstmt.setInt(i++, vo.getTot());
			pstmt.setDouble(i++, vo.getAvg());
			pstmt.setString(i++, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("[예외발생] 작업중 예외가 발생 : " + e.getMessage());
			result = -1;
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt);
		}
		
		return result;
	}
	
	
	//- UPDATE : 이름(name) 받아서 수정 - updateName : int
	//- UPDATE : 국어점수(kor) 수정 - updateKor : int
	//- UPDATE : 총점, 평균 계산처리 - updateTotAvg : int
	//DELETE : VO 객체를 받아서 삭제 - delete : int
	//(실습)DELETE : 키값(id)을 받아서 삭제 - delete : int
	public int delete(String id) {
		int result = 0;
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM STUDENT ");
			sql.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);  //?에 대한 값 세팅작업

			result = pstmt.executeUpdate();  //result는 삭제 건수
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("[예외발생] 작업중 예외가 발생 : " + e.getMessage());
			result = -1;
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt);
		}
		
		return result;
	}
	
	
}














