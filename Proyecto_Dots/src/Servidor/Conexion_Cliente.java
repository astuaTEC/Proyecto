package Servidor;
import java.util.*;
import java.net.*;
import Estructuras_Socket.*;
import Logica.Tablero;
import java.awt.Polygon;
import java.io.*;

/**
 * Clase que permite crear un hilo para que el Servidor se comunique con cada cliente.
 * 
 * Implementa un Observer para que el Cliente est� a la espera de actualizaciones en la clase MensajesChat.
 *
 */
public class Conexion_Cliente extends Thread implements Observer {
	
	private Socket socket;  // Socket del cliente.
	
	private MensajesChat mensajes;  // Objeto observable.
	
	private DataInputStream entrada;  // Stream de entrada de datos.
	
	private DataOutputStream salida;  // Stream de salida de datos.
	
	private Molde Envio = new Molde();
	
	private int turno ; // Esta variable contiene el turno de cada jugador
        
        private Tablero tablero;
        
        private String e, c;
       
        
        
	
	
	
	/**
	 * Constructor del hilo para tratar a los clientes.
	 * @param socket Socket del cliente al que se le quiere brindar el hilo.
	 * @param mensajes Objeto observable al que se le va a a�adir un observador que ser� el cliente.
     * @param tablero
     * @param turno
	 */
	public Conexion_Cliente(Socket socket, MensajesChat mensajes,Tablero tablero, int turno) {
		
		this.socket = socket;		
		this.mensajes = mensajes;				
                this.tablero = tablero;	
                this.turno = turno;
		try {	
			entrada = new DataInputStream(socket.getInputStream());  // Se le dice que se va a recibir datos del cliente.
			salida = new DataOutputStream(socket.getOutputStream());  // Se va a enviar datos al Cliente.
		}
		
		catch(IOException e) {
			System.out.println("Error al crear los stream de entrada y salida :" + e.getMessage());
		}
		
		
	}
        public void Notificar_turno(String turno){
            //String string_turno = Integer.toString(turno);
            try{
                 salida.writeUTF(turno);     
            }
            catch(IOException e){
                System.out.println("Error al notificar el turno del jugador");
            }  
        }
   
	


        @Override
	public void run() {
		
		Notificar_turno(Integer.toString(turno));
                
                System.out.println("Se ha notificado el turno" + turno);
                
		String mensajeRecibido;  
		
		boolean conectado = true;   
		
		mensajes.addObserver(this);  
                
                
                
		
		while(conectado) {
			try {
				
				mensajeRecibido = entrada.readUTF();  
                                
				Envio = Transformador.convertJsonToJava(mensajeRecibido, Molde.class);
                                
				
				if(tablero.enlazar(Envio.getJugador(), Envio.getX1(),Envio.getY1(),Envio.getX2(),Envio.getY2()) == true){
                                    
                                    
                                    if(Envio.getJugador()== 1){
                                        if(tablero.getFiguras1().size()>0){
                                           e = Transformador.convertJavaToJson2(tablero.getFiguras1());
                                           
                                         
                                           mensajes.setMensaje(e);
                                           System.out.println("Goku "+ e);
                                           tablero.setFiguras1(new ArrayList<>());
                                        }
                                       
                                        if(tablero.getFiguras2().size()>0){
                                          c = Transformador.convertJavaToJson2(tablero.getFiguras2()); 
                                          mensajes.setMensaje(c);
                                          System.out.println("Vegeta "+c);
                                          tablero.setFiguras2(new ArrayList<>());
                                        }
                                        
                                        Envio.setTurno(2);
                                        Envio.setScore1(Integer.toString(tablero.getPuntos1()));
                                        Envio.setScore2(Integer.toString(tablero.getPuntos2()));
                                        //Envio.setPoligonos1(tablero.getFiguras1());
                                        //Envio.setPoligonos2(tablero.getFiguras2());
                                        Envio.setAceptacion(true);
                                       
                                        String new_json = Transformador.convertJavaToJson(Envio);
                                       
                                        mensajes.setMensaje(new_json);
                                        

                                    }
                                    
                                    else if(Envio.getJugador() == 2){
                                        if(tablero.getFiguras1().size()>0){
                                           e = Transformador.convertJavaToJson2(tablero.getFiguras1());
                                           mensajes.setMensaje(e);
                                           System.out.println("Goku "+ e);
                                           tablero.setFiguras1(new ArrayList<>());
                                        }
                                       
                                        if(tablero.getFiguras2().size()>0){
                                          c = Transformador.convertJavaToJson2(tablero.getFiguras2()); 
                                          mensajes.setMensaje(c);
                                          System.out.println("Vegeta "+c);
                                          tablero.setFiguras2(new ArrayList<>());
                                        }
                                        Envio.setTurno(1);
                                        Envio.setScore1(Integer.toString(tablero.getPuntos1()));
                                        Envio.setScore2(Integer.toString(tablero.getPuntos2()));
                                        //Envio.setPoligonos1(tablero.getFiguras1());
                                        //Envio.setPoligonos2(tablero.getFiguras2());
                                        Envio.setAceptacion(true);
                                        String new_json = Transformador.convertJavaToJson(Envio);
                                        mensajes.setMensaje(new_json);
                                       
                              
                                    }
                                    
                                }
                                else{
                                    if(Envio.getJugador()== 1){
                                        Envio.setTurno(2);
                                        Envio.setAceptacion(false);
                                         String new_json = Transformador.convertJavaToJson(Envio);
                                         mensajes.setMensaje(new_json);
                                        
                                        
                                    }
                                    else if(Envio.getJugador() == 2){
                                        Envio.setTurno(1);
                                        Envio.setAceptacion(false);
                                         String new_json = Transformador.convertJavaToJson(Envio);
                                         mensajes.setMensaje(new_json);
                                        
                                    }
                                    
                                }
			}
			catch(IOException e) {
				System.out.println("Cliente con la ip " + socket.getInetAddress() + " " + e.getMessage());
				
				conectado = false;
				
				System.out.println("Cliente desconectado");
			
				
				try {    // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el servidor.
					
					entrada.close();  // Se cierra la entrada.
					
					salida.close();  // Se cierra la salida.
				}
				catch(IOException ex) {
					System.out.println("Error al cerrar los streams de entrada y salida : " + ex.getMessage());
					
				}
			}
		
		}
	}


	@Override
	public void update(Observable o, Object arg) {  // Metodo que se llama para que se envien los mensajes a los clientes.
		
		try {
			
			
			salida.writeUTF(arg.toString()); // Envia el mensaje al cliente
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al enviar mensaje al cliente : "+ e.getMessage());
		}
		
	}
	
	
	
	

}

