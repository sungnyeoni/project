package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

	//학생 정보 추가
	public int insert(Student s) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "insert into student values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, s.getStuNum());
			pstmt.setString(2, s.getStuName());
			pstmt.setString(3, s.getStuS());
			
			//5.
			result = pstmt.executeUpdate();
			
		} finally {
			//6.
			DButil.close(pstmt, con);
		}
		return result;
	}

	
	//학생 정보 출력
	public List<Student> selectAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Student> list = new ArrayList<>();
		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "select * from student order by stu_name";
			pstmt = con.prepareStatement(sql);
			
			//5.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student(rs.getString("stu_num"),rs.getString("stu_name"),rs.getString("stu_s"));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6.
			DButil.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param name
	 */
	public Student selectByName(String name){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	

		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "select * from student where stu_name=?";
			pstmt = con.prepareStatement(sql);
			
			//5.
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student(rs.getString("stu_num"),rs.getString("stu_name"),rs.getString("stu_s"));
				return s;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6.
			DButil.close(rs, pstmt, con);
		}
		return null;
	}
}
