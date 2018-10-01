package Cliente;
import Estructuras_Socket.*;
import java.io.*;
import java.net.*;

/**
 * Clase encargada de manejar los eventos del boton que se encuantra en la interfaz del cliente.
 * Controla la salida de datos hacia el servidor.
 *
 */
public class Conexion_Servidor{
	
	
	private Molde Envio = new Molde(); // Clase molde para los datos a enviar.
	
	private DataOutputStream salida;  //flujo de salida hacia el servidor

	private Socket socket;//sockets del cliente
	

	
	
	/**
	 * Constructor del hilo que recibe los datos necesarios para manejar el Stream de salida.
	 * @param socket Socket del cliente que va a enviar.
	 * @param mensaje Los datos que va a enviar.
	 */
	public Conexion_Servidor(Socket socket, Molde Envio) {
		this.socket = socket;
		this.Envio = Envio;
		
		
		try {
			this.salida = new DataOutputStream(socket.getOutputStream());//le indicamos el canal de envio
                        envio();//llamando al metodo enviar
		}
		catch(IOException ex) {
			System.out.println("Error al crear el Stream de salida :"+ ex.getMessage());
			
		}
		catch(NullPointerException ex) {
			System.out.println("El socket no se creo correctamente");
		}
		
	}


	
	public void envio() {   // Al presionarse el boton se aciva este m�todo.
		
		try {
			String json = Transformador.convertJavaToJson(Envio);
			
			salida.writeUTF(json);
			
			//mensaje.setSalida_cliente(null);
			
		}
		catch(IOException ex) {
			System.out.println("Error al intentar enviar un mensaje :"+ ex.getMessage());
		}
	
		System.out.println("Enviando a servidor");
	}
		

}

