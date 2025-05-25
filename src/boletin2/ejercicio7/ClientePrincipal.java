package boletin2.ejercicio7;

import java.util.Scanner;

public class ClientePrincipal {
	
	/*Creamos el Scanner*/
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*Creamos una variable que almacenara la opcion del usuario*/
		int opcion = 0;
		
		/*Creamos una variable para almacemnar el dni del cliente*/
		String dni;
		
		/*Creamos un cliente*/
		Cliente cliente = null;
		
		/*LLamamos a la funcion para cargar a los pacientes que teniamos registrados
		 * en el fichero y si no se puede realizar se le notifica al usuario*/
		if(GestionFicheroCliente.leerFichero()) {
			System.out.println("Se han cargado a los pacientes");
		} else {
			System.out.println("No se ha podido cargar a los pacientes");
		}
		
		/*Creamos un bucle do while para que se repita el programa mientras que 
		 * el usuario no introduzca 4*/
		do {
			
			/*LLamamos a la funcion para mostrar el menu*/
			menu();
			
			/*Pedimos al usuario que introduzca una opcion*/
			System.out.println("Introduce una opcion");
			
			/*Leemos la opcion del usuario*/
			opcion = sc.nextInt();
			sc.nextLine();
			
			/*Creamos un switch para que depende de la opcion que introduzca el usuario se
			 * realice una funcion u otra*/
			switch(opcion) {
			
			/*Si la opcion es 1 añadimos a un nuevo cliente*/
			case 1 -> {
				
				/*LLamamosa a la funcion para pedir al usuario los datos del cliente*/
				cliente = pedirCliente();
				
				/*Si el cliente no es nulo*/
				if(cliente != null) {
					
					/*Llamamos a la funcion para añadir al cliente*/
					if(ClienteCRUD.añadirCliente(cliente)) {
						System.out.println("El cliente se ha añadido");
						
					} else {
						System.out.println("No se ha podido añadir al cliente");
					}
				}
			}
			
			/*Si la opcion es 2 eliminamos a un cliente*/
			case 2 -> {
				
				/*Pedimos el dni del cliente al usuario llamando a la funcion*/
				dni = pedirDNI();
				
				/*Creamos un nuevo cliente*/
				cliente = new Cliente(dni);
				
				/*Llamamos a la funcion para eliminar al cliente y notificamos el resultado al usuario*/
				if(ClienteCRUD.eliminarCliente(cliente)) {
					System.out.println("Se ha eliminado al cliente");
					
				} else {
					System.out.println("No se ha podido eliminar al cliente");
				}
			}
			
			/*Si la opcion es 3 mostramos a todos los clientes*/
			case 3 -> {
				
				/*Llamamos a la funcion para mostrar a los clientes*/
				System.out.println("\n" + "Clientes:" + "\n");
				ClienteCRUD.mostrarCliente();
			}
			
			/*Si la opcion es 4 se informara al usuario de que ha salido del programa*/
			case 4 -> {
				System.out.println("Has salido del programa");
			}
			
			/*Si no es ninguna de las opciones anteriores la opcion que ha elegido el 
			 * usuario no sera valida*/
			default -> {
				System.out.println("Opcion no valida");
			}
			}
		}while(opcion != 4);
		
		/*LLamamos a la funcion para guardar a los nuevos clientes en el fichero*/
		if(GestionFicheroCliente.escribirFichero()) {
			System.out.println("Se han guardado a los clientes");
		} else {
			System.out.println("No se ha podido guardar a los clientes");
		}
		
		/*Cerramos el Scanner*/
		sc.close();
	}
	
	private static void menu() {
		/*Mostramos el menu de gestion de pacientes al usuario*/
		System.out.println("\n" + "Menu:");
		System.out.println("1. Alta cliente");
		System.out.println("2. Baja cliente");
		System.out.println("3. Listar clientes");
		System.out.println("4. Salir");
	}
	
	private static Cliente pedirCliente() {
		
		/*Creamos una variable para almacemnar el dni del cliente*/
		String dni;
		
		/*Creamos una variable para almacenar el nombre del cliente*/
		String nombre;
		
		/*Creamos una variable para almacenar la fecha de nacimiento del cliente*/
		String fechaNacimiento;
		
		/*Creamos una variable para almacenar el saldo del cliente*/
		double saldo;
		
		/*Creamos un cliente*/
		Cliente cliente = null;
		
		/*Pedimos al usuario que introduzca el dni del cliente*/
		System.out.println("Introduce el dni del cliente");
		
		/*Leemos el dni del cliente*/
		dni = sc.nextLine();
		
		/*Pedimos al usuario que introduzca el nombre del cliente*/
		System.out.println("Introduce el nombre del cliente");
		
		/*Leemos el nombre del cliente*/
		nombre = sc.nextLine();
		
		/*Pedimos al usuario que introduzca la fecha de nacimiento del cliente*/
		System.out.println("Introduce la fecha de nacimiento del cliente");
		
		/*Leemos la fecha de nacimiento del cliente*/
		fechaNacimiento = sc.nextLine();
		
		/*Pedimos al usuario que introduzca el saldo del cliente*/
		System.out.println("Introduce el saldo del cliente");
		
		/*Leemos el saldo del cliente*/
		saldo = sc.nextDouble();
		sc.nextLine();
		
		/*Creamos un nuevpo cliente*/
		cliente = new Cliente(dni, nombre, fechaNacimiento, saldo);
		
		/*Devolvemos al cliente*/
		return cliente;
	}
	
	private static String pedirDNI() {
		
		/*Creamos una variable para almacemnar el dni del cliente*/
		String dni;
		
		/*Pedimos al usuario que introduzca el dni del cliente*/
		System.out.println("Introduce el dni del cliente");
		
		/*Leemos el dni del cliente*/
		dni = sc.nextLine();
		
		/*Devolvemos el dni del cliente*/
		return dni;
	}
}