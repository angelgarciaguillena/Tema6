package boletin1.ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio1 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin1\\ejercicio1\\NumerosReales.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar el numero*/
		double numero;
		
		/*Creamos una variable para almacenar la suma*/
		double suma = 0;
		
		/*Creamos una variable para almacenar la media*/
		double media;
		
		/*Creamos una variable que funcionara como contador*/
		int contador = 0;
		
		/*Creamos un try catch para lanzar un mensaje con el error en el caso de que se produzca*/
		try(Scanner sc = new Scanner(new FileReader(FICHERO))) {
			
			/*Creamos un bucle while para recorrer el archivo*/
			while(sc.hasNextDouble()) {
				
				/*Leemos el numero del archivo*/
				numero = sc.nextDouble();
				
				/*Sumamos el numero al total*/
				suma += numero;
				
				/*Sumamos 1 al contador*/
				contador++;
			}
			
			/*Calculamos la media*/
			media = suma/contador;
			
			/*Mostramos la suma total*/
			System.out.println("Suma total: " + suma);
			
			/*Mostramos la media*/
			System.out.println("Media aritmetica: " + media);
			
			/*Cerramos el Scanner*/
			sc.close();
			
		/*Mostramos el mensaje en caso de que se produzca el error*/
		} catch (FileNotFoundException e) {
			System.err.println("Error: No se encuentra el fichero " + e.getMessage());
		} 
	}
}