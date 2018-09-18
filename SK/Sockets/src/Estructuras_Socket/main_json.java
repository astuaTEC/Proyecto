package Estructuras_Socket;

public class main_json {

	public static void main(String[] args) {
		
		Molde paquete = new Molde();
		
		paquete.setNombre("Kevin");
		
		paquete.setJugador(1);
		
		//paquete.setLinea("Linea");
		
		paquete.setScore1("11");
		
		paquete.setScore2("34");
		
		paquete.setTurno(1);
		
		String json =Transformador.convertJavaToJson(paquete);
		
		System.out.println(json);
		
	

	}

}
