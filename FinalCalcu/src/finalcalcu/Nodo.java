/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

/**
 *
 * @author arturo88
 */
public class Nodo {
    String info;
    int tipo;
    Nodo izquierdo,derecho,padre;

    public Nodo(String inf){
        this(inf,null,null);
    }
    public Nodo(String inf,Nodo izq, Nodo der)
    {
        info= new String(inf); izquierdo=izq; derecho=der;
    }

}
