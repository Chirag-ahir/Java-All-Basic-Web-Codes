package com.miit.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	static Connection connection;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miit", "root", "Prin@2014");
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
