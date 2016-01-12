package com.mposluszny.loldbmongo.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mposluszny.loldbmongo.service.PlayerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PlayerServiceTest {

	@Autowired
	PlayerService playerService;
	@Autowired
	MongoOperations mongoOperations;
	
	@Test
	public void checkGetAllPlayers() {
		assertEquals(playerService.getPlayers().size(), playerService.count());
	}
	
	@After
	public void dropAllCollections() {
		mongoOperations.dropCollection("player");
	}
}
