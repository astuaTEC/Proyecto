package Cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.net.*;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Estructuras_Socket.Molde;

/**
 * Clase donde se dibujan los puntos en la interfaz grafica
 *
 */
class Panel extends JPanel{
    private ArrayList<Point> lista1 = new ArrayList<Point>();
    private ImageIcon imagen;
    private JLabel texto,texto2;          
    private JTextArea caja,caja2;        
    private JButton boton;         
    private Socket socket;
    private Molde mensaje;
    
     // colocamos posicion y tamanio al boton (x, y, ancho, alto)
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * funcion para trabajar metodos de la liberia como graficos
	 * con dos for se dibujan todos los puntos que se necesitan 
	 */
    
    private Molde molde, R;
    
    public Panel() {
		 
    	
    	
    	
    }
    
	public void paintComponent(Graphics g) {
		 imagen = new ImageIcon(getClass().getResource("/Cliente/fondok.png"));
		 
		 texto = new JLabel();
		 texto2 = new JLabel();
		 texto.setText("Score 1");    // colocamos un texto a la etiqueta
		 texto2.setText("Score 2");
		 texto.setBounds(10, 5, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
	     texto2.setBounds(10,50,100,25);
		 this.add(texto);
		 this.add(texto2);
		 
		 
	     caja = new JTextArea();
	     caja2 = new JTextArea();
	     caja.setBounds(110, 5, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
	     caja.setText("32");
	     caja2.setText("34");
	     caja2.setBounds(110,50,100,25);
	     this.add(caja);
	     this.add(caja2);
	  
	     boton = new JButton();
	     boton.setText("Listo");   // colocamos un texto al boton
	     boton.setBounds(445, 25, 100, 30);
	     
	     boton.setEnabled(false);
	     boton.addActionListener(new Conexion_Servidor(socket,mensaje));
	 
	     this.add(boton);
		 g.drawImage(imagen.getImage(), 0,0,600,700,null);
		 setOpaque(false);
		 super.paintComponent(g);
		 for (int i=35;i<600;i+=100) {
			for (int j=100;j<=600;j+=100) {
				g.setColor (Color.ORANGE);
				g.fillOval (i,j,15,15);
				lista1.add(new Point(i,j));
				}
			}
		}
}
