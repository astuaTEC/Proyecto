package Estructuras_datos;

import java.util.Observable;

/**
 * Clase Observable que se va a encargar de recibir notificaciones, notificar y meter a sus observadores.
 *
 */
public class MensajesChat extends Observable{
	
	private Object mensaje;  // Mensajes que llegan.
	
	
	/**
	 * Constructor de la clase MensajesChat
	 */
	public MensajesChat() {
		
	}
	
	
	/**
	 * Metodo encargado de retornar el mensaje.
	 * @return Devuelve el mensaje.
	 */
	public Object  getMensaje() {
		return mensaje;
	}
	
	/**
	 * Metodo encargado de añadir el mensaje deseado.
	 * @param mensaje El mensaje que queremos enviar.
	 */
	public void setMensaje(Object mensaje) {
		this.mensaje = mensaje;
		// indica que el mensaje ha cambiado
		this.setChanged();
		
		//NOtifica a los observadores que el mensaje ha cambiado y lo pasa
		//(Internamente NotifyObservers llama al metodo update del observador
		this.notifyObservers(this.getMensaje());
	}
	
	

}
