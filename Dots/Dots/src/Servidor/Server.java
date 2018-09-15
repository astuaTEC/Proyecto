package Servidor;
import Estructuras_datos.*;
import java.net.*;

/**
 * 
 * Esta clase se encarga de manejar la logica principal del juego.
 * Utiliza un hilo para estar a la escucha de nuevas conexiones con clientes.
 * Si un cliente se conecta, el Servidor le brinda un hilo personal para tratar los mensajes.
 *
 */
public class Server implements Runnable{

	private Cola cola = new Cola();  // Esta es la cola en donde se colocan los jugadores
	
	private MensajesChat mensajes = new MensajesChat(); 
	
	private Socket cliente ;
	
	private ServerSocket servidor;
	
	private boolean en_juego = false;
	
	private Socket Juego[] = new Socket[2];
	
	/**
	 * Constructor de la clase Servidor.
	 * Al construirse se inicia el hilo principal del server.
	 */
	public Server() {
		
		Thread hilo = new Thread(this);
		
		hilo.start();
		
	}



	
	@Override
	public void run() {
		try {
			@SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true) {
				//System.out.println("El servidor está escuchando....");
				Socket cliente = servidor.accept();
				cola.encolar(cliente);
				
				System.out.println("El servidor ha aceptado a un cliente");
				
				if(en_juego == false & cola.obtenerTamano()>= 2) {
					for(int i = 1 ; i<3 ; i++) {
						ConexionCliente cc = new ConexionCliente(cola.Desencolar(),mensajes);
						cc.start();
					}
					System.out.println("El juego ha empezado");
					en_juego = true;
				}
				
				//ConexionCliente cc = new ConexionCliente(cliente,mensajes);
				//cc.start();	
			}
		}
		catch(Exception e) {
			System.out.println("Error"+ e.getMessage());
		}
		
		
	}
	
	
public static void main(String[] args) {
	Server s = new Server();
	
}

}
