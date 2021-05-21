package com.dev.service;

import java.util.List;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {
	// 입력, 수정, 삭제, 조회, 리스트
	MemberDAO dao = MemberDAO.getInstance();
	private static MemberService service = new MemberService();

	private MemberService() {
	}

	public static MemberService getInstance() {
		return service;
	}

	public List<MemberVO> listMember(){
		return dao.listMember();
	}
	
	public void memberInsert(MemberVO member) {
		dao.insertMember(member);
	}

	public MemberVO memberSearch(String id) {
		return dao.searchMember(id);
	}

	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}

	public void memberDelete(String id) {
		dao.memberDelete(id);
	}
}
