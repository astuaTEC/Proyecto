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
     * Función para agregar al final de una lista
     *
     * @param data
     */
    public void insertLast(Nodo<T> data) {
        if (this.esta_vacia()) {
            this.head = new Nodo<T>((T) data);
        } else {
            Nodo aux = this.head;
            Nodo ultimo = aux;
            while (aux != null) {
                ultimo = aux;
                aux = aux.getNext();
            }
            Nodo nuevo_nodo = new Nodo<T>((T) data);
            ultimo.setNext(nuevo_nodo);
            this.size++;
        }
    }

    /**
     * Función para recorrer la lista desde el inicio hasta el final de la lista
     */
    public void recorrer() {
        Nodo aux = this.head;
        while (aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }
        /**
         * método para eliminar el primer elemento de una lista
         */
        public void deleteFirst () {
            Nodo<T> aux = this.head;
            if (aux != null) {
                this.head = aux.getNext();
            }
        }

        /**
         * retorna el primer nodo de la lista
         * @return
         */
        public Nodo<T> getHead(){
            return this.head;
        }

        /**
         * retorna el ultimo elemento de la lista
         * @return
         */
        public Nodo<T> getLast(){
            Nodo<T> aux = this.head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            return aux;
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
        public boolean buscar_p(Punto p){
            Nodo<Punto> aux = (Nodo<Punto>) this.head;
            while (aux != null){
                Punto punto = (Punto) aux.getData();
                if (punto.getX() == p.getX() & punto.getY()==p.getY()){
                    return true;
                }
                else{
                    aux = aux.getNext();
                }
            }
            System.out.println("No se encuentra");
            return false;

        }
        /**public void eliminar(Punto p) {
            Nodo<Punto> aux = (Nodo<Punto>) this.getHead();
            while (aux.getNext() != null) {
                if (aux.getNext().getData() == p.getData()) {
                    aux.setNext(p);
                    aux = aux.getNext();
                }
                else{
                    aux = aux.getNext();
                }
            }
            System.out.println("nodo eliminado");
        }*/
}


