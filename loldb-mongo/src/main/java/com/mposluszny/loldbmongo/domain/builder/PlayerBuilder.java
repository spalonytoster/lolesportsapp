package com.mposluszny.loldbmongo.domain.builder;

import org.bson.types.ObjectId;

import com.mposluszny.loldbmongo.domain.Player;
import com.mposluszny.loldbmongo.domain.Team;

/**
 *	private long idPlayer;
 *	private String name;
 *	private String surname;
 *	private String ign;
 *	private String role;
 *	private Team team;
 *	private boolean isRetired;
 */

public class PlayerBuilder {
	
	private Player player = new Player();
	
	public PlayerBuilder idPlayer(ObjectId id) {
		player.setId(id);
		return this;
	}
	
	public PlayerBuilder name(String name) {
		player.setName(name);
		return this;
	}
	
	public PlayerBuilder surname(String surname) {
		player.setSurname(surname);
		return this;
	}
	
	public PlayerBuilder ign(String ign) {
		player.setIgn(ign);
		return this;
	}
	
	public PlayerBuilder role(String role) {
		player.setRole(role);
		return this;
	}
	
	public PlayerBuilder team(Team team) {
		player.setTeam(team);
		return this;
	}
	
	public PlayerBuilder isRetired(boolean isRetired) {
		player.setRetired(isRetired);
		return this;
	}

	public Player build() {
		return player;
	}
}
