/**
 * Clase lista (lista simplemente enlazada)
 * @author Saymon Astúa
 */

package Estructuras;

public class Lista {
    private Nodo head;
    private int size;

    /**
     * constructor
     */
    public Lista(){
        this.head = null;
        this.size= 0;
    }

    public Boolean esta_vacia(){
        return this.head == null;
    }

    public int getSize(){
        return this.size;
    }

    /**
     * Método para insertar al inicio de la lista
     * @param data
     */
    public void insertFirst(Object data){
        Nodo nuevo_nodo = new Nodo(data);
        nuevo_nodo.setNetx(this.head);
        this.head = nuevo_nodo;
        this.size++;

    }

    public void recorrer(){
        Nodo aux = this.head;
        while(aux!= null){
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }

    public void deleteFirst(){
        Nodo aux = this.head;
        if (aux != null){
            this.head = aux.getNext();
        }
    }
}
