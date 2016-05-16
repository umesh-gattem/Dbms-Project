package com.umesh.example.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class InsertData {

	static Connection connection = null;

	static String[] teams = { "Afghanistan", "Australia", "Bangladesh",
			"England", "India", "Ireland", "New Zealand", "Pakistan",
			"Scotland", "South Africa", "Sri Lanka", "United Arab Emirates",
			"West Indies", "Zimbabwe" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String folderPath = "C:/Users/administrator.RZT/AppData/Roaming/Skype/My Skype Received Files/avg";
		System.out
				.println("-------- MySQL JDBC Connection Testing ------------");

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

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			displayDirectoryContents(new File(folderPath));
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	private static void insertData(String player, int teamid, String matches,
			String inngs, String no, String runs, String highscore, String avg,
			String bf, String strikerate, int hundred, int fifty, int zero,
			int fours, int sixs) {
		//System.out.println("Inserting data");

		String insertTableSQL = "INSERT INTO batting_avg"
				+ "(player, teamid,matches,inngs,no,runs,highscore,avg,bf,strikerate,100s,50s,0s,4s,6s ) "
				+ "VALUES" + "('"
				+ player
				+ "',"
				+ teamid
				+ ","
				+ Integer.parseInt(matches)
				+ ","
				+ Integer.parseInt(inngs)
				+ ","
				+ Integer.parseInt(no)
				+ ","
				+ Integer.parseInt(runs)
				+ ",'"
				+ highscore
				+ "',"
				+ Float.parseFloat(avg)
				+ ","
				+ Integer.parseInt(bf)
				+ ","
				+ Float.parseFloat(strikerate)
				+ ","
				+ hundred
				+ ","
				+ fifty
				+ "," + zero + "," + fours + "," + sixs + ")";
		try {

			System.out.println(insertTableSQL);

			Statement statement = connection.createStatement();
			// execute insert SQL statement
			statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into batting_avg table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					//System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					//System.out.println("     file:" + file.getCanonicalPath());
					if (file.getName().contains("bat_avg")) {
						readFileAndInsertData(file);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readFileAndInsertData(File file) {
		BufferedReader reader = null;
		int teamId = 0;
		for (String team : teams) {
			if (file.getAbsolutePath().contains(team)) {
				teamId = getTeamIdByName(team);
			}
		}

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			int i = 0;
			while ((text = reader.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				} else {
					
					String a[] = text.replaceAll("\t", "~~")
							.replaceAll("  ", "~~").replaceAll("-", "0")
							.split("~~");
					int hundred = Integer.parseInt(a[9]);
					int fifty = Integer.parseInt(a[10]);
					int zero = Integer.parseInt(a[11]);
					int fours = Integer.parseInt(a[12]);
					int sixs = Integer.parseInt(a[13]);
					//System.out.println(a[9]);
					insertData(a[0], teamId, a[1], a[2], a[3], a[4], a[5],
							a[6], a[7], a[8], hundred, fifty, zero, fours, sixs);
				}
				i++;
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private static int getTeamIdByName(String team) {
		Statement statement;
		try {
			statement = connection.createStatement();
			// execute insert SQL statement
			String select = "select * from teams where name='" + team + "'";
			ResultSet res = statement.executeQuery(select);
			while (res.next()) {
				return res.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
