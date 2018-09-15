package Client;

import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Cliente {
	
	//socket con el servidor del chat
	private Socket socket;
	// panel con la ventana del cliente
	private PanelCliente panel;
	
	public static void main(String[] args) {
		new Cliente();
		
	}
	
	//crea la ventana, establece la conexion e instancia al controlador
	public Cliente() {
		try {
			creaYVisualizaVentana();
			socket = new Socket("localhost", 9999);
			ControlCliente control = new ControlCliente(socket, panel);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private void creaYVisualizaVentana() {
		JFrame v = new JFrame();
		
		panel = new PanelCliente(v.getContentPane());
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

}
