package com.mposluszny.loldbmongo.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mposluszny.loldbmongo.domain.Player;
import com.mposluszny.loldbmongo.domain.Team;
import com.mposluszny.loldbmongo.repositories.PlayerRepository;
import com.mposluszny.loldbmongo.service.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public List<Player> getPlayers() {
		return (List<Player>) playerRepository.findAll();
	}

	@Override
	public List<Player> getPlayersByName(String name) {
		return playerRepository.findByName(name);
	}

	@Override
	public List<Player> getPlayersBySurname(String surname) {
		return playerRepository.findBySurname(surname);
	}

	@Override
	public List<Player> getPlayersByIgn(String ign) {
		return playerRepository.findByIgn(ign);
	}

	@Override
	public List<Player> getPlayersByTeam(Team team) {
		return playerRepository.findByTeam(team);
	}

	@Override
	public Player addPlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public void deletePlayer(Player player) {
		playerRepository.delete(player);
	}

	@Override
	public void deletePlayer(ObjectId id) {
		playerRepository.delete(id);
	}

	@Override
	public int count() {
		return (int) playerRepository.count();
	}

}
