package com.mposluszny.lolesportsapp.web.teams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mposluszny.lolesportsapp.core.dao.DAOManager;
import com.mposluszny.lolesportsapp.core.dao.TeamDao;
import com.mposluszny.lolesportsapp.core.model.Team;

public class ModelBean implements Serializable {

	/**
	 * Bean for 'teams' section.
	 * Contains a Player list
	 */
	private static final long serialVersionUID = 1551523865258549328L;

	private ArrayList<Team> teams;

	public List<Team> getTeams() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		
		this.teams = (ArrayList<Team>) teamDao.getAllTeams();
		
		for (Team team : teams) {
			
			team.setPlayers(teamDao.getPlayersForTeam(team));
		}
		
		daoManager.close();
		
		return teams;
	}
}
