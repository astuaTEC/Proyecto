package Logica;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tablero tablero = new Tablero();
        tablero.enlazar(2,100,100,200,100);
        Thread.sleep(2000);
        tablero.enlazar(1,200,100,100,200);
        Thread.sleep(2000);
        tablero.enlazar(2,100,200,100,100);
        Thread.sleep(2000);
        tablero.enlazar(1,400,600,500,600);
        Thread.sleep(2000);
        tablero.enlazar(2,400,500,500,500);
        Thread.sleep(2000);
        tablero.enlazar(2,500,600,500,500);
        Thread.sleep(2000);
        tablero.enlazar(2,400,500,400,600);
        Thread.sleep(2000);
        tablero.enlazar(1,400,500,400,400);
        Thread.sleep(2000);
        tablero.enlazar(2,400,400,500,500);
        Thread.sleep(2000);
        tablero.enlazar(2,400,400,500,400);
        Thread.sleep(2000);
        tablero.enlazar(2,500,500,500,400);
    }
}
