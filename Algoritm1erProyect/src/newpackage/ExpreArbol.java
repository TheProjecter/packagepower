/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

/**
 *
 * @author arturo88
 */
public class ExpreArbol {
    protected Nodo raiz;
    Nodo factor(){
        if(/*Si es un numero o un operador*/)
            return new Nodo(elemento);
        else if(elemento=='('){
            Nodo p=expre();
            if(elemento==')')
                return p;
            else System.out.println("Error");
        }
    }

}
