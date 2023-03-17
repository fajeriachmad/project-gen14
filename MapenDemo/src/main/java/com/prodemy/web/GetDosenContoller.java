package com.prodemy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodemy.web.dao.DosenDao;
import com.prodemy.web.model.Dosen;

@WebServlet("/MyServlet")
/**
 * Servlet implementation class GetDosenContoller
 */
public class GetDosenContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DosenDao dao;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		dao = new DosenDao();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
    public GetDosenContoller() {
        super();
        // TODO Auto-generated constructor stub
    }
    */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		//		String action = request.getServletPath();
		
		String action = request.getParameter("action");
			
		try {
			switch (action) {
			
			case "new":
				showNewForm(request, response);
				break;
				
			case "insert":
				insertDosen(request, response);
				break;
				
			case "delete":
				deleteDosen(request, response);
				break;
				
			case "edit":
				showEditForm(request, response);
				break;
				
			case "update":
				updateDosen(request, response);
				break;
				
			default:
				daftarDosen(request, response);
				break;	
		}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	private void daftarDosen(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Dosen> daftarDosen = dao.selectAllDosen();
			request.setAttribute("daftarDosen", daftarDosen);
			RequestDispatcher rd = request.getRequestDispatcher("dosen-list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insert-form.jsp");
		rd.forward(request, response);
	}	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Dosen existingDosen = dao.selectDosen(id);

		RequestDispatcher rd = request.getRequestDispatcher("update-form.jsp");
		request.setAttribute("dosen", existingDosen);
		rd.forward(request, response);
	}
	
	private void insertDosen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nama = request.getParameter("nama");
		Dosen newDosen = new Dosen(nama);
		dao.insertDosen(newDosen);
//		response.sendRedirect("kemanaajadeh");
		daftarDosen(request, response);
	}
		
	private void updateDosen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nama = request.getParameter("nama");
		Dosen dosen = new Dosen(id, nama);
		dao.updateDosen(dosen);
//		response.sendRedirect("kemanaajadeh");
		daftarDosen(request, response);
	}
	
	private void deleteDosen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteDosen(id);
//		response.sendRedirect("kemanaajadeh");
		daftarDosen(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
