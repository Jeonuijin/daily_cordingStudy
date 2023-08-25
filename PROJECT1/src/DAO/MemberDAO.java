package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.MemberVO;
import common.CommonJDBCUtil;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 회원가입(INSERT)

	public int insert(MemberVO vo) {
		int result = 0;

		try {
			conn = CommonJDBCUtil.getConnection();
			System.out.println("연결성공");

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MEMBER (MEMBER_ID, CUST_ID, CUST_PASSWORD, CUST_NAME, CUST_EMAIL, CUST_PHONE)");
			sb.append(" VALUES (?, ?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(sb.toString());
			
			int i = 1;
			pstmt.setInt(i++, vo.getMember_ID());
			pstmt.setString(i++, vo.getCust_id());
			pstmt.setString(i++, vo.getCust_password());
			pstmt.setString(i++, vo.getCust_name());
			pstmt.setString(i++, vo.getCust_email());
			pstmt.setString(i++, vo.getCust_phone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonJDBCUtil.close(conn, pstmt);
		}
		

		return result;
	}

	// 회원조회,로그인(SELECT) - 로그인 후 회원조회

	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;

		try {
			conn = CommonJDBCUtil.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT *");
			sb.append("  FROM MEMBER WHERE CUST_PASSWORD = ?"); // 로그인 후 비밀번호를 한번 더 입력해야 조회가능

			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			list = new ArrayList<MemberVO>();

			while (rs.next()) {
				MemberVO vo = new MemberVO(rs.getInt("MEMBER_ID"),rs.getString("CUST_ID"),
						rs.getString("CUST_PASSWORD"), rs.getString("CUST_NAME"), rs.getString("CUST_EMAIL"),
						rs.getString("CUST_PHONE"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			CommonJDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}

	// 회원정보수정(UPDATE) 

	public int update(MemberVO vo) {
		int result = 0;

		try {
			conn = CommonJDBCUtil.getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MEMBER ");
			sql.append("     , CUST_PASSWORD = ? ");
			sql.append("     , CUST_NAME = ? ");
			sql.append("     , CUST_EMAIL = ? ");
			sql.append("     , CUST_PHONE = ? ");
			sql.append(" WHERE MEMBER_ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			int i = 1;
			pstmt.setString(i++, vo.getCust_password());
			pstmt.setString(i++, vo.getCust_name());
			pstmt.setString(i++, vo.getCust_email());
			pstmt.setString(i++, vo.getCust_phone());
			

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("[예외발생] 작업중 예외가 발생 : " + e.getMessage());
			result = -1;
		} finally {
			// 5. 클로징 처리에 의한 자원 반납
			CommonJDBCUtil.close(conn, pstmt);
		}

		return result;
	}
	
	// 탈퇴(delete)
	public int delete(MemberVO vo) {
		int result = 0;
		
		try {
		
			conn = CommonJDBCUtil.getConnection();
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM MEMBER ");
			sql.append(" WHERE CUST_ID = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, vo.getCust_id());

			result = pstmt.executeUpdate();  
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("[예외발생] 작업중 예외가 발생 : " + e.getMessage());
			result = -1;
		} finally {
			
			CommonJDBCUtil.close(conn, pstmt);
		}
		
		return result;
	}

}
