/**
 * Clase lista (lista simplemente enlazada)
 * @author Saymon Astúa
 */

package Estructuras;

public class Lista<T> {
    /**
     * atributos de la clase lista
     */
    private Nodo<T> head;
    private int size;

    /**
     * constructor
     */
    public Lista() {
        this.head = null;
        this.size = 0;
    }

    public Boolean esta_vacia() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Método para insertar al inicio de la lista
     *
     * @param data
     */
    public void insertFirst(T data) {
        Nodo<T> nuevo_nodo = new Nodo<T>(data);
        nuevo_nodo.setNext(this.head);
        this.head = nuevo_nodo;
        this.size++;
    }
    /**
         * retorna el primer nodo de la lista
         * @return
         */
        public Nodo<T> getHead(){
            return this.head;
        }


    /**
     * busca un punto en una lista
     * @param x recibe la coordenada x del punto que se quiere buscar
     * @param y recibe la coordenada y del punto que se quiere buscar
     * @return el Punto que estabamos buscando o un null en caso de no encontrarlo
     */
    public Punto buscar(int x, int y){
        Nodo<Punto> aux = (Nodo<Punto>) this.getHead();
        while(aux!= null){
            Punto punto = (Punto) aux.getData();
            if(punto.getX()==x & punto.getY() == y){
                return punto;
            }
            else {
                aux = aux.getNext();
            }
        }
        return null;
    }
}


