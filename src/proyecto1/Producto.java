package proyecto1;

import java.io.*;

public class Producto {
	String codigo1;
	String nombre;
	String categoria;
	double precio;
	int cantidad;

	public Producto(String codigo, String nombre, String categoria, double precio, int cantidad) {
		this.codigo1 = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Producto() {}
	public String toLinea() {
		return codigo1 + "|" + nombre + "|" + categoria + "|" + precio + "|" + cantidad;
	}

	// Reconstruye línea -> objeto
	public static Producto fromLinea(String linea) {
		String[] p = linea.split("\\|");
		return new Producto(p[0], p[1], p[2], Double.parseDouble(p[3]), Integer.parseInt(p[4]));
	}

	@Override // para que imprima
	public String toString() {
		return "Producto:\n" + "  Código   : " + codigo1 + "\n" + "  Nombre   : " + nombre + "\n" + "  Categoría: "
				+ categoria + "\n" + "  Precio   : " + precio + "\n" + "  Cantidad : " + cantidad;
	}
	


	public String getCodigo() {
		return codigo1;
	}

	public void setCodigo(String codigo) {
		this.codigo1 = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
