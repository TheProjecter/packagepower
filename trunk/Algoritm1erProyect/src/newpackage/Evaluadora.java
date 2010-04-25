/*
 * aqui hacemos el desmadre de tanto evaluar la sintaxis, la expresion y obtener un resultado
 */

package newpackage;

/**
 * clase que recibe maneja la expresion
 * @author Amnesiac
 */
public class Evaluadora {

    public static Double evaula(String ecuacion){

        if (AnalizaSintax.analizadora(ecuacion))
            return 2.0;
        return null;
    }

}
