package com.crud.productos;

import java.util.Date;

public class Productos {
	
	private String codArticulo;
	private String seccion;
	private String nombreArticulo;
	private double precio;
	private Date fecha;
	private String importado;
	
	public Productos(String codArticulo, String seccion, String nombreArticulo, double precio, Date fecha, String importado) {

		this.codArticulo = codArticulo;
		this.seccion = seccion;
		this.nombreArticulo = nombreArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
	}
	
	public Productos(String seccion, String nombreArticulo, double precio, Date fecha, String importado) {
		
		this.seccion = seccion;
		this.nombreArticulo = nombreArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
	}
	
	public Productos(String codArt) {

		this.codArticulo = codArt;
	}

	public String getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(String codArticulo) {
		this.codArticulo = codArticulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}


	@Override
	public String toString() {
		return "Productos [codArticulo=" + codArticulo + ", seccion=" + seccion + ", nombreArticulo=" + nombreArticulo
				+ ", precio=" + precio + ", fecha=" + fecha + ", importado=" + importado + "] \n";
	}
	
	
	

}
