/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluadordeverdad;

/**
 *
 * @author arturo88
 */
public class Nodo {
    String info;
    Nodo izquierdo,derecho;

        public Nodo(String inf)
        {
        this(inf,null,null);
        }
        public Nodo(String inf,Nodo iz,Nodo der)
        {
            info=new String(inf); izquierdo=iz; derecho=der;
        }

}
