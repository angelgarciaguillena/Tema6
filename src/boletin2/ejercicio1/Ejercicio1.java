package boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin2\\ejercicio1\\Carta.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la linea*/
		String linea;
		
		/*Creamos una variable para almacenar el numero de palabras*/
		int numeroPalabras = 0;
		
		/*Creamos una variable para almacenar el numero de caracteres*/
		int numeroCaracteres = 0;
		
		/*Creamos una variable para almacenar el numero de lineas*/
		int numeroLineas = 0;
		
		/*Creamos un array para almacenar las palabras de la frase*/
		String palabras[];
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			/*Leemos la linea del fichero*/
			linea = br.readLine();
			
			/*Creamos un bucle while para leer el fichero*/
			while (linea != null) {
				
				/*Almacenamos las palabras en el array*/
				palabras = linea.split(" ");
				
				/*Sumamos 1 al contador de lineas*/
				numeroLineas++;
				
				/*Sumamos los caracteres que tiene la frase*/
				numeroCaracteres += linea.length();
				
				/*Creamos un bucle for para recorrer el array y sumar las palabras al contador*/
				for (int i = 0; i < palabras.length; i++) {
					
					/*Sumamos 1 al contador de palabras*/
					numeroPalabras++;
				}
				
				/*Leemos la linea del fichero*/
				linea = br.readLine();
			}
			
			/*Cerramos el BufferedReader*/
			br.close();
		
		/*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se ha podido encontrar el fichero " + e.getMessage());
		
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		} catch (IOException e) {
			System.out.println("Error: No se ha podido leer el fichero " + e.getMessage());
		}
		
		/*Mostramos los caracteres, las lineas y las palabras*/
		System.out.println("Numero de caracteres: " + numeroCaracteres);
		System.out.println("Numero de lineas: " + numeroLineas);
		System.out.println("Numero de palabras: " + numeroPalabras);
	}
}