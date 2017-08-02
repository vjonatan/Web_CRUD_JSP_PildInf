package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPrueba
 */

/**
 * Definir fuente o Datasource
 */

@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/productos")
	private DataSource miPool;
       
	
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Crear el objeto PrintWriter
		
		PrintWriter salida = response.getWriter();
		
		response.setContentType("text/plain");
		
		//crear conexion con la base de datos
		
		Connection conexion = null;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		try {
			
			conexion = miPool.getConnection();
			
			String sql = "SELECT * FROM PRODUCTOS";
			
			st = conexion.createStatement();
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				
				String nombreProducto = rs.getString(3);
				
				salida.println(nombreProducto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
