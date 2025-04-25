package boletin1.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin1\\ejercicio4\\Palabras.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar las palabras que introduce el usuario*/
		String palabra = "";
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			/*Creamos un bucle do while para que mientras la palabra sea diferente a fin que se repita*/
			do {
				
				/*Pedimos al usuario que introduzca una palabra*/
				System.out.println("Introduce una palabra");
				
				/*Leemos la palabra del usuario*/
				palabra = sc.nextLine();
				
				/*Escribimos la palabra en el archivo*/
				bw.write(palabra);
				
				/*Hacemos un salto de linea en el archivo*/
				bw.newLine();
				
			}while(!palabra.equalsIgnoreCase("fin"));
			
			/*Vaciamos el buffer*/
			bw.flush();
			
			/*Cerramos el BufferedWritter*/
			bw.close();
			/*Lanzamos un mensaje de error en caso de que no se haya podido escribir en el archivo*/	
		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		} 
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}