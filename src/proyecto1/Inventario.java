package proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Inventario {

	private Producto[] datos;
	private int tamanio;

	public Inventario(int tamanio) {
		this.datos = new Producto[tamanio];
		this.tamanio = tamanio;
	}

	public int getTamanio() {
		return tamanio;
	}

	public Producto get(int i) {
		return datos[i];
	}

	public void agregar(Producto p) {
		for (int i = 0; i < datos.length; i++) {// recorre el array
			if (datos[i] == null) {
				datos[i] = p;
				break;
			}
		}
	}

	public void guardarEnArchivo(String ruta) throws IOException {
	    File f = new File(ruta);

	    // Si no existe el archivo lo crea (FileWriter igual lo hace, pero explícito es más claro)
	    if (!f.exists()) {
	        f.createNewFile();
	        System.out.println("Archivo creado: " + f.getAbsolutePath());
	    }
	    
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
			for (int i = 0; i < datos.length; i++) { // recorre el array
				bw.write(datos[i].toLinea());
				bw.newLine();

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
		for (int i = 0; i < datos.length; i++) {// recorre el array
			datos[i] = null;
		}
	}

	public void listar() {
		for (int i = 0; i < datos.length; i++) {
			if(datos[i]!=null) {
				System.out.println(datos[i]);
			}

		}
	}

}
