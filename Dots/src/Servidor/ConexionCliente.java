package Servidor;
import Estructuras_datos.*;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.io.*;

/**
 * Clase que permite crear un hilo para que el Servidor se comunique con cada cliente.
 * 
 * Implementa un Observer para que el Cliente esté a la espera de actualizaciones en la clase MensajesChat.
 *
 */
public class ConexionCliente extends Thread implements Observer {
	
	private Socket socket;  // Socket del cliente.
	
	private MensajesChat mensajes;  // Objeto observable.
	
	private DataInputStream entrada;  // Stream de entrada de datos.
	
	private DataOutputStream salida;  // Stream de salida de datos.
	
	
	
	/**
	 * Constructor del hilo para tratar a los clientes.
	 * @param socket Socket del cliente al que se le quiere brindar el hilo.
	 * @param mensajes Objeto observable al que se le va a añadir un observador que será el cliente.
	 */
	public ConexionCliente(Socket socket, MensajesChat mensajes) {
		
		this.socket = socket;
		
		this.mensajes = mensajes;
		
		try {
			
			entrada = new DataInputStream(socket.getInputStream());  // Se le dice que se va a recibir datos del cliente.
			salida = new DataOutputStream(socket.getOutputStream());  // Se va a enviar datos al Cliente.
			
		}
		
		catch(Exception e) {
			System.out.println("Error al crear los stream de entrada y salida :" + e.getMessage());
		}
		
		
	}

	public void run() {
		Object mensajeRecibido;  // Variable que se encarga de almacenar los datos recibidos.
		
		boolean conectado = true;   // booleano que va a validar si están conectados.
		
		mensajes.addObserver(this); // Sa apunta al cliente en la lista de observadores.  
		
		while(conectado) {
			try {
				
				mensajeRecibido = entrada.readUTF();  // Lee un mensaje enviado por el cliente.
				
				mensajes.setMensaje(mensajeRecibido);  // Pone el mensaje recibido en el objeto observable para que se notifique a los observadores.
			
			
			}
			catch(Exception e) {
				System.out.println("Cliente con la ip " + socket.getInetAddress() + " " + e.getMessage());
				
				conectado = false;
				
				System.out.println("Cliente desconectado");
			
				
				try {    // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el servidor.
					
					entrada.close();  // Se cierra la entrada.
					
					salida.close();  // Se cierra la salida.
				}
				catch(Exception ex) {
					System.out.println("Error al cerrar los streams de entrada y salida : " + ex.getMessage());
					
				}
			}
		
		}
	}


	@Override
	public void update(Observable o, Object arg) {  // Metodo que se llama para que se envien los mensajes a los clientes.
		
		try {
			
			// envia el mensaje al cliente
			salida.writeUTF(arg.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al enviar mensaje al cliente : "+ e.getMessage());
		}
		
	}
	
	
	
	

}
