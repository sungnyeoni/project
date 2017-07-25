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
			System.out.println("JDBC ����̹� �ε� ����");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� ���� ���� ����");
			
			pstmt = con.prepareStatement(sql);
			if(pstmt!=null)
				System.out.println("Statement ��ü ���� ����");
			else
				System.out.println("Statement ��ü ���� ����");

			rs = pstmt.executeQuery();
			
			System.out.println("�й�\t�̸�\t�����\t����");
			while(rs.next() == true)
				System.out.println(rs.getString("num")+"\t"+rs.getString("stu_name")+"\t"+rs.getString("sub_name")+"\t"+rs.getString("grade"));
			
			
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
