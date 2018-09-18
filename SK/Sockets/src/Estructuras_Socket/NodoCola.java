package Estructuras_Socket;

/**
 * Clase Nodo que permite la creacion de los nodos que se van a utilizar en la cola.
 *
 */
public class NodoCola {
	
	private Object dato;  // El dato que se va aguradar en cada Nodo.
	
	private NodoCola siguiente;  // Puntero de cada nodo.
	
	/**
	 * 
	 * Constructor de la clase Nodo que recibe solamente el dato que se quiere almacenar en el Nodo.
	 * @param d Dato que se le va a asignar al Nodo.
	 */
	public NodoCola(Object d) {
		dato = d;
		siguiente = null;
		
	}
	
	/**
	 * Metodo para obtener el valor que se encuantra en el Nodo.
	 * @return El dato que se encuentra en el Nodo
	 */
	public Object getValue() {
		return dato;
	}
	
	/**
	 * Metodo encargado de  obtener el Nodo siguiente.
	 * @return El siguiente Nodo al que se está apuntando.
	 */
	public NodoCola getNext() {
		return siguiente;
	}
	
	/**
	 * Metodo encargado de asignar siguiente Nodo.
	 * @param sig El nodo al que se le quiere asignar el valor de siguiente.
	 */
	public void setNext(NodoCola sig) {
		siguiente = sig;
	}
	


}

