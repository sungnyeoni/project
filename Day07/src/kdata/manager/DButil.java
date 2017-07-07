package kdata.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB 서버 연결 관리하는 클래스
 * Connection 생성, 종료
 * @author cse
 */
public class DButil {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_ID = "test";
	private static final String USER_PW = "1234";
	
	static{
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		}
	}
	
	/**
	 * 데이터베이스 서버 연결하는 메소드
	 * @return Connection   데이터 베이스 연결 정보 객체 반환
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(CON_URL, USER_ID, USER_PW);

		return con;
	}

	/**
	 * 데이터베이스 연결시 사용한 자원 해제
	 * @param pstmt
	 * @param con
	 */
	
	public static void close(PreparedStatement pstmt, Connection con){
		try {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
