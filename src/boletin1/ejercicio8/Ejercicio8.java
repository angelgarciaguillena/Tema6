package boletin1.ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin1\\ejercicio8\\RegistroTemperatura.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable que almacene la opcion del usuario*/
		int opcion = 0;
		
		/*Creamos una variable que almacena la fecha de la temperatura*/
		String fecha;
		
		/*Creamos una variable que almacena la temperatura maxima*/
		int temperaturaMaxima;
		
		/*Creamos una variable que almacena la temperatura minima*/
		int temperaturaMinima;
		
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
			
			/*Si la opcion es 1 se registrara una nueva temperatura*/
			case 1 -> {
				
				/*Pedimos al usuario que introduzca la fecha de la temperatura*/
				System.out.println("Introduce la fecha de la temperatura");
				
				/*Leemos la fecha*/
				fecha = sc.nextLine();
				
				/*Pedimos al usuario que introduzca la temperatura maxima*/
				System.out.println("Introduce la temperatura maxima");
				
				/*Leemos la temperatura maxima*/
				temperaturaMaxima = sc.nextInt();
				
				/*Pedimos al usuario que introduzca la temperatura minima*/
				System.out.println("Introduce la temperatura minima");
				
				/*Leemos la temperatura minima*/
				temperaturaMinima = sc.nextInt();
				
				/*LLamamos a la funcion para escribir la informacion en el archivo*/
				escribirFichero(fecha, temperaturaMaxima, temperaturaMinima);
			}
			
			/*Si la opcion es 2 se mostraran los registros del archivo*/
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
		System.out.println("1. Registra nueva temperatura");
		System.out.println("2. Mostrar historial de registros");
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
	
	public static void escribirFichero(String fecha, int temperaturaMaxima, int temperaturaMinima) {
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			/*Hacemos un salto de linea*/
			bw.newLine();
			
			/*Escribimos la informacion en el fichero*/
			bw.write(fecha + "," + temperaturaMaxima + "," + temperaturaMinima);
			
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