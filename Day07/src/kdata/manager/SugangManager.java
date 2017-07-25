package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SugangManager {


	//수강 정보 추가
	public int insert(String suNum, String suCode) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "insert into sugang values(?,?,null,default)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, suNum);
			pstmt.setString(2, suCode);
			
			//5.
			result = pstmt.executeUpdate();
			
		} finally {
			//6.
			DButil.close(pstmt, con);
		}
		return result;
	}

	/**
	 * 
	 * @param name
	 */
	public int delete(String suNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "delete from sugang where trim(su_num) = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, suNum);
			
			//5.
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.
			DButil.close(pstmt, con);
		}
		return result;
	}
	
	//수강 정보 출력
	public List<Sugang> selectAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Sugang> list = new ArrayList<>();
		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "select student.stu_num, student.stu_name, subject.sub_code, subject.sub_name, sugang.su_grade, sugang.su_date "
					+ "from student, subject, sugang "
					+ "where student.stu_num=sugang.su_num and subject.sub_code = sugang.su_code";
			pstmt = con.prepareStatement(sql);
			
			//5.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Sugang s = new Sugang(rs.getString("stu_num"),rs.getString("stu_name"),rs.getString("sub_code"),rs.getString("sub_name"),rs.getString("su_grade"),rs.getDate("su_date"));
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
	

	public int updateGrade(String suNum, String suCode, String suGrade){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//2. 데이터베이스 서버 연결
			con = DButil.getConnection();
			//3,4. Statement 객체 생성
			String sql = "update sugang set su_grade = ? "
					+ "where su_num = ? and su_code = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, suGrade);
			pstmt.setString(2, suNum);
			pstmt.setString(3, suCode);
			
			//5.
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.
			DButil.close(pstmt, con);
		}
		return result;
	}

}
