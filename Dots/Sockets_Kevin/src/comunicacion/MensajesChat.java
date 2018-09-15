package comunicacion;

import java.util.Observable;

public class MensajesChat extends Observable{
	
	private String mensaje;
	
	
	public MensajesChat() {
		
	}
	
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
		// indica que el mensaje ha cambiado
		this.setChanged();
		
		//NOtifica a los observadores que el mensaje ha cambiado y lo pasa
		//(Internamente NotifyObservers llama al metodo update del observador
		this.notifyObservers(this.getMensaje());
	}
	
	

}
