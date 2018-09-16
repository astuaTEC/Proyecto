package Logica;

import Estructuras.Lista;
import Estructuras.Nodo;
import Estructuras.Punto;

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

public class Tablero {
    private Lista<Punto> tablero;
    private ArrayList<Polygon> poligonos = new ArrayList<>();


    public Tablero() {
        Lista<Punto> lista_a = new Lista();
        for (int i = 0; i <= 500; i += 100) {
            for (int j = 100; j <= 600; j += 100) {
                Punto punto = new Punto(i, j);
                lista_a.insertFirst(punto);
            }
        }
        this.tablero = lista_a;

    }
/**
    public boolean recorrer_figuras(Punto from, Punto to) {
        Punto f = from;
        Punto t = to;
        Punto aux = f;
        while (aux != t) {
            if (aux.getX() < t.getX() & aux.getY() == t.getY()) {
                if (t.isAsoSO() != null & t.isAsoSO() != f) {
                    f = t;
                    t = t.isAsoSO();
                    System.out.println("entro");
                } else if (t.isAsoDown() != null & t.isAsoDown() != null) {
                    f = t;
                    t = t.isAsoDown();
                    System.out.println("entro");
                } else if (t.isAsoSE() != f & t.isAsoSE() != null) {
                    f = t;
                    t = t.isAsoSE();
                } else if (t.isAsoDer() != null & t.isAsoDer() != f) {
                    f = t;
                    t = t.isAsoDer();
                }
            }
            if (aux.getX() > t.getX() & aux.getY() <= t.getY()) {
                if (t.isAsoDer() != null & t.isAsoDer() != f) {
                    f = t;
                    t = t.isAsoDer();
                    System.out.println("entro");
                } else if (t.isAsoNE() != null & t.isAsoNE() != f) {
                    f = t;
                    t = t.isAsoNE();
                } else if (t.isAsoUp() != null & t.isAsoUp() != f) {
                    f = t;
                    t = t.isAsoUp();
                    System.out.println("entro");
                } else if (t.isAsoNO() != null & t.isAsoNO() != f) {
                    f = t;
                    t = t.isAsoNO();
                    System.out.println("entro");
                } else if (t.isAsoIzq() != null & t.isAsoIzq() != f) {
                    f = t;
                    t = t.isAsoIzq();
            }
            if (aux.getY() < t.getY() & aux.getX() < t.getX()) {
                if (t.isAsoSE() != f & t.isAsoSE() != null) {
                    f = t;
                    t = t.isAsoSE();
                } else if (t.isAsoDer() != null & t.isAsoDer() != f) {
                    f = t;
                    t = t.isAsoDer();
                    System.out.println("entro");
                } else if (t.isAsoNE() != null & t.isAsoNE() != f) {
                    f = t;
                    t = t.isAsoNE();
                    System.out.println("entro");
                } else if (t.isAsoUp() != null & t.isAsoUp() != f) {
                    f = t;
                    t = t.isAsoUp();
                    System.out.println("entro");
                } else if (t.isAsoNO() != null & t.isAsoNO() != f) {
                    f = t;
                    t = t.isAsoNO();
                    System.out.println("entro");
                } else if (t.isAsoIzq() != null & t.isAsoIzq() != f) {
                    f = t;
                    t = t.isAsoIzq();
                } else if (t.isAsoSO() != null & t.isAsoSO() != f) {
                    f = t;
                    t = t.isAsoSO();
                    System.out.println("entro");
                }
            }
            if (aux.getY() < t.getY() & aux.getX() > t.getX()) {
                if (t.isAsoNE() != null & t.isAsoNE() != f) {
                    f = t;
                    t = t.isAsoNE();
                    System.out.println("entro");
                } else if (t.isAsoUp() != null & t.isAsoUp() != f) {
                    f = t;
                    t = t.isAsoUp();
                    System.out.println("entro");
                } else if (t.isAsoNO() != null & t.isAsoNO() != f) {
                    f = t;
                    t = t.isAsoNO();
                    System.out.println("entro");
                } else if (t.isAsoIzq() != null & t.isAsoIzq() != f) {
                    f = t;
                    t = t.isAsoIzq();
                } else if (t.isAsoSO() != null & t.isAsoSO() != f) {
                    f = t;
                    t = t.isAsoSO();
                    System.out.println("entro");
                } else if (t.isAsoDown() != null & t.isAsoDown() != null) {
                    f = t;
                    t = t.isAsoDown();
                    System.out.println("entro");
                }
            }
        }return true;
    }*/

