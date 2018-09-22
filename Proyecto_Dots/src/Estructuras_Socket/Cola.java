package Estructuras_Socket;
import java.net.*;

/**
 * Clase se encarga de simular una cola para los jugadores.
 *
 */
public class Cola {
	
	NodoCola inicio, fin;  // Variables para controlar el inicio y el final de la cola.
	
	int tamano;  // variable para controlar el tamaño de la cola.
	
	/**
	 * Constructor que le da los valores iniciales a el inicio y el final de la cola.
	 * Ademas de darle un valor de 0 a el tamaño de la cola.
	 */
	public Cola() {
		inicio = fin = null;
		
		tamano = 0;
	}
	
	/**
	 * Metodo que se encarga de validar si la cola está vacía.
	 * @return Retorna true si la cola esta vacía y false si no lo está.
	 */
	public boolean estaVacia() {
		return inicio == null;
	}
	
	/**
	 * Metodo encargado de añadir un nuevo elemento al final de la cola
	 * @param elemento Elemento que se desea añadir.
	 */
	public void encolar(Socket elemento) {
		
		NodoCola nuevo = new NodoCola(elemento);
		
		if(estaVacia()) {
			inicio = nuevo;
		}
		
		else {
			fin.setNext(nuevo);
		
			
		}
		
		fin = nuevo;
		tamano++;
	}
	/**
	 * Metodo que se encarga de quitar el elemento que se encuentra en el inicio de la cola para luego devolverlo.
	 * @return Devuelve el elemento que se desencola.
	 */
	public Socket Desencolar() {
		Socket aux = (Socket)inicio.getValue();
		inicio = inicio.getNext();
		tamano--;
		return aux;
		
	}
	/**
	 * Metodo que retorna el elemento que se encuentra en el inicio.
	 * @return Retorna el primer elemento. 
	 */
	public Object inicioDato() {
		return inicio.getValue();
	}
	
	/**
	 * Metodo encargado de brindar el tamaño de la cola.
	 * @return Devuelve un numero entero que representa el tamaño de la cola.
	 */ 
	public int obtenerTamano() {
		return tamano;
	}

	
		
	

}

