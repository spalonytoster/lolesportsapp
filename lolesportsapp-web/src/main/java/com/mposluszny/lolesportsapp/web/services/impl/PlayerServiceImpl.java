package com.mposluszny.lolesportsapp.web.services.impl;

import java.util.List;

import com.mposluszny.lolesportsapp.core.dao.DAOManager;
import com.mposluszny.lolesportsapp.core.dao.PlayerDao;
import com.mposluszny.lolesportsapp.core.dao.TeamDao;
import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	@Override
	public List<Player> getPlayers() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		TeamDao teamDao = daoManager.getTeamDao();
		
		List<Player> players = playerDao.getAllPlayers();
		
		for (Player player : players) {
			
			if (player.getTeam().getIdTeam() != 0L) {
				player.setTeam(teamDao.getTeamById(player.getTeam().getIdTeam()));
			}
		}
		
		daoManager.close();
		
		return players;
	}

}
