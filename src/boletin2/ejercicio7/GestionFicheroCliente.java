package boletin2.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Clase encargada de la gestion del fichero donde se guardan los datos de los 
 * pacientes
 * 
 * @author Angel
 */
public class GestionFicheroCliente {
	
	/**
	 * Creamos una constante para almacenar el fichero
	 */
	public static final String FICHERO = "src\\boletin2\\ejercicio7\\Clientes.txt";
	
	/**
	 * Funcion encargada de leer la informacion de los clientes que esta en el fichero, la carga en el programa
	 * para trabajar con ella y devuelve true si la ha podido leer o false si no la ha podido leer
	 * 
	 * @return Devuelve true si lo ha leido o false si no lo ha podido leer
	 */
	public static boolean leerFichero() {
		
		String datos[];
		String linea;
		boolean realizado = false;
		
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			linea = br.readLine();
			
			while(linea != null) {
				
				datos = linea.split(";");
				
				Cliente cliente = new Cliente(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
					
				ClienteCRUD.añadirCliente(cliente);
				
				
				linea = br.readLine();
			}
			
			realizado = true;
			
			br.close();
			
		} catch (FileNotFoundException e) {
			
			try {
				
				FileWriter fw = new FileWriter(FICHERO);
				
				fw.close();
				
			} catch (IOException e1) {
				System.out.println("Error al crear el fichero: " + e1.getMessage());
			}
			
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero " + e.getMessage());
		}
		
		return realizado;
	}
	
	/**
	 * Funcion encargada de escribir la informacion de los clientes en el fichero y devuelve 
	 * true si lo ha realizado o false si no lo ha realizado
	 * 
	 * @return Devuelve true si lo ha realizado o false si no
	 */
	public static boolean escribirFichero() {
		
		boolean escrito = false;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			
			for(Cliente cliente : ClienteCRUD.clientes) {
				
				bw.write(cliente.getDni() + ";" + cliente.getNombre() + ";" + cliente.getFechaNacimiento() + ";" + cliente.getSaldo());
				
				bw.newLine();
			}
			
			escrito = true;
			
			bw.flush();
			
			bw.close();
			
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el fichero " + e.getMessage());
		}
		
		return escrito;
	}
}