package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private static final MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	/* context.xml 에 저장
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "JAVAWEB";
	private static final String PW = "JAVAWEB";
	*/
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
	
	public List<MemberVO> listMembers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_member"
					+ "		order by id asc";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<MemberVO> list = new ArrayList<>();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");
				MemberVO vo = new MemberVO(id, pwd, name, email, joindate);
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
	
	public void addMember(MemberVO memberVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Insert into t_member"
					+ " 		(id, pwd, name, email)"
					+ " 	values"
					+ "				(?,?,?,?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from t_member" 
					+ "		where id = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
    public LoginDTO loginInfo(String id, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       

        try {
            conn = getConnection();
            String sql = "SELECT name FROM t_member "
            		+ "		WHERE id = ? AND pwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {   
            	String name = rs.getString("name");
            	LoginDTO dto = new LoginDTO(id, name);				
            	return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	closeAll(rs, pstmt, conn);
        }

        return null;
    }
    
}
