package proyecto1;


import java.io.IOException;
import java.util.Scanner;


public class Proyecto1 {

	private static String archivo = "inventario.txt";
	private static Inventario inv = new Inventario(100);
	

	public static void main(String[] args) throws IOException{

		inv.cargarDesdeArchivo(archivo);
		Scanner tienda = new Scanner(System.in);

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
				opcion = tienda.nextInt();
				tienda.nextLine();

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

			} catch (Exception e) { // sirve para
				System.out.println("");
				System.out.println("Vuelve a intentar, solo se permiten numeros");
				tienda.next();
			}

		}
	}

	public static void agregarProducto() throws IOException { // aqui estamo definiendo nuestos variable
		System.out.println("Agrega producto");
		String nombredelproducto = ""; // "" ESTO ES IGUAL A TEXTO VACIO
		String categoria = "";
		double precio = 0.0;
		int cantidadenstock = 0;
		String codigounicodelproducto = "";

		Scanner scanner = new Scanner(System.in); // cree un nuevo objato llamado scanner

		System.out.println("Nombre del producto");
		nombredelproducto = scanner.nextLine();
		System.out.println("Categoria");
		categoria = scanner.nextLine();
		System.out.println("Precio");
		precio = scanner.nextDouble();
		System.out.println("Cantidad en stock");
		cantidadenstock = scanner.nextInt();
		System.out.println("Codigo unico del producto");
		codigounicodelproducto = scanner.nextLine();

		Producto producto = new Producto();
		producto.setNombre(nombredelproducto);
		producto.setCategoria(categoria);
		producto.setPrecio(precio);
		producto.setCantidad(cantidadenstock);
		producto.setCodigo(codigounicodelproducto);
		
		// Vamos a validar 
		if (precio <=0) {
			System.out.println("El precio debe ser mayor a 0");
			return;
		}
		if (cantidadenstock < 0) {
			System.out.println("La cantidad no puede ser negativa");
			return;
		}
		if (existeCodigo(codigounicodelproducto)) {
			System.out.println("El codigo ya existe");
			return;
		}

		inv.agregar(producto);
		inv.guardarEnArchivo(archivo);
	}

	private static boolean existeCodigo(String codigounicodelproducto) {
		// TODO Auto-generated method stub
		return false;
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
