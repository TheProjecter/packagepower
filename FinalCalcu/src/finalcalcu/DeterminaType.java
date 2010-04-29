/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

import java.util.*;
import java.util.regex.*;

/**
 * Si regresa 1 es un operador
 *            2 es operando
 * @author Administrador
 */
public class DeterminaType {
    public static int obtieneTipo(String entrada){
        Pattern patronOperador = Pattern.compile("[^a-zA-Z&&0-9]+");
        Matcher encaja = patronOperador.matcher(entrada);
        if (entrada.equals("*") || entrada.equals("/")|| entrada.equals("+")|| entrada.equals("-"))
        {
            return 1;
        }
        else if (entrada.equals("x") || encaja.find())
        {
            return 2;
        }

        return 0;
    }
/**
 *
 * @param numero introduces la cadena, y te devuelve un double
 * @return el valor numerico de la expresion
 */
    public static double numerico(String numero){
        return new Double(numero);
    }

    public static void main(String args[]){
        System.out.println("introduce algoo! ");
        int op = obtieneTipo(new String(new Scanner(System.in).nextLine()));
        if( op == 2 )
            System.out.println("se introdujo un operando");
        else if (op == 1)
            System.out.println("se introdujo un operador");
        else
            System.out.println("no se sabe que es la cadena D:");
    }
}

