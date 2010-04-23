/*
 * Como cualquier arbolin
 */

package newpackage;

/**
 *
 * @author Amnesiac
 */
public class Nodo {
    protected Object info;
    protected Nodo izquierdo, derecho;

    public Nodo(){
        izquierdo=derecho=null;
    }

    public Nodo(Object elemento){
        this(elemento,null,null);
    }

    public Nodo(Object item, Nodo izquierdot, Nodo derechot){
        info=item;
        izquierdo=izquierdot;
        derecho=derechot;
    }
}
