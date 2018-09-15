package Prueba;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class main_json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cola cola = new Cola();
		
		cola.insertar(1);
		
		cola.insertar(2);
		
		cola.insertar(3);
		
		cola.insertar(4);
		
		
		
		JSONArray paquete = new JSONArray();
		
		paquete.add(cola);
		
		Cola obtenido =(Cola) paquete.get(0);
		
		

		
		System.out.println(obtenido);
		
		

	}

}
