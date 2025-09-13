package proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inventario {

	private Producto[] productos;

	public Inventario(int tamanio) {
		this.productos = new Producto[tamanio];
	}

	public Producto getProducto(int i) {
		return productos[i];
	}

	public void agregar(Producto p) {
		for (int i = 0; i < productos.length; i++) {// recorre el array
			if (productos[i] == null) {
				productos[i] = p;
				break;
			}
		}
	}

	public boolean buscarProducto(String codigo) {

		boolean encontrado = false;
		for (int i = 0; i < productos.length; i++) {
			Producto p = productos[i];

			if (p != null && p.getCodigo().equalsIgnoreCase(codigo)) {
				System.out.println("Producto encontrado");
				System.out.println(p);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No se encontro ningun producto con ese codigo");
		}

		return encontrado;
	}

	public void guardarEnArchivo(String ruta) throws IOException {
		File f = new File(ruta);

		// Si no existe el archivo lo crea (FileWriter igual lo hace, pero explícito es
		// más claro)
		if (!f.exists()) {
			f.createNewFile();
			System.out.println("Archivo creado: " + f.getAbsolutePath());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
			for (int i = 0; i < productos.length; i++) { // recorre el array
				if (productos[i] != null) {
					bw.write(productos[i].toLinea());
					bw.newLine();
				}
			}
		}
	}

	/** Carga desde texto (reemplaza contenido) */
	public void cargarDesdeArchivo(String ruta) throws IOException {
		File f = new File(ruta);

		// Validar si existe
		if (!f.exists()) {
			System.out.println("El archivo no existe: " + ruta);
			return;
		}

		// Validar si está vacío
		if (f.length() == 0) {
			System.out.println("El archivo está vacío: " + ruta);
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			vaciar();
			while ((linea = br.readLine()) != null) {
				if (linea.trim().isEmpty())
					continue;
				agregar(Producto.fromLinea(linea));
			}
		}
	}

	public void vaciar() {
		for (int i = 0; i < productos.length; i++) {// recorre el array
			productos[i] = null;
		}
	}

	public void listar() {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null) {
				System.out.println(productos[i]);
			}

		}
	}

	public void eliminarProducto(String codigo) {
		int eliminar = -1;
		for (int i = 0; i < productos.length; i++) {
			Producto p = productos[i];

			if (p != null && p.getCodigo().equalsIgnoreCase(codigo)) {
				System.out.println("Producto eliminado");
				System.out.println(p);
				productos[i] = null;
				eliminar = i;
				break;
			}
		} // si no existe
		if (eliminar == -1) {
			System.out.println("No se encontro ningun producto con ese codigo");
		
		}
	
	}
}
