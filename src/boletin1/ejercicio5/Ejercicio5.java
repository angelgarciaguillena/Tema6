package boletin1.ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	
	public static final String FICHERO = "src\\boletin1\\ejercicio5\\datos.txt";
	
	public static void main(String[] args) {
		String nombre;
		int edad;
		Scanner sc = new Scanner(System.in);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			System.out.println("Introduce el nombre");
			nombre = sc.nextLine();
			
			System.out.println("Introduce la edad");
			edad = sc.nextInt();
			
			bw.write(nombre + " " + edad);
			
			bw.newLine();
			
			

		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}
	}
}
