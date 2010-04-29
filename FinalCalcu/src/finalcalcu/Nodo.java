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

    public Nodo(String inf, int tip){
        this(inf,null,null,tip);
    }
    public Nodo(String inf,Nodo izq, Nodo der, int tip)
    {
        tipo = tip; info= new String(inf); izquierdo=izq; derecho=der;
    }

}
