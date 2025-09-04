package proyecto1;

import java.util.InputMismatchException;
import java.util.Scanner;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class Proyecto1 {

	public static void main(String[] args) {
		
		
		

		/*
		 * public String agregarProducto; public String buscarProducto; public String
		 * eliminarProducto; public int registrarVenta; public double generarReportes;
		 * public
		 */

		Scanner tienda = new Scanner(System.in);

		tienda.useDelimiter("/n");

		int opcion = 0;

		while (opcion < 8) {

			System.out.println(" MENU ");

			System.out.println("1. AGREGAR PRODUCTO");

			System.out.println("2. BUSCAR PRODUCTO");

			System.out.println("3. ELIMINAR PRODUCTO");

			System.out.println("4. REGISTRAR VENTA ");

			System.out.println("5. GENERAR REPORTES");

			System.out.println("6. VER DATOS DEL ESTUDIANTE ");

			System.out.println("7. BITACORA");

			System.out.println("8. SALIR");

			opcion = tienda.nextInt();

			try {
				System.out.println("Digite una opcion");
				opcion = tienda.nextInt();
				String producto;
				int stock, stockActual;

				switch (opcion) {

				case 1:
					agregarProducto();
					break;

				case 2:
					buscarProducto();
					break;

				case 3:
					eliminarProducto();
					break;

				case 4:
					registrarProducto();
					break;
				case 5:
					generarReportes();
					break;

				case 6:
					verDatosDelEstudiante();
					break;

				case 7:
					bitacora();
					break;

				case 8:
					salir();
					break;

				default:
					break;

				}
			} catch (Exception e) {
				System.out.println("jhi");
			}

		}
	}

	public static void agregarProducto() { // aqui estamo definiendo nuestos variable

		int opcion= 0;
		while (opcion  <4) {
			
			System.out.println("Nombre del producto");
			System.out.println("Categoria");
			System.out.println("Precio");
			System.out.println("Cantidad en stock");
			System.out.println("Codigo unico del producto");
			
		}
		
		
		
		
		
	}

	public static void buscarProducto() {
		System.out.println("Ingresa el producto");
		
	}

	public static void eliminarProducto() {
		System.out.println("Elimnar producto");

	}

	public static void generarProducto() {

	}

	public static void registrarProducto() {

	}

	public static void generarReportes() {

	}

	public static void verDatosDelEstudiante() {

	}

	public static void bitacora() {

	}

	public static void salir() {

	}

}
