package comunicacion;
import java.net.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
public class Client{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		milamina.recibirMensajesServidor();
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
	
		JLabel texto=new JLabel("CLIENTE");
		
		add(texto);
		
		mensajesChat = new JTextArea(12,20);
		
		add(mensajesChat);
		
		//mensajesChat.setEnabled(false);
		//mensajesChat.setLineWrap(true);
		//mensajesChat.setWrapStyleWord(true);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		add(miboton);
		
		try {
			socket = new Socket("localhost", 9999);
        } catch (UnknownHostException ex) {
        	System.out.println("No se ha pidido conectar con el servidor :"+ ex.getMessage());
        } catch (IOException ex) {
        	System.out.println("No se ha podido conectar con el servidor :" + ex.getMessage());
        }
		
		miboton.addActionListener(new ConexionServidor(socket,campo1));
		
	}
	public void recibirMensajesServidor(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
        	System.out.println("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correrctamente");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                mensajesChat.append(mensaje + System.lineSeparator());
            } catch (IOException ex) {
                System.out.println("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                System.out.println("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }
	
	
	
	
		
		
	private Socket socket;	
	private JTextField campo1;
	private JTextArea mensajesChat;
	private JButton miboton;
	
}
	
