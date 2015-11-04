package com.mposluszny.lolesportsapp.web.teams;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mposluszny.lolesportsapp.core.model.Team;
import com.mposluszny.lolesportsapp.web.services.TeamService;
import com.mposluszny.lolesportsapp.web.services.impl.TeamServiceImpl;

//@WebServlet(urlPatterns="/teams/team")
public class TeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8452048539808160419L;

	public enum Mode {
		
		VIEW, EDIT, DELETE
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Mode mode;
		long idTeam;
		TeamService teamService = new TeamServiceImpl();
		
		if (request.getParameter("view") != null) {
			
			idTeam = Long.parseLong(request.getParameter("view"));
			mode = Mode.VIEW;
			
			Team team = teamService.getTeam(idTeam);
			request.setAttribute("team", team);
			request.setAttribute("mode", mode);
			System.out.println(team.getName());
		}
		
		else if (request.getParameter("edit") != null) {
			
			idTeam = Long.parseLong(request.getParameter("edit"));
			mode = Mode.EDIT;
		}
		
		else if (request.getParameter("delete") != null) {
			
			idTeam = Long.parseLong(request.getParameter("delete"));
			mode = Mode.DELETE;
		}
		
		 request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
}
