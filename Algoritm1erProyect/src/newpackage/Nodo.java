/*
 * Como cualquier arbolin
 */

package newpackage;

/**
 *
 * @author Amnesiac
 */
public class Nodo {
   char info;
   Nodo izquierdo, derecho;
   Nodo(char k){
       this(k,null,null);
   }
   Nodo(char k,Nodo lt,Nodo dt)
   {
      info= k; izquierdo=lt; derecho=dt;
   }
}
