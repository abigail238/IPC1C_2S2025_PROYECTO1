package proyecto1;

import java.io.IOException;
import java.util.Scanner;

public class Proyecto1 {

	private static String archivo = "inventario.txt";
	private static Inventario inv = new Inventario(100);

	public static void main(String[] args) throws IOException {

		inv.cargarDesdeArchivo(archivo);
		Scanner scanner = new Scanner(System.in);

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
			try {
				System.out.println("Digite un opcion: ");
				opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {

				case 1:
					agregarProducto(scanner);

					break;

				case 2:
					buscarProducto(scanner);

					break;

				case 3:
					eliminarProducto(scanner);

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

			} catch (Exception e) { // sirve para
				System.out.println(e.getMessage());
				System.out.println("Ocurrio un error al ejecutar el programa, vuelve a intentar mas tarde!");
			}

		}
	}

	public static void agregarProducto(Scanner scanner) throws IOException { // aqui estamo definiendo nuestos variable
		System.out.println("Agrega producto");

		System.out.println("Nombre del producto");
		String nombredelproducto = scanner.nextLine();

		System.out.println("Categoria");
		String categoria = scanner.nextLine();

		System.out.println("Precio");
		double precio = scanner.nextDouble();
		// Vamos a validar2
		if (precio <= 0) {
			throw new RuntimeException("El precio debe ser mayor a 0");
		}

		System.out.println("Cantidad en stock");
		int cantidadenstock = scanner.nextInt();
		if (cantidadenstock < 0) {
			throw new RuntimeException("La cantidad en stock debe ser mayor a cero.");
		}

		scanner.nextLine();
		
		System.out.println("Codigo unico del producto");
		String codigounicodelproducto = scanner.nextLine();
		if (inv.buscarProducto(codigounicodelproducto)) {
			throw new RuntimeException("El codigo ya existe");
		}

		Producto producto = new Producto(codigounicodelproducto,nombredelproducto,categoria,precio,cantidadenstock);

		inv.agregar(producto);
		inv.guardarEnArchivo(archivo);
	}



	public static void buscarProducto(Scanner scanner) {
		System.out.println("Ingresa el producto");

		System.out.println("Ingrese el codigo del producto");
		String codigo = scanner.nextLine();

		inv.buscarProducto(codigo);

	}

	public static void eliminarProducto(Scanner scanner) {
		System.out.println("Elimnar producto");

	}

	public static void generarProducto() {

	}

	public static void registrarProducto() {

	}

	public static void generarReportes() {

	}

	public static void verDatosDelEstudiante() {

		System.out.println("Estudiante");
		System.out.println("Nombre: Lorena Abigail Arrecis Martinez");

		System.out.println("Carnet: 202112134");

	}

	public static void bitacora() {
		inv.listar();
	}

	public static void salir() {

	}

}
