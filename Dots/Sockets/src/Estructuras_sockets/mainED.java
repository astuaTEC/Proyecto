package Estructuras_sockets;

public class mainED {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*Cola mi_cola = new Cola();
		
		mi_cola.insertar("Kevin");
		
		mi_cola.insertar(12);
		
		mi_cola.insertar(35);
	
		
		
		System.out.println(mi_cola.obtenerTamano());
		
		System.out.println(mi_cola.inicioDato());*/
		
		// USO DE LOS THREADS
		
		Thread proceso1 = new Proceso("proceso1");
		
		Thread proceso2 = new Proceso("proceso2");
		
		proceso1.start();
		
		proceso2.start();

		
	

	}

}
