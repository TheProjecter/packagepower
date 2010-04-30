/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;
import java.util.Stack;
/**
 *
 * @author arturo88
 */
public class Arbol {
private Nodo raiz;

public Arbol(){
     raiz=null;
 }
public void insertar(String inf)
{

    if(raiz==null){
        if(DeterminaType.obtieneTipo(inf)==2)
            raiz=new Nodo(inf);
    }
    else{
        if(raiz!=null && DeterminaType.obtieneTipo(inf)==1){
            Nodo temp = raiz;
            raiz = new Nodo(inf);
            raiz.izquierdo = temp;
        }
        else if(raiz!=null && DeterminaType.obtieneTipo(inf)==2)
            raiz.derecho = new Nodo(inf);
        }

}
 
 public void postorden()
 {
     Nodo p=raiz, q=raiz;
     Stack pila = new Stack ();
     while(p!=null){
         for(; p.izquierdo!=null;p=p.izquierdo)
             pila.push(p);
         while(p!=null && (p.derecho==null || p.derecho==q)){
             visitar(p.info);
             q=p;
             if(pila.isEmpty())
                 return;
             p=(Nodo) pila.pop();
         }
         pila.push(p);
         p=p.derecho;
     }
  }
  public void visitar(String p)
  {
      System.out.println(p + "");
  }
}

 
 