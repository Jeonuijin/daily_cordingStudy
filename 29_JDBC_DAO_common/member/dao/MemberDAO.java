package com.mystudy.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.common.CommonJDBCUtil;
import com.mystudy.member.vo.MemberVO;
import com.mystudy.student.vo.StudentVO;

public class MemberDAO {
//	private static final String DRIVER = "oracle.jdbc.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static final String USER = "mystudy";
//	private static final String PASSWORD = "mystudypw";	

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 전체 데이터 검색(찾기) - selectAll() : List<MemberVO>
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS");
			sb.append("  FROM MEMBER ");
			//sb.append(" ORDER BY ID ");
			sb.append(" ORDER BY NAME ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			while (rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			CommonJDBCUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	//CommondJDBCUtil 사용연결, close 처리
	//(실습) INSERT : VO 전달받아 데이터 입력처리 - insert(vo) : int
	
	public int insert(MemberVO vo) {
		int result = 0;
		
		
		try {
			conn = CommonJDBCUtil.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MEMBER");
			sb.append("	(ID, NAME, PASSWORD, PHONE, ADDRESS )");
			sb.append("VALUES (?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		} CommonJDBCUtil.close(conn, pstmt);

		
		return result;
	}
	
	
	
	
	
	
	
}







