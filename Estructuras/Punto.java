/**
 * Clase Punto
 * @author Saymon Astúa
 * Se utiliza como un objeto fijo en el tablero
 */
package Estructuras;

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
    private boolean asoDer;
    private boolean asoIzq;
    private boolean asoUp;
    private boolean asoDown;
    private boolean asoNE;
    private boolean asoNO;
    private boolean asoSE;
    private boolean asoSO;

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
    public boolean isAsoDer() {
        return asoDer;
    }
    //se obtiene si ya hay asociación con el vecino de abajo
    public boolean isAsoDown() {
        return asoDown;
    }
    //se obtiene si ya hay asociación con el vecino de la izquierda
    public boolean isAsoIzq() {
        return asoIzq;
    }
    //se obtiene si ya hay asociación con el vecino de arriba
    public boolean isAsoUp() {
        return asoUp;
    }
    //se obtiene si ya hay asociación con el vecino del Noreste
    public boolean isAsoNE() {
        return asoNE;
    }
    //se obtiene si ya hay asociación con el vecino del Noroeste
    public boolean isAsoNO() {
        return asoNO;
    }
    //se obtiene si ya hay asociación con el vecino del sureste
    public boolean isAsoSE() {
        return asoSE;
    }
    //se obtiene si ya hay asociación con el vecino de la suroeste
    public boolean isAsoSO() {
        return asoSO;
    }

    /**
     * todos los métodos seter de esta clase
     * trabajan con un argumento (puede ser un int o un boolean dependiendo de la función)
     */
    //se le asigna el estado a la asociación derecha
    public void setAsoDer(boolean asoDer) {
        this.asoDer = asoDer;
    }
    //se le asigna el estado a la asociación de abajo
    public void setAsoDown(boolean asoDown) {
        this.asoDown = asoDown;
    }
    //se le asigna el estado a la asociación de arriba
    public void setAsoUp(boolean asoUp) {
        this.asoUp = asoUp;
    }
    //se le asigna el estado a la asociación izquierda
    public void setAsoIzq(boolean asoIzq) {
        this.asoIzq = asoIzq;
    }
    //se le asigna el estado a la asociación Noreste
    public void setAsoNE(boolean asoNE) {
        this.asoNE = asoNE;
    }
    //se le asigna el estado a la asociación Noroeste
    public void setAsoNO(boolean asoNO) {
        this.asoNO = asoNO;
    }
    //se le asigna el estado a la asociación sureste
    public void setAsoSE(boolean asoSE) {
        this.asoSE = asoSE;
    }
    //se le asigna el estado a la asociación suroeste
    public void setAsoSO(boolean asoSO) {
        this.asoSO = asoSO;
    }

}
