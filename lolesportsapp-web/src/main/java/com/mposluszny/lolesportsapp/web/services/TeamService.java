package com.mposluszny.lolesportsapp.web.services;

import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Team;

public interface TeamService {

	public List<Team> getTeams();
	public Team getTeam(long idTeam);
	public void deletePlayerFromTeam(long idPlayer);
	public void deleteTeam(Team team);
	public void updateTeam(Team team);
	public void addTeam(Team team);
}
