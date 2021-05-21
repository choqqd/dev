package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dev.vo.MemberVO;

public class MemberDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return dao;
	}

	// 연결처리 Connection객체
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//전체 리스트 출력
	public List<MemberVO> listMember(){
		connect();
		List<MemberVO> memberList = new ArrayList<>();
		
		String sql = "select * from member_b order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return memberList;
	}
	
	
	//삭제
	public void memberDelete(String id) {
		connect();
		String sql = "delete from member_b where id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	//수정
	public void memberUpdate(MemberVO member) {
		connect();
		String sql = "update member_b set password = ?, name = ?, mail =? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPassword());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	//한건 조회
	public MemberVO searchMember(String id) {
		connect();
		String sql = "select * from member_b where id=?";
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return member;
	}

	// insert DB처리 기능.
	public void insertMember(MemberVO member) {
		connect();
		String sql = "insert into member_b(id, name, password, mail) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPassword());
			psmt.setString(4, member.getMail());
			
			int r = psmt.executeUpdate();
			if(r!=0) {
			System.out.println(r+"건 입력");
			}else
				System.out.println("입력 안됨ㅠㅠㅠㅠㅠㅠㅠㅠㅠ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	// resource 반환
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
