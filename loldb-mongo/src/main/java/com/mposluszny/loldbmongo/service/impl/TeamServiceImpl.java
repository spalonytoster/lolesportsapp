package com.mposluszny.loldbmongo.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mposluszny.loldbmongo.domain.Team;
import com.mposluszny.loldbmongo.repositories.TeamRepository;
import com.mposluszny.loldbmongo.service.TeamService;

@Component
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public List<Team> getTeams () {
		return (List<Team>) teamRepository.findAll();
	}
	
	@Override
	public List<Team> getTeamsByName(String name) {
		return teamRepository.findByName(name);
	}

	@Override
	public List<Team> getTeamsByRegion(String region) {
		return teamRepository.findByRegion(region);
	}
	
	@Override
	public Team addTeam (Team team) {
		return teamRepository.save(team);
	}
	
	@Override
	public Team updateTeam (Team team) {
		return teamRepository.save(team);
	}
	
	@Override
	public void deleteTeam (Team team) {
		teamRepository.delete(team);
	}

	@Override
	public void deleteTeam(ObjectId id) {
		teamRepository.delete(id);
	}

	@Override
	public int count() {
		return (int) teamRepository.count();
	}
}
