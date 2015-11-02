package com.mposluszny.lolesportsapp.web.players;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mposluszny.lolesportsapp.core.dao.DAOManager;
import com.mposluszny.lolesportsapp.core.dao.PlayerDao;
import com.mposluszny.lolesportsapp.core.dao.TeamDao;
import com.mposluszny.lolesportsapp.core.model.Player;

public class ModelBean implements Serializable {

	/**
	 * Bean for 'players' section.
	 * Contains a Player list
	 */
	private static final long serialVersionUID = 1551523865258549328L;

	private ArrayList<Player> players;

	public List<Player> getPlayers() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		TeamDao teamDao = daoManager.getTeamDao();
		
		this.players = (ArrayList<Player>) playerDao.getAllPlayers();
		
		for (Player player : players) {
			
			if (player.getTeam().getIdTeam() != 0L) {
				player.setTeam(teamDao.getTeamById(player.getTeam().getIdTeam()));
			}
		}
		
		daoManager.close();
		
		return players;
	}
}
