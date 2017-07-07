package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

	public static void main(String[] args) {
		
		// 1. JDBC ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		}
		
		// 2. �����ͺ��̽� ���� ����
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� ���� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���� ���� ����");
		}
		
		// 3. Statement ��ü ����
		Statement st = null;
		try {
			st = con.createStatement();
			System.out.println("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 4. SQL�� ����
		int result = 0;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("�й� �Է� : ");
			String id = sc.next();
			System.out.println("�̸� �Է� : ");
			String name = sc.next();
			System.out.println("���� �Է� : ");
			String sex = sc.next();
			//String sql = "INSERT INTO STUDENT VALUES('201402671','��¿�','��')";
			String sql = "INSERT INTO STUDENT VALUES('"+ id +"','"+ name +"','"+ sex +"')"; //SQL injection -> Secure coding
			result = st.executeUpdate(sql);
			System.out.println(result+"���� ���� �߰��Ǿ����ϴ�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 5. ��� ó��
		if(result == 0)
			System.out.println("SQL�� ����");
		else
			System.out.println("SQL�� ����");
		
		// 6. �����ͺ��̽� ���� ���� ����
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
