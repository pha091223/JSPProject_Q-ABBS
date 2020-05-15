package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
//	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private String uid = "system";
//	private String pass = "11111111";
	
	public static BoardDAO bDAO = null;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(bDAO==null) {
			bDAO = new BoardDAO();
		}
		return bDAO;
	}
	
	private void connect() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, uid, pass);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insert(BoardDTO b) {
		connect();
		try {
			String sql = "insert into board values(board_no.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getId());
			pstmt.setString(3, b.getName());
			pstmt.setString(4, b.getText());
			pstmt.setString(5, b.getPwd());
			int cnt = pstmt.executeUpdate();
			
			if(cnt==1) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean delete(String no) {
		connect();
		try {
			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean pwdChk(String no, String pwd) {
		connect();
		try {
			String sql = "select * from board where no=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, pwd);
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;	
	}
	
	public boolean update(String text, String number) {
		connect();
		try {
			String sql = "update board set text=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setString(2, number);
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;		
	}
	
	public BoardDTO getOne(String number) {
		connect();
		try {
			String sql = "select * from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setNo(rs.getString("no"));
				b.setTitle(rs.getString("title"));
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setText(rs.getString("text"));
				b.setPwd(rs.getString("pwd"));
				b.setDay(rs.getString("day"));
				return b;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<BoardDTO> getAll(){
		connect();
		ArrayList<BoardDTO> bList = new ArrayList<>();
		try {
			String sql = "select * from board order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				BoardDTO b = new BoardDTO();
				b.setNo(rs.getString("no"));
				b.setTitle(rs.getString("title"));
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setText(rs.getString("text"));
				b.setPwd(rs.getString("pwd"));
				b.setDay(rs.getString("day"));
				bList.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bList;
	}

}
