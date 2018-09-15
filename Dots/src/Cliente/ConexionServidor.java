package Cliente;
import java.io.*;
import Estructuras_datos.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase encargada de manejar los eventos del boton que se encuantra en la interfaz del cliente.
 * Controla la salida de datos hacia el servidor.
 *
 */
public class ConexionServidor implements ActionListener{
	
	
	private Molde mensaje; // Clase molde para los datos a enviar.
	
	private DataOutputStream salida;  // 

	private Socket socket;
	
	private Object cambios;
	
	
	/**
	 * Constructor del hilo que recibe los datos necesarios para manejar el Stream de salida.
	 * @param socket Socket del cliente que va a enviar.
	 * @param mensaje Los datos que va a enviar.
	 */
	public ConexionServidor(Socket socket, Molde mensaje) {
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
			salida.writeUTF((String)mensaje.getSalida_cliente());
			mensaje.setSalida_cliente(null);
			
		}
		catch(IOException ex) {
			System.out.println("Error al intentar enviar un mensaje :"+ ex.getMessage());
		}
	
		
	}

}
