package boletin1.ejercicio6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
	
	public static void main(String[] args) {
		
		/*Creamos una lista para almacenar los numeros*/
		List<Integer> numeros;
		
		/*Llamamos a la funcion para leer el fichero*/
		numeros = leerNumeros();
		
		/*Ordenamos los numeros*/
		Collections.sort(numeros);
		
		/*Escribimos los numeros en el archivo llamando a la funcion*/
		escribirNumeros(numeros);		
	}
	
	public static List<Integer> leerNumeros() {
		
		/*Creamos una lista para almacenar los numeros*/
		List<Integer> numeros = new ArrayList<Integer>();
	
		/*Creamos una constante para almacenar el fichero de lectura*/
		String FICHERO_LECTURA = "src\\boletin1\\ejercicio6\\NumerosDesordenados.txt";
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(Scanner sc = new Scanner(new FileReader(FICHERO_LECTURA))) {
			
			/*Creamos un bucle while para leer el archivo*/
			while(sc.hasNextInt()) {
				
				/*Añadimos el numero a la lista*/
				numeros.add(sc.nextInt());
			}
			
			/*Cerramos el Buffered Reader*/
			sc.close();
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/	
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo " + e.getMessage());
		} 
		
		/*Devolvemos la lista*/
		return numeros;
	}
	
	public static void escribirNumeros(List<Integer> numeros) {
		
		/*Creamos una constante para almacenar el fichero de escritura*/
		String FICHERO_ESCRITURA = "src\\boletin1\\ejercicio6\\NumerosOrdenados.txt";
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_ESCRITURA, true))) {
			
			/*Creamos un bucle for para recorrer la lista*/
			for(int numero : numeros) {
				
				/*Escribimos el numero*/
				bw.write(String.valueOf(numero));
				
				/*Hacemos un salto de linea*/
				bw.newLine();
			}
			
			/*Vaciamos el buffer*/
			bw.flush();
			
			/*Cerramos el Buffered Writer*/
			bw.close();
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido escribir en el archivo*/
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el archivo " + e.getMessage());
		}
	}
}