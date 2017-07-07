package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSelectTest {

	public static void main(String[] args) { 

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from student";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("데이터베이스 서버 연결 성공");
			
			pstmt = con.prepareStatement(sql);
			if(pstmt!=null)
				System.out.println("Statement 객체 생성 성공");
			else
				System.out.println("Statement 객체 생성 실패");

			rs = pstmt.executeQuery();
			
			while(rs.next() == true)
				System.out.println(rs.getString("STU_NUM")+"\t"+rs.getString("STU_NAME")+"\t"+rs.getString("STU_S"));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 서버 연결 실패");
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
