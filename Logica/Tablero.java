package Logica;

import Estructuras.Lista;
import Estructuras.Punto;

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

public class Tablero {
    private Lista<Punto> tablero;
    private ArrayList<Polygon> poligonos = new ArrayList<>();
    private ArrayList<Polygon> figuras1 = new ArrayList<>();
    private ArrayList<Polygon> figuras2 = new ArrayList<>();
    private int puntos_j1;
    private int puntos_j2;

    /**
     * constructor del Tablero
     */
    public Tablero() {
        Lista<Punto> lista_a = new Lista();
        for (int i = 35; i <= 535; i += 100) {
            for (int j = 100; j <= 600; j += 100) {
                Punto punto = new Punto(i, j);
                lista_a.insertFirst(punto);
            }
        }
        this.tablero = lista_a;

    }
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
                        buscar_figuras(j,lista,from,to);
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
                        buscar_figuras(j,lista,from,to);
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
                        buscar_figuras(j,lista,from,to);
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
                        buscar_figuras(j,lista,from,to);
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
                        buscar_figuras(j,lista,from,to);
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
                        buscar_figuras(j,lista, from, to);
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
                        buscar_figuras(j,lista,from,to);
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
                        buscar_figuras(j,lista,from,to);
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
     * función para determinar si hay alguna figura que se completa.
     * @param j jugador que realiza la línea
     * @param lista vacía, para ir guardando el recorrido que realiza
     * @param destino hacia donde se quiere llegar recorriendo los puntos
     * @param actual donde se encuentra en el momento de realizar las validaciones
     */

    public void buscar_figuras(int j,ArrayList<Punto> lista, Punto destino, Punto actual) {
        if (destino == actual & destino.vecinos.size() >= 2) {
            Polygon fig = new Polygon();
            for (Punto p : lista) {
                fig.addPoint(p.getX(), p.getY());
            }
            if (poligonos.size() == 0 & fig.npoints > 2) {
                poligonos.add(fig);
                if(j == 1){
                    figuras1.add(fig);  //se agrega la figura a la lista de figuras para el jugador 1
                    puntajes();
                }
                else{
                    figuras2.add(fig); //se agrega la figura a la lista de figuras para el jugador 2
                    puntajes();
                }
                if (fig.npoints == 3) {
                    System.out.println("Triangulo hecho");
                } else if (fig.npoints == 4) {
                    System.out.println("cuadrado hecho");
                } else {
                    System.out.println("Poligono hecho");
                }
            } else if (poligonos.size() != 0 & fig.npoints > 2) {
                if (revisar_p(fig) != null) {
                    poligonos.add(fig); //se agrega  la figura a la lista de polígonos totales en el tablero
                    if (j == 1) {
                        figuras1.add(fig); //se agrega la figura a la lista de figuras para el jugador 1
                        puntajes();
                    } else {
                        figuras2.add(fig); //se agrega la figura a la lista de figuras para el jugador 2
                        puntajes();

                    }
                }
                System.out.println(poligonos.size());
                System.out.println(figuras1.size());
                System.out.println(figuras2.size());
                puntajes();
                for(Polygon p:poligonos){
                    System.out.println(p.getBounds());
                }
            }
            } else {
                for (Punto vecino : actual.vecinos) {
                    if (!lista.contains(vecino)) {
                        lista.add(vecino);
                        buscar_figuras(j,lista, destino, vecino);  //se llama a la misma función recursivamente
                        lista.remove(vecino);
                    }

                }

            }
        }

    /**
     * revisa si una figura interseca o no con las demás que existen el poligonos(figuras totales en el tablero)
     * @param fig una figura(poligono) para compararlo con el resto que ya existen
     * @return fig(poligono) si no interseca con ninguna otra figura, o null en caso contrario.
     */
    public Polygon revisar_p (Polygon fig){
            for (Polygon p : poligonos) {
                Area a = new Area(fig);
                Area b = new Area(p);
                Area c = new Area(fig);
                a.subtract(b);
                if (!a.equals(c)) {
                    return null;
                }
            }
            return fig;
        }

    /**
     * función para determinar los puntajes que llevan cada jugador
     */
    public void puntajes(){
        int suma1 = 0;
        int suma2=0;
        for(Polygon p: figuras1){
            suma1+= (p.npoints*2);
        }
        puntos_j1=suma1;
        for(Polygon p: figuras2){
            suma2 += (p.npoints*2);
        }
        puntos_j2=suma2;
        System.out.println("puntos jugador1: "+puntos_j1);
        System.out.println("puntos jugador2: "+puntos_j2);
        }

}