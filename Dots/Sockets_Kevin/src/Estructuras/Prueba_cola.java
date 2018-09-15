package Estructuras;

public class Prueba_cola {

	public static void main(String[] args) {
		
	Cola cola = new Cola();
	
	cola.insertar(1);
	
	cola.insertar(2);
	
	cola.insertar(3);
	
	cola.insertar(4);
	
	System.out.println(cola.inicioDato());
	
	cola.Desencolar();
	
	cola.Desencolar();
	
	System.out.println(cola.inicioDato());
	
	cola.Desencolar();
	
	System.out.println(cola.inicioDato());
	
	


	}

}
