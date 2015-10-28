package com.mposluszny.lolesportsapp.core.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.core.model.Team;

public class DaoManagerTest {

	@Test
	public void TestAdd() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		TeamDao teamDao = daoManager.getTeamDao();
		PlayerDao playerDao = daoManager.getPlayerDao();

		int teamCount = teamDao.count();
		int playerCount = playerDao.count();
		
		teamDao.addTeam(new Team("AA", "NA", "2011-10-10"));
		teamDao.addTeam(new Team("BB", "EU", "2011-10-09"));
		playerDao.addPlayer(new Player("XX", "XX", "XX", "ADC", "TSM", false));
		playerDao.addPlayer(new Player("AA", "AA", "AA", "TOP", "TSM", false));
		playerDao.addPlayer(new Player("BB", "BB", "BB", "MID", "TSM", false));
		playerDao.addPlayer(new Player("CC", "CC", "CC", "SUPPORT", "TSM", false));
		playerDao.addPlayer(new Player("DD", "DD", "DD", "JUNGLE", "Fnatic", false));
		
		assertTrue(teamDao.count() == teamCount+2);
		assertTrue(playerDao.count() == playerCount+5);
		
		daoManager.close();
		
	}
	
	@Test
	public void TestGetAll() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		TeamDao teamDao = daoManager.getTeamDao();
		
		assertTrue(teamDao.getAllTeams().size() == teamDao.count());
		assertTrue(playerDao.getAllPlayers().size() == playerDao.count());
		
		daoManager.close();
	}
	
	@Test
	public void TestDelete() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		TeamDao teamDao = daoManager.getTeamDao();
		
		Player player1 = new Player();
		Player player2 = new Player();
		Team team1 = new Team();
		
		player1.setIgn("Wildturtle");
		player2.setName("Marcin"); player2.setSurname("Jankowski");
		team1.setName("TSM");
		
		int playerCountBefore = playerDao.count();
		int teamCountBefore = teamDao.count();
		
		playerDao.deletePlayer(player1);
		playerDao.deletePlayer(player2);
		teamDao.deleteTeam(team1);
		
		int playerCountAfter = playerDao.count();
		int teamCountAfter= teamDao.count();
		
		assertTrue(playerCountBefore == playerCountAfter+2);
		assertTrue(teamCountBefore == teamCountAfter+1);
		
		daoManager.close();
	}
	
	@Test
	public void TestUpdate() {
		
		DAOManager daoManager = DAOManager.getInstance();
		daoManager.open();
		PlayerDao playerDao = daoManager.getPlayerDao();
		TeamDao teamDao = daoManager.getTeamDao();
		
		Team team = teamDao.getTeamByName("Roccat");
		String newName = "Kiedys Mialem Team";
		team.setName(newName);
		teamDao.updateTeam(team);
		Team team2 = teamDao.getTeamByName(newName);
		assertEquals(team.getIdTeam(), team2.getIdTeam());
		
		Player player = playerDao.getPlayerByIgn("Dyrus");
		assertFalse(player.isRetired());
		player.setRetired(true);
		playerDao.updatePlayer(player);
		Player player2 = playerDao.getPlayerByIgn("Dyrus");
		assertTrue(player2.isRetired());
		
		daoManager.close();
	}
	
}
