/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cereal
 */
public class Database {
	// Singleton Database
	private static Database dbInstance;
	private Connection connection;

	private Database(){
	}

	public static Database getDbInstance(){
		if(dbInstance == null){
			dbInstance = new Database();
		}
		return dbInstance;
	}

	public Connection connect(){
		if(connection == null){
			String url = "jdbc:mariadb://localhost:3306/TindahanPRO";
			String username = "root";
			String password = "";

			try {
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password);
				System.out.println("Connected to database");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.println("Failed to connect to database");
				// Handle exception appropriately
			}
		}
		return connection;
	}

	public void disconnect(){
		if(connection != null){
			try{
				connection.close();
				System.out.println("Disconnected from database");
			}catch (SQLException e){
				e.printStackTrace();
				System.out.println("Failed to disconnect from database");
				// Handle exception appropriately
			}
		}
	}
}
