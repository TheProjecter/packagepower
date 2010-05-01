/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

import java.util.*;

/**
 *
 * @author Amnesiac
 */
public class Polacalizadora {
    public static String polaca(String infija){
        StringTokenizer elemento = new StringTokenizer(infija);
        Arbol polaco = new Arbol();
        String polacota = new String();

        while (elemento.hasMoreTokens()) {

            String str = elemento.nextToken();
            polaco.insertar(str);
            
            }
        polaco.postorden();
        return polaco.getPostordenada();
    }
}
