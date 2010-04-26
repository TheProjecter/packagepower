/*
 * Revisa los parentesis
 */

package newpackage;

/**
 *
 * @author Amnesiac
 */
public class RevisaPar {
    private boolean correcto =  false;
    
    public static void valida(String expresion){
        Pila parentesis = new Pila(expresion.length());
        for (int i=0;i<=expresion.length();i++){
            char x = expresion.charAt(i);
            if ( x == '(')
                parentesis.insertar(x);
            else if (x == ')'){
                if (parentesis.obtener()=='(');
            }
        }
    }
}
