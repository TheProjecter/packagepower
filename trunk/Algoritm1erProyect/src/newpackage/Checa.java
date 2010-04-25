/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;
import java.lang.String.*;
/**
 *
 * @author arturo88
 */
public class Checa {
    Nodo operador;

    public void insertar(char elemento )
    {
      Nodo p=operador, prev=null;
      if(operador==null)
        if(elemento=='+'||elemento=='*'||elemento=='/'||elemento=='-')
        operador= new Nodo(elemento);
        else
        prev.derecho=new Nodo(elemento);
        
    }
}