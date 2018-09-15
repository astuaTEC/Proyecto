package comunicacion;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConexionServidor implements ActionListener{
	
	private JTextField tfMensaje;
	

	
	private DataOutputStream salida;

	private Socket socket;
	
	
	public ConexionServidor(Socket socket, JTextField tfMensaje) {
		this.socket = socket;
		this.tfMensaje = tfMensaje;
		
		
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
	public void actionPerformed(ActionEvent e) {
	
		try {
			salida.writeUTF(tfMensaje.getText());
			tfMensaje.setText("");
			
		}
		catch(IOException ex) {
			System.out.println("Error al intentar enviar un mensaje :"+ ex.getMessage());
		}
	
	
		
	}
	

}
