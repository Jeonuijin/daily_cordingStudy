package com.mystudy.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	//static 을 붙이지 않으면 하나하나 객체생성을 해서 써야된다.
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";
	
	//static 초기화구문 //로딩하는 작업.(최초1번실행)
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void close(Connection conn, Statement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
