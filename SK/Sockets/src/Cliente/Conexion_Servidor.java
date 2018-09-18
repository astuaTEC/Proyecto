package Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Estructuras_Socket.*;
import java.io.*;
import java.net.*;

/**
 * Clase encargada de manejar los eventos del boton que se encuantra en la interfaz del cliente.
 * Controla la salida de datos hacia el servidor.
 *
 */
public class Conexion_Servidor implements ActionListener{
	
	
	private Molde mensaje; // Clase molde para los datos a enviar.
	
	private DataOutputStream salida;  // 

	private Socket socket;
	

	
	
	/**
	 * Constructor del hilo que recibe los datos necesarios para manejar el Stream de salida.
	 * @param socket Socket del cliente que va a enviar.
	 * @param mensaje Los datos que va a enviar.
	 */
	public Conexion_Servidor(Socket socket, Molde mensaje) {
		this.socket = socket;
		this.mensaje = mensaje;
		
		
		try {
			this.salida = new DataOutputStream(socket.getOutputStream());
		}
		catch(IOException ex) {
			System.out.println("Error al crear el Stream de salida :"+ ex.getMessage());
			
		}
		catch(NullPointerException ex) {
			System.out.println("El socket no se creo correctamente");
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {   // Al presionarse el boton se aciva este método.
		
		try {
			String mi_mensaje = Transformador.convertJavaToJson(mensaje);
			
			salida.writeUTF(mi_mensaje);
			
			//mensaje.setSalida_cliente(null);
			
		}
		catch(IOException ex) {
			System.out.println("Error al intentar enviar un mensaje :"+ ex.getMessage());
		}
	
		System.out.println("Enviando a servidor");
	}
		

}

