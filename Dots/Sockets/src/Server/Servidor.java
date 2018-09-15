package Server;
import java.net.*;
import javax.swing.DefaultListModel;
public class Servidor {
	
	private DefaultListModel<String> charla = new DefaultListModel<>(); // Esta debe ser la lista que guarda toda la informacion
	
	
	// Ahora se instancia la clase servidor
	public static void main(String[] args) {
		new Servidor();
	}
	
    public Servidor()
    {
        try
        {
            @SuppressWarnings("resource")
			ServerSocket socketServidor = new ServerSocket(9997);
            while (true)
            {
                Socket cliente = socketServidor.accept();
                Runnable nuevoCliente = new HiloCliente(charla, cliente);
                Thread hilo = new Thread(nuevoCliente);
                hilo.start();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

	
	}

