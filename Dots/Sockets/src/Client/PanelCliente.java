package Client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//panel para mostrar la conversacion y pedir al usuario el 
// texto que quiere enviar
public class PanelCliente {
	
//Scroll
	private JScrollPane scroll;
	
	// area para mostrar la conversacion
	private JTextArea textArea;
	
	//para pedir texto al usuario
	private JTextField textField;
	
	//boton para enviar texto
	private JButton boton;
	
	// Crea panel con todos los componetes.
	//Un area de texto para enviar la conversacion
	// un textfield para escribir los mensajes
	// un boton de enviar
	
	// El contenedor en el que se añaden todos los componentes
	
	public PanelCliente(Container contenedor) {
		
		contenedor.setLayout(new BorderLayout());
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		
		JPanel panel = new JPanel(new FlowLayout());
		textField = new JTextField(50);
		boton = new JButton("enviar");
		panel.add(textField);
		panel.add(boton);
		
		contenedor.add(scroll, BorderLayout.CENTER);
		contenedor.add(panel, BorderLayout.SOUTH);
	
		
		
	}
	
	// Añade el actionlistener que se le pasa tanto a pulsar(intro)
	// en el textField como al boton
	
	
	public void addActionListener(ActionListener accion) {
		textField.addActionListener(accion);
		boton.addActionListener(accion);
	}
	//Añade el texto que se le pasa en el textarea
	
	public void addTexto(String texto) {
		textArea.append(texto);
	}
	
	// Devuelve el texto que hay en el textField y lo borra
	
	
	public String getTexto() {
		String texto = textField.getText();
		textField.setText("");
		return texto;
	}
}
