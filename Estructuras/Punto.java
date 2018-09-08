package Estructuras;

public class Punto {

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

    public Punto(int x, int y ){
        this.x= x;
        this.y = y;
        this.der = x+100;
        this.izq = x-100;
        this.up= y+100;
        this.down= y-100;

    }

    public Punto() {
    }


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getDer() {
        return der;
    }
    public int getDown() {
        return down;
    }
    public int getIzq() {
        return izq;
    }
    public int getUp() {
        return up;
    }

    public void setAsoDer(boolean asoDer) {
        this.asoDer = asoDer;
    }

    public void setAsoDown(boolean asoDown) {
        this.asoDown = asoDown;
    }

    public void setAsoUp(boolean asoUp) {
        this.asoUp = asoUp;
    }

    public void setAsoIzq(boolean asoIzq) {
        this.asoIzq = asoIzq;
    }

    public boolean isAsoDer() {
        return asoDer;
    }

    public boolean isAsoDown() {
        return asoDown;
    }

    public boolean isAsoIzq() {
        return asoIzq;
    }

    public boolean isAsoUp() {
        return asoUp;
    }
}
