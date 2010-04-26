/*
 * Como cualquier arbolin
 */

package newpackage;

/**
 *
 * @author Amnesiac
 */
public class Nodo {
   String info;
   Nodo izquierdo, derecho;
   Nodo(String k){
       this(k,null,null);
   }
   Nodo(String k,Nodo lt,Nodo dt)
   {
      info= k; izquierdo=lt; derecho=dt;
   }
}
