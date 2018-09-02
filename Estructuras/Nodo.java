/**
 * Creación de la clase nodo
 * @author Saymon Astúa
 */

package Estructuras;

public class Nodo {

    private Object data;
    private Object sgt;

    //constructor

    /**
     * crea una instancia de Nodo
     * @param data
     */
    public Nodo(Object data){
        this.sgt = null;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Nodo getNext(){
        return this.sgt;
    }

    public Nodo setNetx(Nodo nodo){
        this.sgt= nodo;
    }
}
