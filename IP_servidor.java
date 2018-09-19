package Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

public class IP_servidor extends JFrame{
	private Container contenedor; 
	private JPanel panel;
	private JLabel etiqueta;
	private JButton boton;
	private JTextField campo;
	IP_servidor(){
		contenedor=getContentPane();
		panel=new JPanel();
		boton=new JButton("PRESS");
		etiqueta=new JLabel("IP servidor");
		campo =new JTextField(10);
		
	panel.add(etiqueta);
	panel.add(campo);
	panel.add(boton);
	contenedor.add(panel);
	setTitle("Ingrese la ip");
	setLocation(400,200);
	setSize(300,300);
	setVisible(true);
	}
	public void main(String[]arg) {
		IP_servidor n=new IP_servidor();
	}
}
