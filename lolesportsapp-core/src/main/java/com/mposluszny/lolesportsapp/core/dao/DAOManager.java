package com.mposluszny.lolesportsapp.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mposluszny.lolesportsapp.core.dao.impl.PlayerDaoImpl;
import com.mposluszny.lolesportsapp.core.dao.impl.TeamDaoImpl;

public class DAOManager {

	private final String URL = "jdbc:hsqldb:hsql://localhost/";
	private final String USERNAME = "mposluszny";
	private final String PASSWORD = "admin";
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;	
	
	private DAOManager() {
		
		// for singleton purpose
	}
	
	public enum Table { PLAYER, TEAM }
	
	public static DAOManager getInstance() {
		
		return DAOManagerSingleton.INSTANCE.get();
	}
	
	public void open() {
		
		try {
			
			if (this.connection == null || this.connection.isClosed()) {
				
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void close() {
		
		try {
			
			if (this.statement != null && !this.statement.isClosed()) {
				
				this.statement.close();
			}
			
			if (this.preparedStatement != null && !this.preparedStatement.isClosed()) {
				
				this.preparedStatement.close();
			}
			
			if (this.connection != null && !this.connection.isClosed()) {
				
				this.connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private static class DAOManagerSingleton {

        public static final ThreadLocal<DAOManager> INSTANCE;
        
        static {
        	
            ThreadLocal<DAOManager> daoManager;
            
            try {
            	
                daoManager = new ThreadLocal<DAOManager>() {
                	
                    @Override
                    protected DAOManager initialValue() {
                    	
                        try {
                            return new DAOManager();
                        }
                        
                        catch(Exception e) {
                            return null;
                        }
                    }
                };
            }
            catch(Exception e) {
            	
            	daoManager = null;
            }
            
            INSTANCE = daoManager;
        }        

    }
	
	public PlayerDaoImpl getPlayerDao() {
		
		try {
			
			if (this.connection == null || this.connection.isClosed()) {
				this.open();
			}
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return new PlayerDaoImpl(this.connection, this.statement, this.preparedStatement);
	}
	
	public TeamDaoImpl getTeamDao() {
		
		try {
			
			if (this.connection == null || this.connection.isClosed()) {
				this.open();
			}
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return new TeamDaoImpl(this.connection, this.statement, this.preparedStatement);
	}
	
	public GenericDAO<?> getDao(Table table) throws SQLException {
		
		try {
			
			if (this.connection == null || this.connection.isClosed()) {
				this.open();
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		switch (table) {
		
		case PLAYER:
			return new PlayerDaoImpl(this.connection, this.statement, this.preparedStatement);
			
		case TEAM:
			return new TeamDaoImpl(this.connection, this.statement, this.preparedStatement);
			
		default:
			throw new SQLException("There's no such table in db as " + table + ".");
			
		}
	}
	
	@Override
	protected void finalize() {
		
		try {
			
			this.close();
		}
		
		finally {
			
			try { super.finalize(); }
			catch (Throwable e) { e.printStackTrace(); }
		}
	}
}
