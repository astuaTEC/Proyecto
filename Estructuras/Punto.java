/**
 * Clase Punto
 * @author Saymon Astúa
 * Se utiliza como un objeto fijo en el tablero
 */
package Estructuras;

import java.util.ArrayList;

public class Punto {
    /**
     * métodos de la clase punto
     */
    private int x;
    private int y;
    private int der;
    private int izq;
    private int up;
    private int down;
    private Punto asoDer;
    private Punto asoIzq;
    private Punto asoUp;
    private Punto asoDown;
    private Punto asoNE;
    private Punto asoNO;
    private Punto asoSE;
    private Punto asoSO;
    public ArrayList<Punto> vecinos = new ArrayList();
    /**
     * constructor de esta clase
     * @param x
     * @param y
     */
    public Punto(int x, int y ){
        this.x= x;
        this.y = y;
        this.der = x+100;
        this.izq = x-100;
        this.up= y+100;
        this.down= y-100;
    }

    /**
     * Todos los métodos geter de esta clase
     * @return el valor o estado de cada atributo de la clase
     */

    public int getX(){
        return x;
    }
    //se obtiene el valor de x en el punto
    public int getY(){
        return y;
    }
    //se obtiene el valor de el vecino de la derecha del punto
    public int getDer() {
        return der;
    }
    //se obtiene el valor de el vecino de abajo del punto
    public int getDown() {
        return down;
    }
    //se obtiene el vecino de la izquierda del punto
    public int getIzq() {
        return izq;
    }
    //se obtiene el vecino de arriba del punto
    public int getUp() {
        return up;
    }
    //se obtiene si ya hay asociación con el vecino de la derecha
    public Punto isAsoDer() {
        return asoDer;
    }
    //se obtiene si ya hay asociación con el vecino de abajo
    public Punto isAsoDown() {
        return asoDown;
    }
    //se obtiene si ya hay asociación con el vecino de la izquierda
    public Punto isAsoIzq() {
        return asoIzq;
    }
    //se obtiene si ya hay asociación con el vecino de arriba
    public Punto isAsoUp() {
        return asoUp;
    }
    //se obtiene si ya hay asociación con el vecino del Noreste
    public Punto isAsoNE() {
        return asoNE;
    }
    //se obtiene si ya hay asociación con el vecino del Noroeste
    public Punto isAsoNO() {
        return asoNO;
    }
    //se obtiene si ya hay asociación con el vecino del sureste
    public Punto isAsoSE() {
        return asoSE;
    }
    //se obtiene si ya hay asociación con el vecino de la suroeste
    public Punto isAsoSO() {
        return asoSO;
    }

    /**
     * todos los métodos seter de esta clase
     * trabajan con un argumento (puede ser un int o un boolean dependiendo de la función)
     */
    //se le asigna el estado a la asociación derecha
    public void setAsoDer(Punto asoDer) {
        this.asoDer = asoDer;
    }
    //se le asigna el estado a la asociación de abajo
    public void setAsoDown(Punto asoDown) {
        this.asoDown = asoDown;
    }
    //se le asigna el estado a la asociación de arriba
    public void setAsoUp(Punto asoUp) {
        this.asoUp = asoUp;
    }
    //se le asigna el estado a la asociación izquierda
    public void setAsoIzq(Punto asoIzq) {
        this.asoIzq = asoIzq;
    }
    //se le asigna el estado a la asociación Noreste
    public void setAsoNE(Punto asoNE) {
        this.asoNE = asoNE;
    }
    //se le asigna el estado a la asociación Noroeste
    public void setAsoNO(Punto asoNO) {
        this.asoNO = asoNO;
    }
    //se le asigna el estado a la asociación sureste
    public void setAsoSE(Punto asoSE) {
        this.asoSE = asoSE;
    }
    //se le asigna el estado a la asociación suroeste
    public void setAsoSO(Punto asoSO) {
        this.asoSO = asoSO;
    }

}
