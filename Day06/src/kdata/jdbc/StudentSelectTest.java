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
			System.out.println("JDBC ����̹� �ε� ����");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� ���� ���� ����");
			
			pstmt = con.prepareStatement(sql);
			if(pstmt!=null)
				System.out.println("Statement ��ü ���� ����");
			else
				System.out.println("Statement ��ü ���� ����");

			rs = pstmt.executeQuery();
			
			while(rs.next() == true)
				System.out.println(rs.getString("STU_NUM")+"\t"+rs.getString("STU_NAME")+"\t"+rs.getString("STU_S"));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���� ���� ����");
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
