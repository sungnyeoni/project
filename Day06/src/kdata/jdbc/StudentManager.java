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
	
	//드라이버 로드 및 서버 연결 
	public void connect(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("데이터베이스 서버 연결 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 서버 연결 실패");
		}
	}
	
	//학생 정보 추가
   public void insert(String name, String num,String gender) {
	      String sql = "insert into student values(?,?,?)";
	      PreparedStatement pstmt = null;
	      try {
	          pstmt = con.prepareStatement(sql);
	          System.out.println("PreparedStatement 성공");
	      } catch (SQLException e) {
	         e.printStackTrace();
	          System.out.println("PreparedStatement 실패");
	      }
	      //4. SQL문 전송
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
	         System.out.println(result+"개의 "+"정보가 추가되었습니다.");
	      else
	         System.out.println("정보가 추가되지 않았습니다.");
	}
	
	//학생 리스트 출력
	public void selectAll(){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student order by stu_name";	
		
	      try {
	          pstmt = con.prepareStatement(sql);
	          System.out.println("PreparedStatement 성공");
	      } catch (SQLException e) {
	         e.printStackTrace();
	          System.out.println("PreparedStatement 실패");
	      }
		try {	
			rs = pstmt.executeQuery();
			
			System.out.println("학번\t이름\t성별");
			
			while(rs.next() == true)
				System.out.println(rs.getString("stu_num")+"\t"+rs.getString("stu_name")+"\t"+rs.getString("stu_s"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("리스트 불러오기 실패");
			
		}
	}
	
	//학생 이름 검색
	public void selectByName(String name){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where stu_name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("PreparedStatement 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PreparedStatement 실패");
			}
		try {	
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			System.out.println("학번\t이름\t성별");
			rs.next();
			System.out.println(rs.getString("stu_num")+"  "+rs.getString("stu_name")+"  "+rs.getString("stu_s"));
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("리스트 검색 실패");
		}
	}
}
