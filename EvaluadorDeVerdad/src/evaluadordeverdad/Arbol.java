/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluadordeverdad;
import java.util.Stack;

/**
 *
 * @author arturo88
 */
public class Arbol {
   protected Nodo raiz;

    public Arbol()
    {
        raiz=null;
    }
    public void insertar(String inf)
    {
      Nodo p = raiz, prev=null;
      while(p!=null){
          prev=p;
          if(p.izquierdo!=null)
              p=p.izquierdo;
          else if(p.derecho!=null)
              p=p.derecho;
      }
      if(raiz==null)
          raiz= new Nodo(inf);
      else if(prev.izquierdo!=null)
          prev.izquierdo= new Nodo(inf);
      else prev.derecho= new Nodo(inf);
    }
    public void visitar(Nodo p)
    {
     System.out.println(p.info + "");
    }

 public void postorden()
 {
     Nodo p=raiz, q=raiz;
     Stack pila = new Stack ();
     while(p!=null){
         for(; p.izquierdo!=null;p=p.izquierdo)
             pila.push(p);
         while(p!=null && (p.derecho==null || p.derecho==q)){
             visitar(p);
             q=p;
             if(pila.isEmpty())
                 return;
             p=(Nodo) pila.pop();
         }
         pila.push(p);
         p=p.derecho;
     }

 }
 
 
}