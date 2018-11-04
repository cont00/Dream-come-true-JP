package com.kb.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FreeboardService {
	public ArrayList<FreeboardDTO> getFreeboardAllThree() {
		ArrayList<FreeboardDTO> al = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement("SELECT * FROM FREEBOARD "
					+ " WHERE ROWNUM < 4 ORDER BY FREEBOARD_IDX DESC "
			);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FreeboardDTO fbd = new FreeboardDTO();
				fbd.setFreeboard_idx(rs.getInt("FREEBOARD_IDX"));
				fbd.setTitle(rs.getString("TITLE"));
				fbd.setCname(rs.getString("CNAME"));
				fbd.setContent(rs.getString("CONTENT"));
				fbd.setWritetime(rs.getString("WRITETIME"));
				al.add(fbd);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<FreeboardDTO> getFreeboardAllten() {
		ArrayList<FreeboardDTO> al = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement(" SELECT * FROM FREEBOARD WHERE ROWNUM < 10 ORDER BY FREEBOARD_IDX DESC ");
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				FreeboardDTO temp = new FreeboardDTO();
				temp.setFreeboard_idx(rs.getInt("FREEBOARD_IDX"));
				temp.setTitle(rs.getString("TITLE"));
				temp.setCname(rs.getString("CNAME"));
				temp.setContent(rs.getString("CONTENT"));
				temp.setWritetime(rs.getString("WRITETIME"));
				temp.setGroup_idx(rs.getInt("GROUP_IDX"));
				temp.setGroup_idx_fk(rs.getInt("GROUP_IDX_FK"));
				temp.setLevel_idx(rs.getInt("LEVEL_IDX"));
				
				al.add(temp);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}

	public boolean insertFreeboard(FreeboardDTO fbd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement(" INSERT INTO FREEBOARD "
			+ " ( FREEBOARD_IDX, TITLE, CNAME, CONTENT, WRITETIME, GROUP_IDX, GROUP_IDX_FK, LEVEL_IDX ) "
			+ " VALUES ( ( SELECT NVL ( MAX ( FREEBOARD_IDX ) + 1, 0 ) FROM FREEBOARD ), ?, ?, ?, SYSDATE, "
			+ " ( SELECT NVL ( MAX ( GROUP_IDX ) + 1, 0 ) FROM FREEBOARD ), 0, 0 )" );
			pstmt.setString(1, fbd.getTitle());
			pstmt.setString(2, fbd.getCname());
			pstmt.setString(3, fbd.getContent());
			pstmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return false;
	}
	
	public boolean deleteForm(FreeboardDTO fbd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement("DELETE FROM WHERE GROUP_IDX = ?");
//			pstmt.setString(1, Integer.parseInt(GROUP_IDX));
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return false;
	}
}