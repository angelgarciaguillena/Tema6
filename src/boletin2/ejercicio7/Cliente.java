package boletin2.ejercicio7;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {

	/**
	 * Creamos un atributo para almacenar el dni del cliente
	 */
	private String dni;
	
	/**
	 * Creamos un atributo para almacenar el nombre del cliente
	 */
	private String nombre;
	
	/**
	 * Creamos un atributo pata almacenar la fecha de nacimiento del cliente
	 */
	private String fechaNacimiento;
	
	/**
	 * Creamos un atributo para almacenar el saldo del cliente
	 */
	private double saldo;
	
	/**
	 * Constructor que inicializa el dni del cliente comprobando que es valido
	 * antes de asignalo
	 * 
	 * @param dni Dni del cliente
	 */
	public Cliente(String dni) {
		
		if(dni.length() == 9) {
			this.dni = dni;
		}
	}
	
	/**
	 * Constructor que inicializa los atributos de la clase Cliente comprobando si son
	 * validos antes de asignarlos
	 * 
	 * @param dni Dni del cliente
	 * @param nombre Nombre del cliente
	 * @param fechaNacimiento Fecha de nacimiento del cliente
	 * @param saldo Saldo del cliente
	 */
	public Cliente(String dni, String nombre, String fechaNacimiento, double saldo) {
		
		if(dni.length() == 9) {
			this.dni = dni;
		}
		
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
		if(fechaNacimiento != null && !fechaNacimiento.isBlank()) {
			this.fechaNacimiento = fechaNacimiento;
		}
		
		if(saldo >= 0) {
			this.saldo = saldo;
		}
	}
	
	/**
	 * Funcion que devuelve el saldo del cliente
	 * 
	 * @return Devuelve el saldo del cliente
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Funcion que modifica el saldo del paciente si el valor es valido
	 * 
	 * @param saldo Nuevo saldo del cliente
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * Funcion que devuelve el dni del cliente
	 * 
	 * @return Devuelve el dni del cliente
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Funcion que devuelve el nombre del cliente
	 * 
	 * @return Devuelve el nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Funcion que devuelve la fecha de nacimiento del cliente
	 * 
	 * @return Devuelve la fecha de nacimiento del cliente
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * Funcion que devuelve la edad del cliente
	 * 
	 * @return Devuelve la edad del cliente
	 */
	public int getEdad() {
		
		int añoNacimiento = Integer.parseInt(this.fechaNacimiento.substring(6));
		
		int añoActual = 2025;
		
		return añoActual - añoNacimiento;
	}
	
	/**
	 * Funcion encargada de identificar al cliente segun su dni 
	 * y devuelve un numero que identifica al cliente
	 * 
	 * @return Devuelve un numero que identifica al cliente
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	/**
	 * Funcion que comprueba si los clientes son iguales segun su dni y devuelve
	 * true si son iguales o false si no lo son
	 * 
	 * @return Devuelve true si los clientes son iguales o false si no son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		Cliente cliente2 = (Cliente) obj;
		return this.dni.equalsIgnoreCase(cliente2.dni);
	}

	/**
	 * Funcion que devuelve la informacion del cliente
	 * 
	 * @return Devuelve la informacion del cliente
	 */
	@Override
	public String toString() {
		return this.dni + " - " + this.nombre + " - " + this.saldo + "€ - " + getEdad() + " años";
	}
	
	/**
	 * Funcion que se encarga de calcular el orden de los clientes
	 * segun su dni y devuelve el orden que tiene que seguir los pacientes
	 * 
	 * @return Devuelve el orden de los clientes
	 */
	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.dni);
	}
}