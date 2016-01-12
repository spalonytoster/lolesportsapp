package com.mposluszny.loldbmongo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.mposluszny.loldbmongo.domain.Team;

public interface TeamService {
	
	public List<Team> getTeams ();
	public List<Team> getTeamsByName(String name);
	public List<Team> getTeamsByRegion(String region);
	public Team addTeam (Team team);
	public Team updateTeam (Team team);
	public void deleteTeam (Team team);
	public void deleteTeam (ObjectId id);
	public int count();
}
