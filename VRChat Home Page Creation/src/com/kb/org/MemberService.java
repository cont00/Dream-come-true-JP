package com.kb.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.lang.Exception;

/**
 * oracle
 * Member table
 * String id
 * String pw
 * Login Check
 */

public class MemberService {
	public String loginCheck (String id, String pw) {
		String result = "Not ID";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 반환되는 값을 가지고 있는 객체
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER " + " WHERE ID = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next() ) {
				// ID가 있음
				if (rs.getString("pw").equals(pw)) {
//					System.out.println("Login success");
					return result = "Login success";
				}
				else {
//					System.out.println("Login fail. Please check PW.");
					return result = "Not PW";
				}
			} else {
//				System.out.println("Login fail. Please check ID.");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "Exception";
			return "Exception";
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	public boolean insertMember(MemberDTO md) {
		System.out.println("ID : " + md.getId());
		System.out.println("Password : " + md.getPw());
		System.out.println("Password Check : " + md.getPwc());
		System.out.println("NAME : " + md.getName());
		System.out.println("Character Name : " + md.getCname());
		System.out.println("Address : " + md.getAd());
		System.out.println("E-mail : " + md.getEm());
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement("INSERT INTO MEMBER " + 
				" (MEMBER_IDX, ID, PW, NAME, CNAME, SEX, ADDRESS, EMAIL, LANGUAGE) " + 
				" VALUES " + 
				" ((SELECT NVL(MAX(MEMBER_IDX)+1, 1) FROM MEMBER), ?, ?, ?, ?, ?, ?, ?, ?)");
//			pstmt.setInt(1, 1);
			pstmt.setString(1, md.getId());
			pstmt.setString(2, md.getPw());
			pstmt.setString(3, md.getName());
			pstmt.setString(4, md.getCname());
			pstmt.setString(5, md.getSex());
			pstmt.setString(6, md.getAd());
			pstmt.setString(7, md.getEm());
			pstmt.setString(8, md.getLang());
			pstmt.executeUpdate();
			System.out.println("insert 성공");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e1) {
				
			}
		}
	}
	
	public MemberDTO getMemberOne(String id, String pw) {
		MemberDTO md = new MemberDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement(" SELECT * FROM MEMBER " + 
					" WHERE ID = ? AND PW = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				md.setMember_idx(rs.getInt("MEMBER_IDX"));
				md.setId(rs.getString("ID"));
				md.setPw(rs.getString("PW"));
				md.setName(rs.getString("NAME"));
				md.setCname(rs.getString("CNAME"));
				md.setSex(rs.getString("SEX"));
				md.setAd(rs.getString("ADDRESS"));
				md.setEm(rs.getString("EMAIL"));
				md.setLang(rs.getString("LANGUAGE"));
				return md;
			} else {
				System.out.println("Server Error");
				return null;
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e1) {
				
			}
		}
		return null;
	}
	
	public boolean updateMemberOne(String member_idx, String id, String pw, String name, String cname, String sex, String ad, String em, String langs) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement(" UPDATE MEMBER "
					+ " SET ID=?, PW=?, NAME=?, CNAME=?, "
					+ " SEX=?, ADDRESS=?, EMAIL=?, LANGUAGE=? "
					+ " WHERE MEMBER_IDX=? ");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, cname);
			pstmt.setString(5, sex);
			pstmt.setString(6, ad);
			pstmt.setString(7, em);
			pstmt.setString(8, langs);
			pstmt.setInt(9, Integer.parseInt(member_idx));
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e1) {
				
			}
		}
	}
	
	public ArrayList<MemberDTO> getMemberAllThree() {
		ArrayList<MemberDTO> al = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement(" SELECT * FROM MEMBER "
					+ " WHERE ROWNUM < 4 "
					+ " ORDER BY MEMBER_IDX DESC ");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO md = new MemberDTO();
				md.setMember_idx(rs.getInt("MEMBER_IDX"));
				md.setId(rs.getString("ID"));
				md.setPw(rs.getString("PW"));
				md.setName(rs.getString("NAME"));
				md.setCname(rs.getString("CNAME"));
				md.setSex(rs.getString("SEX"));
				md.setAd(rs.getString("ADDRESS"));
				md.setEm(rs.getString("EMAIL"));
				md.setLang(rs.getString("LANGUAGE"));
				al.add(md);
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
	
	public MemberDTO getIDPW(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnection.oracle_class);
			conn = DriverManager.getConnection(DBConnection.db_addr, DBConnection.db_user, DBConnection.db_pw);
			pstmt = conn.prepareStatement(" SELECT * FROM MEMBER "
					+ " WHERE EMAIL = ? AND ROWNUM = 1 ");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberDTO md = new MemberDTO();
				md.setId(rs.getString("ID"));
				md.setPw(rs.getString("PW"));
				return md;
			} else {
				// 해당되는 아이디가 없습니다.
				return null;
			}
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
}