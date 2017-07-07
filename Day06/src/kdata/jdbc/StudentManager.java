package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {
	
	String num;
	String name;
	String gender;
	
	Student stu = new Student(num, name, gender);
	
	Connection con = null;
	
	//����̹� �ε� �� ���� ���� 
	public void connect(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� ���� ���� ����");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���� ���� ����");
		}
	}
	
	//�л� ���� �߰�
   public void insert(String name, String num,String gender) {
	      String sql = "insert into student values(?,?,?)";
	      PreparedStatement pstmt = null;
	      try {
	          pstmt = con.prepareStatement(sql);
	          System.out.println("PreparedStatement ����");
	      } catch (SQLException e) {
	         e.printStackTrace();
	          System.out.println("PreparedStatement ����");
	      }
	      //4. SQL�� ����
	      int result = 0;
	      try {
	         pstmt.setString(1, num);
	         pstmt.setString(2, name);
	         pstmt.setString(3, gender);
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      if(result > 0)
	         System.out.println(result+"���� "+"������ �߰��Ǿ����ϴ�.");
	      else
	         System.out.println("������ �߰����� �ʾҽ��ϴ�.");
	}
	
	//�л� ����Ʈ ���
	public void selectAll(){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student order by stu_name";	
		
	      try {
	          pstmt = con.prepareStatement(sql);
	          System.out.println("PreparedStatement ����");
	      } catch (SQLException e) {
	         e.printStackTrace();
	          System.out.println("PreparedStatement ����");
	      }
		try {	
			rs = pstmt.executeQuery();
			
			System.out.println("�й�\t�̸�\t����");
			
			while(rs.next() == true)
				System.out.println(rs.getString("stu_num")+"\t"+rs.getString("stu_name")+"\t"+rs.getString("stu_s"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����Ʈ �ҷ����� ����");
			
		}
	}
	
	//�л� �̸� �˻�
	public void selectByName(String name){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where stu_name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("PreparedStatement ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PreparedStatement ����");
			}
		try {	
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			System.out.println("�й�\t�̸�\t����");
			rs.next();
			System.out.println(rs.getString("stu_num")+"  "+rs.getString("stu_name")+"  "+rs.getString("stu_s"));
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����Ʈ �˻� ����");
		}
	}
}
