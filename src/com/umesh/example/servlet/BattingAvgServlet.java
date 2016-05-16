package com.umesh.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.umesh.example.main.MySqlConnection;
import com.umesh.example.pojo.Batting_avg;

public class BattingAvgServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection connection = MySqlConnection.getConnection();
		Statement statement;

		List<Batting_avg> battingList = new ArrayList<>();
		try {
			System.out.println(req.getAttribute(""));
			System.out.println(req.getParameter("id"));
			statement = connection.createStatement();
			String teamId = req.getParameter("id");
			String playerName = req.getParameter("playerName");
			String query;
			if (playerName != null) {
				query = "select * from batting_avg where teamid=" + teamId
						+ " and player='" + playerName + "'";
			} else {
				query = "select * from batting_avg where teamid=" + teamId;
			}
			
//			Batting_avg pojo = new Batting_avg();
//			pojo.setAvg(0);
//			pojo.setBf(1);
//			pojo.setPlayer("Santhosh");
//			battingList.add(pojo);
			
			
			// execute insert SQL statement
			ResultSet res = statement.executeQuery(query);

			while (res.next()) {
				Batting_avg pojo = new Batting_avg();
				pojo.setFifty(res.getInt("fifty"));
				
				
				 battingList.add(pojo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = resp.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(new Gson().toJson(battingList));
		out.flush();
//		resp.setStatus(HttpServletResponse.SC_OK);
//		resp.getWriter().println(battingList);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Succe");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().println("<h1>Hello Servlet</h1>");
	}
}
