/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

/**
 *
 * @author arturo88
 */
public class Tabulador {

    public void tabula(double min,double may, double incremento, String expresion)
    {

        for(double i=min; i<=may; i = i + incremento){
            Double x = new Double(i);
            String tmp = expresion;
            expresion = expresion.replace( "x", x.toString());
            System.out.println(expresion);
            System.out.print("\tF("+i+"):");
            new Analiza(Polacalizadora.polaca(expresion));
            System.out.println("");
            expresion = tmp;
        }
            
    }

}

