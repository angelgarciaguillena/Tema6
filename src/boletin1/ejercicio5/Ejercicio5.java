package boletin1.ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin1\\ejercicio5\\datos.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar el nombre del usuario*/
		String nombre;
		
		/*Creamos una variable para almacenar la edad*/
		int edad;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			/*Pedimos al usuario que introduzca el nombre*/
			System.out.println("Introduce el nombre");
			
			/*Leemos el nombre del usuario*/
			nombre = sc.nextLine();
			
			/*Pedimos al usuario que introduzca la edad*/
			System.out.println("Introduce la edad");
			
			/*Leemos la edad del usuario*/
			edad = sc.nextInt();
			
			/*Escribimos la edad y el nombre en el fichero*/
			bw.write(nombre + " " + edad);
			
			/*Hacemos un salto de linea en el fichero*/
			bw.newLine();
			
			/*Vaciamos el buffer*/
			bw.flush();
			
			/*Cerramos el BufferedWriter*/
			bw.close();
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido escribir en el archivo*/	
		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}
