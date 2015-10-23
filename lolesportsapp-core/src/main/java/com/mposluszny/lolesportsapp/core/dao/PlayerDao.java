package com.mposluszny.lolesportsapp.core.dao;

import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Player;

public interface PlayerDao {

	public List<Player> getAllPlayers();
	public Player getPlayerById (long idPlayer);
	public void updatePlayer(Player player);
	public void addPlayer(Player player);
	public boolean deletePlayer(Player player);
	public int count();
}
