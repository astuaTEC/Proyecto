package Logica;

import Estructuras.Lista;
import Estructuras.Punto;

public class Tablero {
    private Lista<Punto> tablero;


    public static void main(String[] args) {
        Lista<Punto> lista_a = new Lista();
        for (int i = 100; i <=600; i += 100) {
            for (int j = 100; j <= 600; j += 100) {
                Punto punto = new Punto(i,j);
                lista_a.insertFirst(punto);
            }
        }
        lista_a.recorrer2();
        //lista_a.recorrer();
        lista_a.enlazar(1,200,300,200,200);
        lista_a.enlazar(2,200,100,300,100);
        //lista_a.enlazar(1,300,200,300,100);
        lista_a.enlazar(1,300,100,200,200);

    }
}

