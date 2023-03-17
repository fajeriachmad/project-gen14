package com.prodemy.web.dao;

import java.awt.Taskbar.State;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.eclipse.jdt.internal.compiler.ast.TryStatement;

import com.prodemy.web.model.Dosen;

public class DosenDao {
	String driver = "org.postgresql.Driver";
	String url = "jdbc:postgresql://localhost:5432/mahasiswa";
	String username = "postgres";
	String password = "@Samprengki88";

	private static final String INSERT_DOSEN = "INSERT INTO dosen VALUES" + "(NEXTVAL('dosen_sequence'), ?);";
	private static final String SELECT_DOSEN = "SELECT * FROM dosen WHERE kode_dosen=?;";
	private static final String SELECT_ALL_DOSEN = "SELECT * FROM dosen ORDER BY kode_dosen ASC;";
	private static final String UPDATE_DOSEN = "UPDATE dosen SET nama=? WHERE kode_dosen=?;";
	private static final String DELETE_DOSEN = "DELETE FROM dosen WHERE kode_dosen=?;";
	
	public DosenDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// insert dosen
	public void insertDosen(Dosen dosen) {
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(INSERT_DOSEN);
			st.setString(1, dosen.getNama());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// select dosen by kode_name
	public Dosen selectDosen(int id) {
//		Dosen dosen = new Dosen();
		Dosen dosen = null;
		
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(SELECT_DOSEN);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
//				dosen.setId(rs.getInt("kode_dosen"));
//				dosen.setNama(rs.getString("nama"));
				
				String nama = rs.getString("nama");
				dosen = new Dosen(id, nama);
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dosen;
	}
	
	// select dosen	
	public List<Dosen> selectAllDosen() {
		List<Dosen> dosen = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(SELECT_ALL_DOSEN);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("kode_dosen");
				String nama = rs.getString("nama");
				dosen.add(new Dosen(id, nama));
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dosen;
	}
	
	
	// update dosen
	public boolean updateDosen(Dosen dosen) {
		
		boolean rowUpdated = false;
		
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(UPDATE_DOSEN);
			
			st.setString(1, dosen.getNama());
			st.setInt(2, dosen.getId());
			
			rowUpdated = st.executeUpdate() > 0;
			
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rowUpdated;
	}
	
	// delete dosen
	public boolean deleteDosen(int id) {
		boolean rowDeleted = false;
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(DELETE_DOSEN);
			st.setInt(1, id);
			rowDeleted = st.executeUpdate() > 0;
			
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
