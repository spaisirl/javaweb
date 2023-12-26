package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDao {
	
	private static final StudentDao instance = new StudentDao();
	private StudentDao() {}
	public static StudentDao getInstance() {
		return instance;
	}
	
	//쿼리식 작성
	
	public Connection getConnection() {
		try {

			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
			Connection conn = ds.getConnection();
			System.out.println("conn:" + conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try {rs.close();} catch (Exception e) {}
		if (rs != pstmt) try {pstmt.close();} catch (Exception e) {}
		if (rs != conn) try {conn.close();} catch (Exception e) {}
	}
	
	public List<StudentVo> studentlist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_student"
					+ "		order by s_no asc";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<StudentVo> list = new ArrayList<>();
			while (rs.next()) {
				Integer s_no = rs.getInt("s_no");
				String s_name = rs.getString("s_name");
				Integer s_year = rs.getInt("s_year");
				String s_gender = rs.getString("s_gender");
				String s_major = rs.getString("s_major");
				Integer s_score = rs.getInt("s_score");
				
				StudentVo vo = new StudentVo(s_no, s_name, s_year, s_gender, s_major, s_score);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
	
	public void addStudent(StudentVo studentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Insert into t_student"
					+ " 		(s_no, s_name, s_year, s_gender, s_major, s_score)"
					+ " 	values"
					+ "				(?,?,?,?,?,?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentVo.getS_no());
			pstmt.setString(2, studentVo.getS_name());
			pstmt.setInt(3, studentVo.getS_year());
			pstmt.setString(4, studentVo.getS_gender());
			pstmt.setString(5, studentVo.getS_major());
			pstmt.setInt(6, studentVo.getS_score());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public void delete(Integer s_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from t_student" 
					+ "		where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	  
	
    public boolean checkDupId(Integer s_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) cnt from t_student"
					+ "   where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("cnt");
				if (count > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
    // 회원 1명 정보 불려오기
    public StudentVo selectByID(String modifySno) {
    	try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from t_student"
					+ "	 	 where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifySno);
			rs = pstmt.executeQuery();	
			if (rs.next()) {
				String s_name = rs.getString("s_name");
				Integer s_year = rs.getInt("s_year");
				String s_gender = rs.getString("s_gender");
				String s_major = rs.getString("s_major");
				Integer s_score = rs.getInt("s_score");
				StudentVo studentVo  = new StudentVo(null, s_name, s_year, s_gender, s_major, s_score);
				
				return studentVo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
    	
    	return null;
    }
    
    // 업데이트 (회원정보 수정)
    public boolean modifyStudent(StudentVo studentVo) {
    	Connection conn = null;
		PreparedStatement pstmt = null;
    	try {
			
				
			String sql = "update t_student set"
					+ "	 	 	s_name = ? ,"
					+ "			s_year=?, "
					+ "			s_gender =?"
					+ "			s_major =?"
					+ "			s_score =?"
					+ "		where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setString(1, studentVo.getS_name());
			pstmt.setInt(2, studentVo.getS_year());
			pstmt.setString(3, studentVo.getS_gender());
			pstmt.setString(4, studentVo.getS_major());	
			pstmt.setInt(5, studentVo.getS_score());	
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
    	return false;
    }
}
