package com.mposluszny.lolesportsapp.core.dao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.mposluszny.lolesportsapp.core.dao.DAOManager.Table;
import com.mposluszny.lolesportsapp.core.dao.impl.PlayerDaoImpl;
import com.mposluszny.lolesportsapp.core.dao.impl.TeamDaoImpl;
import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.core.model.Team;

public class PlayerDaoTest {

	@Test
	public void checkAddPlayer() {
		
		try {
		
			DAOManager daoManager = DAOManager.getInstance();
			TeamDaoImpl teamDao = (TeamDaoImpl) daoManager.getDao(Table.TEAM);
			PlayerDaoImpl playerDao = (PlayerDaoImpl) daoManager.getDao(Table.PLAYER);
		
			int teamCount = teamDao.count();
			int playerCount = playerDao.count();
			
			teamDao.addTeam(new Team("TSM", "NA", "2011-10-10"));
			playerDao.addPlayer(new Player("Peter", "Peng", "Doublelift", "ADC", "TSM", false));
			
			assertTrue(teamDao.count() == teamCount+1);
			assertTrue(playerDao.count() == playerCount+1);
			
			daoManager.close();
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
