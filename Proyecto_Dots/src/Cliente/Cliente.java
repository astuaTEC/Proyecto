package Cliente;
import java.net.*;
import Estructuras_Socket.*;
import java.io.*;

/**
 *Clase que controla las acciones del usuario y le brinda una interfaz para que pueda realizar sus movimientos en la malla.
 *
 */
public class Cliente {
	
	
	private Socket socket;  // Socket que va a utilizar el usuario para comunicarse con el servidor.
	
	private Molde R = new Molde();  // Molde en donde se van a guardar los datos que se desean enviar.
	
	private Molde mensaje;
	
	/**
	 * Constructor que al iniciarse trata de conectarse al servidor.
	 */
	public Cliente() {
		
		
		
		try {
			socket = new Socket("localhost", 9999);  // Se conecta al Servidor tomando como parámetro la direccion ip y el puerto.
		} catch (UnknownHostException ex) {
			System.out.println("No se ha pidido conectar con el servidor :"+ ex.getMessage());
			
		} catch (IOException ex) {
			System.out.println("No se ha podido conectar con el servidor :" + ex.getMessage());
				
		}	
		
	}
	
	
	

	
	
	
	
	/**
	 * Metodo que usa un bucle infinito para estar atento a nuevos mensajes del servidor.
	 */
	public void recibirMensajesServidor(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String recibido;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
        	System.out.println("Error al crear el stream de entrada en el cliente: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correrctamente en el cliente");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                recibido = entradaDatos.readUTF();  // Almaceno el Json recibido en esta variable de tipo String
                
                Molde R = Transformador.convertJsonToJava(recibido, Molde.class); // Se convierte el mensaje Json a un objeto de tipo Molde
                
        
               
            } catch (IOException ex) {
                System.out.println("Error al leer del stream de entrada en el cliente: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                System.out.println("El socket no se creo correctamente en el cliente. ");
                conectado = false;
            }
        }
    }
	

	
	public static void main(String[] args) {
		Cliente c = new Cliente(); // Se crea una instancia de Client.
		
		c.recibirMensajesServidor(); // Se le dice que empiece a recibir mensajes del servidor.
		
		
	}
	
	
}


