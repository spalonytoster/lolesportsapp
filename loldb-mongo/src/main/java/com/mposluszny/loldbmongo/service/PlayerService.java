package com.mposluszny.loldbmongo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.mposluszny.loldbmongo.domain.Player;
import com.mposluszny.loldbmongo.domain.Team;

public interface PlayerService {

	public List<Player> getPlayers ();
	public List<Player> getPlayersByName(String name);
	public List<Player> getPlayersBySurname(String surname);
	public List<Player> getPlayersByIgn(String ign);
	public List<Player> getPlayersByTeam(Team team);
	public Player addPlayer (Player player);
	public Player updatePlayer (Player player);
	public void deletePlayer (Player player);
	public void deletePlayer (ObjectId id);
	public int count();
}
