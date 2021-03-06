package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 리스트 -> memberListOutput.jsp
		MemberService service = MemberService.getInstance();
		
		List<MemberVO> list = new ArrayList<>(); 
		list = service.listMember();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("result/memberListOutput.jsp");
		rd.forward(request, response);
	}

}
