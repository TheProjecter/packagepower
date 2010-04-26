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
Nodo term(){
    char oper;
    Nodo p1,p2;
    p1=factor();
    while(elemento=='*'||elemento='/'){
        oper=elemento;
        p2=factor();
        p1=new Nodo(oper,p1,p2);

    }
    return p1;
}
}
