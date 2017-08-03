package com.crud.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/productos")
	private DataSource miPool;
	
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			modeloProductos = new ModeloProductos(miPool);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new ServletException(e);
			
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String datoOculto = request.getParameter("instruccion");
		
		//sino se envia el parametro, listo los productos
		if (datoOculto == null) datoOculto = "listar";
		
		try {
			switch (datoOculto) {
			case "listar":
				obtenerProductos(request, response);
				break;
				
			case "insertarBBDD":
				
				agregarProducto(request, response);
				break;
				
			case "cargar":
				cargarProductos(request, response);
				break;
				
			case "actualizarBBDD":
				actualizarProducto(request, response);
				break;
				
			case "eliminarBBDD":
				eliminarProducto(request, response);
				break;
	
			default:
				obtenerProductos(request, response);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}



	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// leer el producto que viene del formulario
		String codArt = request.getParameter("codArticulo");
		
		
		// crear objeto producto para actualizar
		Productos productoEliminar = new Productos(codArt);
		
		
		// enviar al modelo el objeto y actualizar el producto
		try {
			modeloProductos.eliminarProducto(productoEliminar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// mostrar listado de productos
		obtenerProductos(request, response);
		
	}



	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// leer el producto que viene del formulario
		String codArt = request.getParameter("codArticulo");
		
		String seccion = request.getParameter("seccion");
		
		String nombreArt = request.getParameter("nombreArticulo");
		
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null;
		
		try {
			fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String importado = request.getParameter("importado");
		
		
		// crear objeto producto para actualizar
		Productos productoActualizado = new Productos(codArt, seccion, nombreArt, precio, fecha, importado);
		
		
		// enviar al modelo el objeto y actualizar el producto
		try {
			modeloProductos.actualizarProducto(productoActualizado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// mostrar listado de productos
		obtenerProductos(request, response);
		
	}



	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//leer el producto que viene por parametro
		String codigoArticulo = request.getParameter("CArticulo");
		
		
		//enviar el CArticulo al modelo
		Productos prod = null;
		
		try {
			
			prod = modeloProductos.getProducto(codigoArticulo);
		
			//colocar atributo correspondiente al CArticulo
			request.setAttribute("ProductoActualizar", prod);
			
			
			//enviar producto al formulario de actualizar (jsp)
			RequestDispatcher rd = request.getRequestDispatcher("/actualizar_producto.jsp");
			
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		//leer informacion del producto enviado
		String codArt = request.getParameter("codArticulo");
		
		String seccion = request.getParameter("seccion");
		
		String nombreArt = request.getParameter("nombreArticulo");
		
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null;
		
		try {
			fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String importado = request.getParameter("importado");
		
		
		//crear un objeto del tipo Producto
		
		Productos nuevoProducto = new Productos(codArt, seccion, nombreArt, precio, fecha, importado);
		
		
		//enviar al modelo el objeto y registrarlo en la BBDD
		
		modeloProductos.agregarProducto(nuevoProducto);
		
		
		//volver al listado de Productos
		
		obtenerProductos(request, response);
		
	}



	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// obtener la lista de producto del modelo
		
		List<Productos> productos;
		
		try{
			
			productos = modeloProductos.getProductos();
		
		// agregar lista de productos al request
			
			request.setAttribute("LISTAPRODUCTOS", productos);		
		
		// enviar el request a la pagina JSP
			
			RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("/listaProductos.jsp");
			
			miRequestDispatcher.forward(request, response);
		
		}catch (Exception e){
			
			e.printStackTrace();
			
		}		
		
	}

}
