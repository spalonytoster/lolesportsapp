package com.mposluszny.lolesportsapp.web.teams;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/teams/team/")
public class TeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8452048539808160419L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//long idTeam = (long) request.getAttribute("view");
		
		System.out.println(request.getParameter("view"));
		System.out.println(request.getParameter("edit"));
		System.out.println(request.getParameter("remove"));
	}

	
}
