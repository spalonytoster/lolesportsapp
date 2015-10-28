package com.mposluszny.lolesportsapp.web.players;

import java.io.Serializable;
import java.util.ArrayList;

import com.mposluszny.lolesportsapp.core.dao.DAOManager;
import com.mposluszny.lolesportsapp.core.dao.PlayerDao;
import com.mposluszny.lolesportsapp.core.model.Player;

public class ModelBean implements Serializable {

	/**
	 * Bean for 'players' section.
	 * Contains a Player list
	 */
	private static final long serialVersionUID = 1551523865258549328L;

	private ArrayList<Player> players;

	public ArrayList<Player> getPlayers() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		
		this.players = (ArrayList<Player>) playerDao.getAllPlayers();
		
		return players;
	}
}
