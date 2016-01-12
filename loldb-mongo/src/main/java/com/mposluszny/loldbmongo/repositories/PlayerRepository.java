package com.mposluszny.loldbmongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.mposluszny.loldbmongo.domain.Player;
import java.lang.String;
import java.util.List;
import com.mposluszny.loldbmongo.domain.Team;

public interface PlayerRepository extends CrudRepository<Player, ObjectId> {

	public Player findById(ObjectId id);
	public List<Player> findByIgn(String ign);
	public List<Player> findByName(String name);
	public List<Player> findBySurname(String surname);
	public List<Player> findByTeam(Team team);
	
}
