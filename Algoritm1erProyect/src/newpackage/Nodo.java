/*
 * Como cualquier arbolin
 */

package newpackage;

/**
 *
 * @author Amnesiac
 */
public class Nodo {
    protected char info;
    protected Nodo izquierdo, derecho;

    public Nodo(){
        izquierdo=derecho=null;
    }

    public Nodo(char elemento){
        this(elemento,null,null);
    }

    public Nodo(char item, Nodo izquierdot, Nodo derechot){
        info=item;
        izquierdo=izquierdot;
        derecho=derechot;
    }
}
