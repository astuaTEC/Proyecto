package comunicacion;
import java.net.*;
import Estructuras.*;

public class Server implements Runnable {
	
	public Cola cola = new Cola();
	
	MensajesChat mensajes = new MensajesChat();
	
	Socket cliente ;
	
	ServerSocket servidor;
	public Server() {
		
		Thread hilo = new Thread(this);
		
		hilo.start();
		
	}


	@Override
	public void run() {
		try {
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true) {
				//System.out.println("El servidor está escuchando....");
				Socket cliente = servidor.accept();
				cola.insertar(cliente);
				System.out.println("El servidor ha aceptado a un cliente");
				
				/*if(cola.obtenerTamano()>= 2) {
					for(int i = 1 ; i<3 ; i++) {
						ConexionCliente cc = new ConexionCliente((Socket)cola.Desencolar(),mensajes);
					}
				}*/
				
				ConexionCliente cc = new ConexionCliente(cliente,mensajes);
				cc.start();	
			}
		}
		catch(Exception e) {
			System.out.println("Error"+ e.getMessage());
		}
		finally {
			try {
				cliente.close();
				servidor.close();
				
			}
			catch(Exception e) {
				System.out.println("Error al crear el servidor :"+ e.getMessage());
			}
		}
		
	}
	
	
public static void main(String[] args) {
	Server s = new Server();
	
}

}
