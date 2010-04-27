/*
 * Proyecto " Calculadora "
 * Usando estructuras de datos básicas se pretende hacer una calculadora
 * evaluando la expresión a partir de una cadena de texto introducida por
 * el usuario.
 */

package newpackage;
import java.util.*;

/**
 * Aqui se ejecuta el programa
 * @author Amnesiac
 */
public class CalculadoraMain {
    public static void main(String args[]){
        System.out.println("Introduce una cadena a evaluar: ");
        Scanner teclado = new Scanner(System.in);
        Evaluadora.evalua(teclado.nextLine());
    }

}
