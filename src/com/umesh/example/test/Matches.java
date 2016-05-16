package com.umesh.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Matches {

	private static Connection connection;

	public static void main(String[] a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/worldcup", "root", null);

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		try {
			getMatchesByTeamName("India");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getMatchesByTeamName(String name) throws SQLException {
		int id = getTeamId(name);
		String query = "select * from matches where teamA=" + id + " or teamB="
				+ id;
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(query);
		String response = "";

		while (res.next()) {
			System.out.println(res.getInt("id")+"-- "+res.getString("wonby"));
		}
		return response;

	}

	private static int getTeamId(String name) throws SQLException {

		String query = "select * from teams where name='" + name + "'";
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(query);
		while (res.next()) {
			return res.getInt("id");
		}
		return 0;

	}
}
