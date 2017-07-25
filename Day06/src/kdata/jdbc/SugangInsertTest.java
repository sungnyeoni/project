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
			System.out.println("JDBC ����̹� �ε� ����");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� ���� ���� ����");
			
			pstmt = con.prepareStatement(sql);
			if(pstmt!=null)
				System.out.println("Statement ��ü ���� ����");
			else
				System.out.println("Statement ��ü ���� ����");

			
			Scanner sc = new Scanner(System.in);
			System.out.println("�й� �Է� : ");
			String num = sc.next();
			System.out.println("�����ڵ� �Է� : ");
			String code = sc.next();
			System.out.println("���� �Է� : ");
			String grade = sc.next();
			pstmt.setString(1, num);
			pstmt.setString(2, code);
			pstmt.setString(3, grade);
			int result = pstmt.executeUpdate();
			if(result == 1)
				System.out.println("SQL�� ����");
			else
				System.out.println("SQL�� ����");

			
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
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