            /**
             * función para enlazar o establecer una relación entre 2 puntos de una lista de puntos
             * @param j sirve para identificar el jugador que realiza el enlace
             * @param a la coordenada en x del punto desde donde se parte
             * @param b la coordenada en y del punto desde donde se parte
             * @param c la coordenadad en x del punto al que se quiere llegar o hacer el enlace
             * @param d la coordenada en y del punto al que se quiere llegar o hacer el enlace
             */
    public void enlazar(int j, int a, int b, int c, int d){
        ArrayList<Punto> lista = new ArrayList<>();
        if(tablero.buscar(a,b)!= null & tablero.buscar(c,d)!= null){
            Punto from = tablero.buscar(a,b);
            Punto to = tablero.buscar(c,d);
            if(from.getDer()== c & from.getY() ==d){
                if(from.isAsoDer()== null & to.isAsoIzq()==null){
                    from.setAsoDer(to);
                    from.vecinos.add(to);
                    to.setAsoIzq(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getIzq() == c & from.getY() == d){
                if(from.isAsoIzq()== null & to.isAsoDer()== null){
                    from.setAsoIzq(to);
                    from.vecinos.add(to);
                    to.setAsoDer(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getDown() == d & from.getX() == c){
                if(from.isAsoDown()==null & to.isAsoUp() == null){
                    from.setAsoDown(to);
                    from.vecinos.add(to);
                    to.setAsoUp(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getUp() == d & from.getX() == c){
                if( from.isAsoUp()== null & to.isAsoDown()==null){
                    from.setAsoUp(to);
                    from.vecinos.add(to);
                    to.setAsoDown(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getX()+100 == c & from.getY()-100 == d){
                if(from.isAsoNE()== null & to.isAsoSO()== null){
                    from.setAsoNE(to);
                    from.vecinos.add(to);
                    to.setAsoSO(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getX()+100 == c & from.getY()+100 ==d){
                if(from.isAsoSE()== null & to.isAsoNO()==null) {
                    from.setAsoSE(to);
                    from.vecinos.add(to);
                    to.setAsoNO(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador " + j);
                    if (from.vecinos.size() >= 2) {
                        buscar_figuras(lista, from, to);
                    }
                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getX()-100 == c & from.getY()-100 == d){
                if(from.isAsoNO()== null & to.isAsoSE()== null){
                    from.setAsoNO(to);
                    from.vecinos.add(to);
                    to.setAsoSE(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }
                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else if(from.getX()-100 == c & from.getY()+100 == d){
                if(from.isAsoSO()==null & to.isAsoNE()==null){
                    from.setAsoSO(to);
                    from.vecinos.add(to);
                    from.setAsoNE(from);
                    to.vecinos.add(from);
                    System.out.println("Puntos enlazados correctamente");
                    System.out.println("Raya hecha por el jugador "+j);
                    if (from.vecinos.size()>=2){
                        buscar_figuras(lista,from,to);
                    }                }
                else{
                    System.out.println("Los puntos ya se encuentran enlazados");
                }
            }
            else{
                System.out.println("Punto inválido");
            }
        }
        else{
            System.out.println("No existe ese punto");
        }
    }

    /**
     * recorre una lista de puntos
     * imprime las coordenadas x y y de cada punto
     */
    public void recorrer2() {
        Nodo<Punto> aux = (Nodo<Punto>) tablero.getHead();
        while (aux != null) {
            Punto d = (Punto) aux.getData();
            System.out.println("X: "+d.getX());
            System.out.println("Y: "+d.getY());
            System.out.println("--------");
            //enviar d por JSON
            aux = aux.getNext();
        }

    }
    public void buscar_figuras(ArrayList<Punto> lista, Punto destino, Punto actual) {
        if (destino == actual & destino.vecinos.size() >= 2) {
            //si le llega un 1, lo agrega a la lista de jugador 1
            //si le llega un 2, lo agrega a la lista de jugador 2
            Polygon fig = new Polygon();
            for (Punto p : lista) {
                fig.addPoint(p.getX(), p.getY());
                System.out.println("agrego a: X: " + p.getX() + "Y: " + p.getY());
            }
            if (poligonos.size() == 0 & fig.npoints > 2) {
                poligonos.add(fig);
                System.out.println(fig.getBounds());
                if (fig.npoints == 3) {
                    System.out.println("Triangulo hecho");
                } else if (fig.npoints == 4) {
                    System.out.println("cuadrado hecho");
                } else {
                    System.out.println("Poligono hecho");
                }
            } else if (poligonos.size() != 0 & fig.npoints > 2) {
                if (revisar_p(fig) != null) {
                    poligonos.add(fig);
                }
            }
                System.out.println(poligonos.size());
                for (Polygon p : poligonos) {
                    System.out.println(p);
                    System.out.println(p.getBounds());
                }
            } else {
                for (Punto vecino : actual.vecinos) {
                    if (!lista.contains(vecino)) {
                        lista.add(vecino);
                        buscar_figuras(lista, destino, vecino);
                        lista.remove(vecino);
                    }

                }

            }
        }
        public Polygon revisar_p (Polygon fig){
            for (Polygon p : poligonos) {
                Area a = new Area(p);
                Area b = new Area(fig);
                Area c = new Area(p);
                System.out.println(a.getBounds());
                System.out.println(b.getBounds());
                System.out.println(b.isEmpty());
                a.subtract(b);
                System.out.println(fig.intersects(p.getBounds()));
                System.out.println(b.getBounds());
                if (!a.equals(c)) {
                    return null;
                }
            }
            return fig;
        }
}