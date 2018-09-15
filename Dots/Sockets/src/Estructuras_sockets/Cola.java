package Estructuras_sockets;

public class Cola {
	
	NodoCola inicio, fin;
	
	int tamano;
	
	public Cola() {
		inicio = fin = null;
		
		tamano = 0;
	}
	
	public boolean estaVacia() {
		return inicio == null;
	}
	
	public void insertar(Object elemento) {
		
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
	public Object Eliminar() {
		Object aux = inicio.getValue();
		inicio = inicio.getNext();
		tamano--;
		return aux;
		
	}
	public Object inicioDato() {
		return inicio.getValue();
	}
	
	public int obtenerTamano() {
		return tamano;
	}

	
		
	

}
