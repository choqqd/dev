package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력 파라메터 읽어옴
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setMail(mail);
		member.setName(name);
		member.setPassword(password);
		
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("result/memberUpdateOutput.jsp");
		rd.forward(request, response);
		
	}

}
