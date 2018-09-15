package Estructuras;

public class NodoCola {
	
	private Object dato;
	
	private NodoCola siguiente;
	
	public NodoCola(Object d) {
		dato = d;
		siguiente = null;
		
	}
	
	public Object getValue() {
		return dato;
	}
	
	public NodoCola getNext() {
		return siguiente;
	}
	
	public void setNext(NodoCola sig) {
		siguiente = sig;
	}
	


}
