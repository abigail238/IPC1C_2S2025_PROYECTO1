package proyecto1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Proyecto1 {

	public static void main(String[] args) {
		
		
		

		/*
		 * public String agregarProducto; public String buscarProducto; public String
		 * eliminarProducto; public int registrarVenta; public double generarReportes;
		 * public
		 */
		HashMap<String,Integer> inventario=new HashMap<>();
		TreeMap<String, Integer> tree;

		static Scanner tienda = new Scanner(System.in);
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

			

			try {
				
				
				System.out.println("Digite un opcion: ");
				opcion = tienda.nextInt();
				
				String producto;
				int stock, stockActual;
				
				switch (opcion) {

				case 1:
					agregarProducto();
					producto = tienda.next();
					// si ya existe ese nombre
					if (inventario.containsKey(producto)) {
						System.out.println("No se ha podido ingresar el producto,ya existe.");
						
					}else {
						inventario.put(producto, 0);
						System.out.println("Se ha ingresado el producto");
					}
					
					break;

				case 2:
					buscarProducto();
					System.out.println("Ingrese el nombre del producto");
					producto =tienda.next();
					if (inventario.containsKey(producto)) {
						System.out.println("Digite la cantidad:");
						stock = tienda.nextInt();					
					// LE VAMOS A PREGUNTAR SI ESTA EN EN STOCK
					 
					if (stock > 0) {
						stockActual = inventario.get(producto);
						inventario.put(producto, stockActual + stock);
						System.out.println("Se ha ananido " + stock + " de stock sl producto " + producto + " ." );
				}else {
					System.out.println("No se puede agregar un stock negativo .");
				 }
				}else {
				System.out.println("No existe el producto. ");
				}
					break;

				case 3:
					eliminarProducto();
					if(inventario.containsKey(producto)) {
						System.out.println("Ingrese el producto a eliminar: ");
						producto = tienda.next();
						
						if (inventario.contains) {                                         // el producto es la llave 
							stockActual= inventario.get(producto); //estoy obteniendo el valr del maop
							if (stockActual> stock) {
								inventario.put(producto, stockActual - stock);    
									
							}else {
								System.out.println("No hay sufciente stock a eliminar");
							}
						}else {
								System.out.println("No hay podructo a eliminar");
						}
						
						
					}else {
						System.out.println("No existe el producto");
					}
					
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
				
			}catch (InputMismatchException excepcion) {  // sirve para 
				System.out.println("");
				System.out.println("Vuelve a intentar, solo se permiten numeros");
				tienda.next();
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
