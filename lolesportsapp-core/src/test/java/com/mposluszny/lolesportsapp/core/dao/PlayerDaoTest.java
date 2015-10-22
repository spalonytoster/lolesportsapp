package com.mposluszny.lolesportsapp.core.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.core.model.Team;

public class PlayerDaoTest {

	@Test
	public void checkAddPlayer() {
		
		DAOManager daoManager = DAOManager.getInstance();
		TeamDao teamDao = daoManager.getTeamDao();
		PlayerDao playerDao = daoManager.getPlayerDao();

		int teamCount = teamDao.count();
		int playerCount = playerDao.count();
		
		teamDao.addTeam(new Team("TSM", "NA", "2011-10-10"));
		playerDao.addPlayer(new Player("Peter", "Peng", "Doublelift", "ADC", "TSM", false));
		
		assertTrue(teamDao.count() == teamCount+1);
		assertTrue(playerDao.count() == playerCount+1);
		
		daoManager.close();
		
	}
	
}
