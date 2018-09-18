package Estructuras_Socket;
import java.net.*;

/**
 * Clase se encarga de simular una cola para los jugadores.
 *
 */
public class Cola {
	
	NodoCola inicio, fin;  // Variables para controlar el inicio y el final de la cola.
	
	int tamano;  // variable para controlar el tama�o de la cola.
	
	/**
	 * Constructor que le da los valores iniciales a el inicio y el final de la cola.
	 * Ademas de darle un valor de 0 a el tama�o de la cola.
	 */
	public Cola() {
		inicio = fin = null;
		
		tamano = 0;
	}
	
	/**
	 * Metodo que se encarga de validar si la cola est� vac�a.
	 * @return Retorna true si la cola esta vac�a y false si no lo est�.
	 */
	public boolean estaVacia() {
		return inicio == null;
	}
	
	/**
	 * Metodo encargado de a�adir un nuevo elemento al final de la cola
	 * @param elemento Elemento que se desea a�adir.
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
	 * Metodo encargado de brindar el tama�o de la cola.
	 * @return Devuelve un numero entero que representa el tama�o de la cola.
	 */ 
	public int obtenerTamano() {
		return tamano;
	}

	
		
	

}

