package boletin1.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {
	public static void main(String[] args) {
		
		String palabra = "";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\ejercicio4\\Palabras"))) {
			
			do {
				
			}while(!palabra.equalsIgnoreCase("fin"));
			
		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());;
		}
	}
}
