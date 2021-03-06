package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 전체 어플리케이션의 컨트롤러 등록관리
 *   *.do, *.action
 */


public class FrontController extends HttpServlet{
	HashMap<String, Controller> list;
	String charset=null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//front 요청하면 제일 처음 한번만 실행됨
		charset = config.getInitParameter("charset");
				
		list = new HashMap<>();
		System.out.println("front init()");
//		list.put("/요쳉페이지.do", "컨트롤러");
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memBerList.do", new MemberListController());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI(); // /dev/insertMember.do
		String contextpath = req.getContextPath(); // /dev
		String path = uri.substring(contextpath.length());  // /insertMember.do
		System.out.println(path);
		
		Controller sub = list.get(path); //controller
		sub.execute(req, resp);
		
	}
}
