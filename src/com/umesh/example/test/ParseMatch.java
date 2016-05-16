package com.umesh.example.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ParseMatch {

	static String teams[] = { "AFGHANISTAN", "AUSTRALIA", "BANGLADESH",
			"ENGLAND", "INDIA", "IRELAND", "NEW ZEALAND", "PAKISTAN",
			"SCOTLAND", "SOUTH AFRICA", "SRI LANKA", "UNITED ARAB EMIRATES",
			"WEST INDIES", "ZIMBABWE" };
	static HashMap<String, Integer> team = new HashMap<>();
	private static Connection connection;
	static String[] venues = { "1--1--ADELAIDE", "2--1--MELBOURNE",
			"3--1--SYDNEY", "4--1--PERTH", "5--1--CANBERRA", "6--1--BRISBANE",
			"7--1--AUCKLAND", "8--2--CHRISTCHURCH", "9--2--HAMILTON",
			"10--2--HOBART", "11--2--WELLINGTON", "12--2--NAPIER",
			"13--2--NELSON", "14--2--DUNEDIN" };

	public static void main(String[] args) {

		BufferedReader reader = null;
		File file = new File(
				"C:\\Users\\administrator.RZT\\Desktop\\Matches.txt");
		team.put("AFGHANISTAN", 13);
		team.put("AUSTRALIA", 9);
		team.put("BANGLADESH", 11);
		team.put("ENGLAND", 12);
		team.put("INDIA", 1);
		team.put("IRELAND", 5);
		team.put("NEW ZEALAND", 8);
		team.put("PAKISTAN", 4);
		team.put("SCOTLAND", 14);
		team.put("SOUTH AFRICA", 2);
		team.put("SRI LANKA", 10);
		team.put("UNITED ARAB EMIRATES", 7);
		team.put("WEST INDIES", 3);
		team.put("ZIMBABWE", 6);
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
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			int i = 0;
			int teamA = 0, teamB = 0;
			int venue = 0;
			String date = null;
			String won = null;
			int scoreA = 0;
			int scoreB = 0;
			while ((text = reader.readLine()) != null) {
				if (i == 0) {
					String[] matches = text.split("\\(");
					String[] teamsPlayed = matches[0].split("VS");
					teamA = team.get(teamsPlayed[0].trim());
					teamB = team.get(teamsPlayed[1].trim());
					String venueString = matches[1].split("\\)")[0].trim();
					for (String v : venues) {
						if (venueString.contains(v.split("--")[2])) {
							venue = Integer.parseInt(v.split("--")[0]);
						}
					}
					date = matches[1].split("\\)")[1].trim();

				} else if (i == 1) {
					// System.out.println(text.split("WON")[0].replace(
					// " RECAP & HIGHLIGHTS ", "").trim());
					if (text.split("WON")[0]
							.replace(" RECAP & HIGHLIGHTS ", "").trim()
							.contains("MATCH ABANDONED WITHOUT A BALL BOWLED")) {
						won = "DRAW";

					} else {
						won = text.split("WON")[0].replace(
								" RECAP & HIGHLIGHTS ", "").trim();
					}

				} else if (i == 2) {
					if (text.split(" ")[0].split("/")[0].contains("-")) {
						scoreA = 0;
					} else
						scoreA = Integer
								.parseInt(text.split(" ")[0].split("/")[0]);
				} else if (i == 3) {

				} else if (i == 4) {
					if (text.split(" ")[0].split("/")[0].contains("-")) {
						scoreB = 0;
					} else
						scoreB = Integer
								.parseInt(text.split(" ")[0].split("/")[0]);
				} else if (i == 5) {

				}
				i++;
				if (i > 5) {
//					System.out.println(teamA + "--" + teamB + "--" + venue
//							+ "--" + date + "--" + won + "--" + scoreA + "--"
//							+ scoreB);
					String insertTableSQL = "INSERT INTO matches"
							+ "(date ,sid ,teamAid, teamBid, scoreA, scoreB, wonby,venue) "
							+ "VALUES" + "('" + date + "'," + 1 + "," + teamA
							+ "," + teamB + "," + scoreA

							+ "," + scoreB + ",'" + won + "'," + venue + ")";

					System.out.println(insertTableSQL+";");

					Statement statement;
//					try {
////						statement = connection.createStatement();
////						statement.executeUpdate(insertTableSQL);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					// execute insert SQL statement

					i = 0;
				}
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
}
