package com.kb.org.noticeboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kb.org.DBConnection;

public class NoticeBoardDAO {

//	public ArrayList<NoticeBoardDTO> getAll() {
//		ArrayList<NoticeBoardDTO> al = new ArrayList<>();
//		al.add(new NoticeBoardDTO(1, "제목", "닉네임", "내용", "2018/7/18", 0));
//		al.add(new NoticeBoardDTO(2, "제목", "닉네임", "내용", "2018/7/18", 0));
//		al.add(new NoticeBoardDTO(3, "제목", "닉네임", "내용", "2018/7/18", 0));
//		
//		return al;
//	}
	
	public ArrayList<NoticeBoardDTO> getPage(int pageNum) {
		ArrayList<NoticeBoardDTO> al = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int minrow = 0;
		int maxrow = 6;
		if (pageNum != 1) {
			minrow = 5 * (pageNum - 1);
			maxrow = 6 + ((pageNum - 1 )* 5);
		}
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement( "SELECT RNUM, IDX, TITLE, CNAME, CONTENT, REGDATE, CNT FROM "
					+ " (SELECT ROWNUM AS RNUM, IDX, TITLE, CNAME, CONTENT, REGDATE, CNT FROM NOTICEBOARD ) "
					+ " WHERE RNUM > ? AND RNUM < ? " );
			pstmt.setInt(1, minrow);
			pstmt.setInt(2, maxrow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeBoardDTO nbdto = new NoticeBoardDTO();
				nbdto.setIdx(rs.getInt("IDX"));
				nbdto.setTitle(rs.getString("TITLE"));
				nbdto.setCname(rs.getString("CNAME"));
				nbdto.setContent(rs.getString("CONTENT"));
				nbdto.setRegdate(rs.getString("REGDATE"));
				nbdto.setCnt(rs.getInt("CNT"));
				al.add(nbdto);
			}
			return al;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			doClose(conn, pstmt, rs);
		}
	}
	
	public int getRows() {
		int rows = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement( " SELECT COUNT(*) FROM NOTICEBOARD " );
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}
		} catch (Exception e) {
			
		} finally {
			doClose(conn, pstmt, rs);
		}
		return rows;
	}
	public void doClose (Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)rs.close();
			if (pstmt != null)pstmt.close();
			if (conn != null)conn.close();
		} catch (Exception e) {
			
		}
		
	}
}