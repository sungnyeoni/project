package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectManager {
	
	//과목 평균점수 출력
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
}
