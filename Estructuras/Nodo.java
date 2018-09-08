/**
 * Creación de la clase nodo
 * @author Saymon Astúa
 */

package Estructuras;

public class Nodo<T> {

    private T data;
    private Nodo<T> sgt;




    //constructor

    /**
     * crea una instancia de Nodo
     * @param data
     */
    public Nodo(T data){
        this.sgt = null;
        this.data = data;
    }


    public Object getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }

    public Nodo getNext(){
        return this.sgt;
    }

    public void setNext(Nodo<T> nodo){
        this.sgt= nodo;
    }
}
