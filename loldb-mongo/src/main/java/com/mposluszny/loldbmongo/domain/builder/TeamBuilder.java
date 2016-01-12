package com.mposluszny.loldbmongo.domain.builder;

import java.util.List;

import org.bson.types.ObjectId;

import com.mposluszny.loldbmongo.domain.Player;
import com.mposluszny.loldbmongo.domain.Team;

  /**
	*private long idTeam;
	*private String name;
	*private String region;
	*private String dateOfEstablishment;
	*private List<Player> players;
	*
    */

public class TeamBuilder {
	
	private Team team = new Team();
	
	public TeamBuilder id(ObjectId id) {
		team.setId(id);
		return this;
	}
	
	public TeamBuilder name(String name) {
		team.setName(name);
		return this;
	}
	
	public TeamBuilder region(String region) {
		team.setRegion(region);
		return this;
	}
	
	public TeamBuilder dateOfEstablishment(String dateOfEstablishment) {
		team.setDateOfEstablishment(dateOfEstablishment);;
		return this;
	}
	
	public TeamBuilder players(List<Player> players) {
		team.setPlayers(players);
		return this;
	}
	
	public Team build() {
		return team;
	}
}
