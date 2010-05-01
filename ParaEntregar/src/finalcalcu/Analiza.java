/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

import java.util.StringTokenizer;

/**
 *
 * @author arturo88
 */
public class Analiza {
    private StringTokenizer elemento;

    public Analiza(String expresion)
    {

        elemento= new StringTokenizer(expresion);
        evaluador pene = new evaluador();
        while (elemento.hasMoreTokens()) {
            String str = elemento.nextToken();
             pene.evaluar(str);
            }
        System.out.println("el resultado es " + pene.getRes());
    }
}
