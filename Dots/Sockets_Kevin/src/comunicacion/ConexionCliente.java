package comunicacion;

import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.io.*;

public class ConexionCliente extends Thread implements Observer {
	
	private Socket socket;
	
	private MensajesChat mensajes;
	
	private DataInputStream entrada;
	
	private DataOutputStream salida;
	
	
	
	public ConexionCliente(Socket socket, MensajesChat mensajes) {
		
		this.socket = socket;
		
		this.mensajes = mensajes;
		
		try {
			
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());
			
		}
		
		catch(Exception e) {
			System.out.println("Error al crear los stream de entrada y salida :" + e.getMessage());
		}
		
		
	}
	public void run() {
		String mensajeRecibido;
		
		boolean conectado = true;
		// Se apunta a la lista de observadores de mensajes
		mensajes.addObserver(this);
		
		while(conectado) {
			try {
				//lee un mensaje enviado por el cliente
				mensajeRecibido = entrada.readUTF();
				//pone el mensaje recibido en mensajes para que se notifique
				// a sus observadores que hay un nuevo mensaje
				mensajes.setMensaje(mensajeRecibido);
			
			
			}
			catch(Exception e) {
				System.out.println("Cliente con la ip " + socket.getInetAddress() + " " + e.getMessage());
				
				conectado = false;
				// si se ha producido un error al recibir datos del cliente se cierra la conexion con el servidor
				
				try {
					
					entrada.close();
					
					salida.close();
				}
				catch(Exception ex) {
					System.out.println("Error al cerrar los streams de entrada y salida : " + ex.getMessage());
					
				}
			}
		
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		try {
			
			// envia el mensaje al cliente
			salida.writeUTF(arg.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al enviar mensaje al cliente : "+ e.getMessage());
		}
		
	}
	
	
	
	

}
