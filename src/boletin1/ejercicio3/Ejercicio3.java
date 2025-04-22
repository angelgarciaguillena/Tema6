package boletin1.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) {
		
		String cadena;
		String datos[];
		String nombre = "";
		int sumaEdad = 0;
		double mediaEdad;
		double sumaEstatura = 0;
		double mediaEstatura;
		int contador = 0;
		
		try(BufferedReader reader = new BufferedReader(new FileReader("src\\boletin1\\ejercicio3\\Alumnos"))){
			
			cadena = reader.readLine();
			
			while(cadena != null) {
				datos = cadena.split(" ");
				nombre += datos[0] + " ";
				sumaEdad += Integer.parseInt(datos[1]);
				sumaEstatura += Double.parseDouble(datos[2]);
				contador++;
				cadena = reader.readLine();
			}
			
			mediaEdad = sumaEdad / contador;
			mediaEstatura = sumaEstatura / contador;
			
			System.out.println("Nombres: " + nombre);
			System.out.println("Media de las edades: " + mediaEdad);
			System.out.println("Media de las estaturas: " + mediaEstatura);
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Error: No se ha encontrado el fichero " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: No se puede leer el fichero " + e.getMessage());
		}
	}
}