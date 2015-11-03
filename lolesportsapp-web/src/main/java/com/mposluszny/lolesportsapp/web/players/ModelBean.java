package com.mposluszny.lolesportsapp.web.players;

import java.io.Serializable;
import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.web.services.PlayerService;
import com.mposluszny.lolesportsapp.web.services.impl.PlayerServiceImpl;

public class ModelBean implements Serializable {

	/**
	 * Bean for 'players' section.
	 * Contains a Player list
	 */
	
	private List<Player> players;
	
	public ModelBean() {
		
		PlayerService playerService = new PlayerServiceImpl();
		this.players = playerService.getPlayers();
	}
	
	private static final long serialVersionUID = 1551523865258549328L;

	public List<Player> getPlayers() {
		
		return this.players;
	}
	
	public void setPlayers(List<Player> players) {
		
		this.players = players;
	}
}
