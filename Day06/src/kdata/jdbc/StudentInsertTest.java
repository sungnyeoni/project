package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

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
		Statement st = null;
		try {
			st = con.createStatement();
			System.out.println("");
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
			//String sql = "INSERT INTO STUDENT VALUES('201402671','김승연','남')";
			String sql = "INSERT INTO STUDENT VALUES('"+ id +"','"+ name +"','"+ sex +"')"; //SQL injection -> Secure coding
			result = st.executeUpdate(sql);
			System.out.println(result+"개의 행이 추가되었습니다.");
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
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
