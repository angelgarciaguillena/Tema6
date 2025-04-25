package boletin1.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
	
	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin1\\ejercicio3\\Alumnos.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la cadena*/
		String cadena;
		
		/*Creamos una variable para almacenar los datos de las personas*/
		String datos[];
		
		/*Creamos una variable para almacenar el nombre de la persona*/
		String nombre = "";
		
		/*Creamos una variable para almacenar la suma de las edades*/
		int sumaEdad = 0;
		
		/*Creamos una variable para almacenar la media de las edades*/
		double mediaEdad;
		
		/*Creamos una variable para almacenar la suma de las estaturas*/
		double sumaEstatura = 0;
		
		/*Creamos una variable para almacenar la media de las estaturas*/
		double mediaEstatura;
		
		/*Creamos una variable que nos servira como contador*/
		int contador = 0;
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedReader reader = new BufferedReader(new FileReader(FICHERO))){
			
			/*Leemos el fichero*/
			cadena = reader.readLine();
			
			/*Creamos un bucle while para recorrer el array*/
			while(cadena != null) {
				
				/*Convertimos la cadena en un array*/
				datos = cadena.split(" ");
				
				/*Almacenamos el nombre*/
				nombre += datos[0] + " ";
				
				/*Sumamos las edades*/
				sumaEdad += Integer.parseInt(datos[1]);
				
				/*Sumamos las estaturas*/
				sumaEstatura += Double.parseDouble(datos[2]);
				
				/*Sumamos 1 al contador*/
				contador++;
				
				/*Leemos la cadena*/
				cadena = reader.readLine();
			}
			
			/*Calculamos la media de las edades*/
			mediaEdad = sumaEdad / contador;
			
			/*Calculamos la media de las estaturas*/
			mediaEstatura = sumaEstatura / contador;
			
			/*Mostramos los nombres*/
			System.out.println("Nombres: " + nombre);
			
			/*Mostramos la media de las edades*/
			System.out.println("Media de las edades: " + mediaEdad);
			
			/*Mostramos la media de las estaturas*/
			System.out.println("Media de las estaturas: " + mediaEstatura);
			
			/*Cerramos el lector*/
			reader.close();
		
		/*Lanzamos un error en caso de que no se haya podido encontrar el archivo*/
		} catch (FileNotFoundException e) {
			System.err.println("Error: No se ha encontrado el fichero " + e.getMessage());
		
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer el archivo*/	
		} catch (IOException e) {
			System.err.println("Error: No se puede leer el fichero " + e.getMessage());
		}
	}
}