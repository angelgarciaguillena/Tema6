package boletin2.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	/*Creamos una constante para almacenar el fichero*/
	public static final String FICHERO = "src\\boletin2\\ejercicio3\\Fichero.txt";
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la linea*/
		String linea;
		
		/*Creamos una variable para almacenar la eleccion del usuario*/
		String eleccion;
		
		/*Creamos una variable que almacene el numero de lineas*/
		int numeroLineas = 0;
		
		/*Creamos una variable para almacenar cuando se termina el programa*/
		boolean finalizar = false;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			/*Leemos la linea del fichero*/
			linea = br.readLine();
			
			/*Creamos un bucle while para recorrer el fichero*/
			while(linea != null && !finalizar) {
				
				/*Mostramos la linea*/
				System.out.println(linea);
				
				/*Sumamos 1 al contador de lineas*/
				numeroLineas++;
				
				/*Si las lineas imprimidas son 24 preguntamos al usuario que desea hacer*/
				if(numeroLineas == 24) {
					System.out.println("\n" + "Se han mostrado 24 lineas");
					
					/*Preguntamos al usuario si desea continuar*/
					System.out.println("Si desea salir introduzca 'Salir' sino introduce cualquier cosa");
					
					/*Leemos la eleccion del usuario*/
					eleccion = sc.nextLine();
					
					/*Si la eleccion del usuario es no continuar ponemos la variable a false*/
					if(eleccion.equalsIgnoreCase("Salir")) {
						
						/*Establecemos la variable a true para finalizar el programa*/
						finalizar = true;
					} 
					
					/*Reiniciamos la variable*/
					numeroLineas = 0;
				}
				
				/*Leemos la linea del fichero*/
				linea = br.readLine();
			}
			
			/*Mostramos un mensaje de que ha terminado el programa*/
			System.out.println("\n" + "Has terminado el programa");
			
			/*Cerramos el BufferedReader*/
			br.close();
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se ha podido encontrar el fichero " + e.getMessage());
			
		/*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		} catch (IOException e) {
			System.out.println("Error: No se ha podido leer el fichero " + e.getMessage());
		}
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}