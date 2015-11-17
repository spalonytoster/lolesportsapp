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
public class TeamsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8452048539808160419L;

	public enum Mode {
		
		VIEW, EDIT, DELETE
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModelBean model = (ModelBean) request.getSession().getAttribute("modelBean");
		Mode mode = null;
		long idTeam = 0L;
		TeamService teamService = new TeamServiceImpl();
		Team team;
		
		if (request.getParameter("view") != null) {
			
			idTeam = Long.parseLong(request.getParameter("view"));
			mode = Mode.VIEW;
			model.setView(true);
		}
		
		else if (request.getParameter("edit") != null) {
			
			idTeam = Long.parseLong(request.getParameter("edit"));
			mode = Mode.EDIT;
			model.setEdit(true);
		}
		
		else if (request.getParameter("delete") != null) {
			idTeam = Long.parseLong(request.getParameter("delete"));
			team = teamService.getTeam(idTeam);
			teamService.deleteTeam(team);
			request.getRequestDispatcher("team/index.jsp").forward(request, response);
		}
		
		team = teamService.getTeam(idTeam);
		request.setAttribute("team", team);
		request.setAttribute("mode", mode);
		request.getRequestDispatcher("team/index.jsp").forward(request, response);
	}

	
}
