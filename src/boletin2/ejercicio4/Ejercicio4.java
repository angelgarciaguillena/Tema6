package boletin2.ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio4 {

	/* Creamos una constante para almacenar el fichero con el alfabeto */
	public static final String ALFABETO = "src\\boletin2\\ejercicio4\\Codec.txt";

	/*Creamos una constante para almacenar el fichero con el mensaje sin encriptar*/
	public static final String MENSAJE = "src\\boletin2\\ejercicio4\\MensajeSinEncriptar.txt";

	/* Creamos una constante para almacenar el fichero con el mensaje encriptado */
	public static final String ENCRIPTADO = "src\\boletin2\\ejercicio4\\MensajeEncriptado.txt";

	public static void main(String[] args) {

		/* Creamos un mapa para almacenar el alfabeto */
		Map<Character, Character> alfabetoCodificacion = new HashMap<>();

		/* Leemos el alfabeto llamando a la funcion */
		alfabetoCodificacion = leerAlfabeto();

		/* Codificamos el mensaje llamando a la funcion */
		codificarMensaje(alfabetoCodificacion);

		/* Mostramos un mensaje de que ha finalizado el programa */
		System.out.println("El programa ha terminado");
	}

	

	public static Map<Character, Character> leerAlfabeto() {

		/* Creamos una variable para almacenar la cadena sin codificar */
		String cadenaSinCodificar;

		/* Creamos una variable para almacenar la cadena codificada */
		String cadenaCodificada;

		/* Creamos un array para almacenar los caracteres sin codificar */
		String[] sinCifrado;

		/* Creamos un array para almacenar los caracteres codificados */
		String[] cifrado;

		/* Creamos un mapa almacenar el alfabeto */
		Map<Character, Character> alfabeto = new HashMap<>();

		/*
		 * Creamos un try catch para notificar al usuario en caso de que se produzca un
		 * error
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(ALFABETO))) {

			/* Leemos la linea sin codificar del fichero */
			cadenaSinCodificar = br.readLine();

			/* Leemos la linea codificada del fichero */
			cadenaCodificada = br.readLine();

			/* Almacenamos los caracteres sin cifrado */
			sinCifrado = cadenaSinCodificar.split(" ");

			/* Almacenamos los caracteres cifrados */
			cifrado = cadenaCodificada.split(" ");

			/* Creamos un bucle for para recorrer la cadena sin codificar */
			for (int i = 0; i < cifrado.length; i++) {

				/* Almacenamos el alfabeto en el mapa */
				alfabeto.put(sinCifrado[i].charAt(0), cifrado[i].charAt(0));
			}

			/* Cerramos el BufferedReader */
			br.close();

			/*
			 * Lanzamos un mensaje de error en caso de que no se haya podido encontrar el
			 * archivo
			 */
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero" + e.getMessage());

			/*
			 * Lanzamos un mensaje de error en caso de que no se haya podido leer en el
			 * archivo
			 */
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero" + e.getMessage());
		}

		/* Devolvemos el mapa */
		return alfabeto;
	}

	public static void codificarMensaje(Map<Character, Character> mapaCodificacion) {
	     
		/*Creamos un try catch para notificar al usuario en caso de que se produzca un error*/
		 try (BufferedReader br = new BufferedReader(new FileReader(MENSAJE));
		      BufferedWriter bw = new BufferedWriter(new FileWriter(ENCRIPTADO))) {

			/*Creamos una variable para almacenar la linea*/
			String linea = "";
			
			/* Creamos una variable para almacenar el mensaje codificado */
			String mensajeCodificado = "";
			
			/*Leemos la linea*/
            linea = br.readLine();
			
			/*Creamos un bucle while para leer el archivo*/
	        while (linea != null) {
	        	
	        	/* Creamos un bucle for para recorrer la linea */
	        	for (char caracter : linea.toCharArray()) {
	        		
	        		/* Añadimos los caracteres codificados al mensaje */
	        		mensajeCodificado += mapaCodificacion.getOrDefault(caracter, caracter);
	            }
	                
	            /*Escribimos el mensaje en el archivo*/
	            bw.write(mensajeCodificado);
	                
	            /*Pasamos a la siguiente linea*/
	            bw.newLine();
	            
	            /*Reiniciamos la variable*/
	            mensajeCodificado = "";
	            
	            /*Leemos la siguiente linea*/
	            linea = br.readLine();
	        }
	            
	        /*Vaciamos el buffer y escribimos lo que nos faltaba por escribir*/
	        bw.flush();
	            
	        /*Cerramos el BufferedWriter*/
	        bw.close();
				
	        /*Cerramos el BufferedReader*/
			br.close();	
	            
	     /*Lanzamos un mensaje de error en caso de que no se haya podido encontrar el archivo*/
		 } catch (FileNotFoundException e) {
			 System.out.println("No se ha encontrado el fichero" + e.getMessage());
			 
			 /*Lanzamos un mensaje de error en caso de que no se haya podido leer en el archivo*/
		 } catch (IOException e) {
			 System.out.println("Error al procesar los archivos: " + e.getMessage());
		 }
	 }
}