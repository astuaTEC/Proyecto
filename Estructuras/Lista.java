/**
 * Clase lista (lista simplemente enlazada)
 * @author Saymon Astúa
 */

package Estructuras;

public class Lista<T> {
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
        Nodo nuevo_nodo = new Nodo<T>(data);
        nuevo_nodo.setNext(this.head);
        this.head = nuevo_nodo;
        this.size++;

    }

    /**
     * Función para agregar al final de una lista
     *
     * @param data
     */
    public void insertLast(T data) {
        if (head == null) {
            this.head = new Nodo<T>(data);
        } else {
            Nodo aux = this.head;
            Nodo ultimo = aux;
            while (aux != null) {
                ultimo = aux;
                aux = aux.getNext();
            }
            Nodo nuevo_nodo = new Nodo<T>(data);
            ultimo.setNext(nuevo_nodo);
            this.size++;
        }


    }

    /**
     * Función para recorrer la lista desde el inicio hasta el final
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
        public T getLast(){
            Nodo<T> aux = this.head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            return (T) aux.getData();
        }

        /**
         * recorre una lista que se le envía
         */
        public void recorrer2() {
            Nodo<Punto> aux = (Nodo<Punto>) this.getHead();
            while (aux != null) {
                Punto d = (Punto) aux.getData();
                System.out.println("X: "+d.getX());
                System.out.println("Y: "+d.getY());
                System.out.println("--------");
                aux = aux.getNext();
            }

        }
        public Punto buscar(int x, int y){
            Nodo<Punto> aux = (Nodo<Punto>) this.head;
            while (aux != null){
                Punto punto = (Punto) aux.getData();
                if (punto.getX() == x & punto.getY() == y){
                    return punto;
                }
                else{
                    aux = aux.getNext();
                }
            }
            System.out.println("No se encuentra");
            return null;

        }

        public void enlazar(int a, int b, int c, int d){
            if(this.buscar(a,b)!= null & this.buscar(c,d)!= null){
                Punto from = this.buscar(a,b);
                Punto to = this.buscar(c,d);
                if(from.getDer()== c & from.getY() ==d){
                    if(from.isAsoDer()== false & to.isAsoIzq()==false){
                        from.setAsoDer(true);
                        to.setAsoIzq(true);
                        System.out.println("Puntos enlazados correctamente");
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getIzq() == c & from.getY() == d){
                    if(from.isAsoIzq()== false & to.isAsoDer()== false){
                        from.setAsoIzq(true);
                        to.setAsoDer(true);
                        System.out.println("Puntos enlazados correctamente");
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getDown() == d & from.getX() == c){
                    if(from.isAsoDown()==false & to.isAsoUp() == false){
                        from.setAsoDown(true);
                        to.setAsoUp(true);
                        System.out.println("Puntos enlazados correctamente");
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getUp() == d & from.getX() == c){
                    if( from.isAsoUp()== false & to.isAsoDown()==false){
                        from.setAsoUp(true);
                        to.setAsoDown(true);
                        System.out.println("Puntos enlazados correctamente");
                    }
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
}
