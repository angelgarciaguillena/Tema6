package boletin2.ejercicio6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {

	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin2\\ejercicio6\\Deportistas.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la linea*/
		String linea;
		
		/*Creamos una variable para almacenar el nombre del deportista*/
		String nombre;
		
		/*Creamos una variable para almacenar la edad del deportista*/
		int edad;
		
		/*Creamos una variable para almacenar el peso del deportista*/
		double peso;
		
		/*Creamos una variable para almacenar la estatura del deportista*/
		double estatura;
		
		/*Creamos una variable para almacenar el nombre del deportista con mayor edad*/
		String deportistaMayorEdad = "";
		
		/*Creamos una variable para almacenar el nombre del deportista con mayor peso*/
		String deportistaMayorPeso = "";
		
		/*Creamos una variable para almacenar el nombre del deportista con mayor estatura*/
		String deportistaMayorEstatura = "";
		
		/*Creamos una variable para almacenar la edad maxima*/
		int edadMaxima = 0;
		
		/*Creamos una variable para almacenar el peso maximo*/
		double pesoMaximo = 0;
		
		/*Creamos una variable para almacenar la estatura maxima*/
		double estaturaMaxima = 0;
		
		/*Creamos un array para almacenar los datos de los deportistas*/
		String datos[];
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			/*Saltamos la primera linea del fichero debido a que es el encabezado*/
			br.readLine();
			
			/*Leemos la linea del fichero*/
			linea = br.readLine();
			
			/*Creamos un bucle while para recorrer el fichero*/
			while(linea != null) {
				
				/*Almacenamos los datos en el array*/
				datos = linea.split("	");
				
				/*Almacenamos el nombre del deportista*/
				nombre = datos[0];
				
				/*Almacenamos la edad del deportista*/
				edad = Integer.parseInt(datos[1]);
						
				/*Almacenamos el peso del deportista*/
				peso = Double.parseDouble(datos[2]);
				
				/*Almacenamos la estatura del deportista*/
				estatura = Double.parseDouble(datos[3]);

				/*Si la edad del deportista es mayor a la anterior almacenamos la nueva edad y el nombre del deportista*/
				if (edad > edadMaxima) {
					
					/*Almacenamos la nueva edad maxima*/
					edadMaxima = edad;
					
					/*Almacenamos el nombre del deportista*/
					deportistaMayorEdad = nombre;
				}
				
				/*Si el peso del deportista es mayor al anterior almacenamos el nuevo peso y el nombre del deportista*/
				if (peso > pesoMaximo) {
					
					/*Almacenamos el nuevo peso maximo*/
					pesoMaximo = peso;
					
					/*Almacenamos el nombre del deportista*/
					deportistaMayorPeso = nombre;
				}
				
				/*Si la estatura del deportista es mayor a la anterior almacenamos la nueva estatura y el nombre del deportista*/
				if (estatura > estaturaMaxima) {
					
					/*Almacenamos la nueva estatura maxima*/
					estaturaMaxima = estatura;
					
					/*Almacenamos el nombre del deportista*/
					deportistaMayorEstatura = nombre;
				}
								
				/*Leemos la linea del fichero*/
				linea = br.readLine();
			}
			
			/*Mostramos al deportista con mayor edad*/
			System.out.println("El deportista mas viejo es " + deportistaMayorEdad + " con " + edadMaxima + " años");
			
			/*Mostramos al deportista con mayor peso*/
			System.out.println("El deportista con mayor peso es " + deportistaMayorPeso + " con " + pesoMaximo + " kg");
			
			/*Mostramos al deportista con mayor estatura*/
			System.out.println("El deportista mas alto es " + deportistaMayorEstatura + " con " + estaturaMaxima + " cm");
			
			/*Cerramos el BufferedReader*/
			br.close();
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se ha podido encontrar el fichero " + e.getMessage());
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		} catch (IOException e) {
			System.out.println("Error: No se ha podido leer el fichero " + e.getMessage());
		}
	}
}