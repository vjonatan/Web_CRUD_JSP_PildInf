package com.crud.productos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource origenDatos;

	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productos = new ArrayList<>();
		
		Connection conexion = null;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		/****Creo la conexion****/
		
		conexion = origenDatos.getConnection();
		
		/****Creo la sentencia y statement****/
		
		String sql = "SELECT * FROM PRODUCTOS";
		st = conexion.createStatement();
		
		/*****Ejecuto sentencia sql****/
		
		rs = st.executeQuery(sql);
		
		while(rs.next()){
			
			String codProd = rs.getString(1);			
			String seccion = rs.getString(2);
			String nombProd = rs.getString(3);
			Double precio = rs.getDouble(4);
			Date fecha = rs.getDate(5);
			String importado = rs.getString(6);
			
			
			Productos tempProd = new Productos(codProd, seccion, nombProd, precio, fecha, importado);
			
			productos.add(tempProd);
			
		}
		
		return productos;
				
	}

	public void agregarProducto(Productos nuevoProducto){
		// TODO Auto-generated method stub
		
		Connection conexion = null;
		
		PreparedStatement st = null;
		
		ResultSet rs = null;
		try {
			/****Creo la conexion****/
			
			conexion = origenDatos.getConnection();
			
			/****Creo la sentencia y statement****/
			String sql = "INSERT INTO PRODUCTOS (codigoarticulo, seccion, nombrearticulo, precio, fecha, importado, foto)"
					+ "VALUES (?,?,?,?,?,?,"+"'66'"+")";
					
			st = conexion.prepareStatement(sql);
				
			/****Establecemos los parametros del producto ****/
			
			st.setString(1, nuevoProducto.getCodArticulo());
			
			st.setString(2, nuevoProducto.getSeccion());
			
			st.setString(3, nuevoProducto.getNombreArticulo());
			
			st.setDouble(4, nuevoProducto.getPrecio());
			
			java.util.Date fechaDate = nuevoProducto.getFecha();
			
			java.sql.Date fechaConvertida = new java.sql.Date(fechaDate.getTime());
			
			st.setDate(5, fechaConvertida);
			
			st.setString(6, nuevoProducto.getImportado());
			
			/*****Ejecuto sentencia sql****/
			
			st.execute();					
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	public Productos getProducto(String codigoArticulo) throws Exception {
		// TODO Auto-generated method stub
		
		Productos prod = null;
		
		Connection conexion = null;
		
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		String cArticulo = codigoArticulo;
		
		try {
		
			/****Creo la conexion****/
			
			conexion = origenDatos.getConnection();
			
			
			/****Creo la sentencia y statement****/
			
			String sql = "SELECT * FROM PRODUCTOS WHERE codigoarticulo = ?";
			
			st = conexion.prepareStatement(sql);
			
			st.setString(1, cArticulo);		
			
			
			/*****Ejecuto sentencia sql****/
			
			rs = st.executeQuery();
			
			if(rs.next()){
				
				String codProd = rs.getString(1);			
				String seccion = rs.getString(2);
				String nombProd = rs.getString(3);
				Double precio = rs.getDouble(4);
				Date fecha = rs.getDate(5);
				String importado = rs.getString(6);
				
				
				prod = new Productos(codProd, seccion, nombProd, precio, fecha, importado);
			
			}else {
				throw new Exception("No se ha encontrado el producto seleccionado " + cArticulo);
			}	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puedo recuperar producto cod: " + cArticulo);
			System.out.println("Error: " + e.getMessage());
		}		
		
		return prod;
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conexion = null;
		
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			/****Creo la conexion****/
			
			conexion = origenDatos.getConnection();
			
			/****Creo la sentencia y statement****/
			String sql = "UPDATE PRODUCTOS SET seccion = ?,"
										+ "nombrearticulo = ?,"
										+ "precio = ?,"
										+ "fecha = ?,"
										+ "importado = ?"
										+ "WHERE codigoarticulo = ?";
					
			st = conexion.prepareStatement(sql);
				
			/****Establecemos los parametros del producto ****/			
			
			st.setString(1, productoActualizado.getSeccion());
			
			st.setString(2, productoActualizado.getNombreArticulo());
			
			st.setDouble(3, productoActualizado.getPrecio());
			
			java.util.Date fechaDate = productoActualizado.getFecha();
			
			java.sql.Date fechaConvertida = new java.sql.Date(fechaDate.getTime());
			
			st.setDate(4, fechaConvertida);
			
			st.setString(5, productoActualizado.getImportado());
			
			st.setString(6, productoActualizado.getCodArticulo());
			
			/*****Ejecuto sentencia sql****/
			
			st.execute();					
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
						
	}

	public void eliminarProducto(String codProd) {
		// TODO Auto-generated method stub
		
		Connection conexion = null;
		
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			/****Creo la conexion****/
			
			conexion = origenDatos.getConnection();
			
			/****Creo la sentencia y statement****/
			
			String sql = "DELETE FROM PRODUCTOS "
								+ "WHERE codigoarticulo = ? ";
					
			st = conexion.prepareStatement(sql);
				
			
			/****Establecemos los parametros del producto ****/			
			
			st.setString(1, codProd);

			
			/*****Ejecuto sentencia sql****/
			
			st.execute();					
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}								
		
	}
	
}
