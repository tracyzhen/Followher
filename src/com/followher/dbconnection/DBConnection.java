package com.followher.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private static DBConnection dbconnection = null;

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/followher";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "yuan10081611";

	private DBConnection() {

	}

	public static DBConnection getConnection() {

		return (dbconnection == null) ? new DBConnection() : dbconnection;
	}

	public ResultSet executeQuery(String sql) {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			Statement statement = conn.createStatement();
			return statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void executeUpdate(String sql) {

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			Statement statement = conn.createStatement();
			statement.executeQuery(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
