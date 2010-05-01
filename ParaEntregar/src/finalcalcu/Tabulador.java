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
    public void tabula(double min,double may, String expresion)
    {
        Evaluadora k= new Evaluadora();
        for(double i=min; i<=may;i++)
            System.out.print("\tF("+i+"):" +k.evalua(expresion,i)+"\n");
    }

}
