package com.mposluszny.lolesportsapp.core.dao;

import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.core.model.Team;

public interface TeamDao {

	public List<Team> getAllTeams();
	public Team getTeamById (long idTeam);
	public Team getTeamByName (String name);
	public void updateTeam(Team Team);
	public void addTeam(Team team);
	public boolean deleteTeam(Team team);
	public int count();
	public List<Player> getPlayersForTeam(Team team);
}
