package boletin1.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio7 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin1\\ejercicio7\\Agenda.txt";
	
	/*Creamos un diccionario para almacenar los contactos*/
	public static Map<String, Integer> contactos = new TreeMap<>();
	
	/*Creamos el Scanner*/
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la opcion del usuario*/
		int opcion;
		
		/*Creamos una variable para almacenar el nombre del contacto*/
		String nombre;
		
		/*Creamos una variable para almacenar el telefono del contacto*/
		int telefono;

		/*Leemos el fichero llamando a la funcion*/
		leerFichero();

		/*Creamos un bucle do while para que el usuario siga hasta que quiera salir del bucle*/
		do {
			
			/*Mostramos el menu llamando a la funcion*/
			menu();
			
			/*Pedimos al usuario que introduzca una opcion*/
			System.out.println("Introduce una opcion");
			
			/*Leemos la opcion del usuario*/
			opcion = sc.nextInt();
			
			/*Vaciamos el buffer*/
			sc.nextLine();
			
			/*Creamos un switch para que depende de la opcion del usuario se realize una accion*/
			switch (opcion) {
			
			/*Si la opcion es 1 añadimos un nuevo contacto*/
			case 1 -> {
				
				/*Si se ha añadido el contacto se le notifica al usuario y si no se ha podido añadir tambien se le notifica*/
				if(añadirContacto()) {
					System.out.println("Se ha añadido el contacto");
				} else {
					System.out.println("No se ha podido añadir el contacto");
				}
			}
			
			/*Si la opcion es 2 buscamos un contacto*/
			case 2 -> {
				
				/*Pedimos el nombre al usuario llamando a la funcion*/
				nombre = pedirNombre();
				
				/*Si el contacto se encuentra obtenemos y mostramos su telefono si no se le notifica al usuario*/
				if (contactos.containsKey(nombre)) {
					
					/*Obtenemos el telefono de los contactos*/
					telefono = contactos.get(nombre);
					
					/*Mostramos el telefono al usuario*/
					System.out.println("El teléfono de " + nombre + " es " + telefono);
					
				} else {
					System.out.println("El nombre introducido no es correcto");
				}
			}
			
			/*Si la opcion es 3 mostramos todos los contactos*/
			case 3 -> {
				
				/*Creamos un bucle for para mostrar los contactos*/
				for (String nombreContacto : contactos.keySet()) {
					System.out.println(nombreContacto + ": " + contactos.get(nombreContacto));
				}
			}
			
			/*Si la opcion es 4 informamos al usuario de que ha salido del programa*/
			case 4 -> {
				System.out.println("Has salido del programa");
			}
			
			/*Si no es ninguna de las opciones anteriores informamos al usuario de que la opcion no es valida*/
			default -> {
				System.out.println("Opción no valida");
			}
			}
		} while (opcion != 4);
		
		/*Actualizamos el fichero llamando a la funcion*/
		escribirFichero();
		
		/*Cerramos el Scanner*/
		sc.close();
	}
	
	public static void menu() {
		/*Mostramos el menu del programa al usuario*/
		System.out.println("Menu:");
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
	}

	public static void leerFichero() {
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			/*Creamos una variable para almacenar la linea*/
			String linea;
			
			/*Creamos una tabla que almacenara los datos*/
			String[] datos;
						
			/*Leemos la linea*/
			linea = br.readLine();
			
			/*Creamos un bucle while para leer el archivo*/
			while (linea != null) {
				
				/*Almacenamos los datos en el array*/
				datos = linea.split(" ");
				
				/*Añadimos los datos al mapa*/
				contactos.put(datos[0], Integer.parseInt(datos[1]));
				
				/*Leemos la linea*/
				linea = br.readLine();
			}
			
			/*Cerramos el BufferedReader*/
			br.close();
			
		/*Creamos el archivo en caso de que no se haya podido encontrar*/
		} catch (FileNotFoundException e) {
		
			/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
			try {
				/*Creamos un File Writer para crear el archivo*/
				FileWriter fw = new FileWriter(FICHERO);
				
				/*Cerramos el File Writer*/
				fw.close();
				
			/*Lanzamos un mensaje de error en caso de que no se haya podido crear el archivo*/
			} catch (IOException e1) {
				System.out.println("Error: No se ha podido crear el fichero: " + e1.getMessage());
			}
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero" + e.getMessage());
		}
	}
	
	public static void escribirFichero() {
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			
			/*Creamos un bucle for para recorrer el diccionario*/
			for (String nombre : contactos.keySet()) {
				
				/*Escribimos el contacto en el fichero*/
				bw.write(nombre + " " + contactos.get(nombre));
				
				/*Hacemos un salto de linea en el fichero*/
				bw.newLine();
			}
			
			/*Vaciamos el buffer y escribimos lo que nos quedaba*/
			bw.flush();
			
			/*Cerramos el BufferedWriter*/
			bw.close();
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido escribir en el archivo*/
		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero: " + e.getMessage());
		}
	}

	public static boolean añadirContacto() {
		
		/*Creamos una variable para almacenar el nombre del contacto*/
		String nombre;
		
		/*Creamos una variable para almacenar el telefono del contacto*/
		int telefono;
		
		/*Creamos una variable para almacenar si se ha realizado o no*/
		boolean realizado = false;
		
		/*Pedimos el nombre al usuario llamando a la funcion*/
		nombre = pedirNombre();
		
		/*Pedimos el telefono al usuario*/
		System.out.println("Introduzca el teléfono:");
		
		/*Leemos el telefono que ha introducido el usuario*/
		telefono = sc.nextInt();
		
		/*Si los contactos no son mas de 20 y el telefono y nombre no estan en el diccionario añadimos el contacto*/
		if (contactos.size() < 20 && !contactos.containsKey(nombre)) {
			contactos.put(nombre, telefono);
			realizado = true;
		}
		
		/*Devolvemos si se ha realizado o no*/
		return realizado;
	}

	private static String pedirNombre() {
		
		/*Creamos una variable para almacenar el nombre del contacto*/
		String nombre;
		
		/*Pedimos al usuario que introduzca el nombre*/
		System.out.println("Introduzca el nombre:");
		
		/*Leemos el nombre que ha introducido el usuario*/
		nombre = sc.nextLine();
		
		/*Devolvemos el nombre*/
		return nombre;
	}
}