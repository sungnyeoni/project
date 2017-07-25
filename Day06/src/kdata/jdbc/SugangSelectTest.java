package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SugangSelectTest {

	public static void main(String[] args) { 

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		try {
			String sql = "select lecture.num, student.stu_name, subject.sub_name, lecture.grade "
					+ "from lecture, subject, student "
					+ "where student.stu_num=lecture.num and lecture.code=subject.sub_code";
			
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
			
			System.out.println("학번\t이름\t과목명\t성적");
			while(rs.next() == true)
				System.out.println(rs.getString("num")+"\t"+rs.getString("stu_name")+"\t"+rs.getString("sub_name")+"\t"+rs.getString("grade"));
			
			
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
