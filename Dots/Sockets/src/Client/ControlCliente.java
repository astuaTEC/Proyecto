package Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
/* Esta clase atiende al socket y las peticiones de usuario
 * lo que llega por el socket lo muestra en el text Area del panel
 * lo que escribe el usuario en el panel lo envia por el socket
 */
public class ControlCliente implements ActionListener, Runnable{ 
	
	
	//para lectura de datos del socket
	private DataInputStream dataInput;
	
	//para escritura de datos en el socket
	private DataOutputStream dataOutput;
	
	//panel con los controles para el usuario
	private PanelCliente panel;
	
	// construye una instancia de esta clase, lanzando un hilo
	//para atender al socket
	
	public ControlCliente(Socket socket, PanelCliente panel) {
		this.panel = panel;
		
		try {
			dataInput = new DataInputStream(socket.getInputStream());
			dataOutput = new DataOutputStream(socket.getOutputStream());
			panel.addActionListener(this);
			Thread hilo = new Thread(this);
			hilo.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	// Recoge el texto del panel y lo envia por el socket
	// el panel llamará a este metodo cuando el usuario escriba algo
	// pulse algun boton de "enviar" o pulse "enter" sobre el textField
	public void ActionPerformed(ActionEvent evento) {
		try {
			dataOutput.writeUTF(panel.getTexto());
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	// metodo para atender al socket. Todo lo que llega por el socket
	// se escribe en el panel
	public void run() {
		try {
			while(true) {
				String texto = dataInput.readUTF();
				panel.addTexto(texto);
				panel.addTexto("\n");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
