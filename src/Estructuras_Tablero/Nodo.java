package Estructuras_Tablero;
/**
 * Clase para crear los nodos que contiene la lista enlazada
 * @author Saymon Astua
 * @param <T> Tipo de dato que contiene el nodo
 */
public class Nodo<T> {
    //atributos

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

    /**
     * métodos geter de la clase nodo
     * @return el dato o el nodo siguiente
     */
    public Object getData() {
        return data;
    }

    public Nodo getNext(){
        return this.sgt;
    }

    /**
     * método seter de la clase nodo
     * coloca a un nodo en la posición adelante
     * @param nodo
     */
    public void setNext(Nodo<T> nodo){
        this.sgt= nodo;
    }
}
