package com.mposluszny.lolesportsapp.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.mposluszny.lolesportsapp.core.dao.DAOManager;
import com.mposluszny.lolesportsapp.core.dao.TeamDao;
import com.mposluszny.lolesportsapp.core.model.Team;
import com.mposluszny.lolesportsapp.web.services.TeamService;

public class TeamServiceImpl implements TeamService {

	@Override
	public List<Team> getTeams() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		
		List<Team> teams = (ArrayList<Team>) teamDao.getAllTeams();
		
		for (Team team : teams) {
			
			team.setPlayers(teamDao.getPlayersForTeam(team));
		}
		
		daoManager.close();
		
		return teams;
	}
	
	@Override
	public Team getTeam(long idTeam) {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		
		Team team = teamDao.getTeamById(idTeam);
		team.setPlayers(teamDao.getPlayersForTeam(team));
		daoManager.close();
		
		return team;
	}
}
