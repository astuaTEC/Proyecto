package Estructuras_Socket;
import java.awt.Polygon;
import java.io.*;
import java.util.*;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
//se le da el orden de las claves
/**
* Esta clase permite meter todos los datos que queremos enviar al servidor, usando los atributos de la misma clase.
*
*/
@JsonPropertyOrder(value = {"jugador", "nombre","x1","y1","x2","y2", "Score1", "Score2","turno","estado_juego","poligonos1","poligonos2","aceptacion"}) // El orden que van a tener los elementos cuando se conviertan en Json Strings
public class Molde implements Serializable {
	
	private String Nombre;
	
	private int jugador;
	
	private String Score1;
	
	private String Score2;
	
	private int turno; // El servidor va a llevar un conteo de los turnos
	
	private int x1;
	
	private int y1;
	
	private int x2;
	
	private int y2;
        
        private ArrayList<Polygon> poligonos1 = new ArrayList<>();
        
        private ArrayList<Polygon> poligonos2 = new ArrayList<>();
	
	private boolean estado_juego;
        
        private boolean aceptacion;
	
	public boolean isEstado_juego() {
		return estado_juego;
	}

	public void setEstado_juego(boolean estado_juego) {
		this.estado_juego = estado_juego;
	}
        public void setPoligonos1(ArrayList poligono){
            this.poligonos1 = poligono;
        }
        public ArrayList<Polygon>getPoligonos1(){
            return poligonos1;
            
        }
        public void setPoligonos2(ArrayList poligono){
            this.poligonos2 = poligono;
        }
        public ArrayList<Polygon>getPoligonos2(){
            return poligonos2;
        }

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Molde() {
		
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public String getScore1() {
		return Score1;
	}

	public void setScore1(String score1) {
		Score1 = score1;
	}

	public String getScore2() {
		return Score2;
	}

	public void setScore2(String score2) {
		Score2 = score2;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
        public void setAceptacion(boolean acep){
            this.aceptacion = acep;
        }
        public boolean getAceptacion(){
            return aceptacion;
        }


	
	
	
	

	

}

