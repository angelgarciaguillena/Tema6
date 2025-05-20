package boletin2.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin2\\ejercicio2\\Firmas.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable que almacene la opcion del usuario*/
		int opcion = 0;
		
		/*Creamos una variable para almacenar la firma del usuario*/
		String firma;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un bucle do while para que se repita hasta que el usuario introduzca la opcion de salir*/
		do {
			
			/*Mostramos el menu lamando a la funcion*/
			menu();
			
			/*Pedimos al usuario que introduzca una opcion*/
			System.out.println("\n" + "Introduce una opcion");
			
			/*Leemos la opcion del usuario*/
			opcion = sc.nextInt();
			sc.nextLine();
			
			/*Creamos un switch para realizar una funcion dependiendo de la eleccion del usuario*/
			switch(opcion){
			
			/*Si la opcion es 1 se registrara una nueva firma*/
			case 1 -> {
				
				/*Pedimos al usuario que introduzca la firma*/
				System.out.println("Introduce la firma");
				
				/*Leemos la firma*/
				firma = sc.nextLine();
				
				/*LLamamos a la funcion para escribir la informacion en el archivo*/
				escribirFichero(firma);
			}
			
			/*Si la opcion es 2 se mostraran las firmas del archivo*/
			case 2 -> {
				leerFichero();
			}
			
			/*Si la opcion es 3 se le notifica al usuario que ha salido del programa*/
			case 3 -> {
				System.out.println("Has salido del programa");
			}
			
			/*Si no es ninguna de las opciones anteriores se le informa al usuario que la opcion introducida no es valida*/
			default -> {
				System.out.println("Opcion no valida");
			}
			}			
		}while(opcion != 3);
		
		/*Cerramos el Scanner*/
		sc.close();
	}
	
	public static void menu() {
		/*Mostramos el menu del programa al usuario*/
		System.out.println("\n" + "Menu:");
		System.out.println("1. Añadir firma");
		System.out.println("2. Mostrar firmas");
		System.out.println("3. Salir");
	}
	
	public static void leerFichero() {
		
		/*Creamos una variable para almacenar la cadena*/
		String cadena;
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			/*Leemos la linea del fichero*/
			cadena = br.readLine();
			
			/*Creamos un bucle do while para mostrar el contenido del fichero*/
			while(cadena != null) {
				
				/*Mostramos la linea del fichero*/
				System.out.println(cadena);
				
				/*Leemos la linea del fichero*/
				cadena = br.readLine();
			} 
			
			/*Cerramos el BufferedReader*/
			br.close();
				
		/*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero" + e.getMessage());
		
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero" + e.getMessage());
		}
	}
	
	public static void escribirFichero(String nombre) {
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			/*Escribimos la informacion en el fichero*/
			bw.write(nombre);
			
			/*Hacemos un salto de linea*/
			bw.newLine();
			
			/*Vaciamos el buffer y escribimos lo que nos quedaba*/
			bw.flush();
			
			/*Cerramos el BufferedWriter*/
			bw.close();
		
		/*Lanzamos un mensaje de error en caso de que no se haya podido escribir en el archivo*/
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el fichero" + e.getMessage());
		}
	}
}
