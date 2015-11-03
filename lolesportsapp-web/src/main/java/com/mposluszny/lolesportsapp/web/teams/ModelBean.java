package com.mposluszny.lolesportsapp.web.teams;

import java.io.Serializable;
import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Team;
import com.mposluszny.lolesportsapp.web.services.TeamService;
import com.mposluszny.lolesportsapp.web.services.impl.TeamServiceImpl;

public class ModelBean implements Serializable {

	/**
	 * Bean for 'teams' section.
	 * Contains a Player list
	 */
	private static final long serialVersionUID = 1551523865258549328L;

	private List<Team> teams;
	private Team team;
	
	public ModelBean() {
		
		TeamService teamService = new TeamServiceImpl();
		this.teams = teamService.getTeams();
	}

	public List<Team> getTeams() {
		
		return teams;
	}
	
	public Team getTeam(long idTeam) {
		
		return team;
	}
}
