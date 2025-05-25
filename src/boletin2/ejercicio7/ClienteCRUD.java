package boletin2.ejercicio7;

import java.util.Set;
import java.util.TreeSet;

/**
 * Clase encargada de realizar las funciones para la gestion
 * de los clientes
 * 
 * @author Angel
 */
public class ClienteCRUD {
	
	/**
	 * Creamos un conjunto para almacenar los clientes
	 */
	public static Set<Cliente> clientes = new TreeSet<Cliente>();
	
	/**
	 * Funcion encargada de mostrar a los clientes que se encuentran en el conjunto
	 * y muestra el salario maximo, el salario minimo y el promedio
	 */
	public static void mostrarCliente() {
		
		double saldoTotal = 0;
	    double saldoMaximo = Double.MIN_VALUE;
	    double saldoMinimo = Double.MAX_VALUE;
	    double promedio;

	    for (Cliente cliente : clientes) {
	        System.out.println(cliente);
	        System.out.println("—---------------------------------------------------");

	        saldoTotal += cliente.getSaldo();
	        saldoMaximo = Math.max(saldoMaximo, cliente.getSaldo());
	        saldoMinimo = Math.min(saldoMinimo, cliente.getSaldo());
	    }
	    
	    promedio = saldoTotal / clientes.size();

	 	System.out.println("Saldo Maximo: " + saldoMaximo + "€ - Saldo Minimo: " + saldoMinimo + "€ - Promedio: " + promedio + "€");
	}
	
	/**
	 * Funcion que se encarga de añadir a un cliente al conjunto y devuelve true si se ha añadido
	 * o false si no se ha podido añadir
	 * 
	 * @param cliente Cliente que se va a añadir
	 * @return Devuelve true si se ha añadido o false si no se ha añadido
	 */
	public static boolean añadirCliente(Cliente cliente) {
		return clientes.add(cliente);
	}
	
	/**
	 * Funcion encargada de eliminar a un cliente del conjunto y devuelve true si se ha eliminado o false
	 * si no se ha podido eliminar
	 * 
	 * @param cliente Cliente que se va a eliminar
	 * @return Devuelve true si se ha eliminado al paciente o false si no se ha podido eliminar
	 */
	public static boolean eliminarCliente(Cliente cliente) {
		return clientes.remove(cliente);
	}
}