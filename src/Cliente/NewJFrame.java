/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Estructuras_Socket.Molde;
import Estructuras_Socket.Transformador;
import estructuras_Socket.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author kennet
 */
public class NewJFrame extends javax.swing.JFrame implements Runnable{
    private ArrayList<Point> lista1 = new ArrayList<Point>();
    private ArrayList<Integer> lista = new ArrayList<Integer>();
    private Punto_Interfaz puntos=new Punto_Interfaz();
    //private Molde mensaje = new Molde();
    private Molde mensaje_recibido = new Molde();
    private Molde mensaje = new Molde();
    private Socket socket;
    private int mi_turno;
    private JTextField IP_TextField;
    //private AudioClip clip = Applet.newAudioClip(getClass().getResource("/Cliente/PimPoy.wav"));
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame(Socket socket) {
        Thread mi_hilo = new Thread(this);
        mi_hilo.start();
        this.socket = socket;
        initComponents();
        this.add(puntos);
        setVisible(true);
       setLocationRelativeTo(null);
       setResizable(false);
       setTitle("DOTS");
       //clip.loop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7= new javax.swing.JLabel();
        jLabel8= new javax.swing.JLabel();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(522, 645));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel3.setText("Jugador 1");

        jLabel4.setText("Jugador 2");

        jLabel7.setText("Score 1");
        
        jLabel8.setText("Score 2");
        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(47, 47, 47)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                    .addGap(30,30,30))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
              
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                             .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        ))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        

        pack();
    }// </editor-fold>                                                                

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
       System.out.println(evt.getX());
        System.out.println(evt.getY());
                     
        int y=0;
	    int x=0;
        if (lista.size()<=4){for (int i =0; i<535; i+=100) {
	    	if (i-25 <evt.getX() & evt.getX()<i+45) {
	    		x=i;break;}}
	    for (int j=100;j<645;j+=100) {
	    	if (j-25 <evt.getY() & evt.getY()<j+45) {
	    		y=j;break;}}
            if( mensaje_recibido.getTurno() == mi_turno){
	    lista.add(x);
            lista.add(y);

            if (lista.size()==4 ) {
                System.out.println(lista.get(0));
                System.out.println(lista.get(1));
                System.out.println(lista.get(2));
            System.out.println(lista.get(3));
                mensaje.setJugador(mi_turno);
                mensaje.setX1(lista.get(0));
                mensaje.setY1(lista.get(1));
                mensaje.setX2(lista.get(2));
                mensaje.setY2(lista.get(3));
                Conexion_Servidor cs = new Conexion_Servidor(socket,mensaje);
                lista.clear();
                
        }}}
        
    }
    public void hablar(String m){
        System.out.println(m);
    }
  
    
    public void run(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String recibido;
        Molde R = new Molde();
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
        	System.out.println("Error al crear el stream de entrada en el cliente: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correrctamente en el cliente");
        }
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
               recibido = entradaDatos.readUTF();  // Almaceno el Json recibido en esta variable de tipo String
               
                if(recibido.length()== 1){ // Si el tamaño del String es menor o igual a 3, significa que el servidor mandó el numero de turno
                    mi_turno = Integer.parseInt(recibido);  // Lo transformo a entero y se lo asigno a la variable mi_turno. 
                    mensaje.setTurno(mi_turno);
                    mensaje_recibido.setTurno(1);
                    jLabel2.setText("Su turno es "+mi_turno);
                    
                    hablar("Entro al if");
                }
                else if(recibido.contains("npoints")){ //si en el string recibido se encuentra la palabra "npoints" significa que es un 
                    hablar("Entro goku"); // un ArrayList de poligonos
                    ArrayList<Polygon> a = new ArrayList();
                    ArrayList<Polygon> pf = Transformador.convertJsonToJava2(recibido,a);
                    System.out.println(pf.get(0).getBounds());
                    if(pf.size()>0 ){
                          puntos.dibujar_fig(pf,mensaje_recibido.getTurno()); 
                      }
                    else{
                         System.out.println("No hay figura");
                    }
                }
                else{
                    hablar("Entro al else");
                    System.out.println(recibido);
                   R = Transformador.convertJsonToJava(recibido,Molde.class); // Se convierte de JSON a Java Object
                   System.out.println(R.getTurno()+" El turno es ");
                   mensaje_recibido.setJugador(R.getJugador());
                   System.out.println("El turno recibido es " + mensaje_recibido.getTurno());
                   mensaje_recibido.setNombre(R.getNombre());
                   mensaje_recibido.setTurno(R.getTurno());
                   mensaje_recibido.setEstado_juego(R.isEstado_juego());
                   mensaje_recibido.setScore1(R.getScore1());
                   mensaje_recibido.setScore2(R.getScore2());
                   mensaje_recibido.setX1(R.getX1());
                   mensaje_recibido.setX2(R.getX2());
                   mensaje_recibido.setY1(R.getY1());
                   mensaje_recibido.setY2(R.getY2());
                   mensaje_recibido.setAceptacion(R.getAceptacion());
                   jLabel5.setText(mensaje_recibido.getScore1());
                   jLabel6.setText(mensaje_recibido.getScore2());
                   jLabel1.setText("El turno es de jugador "+mensaje_recibido.getTurno());
                   if(mensaje_recibido.getAceptacion() == true){
                 
                       puntos.dibujar(mensaje_recibido.getX1(), mensaje_recibido.getY1(), mensaje_recibido.getX2(), mensaje_recibido.getY2(), mensaje_recibido.getJugador());
                                         }
                   //mensaje_recibido.limpiar();
                }
               
                 
            } catch (IOException ex) {
                System.out.println("Error al leer del stream de entrada en el cliente: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                System.out.println("El socket no se creo correctamente en el cliente. ");
                conectado = false;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    
    // End of variables declaration                   


}
