/*
 * Revisa los parentesis
 */

package newpackage;

/**
 *
 * @author Amnesiac
 */
public class RevisaPar {
    private static boolean correcto;
    
    public boolean isCorrecto(){
        return correcto;
    }

    public void setCorrecto(boolean titi){
        correcto = titi;
    }

    public static void valida(String expresion){
        Pila parentesis = new Pila(expresion.length());
        for (int i=0;i<=expresion.length();i++){
            char x = expresion.charAt(i);
            if ( x == '(')
                parentesis.insertar(x);
            else if (x == ')'){
                if (parentesis.obtener()=='(')
                    System.out.println(";D");
                else{
                    correcto = true;
                    break;
                }
            }
        }
    }
    
}
