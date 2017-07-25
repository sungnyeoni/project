package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsertTest2 {

	public static void main(String[] args) {
		
		// 1. JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		}
		
		// 2. 데이터베이스 서버 연결
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("데이터베이스 서버 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 서버 연결 실패");
		}
		
		// 3. Statement 객체 생성
		String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 4. SQL문 전송
		int result = 0;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("학번 입력 : ");
			String id = sc.next();
			System.out.println("이름 입력 : ");
			String name = sc.next();
			System.out.println("성별 입력 : ");
			String sex = sc.next();
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, sex);
			result = pstmt.executeUpdate();
			//pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 5. 결과 처리
		if(result == 0)
			System.out.println("SQL문 실패");
		else
			System.out.println("SQL문 성공");
		
		// 6. 데이터베이스 서버 연결 해제
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
