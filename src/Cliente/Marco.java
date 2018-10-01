package Cliente;

import java.awt.*;
import java.net.Socket;
import java.util.ArrayList;
import Estructuras_Socket.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*Se importan las libreria para trabajar con la interfaz*/
/**
 * Clase donde se define el tamano de la ventana de  la interfaz
 *
**/
public class Marco extends JFrame{
	
	
	private Molde mensaje = new Molde();
	
	private Molde R;
	
	private JButton boton;
	
	private ArrayList<Point> lista = new ArrayList<Point>();
	
         
	
	
	
	/**
	 * Metodo constructor de la clase matriz,no recibe parametros 
	 */
	
	public Marco() {
		initComponents();
		
		setTitle("DOTS"); 
		setSize(600,700);
		
		setResizable(false);
		
		
		
	
		
		
		Panel panel=new Panel();
		add(panel);
		setVisible(true);
		
	
		//this.getContentPane().setBackground(Color.black);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco matriz=new Marco();
		matriz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	


	

	
	public void mousePressed(java.awt.event.MouseEvent evt) {
        formMousePressed(evt);
    }
	
	
	
	
	
	public void lectura(Molde R) {
		Graphics g = this.getGraphics();
		System.out.println("llego");
		ArrayList<Integer> lineas = new ArrayList<Integer>();
		
		lineas.add(mensaje.getX1());
		lineas.add(mensaje.getY1());
		lineas.add(mensaje.getX2());
		lineas.add(mensaje.getY2());
		
		
		
		if (true) {// validar el jugador
		
			g.setColor( Color.MAGENTA);
			
			g.drawLine((int)lineas.get(0),(int)lineas.get(1),(int)lineas.get(2),(int)lineas.get(3));}
		
		else{
			g.setColor( Color.GREEN);
			g.drawLine((int)lineas.get(0),(int)lineas.get(1),(int)lineas.get(2),(int)lineas.get(3));

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void formMousePressed(java.awt.event.MouseEvent evt) {
	    //*************DIBUJAR PUNTOS
	    //CREAR LIENZO
	    Graphics g = this.getGraphics();
	    //*************DIBUJAR LINEA********************//
	    int y=0;
	    int x=0;
	    for (int i =35; i<600; i+=100) {
	    	if (i-30 <evt.getX() & evt.getX()<i+30) {
	    		x=i+10;break;}}
	    for (int j=115;j<700;j+=100) {
	    	if (j-30 <evt.getY() & evt.getY()<j+30) {
	    		y=j+20;break;}}
	    lista.add(new Point(x,y));
	    //OBTENER PUNTOS
	    if(lista.size()==2)
	    {
	    	System.out.println("llego1");
	    //DIBUJAR LINEA
	    	
	    mensaje.setNombre("Kenneth");
	    mensaje.setScore1("11");
	    mensaje.setScore2("15");
	    mensaje.setX1(lista.get(lista.size()-1).x);
	    mensaje.setY1(lista.get(lista.size()-1).y);
	    mensaje.setX2(lista.get(lista.size()-2).x);
	    mensaje.setY2(lista.get(lista.size()-2).y);
	    mensaje.setJugador(1);
	    System.out.println("llego2");
	    lectura(mensaje);}
	    	}

	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">
	    private void initComponents() {
	    	
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mousePressed(java.awt.event.MouseEvent evt) {
	                formMousePressed(evt);
	            }
	        });
	     // creamos los componentes
	        }
}