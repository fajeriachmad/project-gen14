package com.prodemy.web.dao;

import java.io.PrintWriter;
import java.sql.*;
import com.prodemy.web.model.Alien;

public class AlienDao {
	public Alien getAlien(int aid) {
		Alien a = new Alien();
//		 === dummy data ===
		/*
		a.setAid(101);
		a.setAname("Farrah");
		a.setTechnology("Java");
		*/
	
		
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/aliendb";
			String username = "postgres";
			String password = "@Samprengki88";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Statement st = conn.createStatement();
			System.out.println(aid);
//			jika aid bertipe varying char, maka gunakan :
//			ResultSet rs = st.executeQuery("SELECT * FROM alien WHERE aid=" + "'" + aid + "'");
			
			ResultSet rs = st.executeQuery("SELECT * FROM alien WHERE aid=" + aid);
			
			if (rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTechnology(rs.getString("technology"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return a;
	}
}
