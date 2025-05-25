package boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5 {

	/*Creamos una constante para almacenar el fichero1*/
	public static final String FICHERO1 = "src\\boletin2\\ejercicio5\\Archivo1.txt";
	
	/*Creamos una constante para almacenar el fichero2*/
	public static final String FICHERO2 = "src\\boletin2\\ejercicio5\\Archivo2.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar las lineas del primer fichero*/
		String lineaArchivo1;
		
		/*Creamos una variable para almacenar las lineas del fichero 2*/
		String lineaArchivo2;
		
		/*Creamos una variable que almacene el numero de la linea que es distinta*/
		int linea = 1;
		
		/*Creamos una variable que almacenara si hay alguna diferencia entre los dos archivos*/
		boolean diferencia = false;
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO1));  BufferedReader br2 = new BufferedReader(new FileReader(FICHERO2))) {
			
			/*Leemos la linea del fichero 1*/
			lineaArchivo1 = br.readLine();
			
			/*Leemos la linea del fichero 2*/
			lineaArchivo2 = br2.readLine();
			
			/*Creamos un bucle while para recorrer el fichero*/
			while(lineaArchivo1 != null && lineaArchivo2 != null && !diferencia) {
				
				/*Si las lineas son diferentes avisamos al usuario sino sumamos 1 a la fila recorrida*/
				if(!lineaArchivo1.equalsIgnoreCase(lineaArchivo2)) {
					
					/*Marcamos que se ha encontrado una diferencia*/
					diferencia = true;
					
					/*Si las lineas tienen la misma extension revisamos las letras sino indicamos que tienen diferente extension*/
					if(lineaArchivo1.length() == lineaArchivo2.length()){
						
						/*Creamos un bucle for para recorrer la frase*/
						for(int i = 0; i < lineaArchivo1.length(); i++) {
							
							/*Si el caracter de los archivos es diferente indicamos al usuario el caracter raro y la linea donde ha sucedido*/
							if (lineaArchivo1.charAt(i) != lineaArchivo2.charAt(i)) {
								System.out.println("Diferencia encontrada en la linea " + linea);
								System.out.println("El caracter del archivo 1 '" + lineaArchivo1.charAt(i) + "' es diferente al caracter del archivo 2 '" + lineaArchivo2.charAt(i) + "'");
							}
						}
						
					} else {
						System.out.println("La linea " + linea + " del archivo 1 y del archivo 2 tienen distinto tamaño");
					}
					
				} else {
					
					/*Sumamos 1 a la linea en la que nos encontramos*/
					linea++;
				}
				
				/*Leemos la linea del fichero 1*/
				lineaArchivo1 = br.readLine();
				
				/*Leemos la linea del fichero 2*/
				lineaArchivo2 = br2.readLine();
			}
			
			/*Si no se ha encontrado diferencia avisamos al usuario pero si se ha encontrado confirmamos que los archivos tienen la misma extension*/
			if(!diferencia) {
				
				/*Si las lineas no son nulas avisamos al usuario que los archivos no tienen el mismo tamaño sino avisamos de que los archivos son identicos*/
				if(lineaArchivo1 != null || lineaArchivo2 != null) {
					System.out.println("Los archivos no tienen el mismo tamaño");
				} else {
					System.out.println("Los archivos son identicos");
				}
				
			} else {
				System.out.println("Los archivos son distintos");
			}
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se ha podido encontrar el fichero " + e.getMessage());
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		} catch (IOException e) {
			System.out.println("Error: No se ha podido leer el fichero " + e.getMessage());
		}
	}
}