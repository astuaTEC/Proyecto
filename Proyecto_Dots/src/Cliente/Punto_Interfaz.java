/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author kennet
 */
public class Punto_Interfaz extends JPanel  {
        private ArrayList<Point> lista1 = new ArrayList<Point>();
        //private Graphics g = this.getGraphics();

     public Punto_Interfaz (){
         this.setBackground(Color.WHITE);
         this.setBounds(0,100, 522, 545);
         
     }
     @Override
     public void paint(Graphics g){
         super.paint(g);
         for (int i=0;i<600;i+=100) {
			for (int j=00;j<=600;j+=100) {
				g.setColor (Color.ORANGE);
				g.fillOval (i,j,15,15);
				lista1.add(new Point(i,j));
				}
         
     }
    
}
public void dibujar (int x1, int y1, int x2, int y2,int jugador){
System.out.println("Llego");   
System.out.println(jugador +"El jugador es"); 
Graphics g = this.getGraphics();
    if(jugador == 1){
       System.out.println("x1 es"+x1+" y1 es "+y1+" x2 es "+x2+" y y2 es "+y2); 
        g.setColor(Color.red);
        g.drawLine(x1+8,y1-93,x2+8,y2-93);
    }
    else{
        g.setColor(Color.DARK_GRAY);
        g.drawLine(x1+8,y1-93,x2+8,y2-93);
        
    }
  
      
}



}

