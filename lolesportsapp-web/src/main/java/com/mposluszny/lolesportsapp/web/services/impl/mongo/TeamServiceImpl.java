package com.mposluszny.lolesportsapp.web.services.impl.mongo;

import java.util.List;

import com.mposluszny.lolesportsapp.core.dao.DAOManager;
import com.mposluszny.lolesportsapp.core.dao.PlayerDao;
import com.mposluszny.lolesportsapp.core.dao.TeamDao;
import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.core.model.Team;
import com.mposluszny.lolesportsapp.web.services.TeamService;

public class TeamServiceImpl implements TeamService {

	@Override
	public List<Team> getTeams() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		
		List<Team> teams = teamDao.getAllTeams();
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

	@Override
	public void deletePlayerFromTeam(long idPlayer) {

		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		
		Player player = playerDao.getPlayerById(idPlayer);
		player.setTeam(new Team());
		player.getTeam().setIdTeam(0L);
		playerDao.updatePlayer(player);
		
		daoManager.close();
	}

	@Override
	public void deleteTeam(Team team) {

		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		teamDao.deleteTeam(team);
		daoManager.close();
	}

	@Override
	public void updateTeam(Team team) {

		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		
		teamDao.updateTeam(team);
		
		daoManager.close();
	}

	@Override
	public void addTeam(Team team) {

		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		
		teamDao.addTeam(team);
		
		daoManager.close();
	}
}
