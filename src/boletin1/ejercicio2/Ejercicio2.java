package boletin1.ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar el numero*/
		int numero;
		
		/*Creamos una variable para almacenar la suma*/
		int suma = 0;
		
		/*Creamos una variable para almacenar la media*/
		int media;
		
		/*Creamos una variable que servira como contador*/
		int contador = 0;
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(Scanner sc = new Scanner(new FileReader("src\\boletin1\\ejercicio2\\Enteros"))) {
			
			/*Creamos un bucle while para leer el archivo */
			while(sc.hasNextInt()) {
				
				/*Leemos el numero del archivo*/
				numero = sc.nextInt();
				
				/*Sumamos el numero al total*/
				suma += numero;
				
				/*Sumamos 1 al contador*/
				contador++;
			}
			
			/*Calculamos la media*/
			media = suma / contador;
			
			/*Mostramos la suma*/
			System.out.println("Suma total: " + suma);
			
			/*Mostramos la media*/
			System.out.println("Media aritmetica: " + media);
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer el archivo*/	
		} catch (FileNotFoundException e) {
			System.err.println("Error: No se encuentra el fichero " + e.getMessage());
		}
	}
}