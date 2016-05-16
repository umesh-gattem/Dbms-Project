package com.umesh.example.servlet;

import java.io.IOException;
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

import com.umesh.example.main.MySqlConnection;
import com.umesh.example.pojo.Teamspojo;

public class TeamsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection connection = MySqlConnection.getConnection();
		Statement statement;
		try {
			System.out.println(req.getAttribute(""));
			System.out.println(req.getParameter("id"));
			statement = connection.createStatement();
			// execute insert SQL statement
			String select = "select * from teams";
			ResultSet res = statement.executeQuery(select);
			List<Teamspojo> teams = new ArrayList<>();
			while (res.next()) {
				Teamspojo pojo = new Teamspojo();
//				pojo.setLost(res.getS);
//				pojo.setMatches(matches);
//				pojo.setPoints(points);
//				pojo.setRunrate(runrate);
//				pojo.setTied(tied);
//				pojo.setWon(won);
//				pojo.setTeams(teams);
//				teams.add(arg0)
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().println("<h1>Hello Servlet</h1>");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Succe");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().println("<h1>Hello Servlet</h1>");
	}
}
