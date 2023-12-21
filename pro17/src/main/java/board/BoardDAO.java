package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private static final BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
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
	
	public boolean insert(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into t_board"
					+ "		(bno, title, content, writer, regdate, attach_file)"
					+ "		values"
					+ "			(seq_bno.nextval, ?, ?, ?, sysdate, ?)";
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.setString(3, boardVO.getWriter());
			pstmt.setString(4, boardVO.getAttach_file());
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
	
	//목록 얻기
	public List<BoardVO> selectAll() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select bno, title, writer, regdate, attach_file"
					+ "		from t_board"
					+ "		order by bno desc";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BoardVO> list = new ArrayList<>();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				String attach_file = rs.getString("attach_file");
				BoardVO boardVO = new BoardVO(bno, title, null, writer, regdate, attach_file);
				list.add(boardVO);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return null;
	}
	
	//글 한 개 조회
	public BoardVO selectByBno(int bno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from t_board "
					+ "			where bno=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				String attach_file = rs.getString("attach_file");
				BoardVO boardVO = new BoardVO(bno, title, content, writer, regdate, attach_file);
				return boardVO;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return null;
	}
	
	//글 수정
		public boolean update(BoardVO boardVO) {
			Connection conn = null;
			PreparedStatement pstmt = null;
					
			try {
				String sql = "update t_board set"
						+ "	 	 	title = ? ,"
						+ "			content=? "
						+ "		where bno = ?";		
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, boardVO.getTitle());
				pstmt.setString(2, boardVO.getContent());
				pstmt.setInt(3, boardVO.getBno());
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
		
		// 글 삭제
		
		public boolean delete(int bno) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				String sql = "delete from t_board "
						+ "		where bno = ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				int count = pstmt.executeUpdate();
				if (count > 0 ) {
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
