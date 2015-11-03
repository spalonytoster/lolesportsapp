package com.mposluszny.lolesportsapp.web.services;

import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Team;

public interface TeamService {

	public List<Team> getTeams();
	public Team getTeam(long idTeam);
}
