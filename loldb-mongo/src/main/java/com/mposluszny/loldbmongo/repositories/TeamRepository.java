package com.mposluszny.loldbmongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.mposluszny.loldbmongo.domain.Team;

public interface TeamRepository extends CrudRepository<Team, ObjectId>{

	public Team findById(ObjectId id);
	public List<Team> findByName(String name);
	public List<Team> findByRegion(String region);
}
