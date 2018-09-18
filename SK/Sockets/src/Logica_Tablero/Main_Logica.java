package Logica_Tablero;

public class Main_Logica {

	public static void main(String[] args) throws InterruptedException {
        Tablero tablero = new Tablero();
        tablero.enlazar(2,135,100,235,100);
        Thread.sleep(2000);
        tablero.enlazar(1,235,100,135,200);
        Thread.sleep(2000);
        tablero.enlazar(1,135,200,135,100);
        Thread.sleep(2000);
        tablero.enlazar(1,435,600,535,600);
        Thread.sleep(2000);
        tablero.enlazar(1,435,500,535,500);
        Thread.sleep(2000);
        tablero.enlazar(2,535,600,535,500);
        Thread.sleep(2000);
        tablero.enlazar(2,435,500,435,600);
        Thread.sleep(2000);
        tablero.enlazar(1,435,500,435,400);
        Thread.sleep(2000);
        tablero.enlazar(2,435,400,535,500);
        Thread.sleep(2000);
        tablero.enlazar(2,435,400,535,400);
        Thread.sleep(2000);
        tablero.enlazar(1,535,500,535,400);
        Thread.sleep(2000);
        tablero.enlazar(1,235,300,335,300);
        Thread.sleep(2000);
        tablero.enlazar(1,335,300,335,400);
        Thread.sleep(2000);
        tablero.enlazar(1,235,300,235,400);
        Thread.sleep(2000);
        tablero.enlazar(1,235,400,335,400);
    }
}
