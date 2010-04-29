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
    Nodo p= raiz, prev=null;
    if(DeterminaType.obtieneTipo(inf)== 2)
        p.info=inf;

    else if(DeterminaType.obtieneTipo(inf)== 1){

        if(p.izquierdo==null){
           prev=p.izquierdo;
           prev.info=inf;}
        else
           prev=p.derecho;
           prev.info=inf;

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
  public void visitar(Nodo p)
  {
      System.out.println(p + "");
  }
}
