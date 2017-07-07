package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SugangInsertTest {

	public static void main(String[] args) { 

		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			String sql = "INSERT INTO LECTURE VALUES(?, ?, ?, DEFAULT)";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("데이터베이스 서버 연결 성공");
			
			pstmt = con.prepareStatement(sql);
			if(pstmt!=null)
				System.out.println("Statement 객체 생성 성공");
			else
				System.out.println("Statement 객체 생성 실패");

			
			Scanner sc = new Scanner(System.in);
			System.out.println("학번 입력 : ");
			String num = sc.next();
			System.out.println("과목코드 입력 : ");
			String code = sc.next();
			System.out.println("성적 입력 : ");
			String grade = sc.next();
			pstmt.setString(1, num);
			pstmt.setString(2, code);
			pstmt.setString(3, grade);
			int result = pstmt.executeUpdate();
			if(result == 1)
				System.out.println("SQL문 성공");
			else
				System.out.println("SQL문 실패");

			
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
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
