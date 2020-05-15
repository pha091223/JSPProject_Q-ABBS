package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
//	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private String uid = "system";
//	private String pass = "11111111";
	
	public static MemberDAO mDAO = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(mDAO==null) {
			mDAO = new MemberDAO();
		}
		return mDAO;
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
	
	public boolean insert(MemberDTO m) {
		connect();
		try {
			String sql = "insert into member values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
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
	
	public boolean idChk(String id) {
		connect();
		try {
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	public MemberDTO getOne(MemberDTO m) {
		connect();
		try {
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(m.getName()==null) {
					sql = "select * from member where id=? and pwd=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, m.getId());
					pstmt.setString(2, m.getPwd());
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						MemberDTO mDTO = new MemberDTO();
						mDTO.setId(rs.getString("id"));
						mDTO.setPwd(rs.getString("pwd"));
						mDTO.setName(rs.getString("name"));
						return mDTO;
					}
				} else {
					MemberDTO mDTO = new MemberDTO();
					mDTO.setId(rs.getString("id"));
					mDTO.setPwd(rs.getString("pwd"));
					mDTO.setName(rs.getString("name"));
					return mDTO;
				}
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

}
