package com.mposluszny.lolesportsapp.web.teams;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mposluszny.lolesportsapp.core.model.Team;
import com.mposluszny.lolesportsapp.web.services.TeamService;
import com.mposluszny.lolesportsapp.web.services.impl.TeamServiceImpl;

@WebServlet(urlPatterns="/teams/team")
public class TeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8452048539808160419L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idTeam = 0L;
		TeamService teamService = new TeamServiceImpl();
		Team team;
		boolean readonly = true;
		
		if (request.getParameter("view") != null) {
			idTeam = Long.parseLong(request.getParameter("view"));
			readonly = true;
		}
		
		else if (request.getParameter("edit") != null) {
			idTeam = Long.parseLong(request.getParameter("edit"));
			readonly = false;
		}
		
		else if (request.getParameter("delete") != null) {
			idTeam = Long.parseLong(request.getParameter("delete"));
			team = teamService.getTeam(idTeam);
			teamService.deleteTeam(team);
			request.getRequestDispatcher("team/index.jsp").forward(request, response);
		}
		
		team = teamService.getTeam(idTeam);
		request.setAttribute("team", team);
		request.setAttribute("readonly", readonly);
		request.getRequestDispatcher("team/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TeamService teamService = new TeamServiceImpl();
		Team team = new Team();

		if (request.getParameter("idTeam") != null) {
			team.setIdTeam(Long.parseLong(request.getParameter("idTeam")));
			team.setName(request.getParameter("name"));
			team.setRegion(request.getParameter("region"));
			team.setDateOfEstablishment(request.getParameter("dateOfEstablishment"));
			teamService.updateTeam(team);
		}
		
		else if (request.getParameter("delete") != null) {
			team.setIdTeam(Long.parseLong(request.getParameter("delete")));
			teamService.deleteTeam(team);
		}
		
		else if (request.getParameter("add") != null) {
			team.setName(request.getParameter("name"));
			team.setRegion(request.getParameter("region"));
			team.setDateOfEstablishment(request.getParameter("dateOfEstablishment"));
			teamService.addTeam(team);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
}
