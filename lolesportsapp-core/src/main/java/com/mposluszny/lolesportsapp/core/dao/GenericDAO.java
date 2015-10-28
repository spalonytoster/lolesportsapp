package com.mposluszny.lolesportsapp.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class GenericDAO<T> {

	protected Connection connection;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected final String tableName;
	
	protected GenericDAO(Connection connection, Statement statement, PreparedStatement preparedStatement, String tableName) {
		
		this.connection = connection;
		this.statement = statement;
		this.preparedStatement = preparedStatement;
		this.tableName = tableName;
	}
	
	public int count() {
		
		try {
			
			String query = "SELECT COUNT(*) FROM " + tableName + ";";
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
	
			return rs.getInt("C1");
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
}
