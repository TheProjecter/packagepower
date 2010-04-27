/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabulador;

/**
 *
 * @author arturo88
 */
public class Tabula {

    public void tabulaPrueba(float min,float may)
    {
        EvaluadorDePrubeba k= new EvaluadorDePrubeba();
        for(float i=min; i<=may ; i++){
            System.out.print("\tF("+i+"):" +k.evalua(i)+"\n");
        }
    }

}
