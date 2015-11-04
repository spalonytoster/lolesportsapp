package com.mposluszny.lolesportsapp.core.model;

import java.util.List;

public class Team {
	
	private long idTeam;
	private String name;
	private String region;
	private String dateOfEstablishment;
	private List<Player> players;
	
	public Team () {
		
		
	}
	
	public Team (String name, String region, String dateOfEstablishment) {
		
		this.name = name;
		this.region = region;
		this.dateOfEstablishment = dateOfEstablishment;
	}
	
	public long getIdTeam() {
		return idTeam;
	}
	
	public void setIdTeam(long idTeam) {
		this.idTeam = idTeam;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getDateOfEstablishment() {
		return dateOfEstablishment;
	}
	
	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
