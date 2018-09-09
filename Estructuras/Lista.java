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
        if (this.esta_vacia()) {
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
         * recorre una lista de puntos
         * imprime las coordenadas x y y de cada punto
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

    /**
     * busca un punto en una lista
     * @param x recibe la coordenada x del punto que se quiere buscar
     * @param y recibe la coordenada y del punto que se quiere buscar
     * @return el Punto que estabamos buscando o un null en caso de no encontrarlo
     */
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

    /**
     * función para enlazar o establecer una relación entre 2 puntos de una lista de puntos
     * @param j sirve para identificar el jugador que realiza el enlace
     * @param a la coordenada en x del punto desde donde se parte
     * @param b la coordenada en y del punto desde donde se parte
     * @param c la coordenadad en x del punto al que se quiere llegar o hacer el enlace
     * @param d la coordenada en y del punto al que se quiere llegar o hacer el enlace
     */
        public void enlazar(int j, int a, int b, int c, int d){
            if(this.buscar(a,b)!= null & this.buscar(c,d)!= null){
                Punto from = this.buscar(a,b);
                Punto to = this.buscar(c,d);
                if(from.getDer()== c & from.getY() ==d){
                    if(from.isAsoDer()== false & to.isAsoIzq()==false){
                        from.setAsoDer(true);
                        to.setAsoIzq(true);
                        System.out.println("Puntos enlazados correctamente");
                        System.out.println("Raya hecha por el jugador "+j);
                        //if(j==1){
                        // dibujar raya verde}
                        //else if(j ==2){
                        //dibujar raya roja}
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
                        System.out.println("Raya hecha por el jugador "+j);
                        //if(j==1){
                        // dibujar raya verde}
                        //else if(j ==2){
                        //dibujar raya roja}
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
                        System.out.println("Raya hecha por el jugador "+j);
                        //if(j==1){
                        // dibujar raya verde}
                        //else if(j ==2){
                        //dibujar raya roja}
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
                        System.out.println("Raya hecha por el jugador "+j);
                        //if(j==1){
                        // dibujar raya verde}
                        //else if(j ==2){
                        //dibujar raya roja}
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getX()+100 == c & from.getY()-100 == d){
                    if(from.isAsoNE()== false & to.isAsoSO()== false){
                        from.setAsoNE(true);
                        to.setAsoSO(true);
                        System.out.println("Puntos enlazados correctamente");
                        System.out.println("Raya hecha por el jugador "+j);
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getX()+100 == c & from.getY()+100 ==d){
                    if(from.isAsoSE()== false & to.isAsoNO()==false){
                        from.setAsoSE(true);
                        to.setAsoNO(true);
                        System.out.println("Puntos enlazados correctamente");
                        System.out.println("Raya hecha por el jugador "+j);
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getX()-100 == c & from.getY()-100 == d){
                    if(from.isAsoNO()== false & to.isAsoSE()== false){
                        from.setAsoNO(true);
                        to.setAsoSE(true);
                        System.out.println("Puntos enlazados correctamente");
                        System.out.println("Raya hecha por el jugador "+j);
                    }
                    else{
                        System.out.println("Los puntos ya se encuentran enlazados");
                    }
                }
                else if(from.getX()-100 == c & from.getY()+100 == d){
                    if(from.isAsoSO()==false & to.isAsoNE()==false){
                        from.setAsoSO(true);
                        from.setAsoNE(true);
                        System.out.println("Puntos enlazados correctamente");
                        System.out.println("Raya hecha por el jugador "+j);
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
