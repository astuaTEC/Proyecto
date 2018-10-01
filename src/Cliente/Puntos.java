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
public class Puntos extends JPanel  {
        private ArrayList<Point> lista1 = new ArrayList<Point>();
        //private Graphics g = this.getGraphics();

     public Puntos (){
         this.setBackground(Color.WHITE);
         this.setBounds(0,100, 600, 600);
         
     }
     @Override
     public void paint(Graphics g){
         super.paint(g);
         for (int i=35;i<600;i+=100) {
			for (int j=100;j<=600;j+=100) {
				g.setColor (Color.ORANGE);
				g.fillOval (i,j,15,15);
				lista1.add(new Point(i,j));
				}
         
     }
    
}
public void dibujar (ArrayList<Integer> lista){

    Graphics g = this.getGraphics();
        System.out.println("Dibjar");
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));        
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
      g.drawLine(lista.get(0),lista.get(1)-127,lista.get(2),lista.get(3)-127);
}



}
