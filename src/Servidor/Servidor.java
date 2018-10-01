package Servidor;
import Estructuras_Socket.*;
import Estructuras_Tablero.*;
import Cliente.*;
import Logica.*;
import java.io.IOException;
import java.net.*;

/**
 * 
 * Esta clase se encarga de manejar la logica principal del juego.
 * Utiliza un hilo para estar a la escucha de nuevas conexiones con clientes.
 * Si un cliente se conecta, el Servidor le brinda un hilo personal para tratar los mensajes.
 *
 */
public class Servidor implements Runnable{

	private Cola cola = new Cola();  // Esta es la cola en donde se colocan los jugadores
	
	private MensajesChat mensajes = new MensajesChat(); 
	
	private Socket cliente ;
	
	private ServerSocket servidor;
        
        private Tablero tablero;
	
	private  boolean en_juego = false;
	
	
	
	/**
	 * Constructor de la clase Servidor.
	 * Al construirse se inicia el hilo principal del server.
	 */
	public Servidor() {
		
		Thread hilo = new Thread(this);
		
		hilo.start();
		
	}



	
	@Override
	public void run() {
            System.out.println("Servidor activado");
		try {
			//@SuppressWarnings("resource")
			tablero  = new Tablero();
			servidor = new ServerSocket(9999);
                        int cont_turno = 1;
			
			while(true) {
				cliente = servidor.accept();
				cola.encolar(cliente);
				
				System.out.println("El servidor ha aceptado a un cliente");

                                if(en_juego == false & cola.obtenerTamano()>= 2) {
   
                                    int i = 1;
                                    while(i<3){
                                        Conexion_Cliente cc;
                                        cc = new Conexion_Cliente(cola.Desencolar(), mensajes, tablero, i);
                                        cc.start();
                                        i++;
                                    
                                    }
                                }
			}
		}
		catch(IOException e) {
			System.out.println("Error"+ e.getMessage());
		}
	}

public static void main(String[] args) {
	Servidor s = new Servidor();
	
	
	
	
	
}

}

