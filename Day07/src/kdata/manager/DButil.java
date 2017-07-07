package kdata.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB ���� ���� �����ϴ� Ŭ����
 * Connection ����, ����
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
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		}
	}
	
	/**
	 * �����ͺ��̽� ���� �����ϴ� �޼ҵ�
	 * @return Connection   ������ ���̽� ���� ���� ��ü ��ȯ
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(CON_URL, USER_ID, USER_PW);

		return con;
	}

	/**
	 * �����ͺ��̽� ����� ����� �ڿ� ����
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
