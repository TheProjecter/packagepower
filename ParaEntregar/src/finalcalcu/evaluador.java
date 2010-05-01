/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

import java.util.Stack;

/**
 *
 * @author andrewwolff
 */
public class evaluador
{
    private Stack<String> operando = new Stack<String>();
    private String elemento;
    private double val1,val2;
    public String getRes(){
        return operando.lastElement();
    }
    public double operaciones(double Operando1, double Operando2, String Operador)
    {

        if(Operador.equals("+"))
            return (Operando1+Operando2);
        else if(Operador.equals("-"))
            return (Operando1-Operando2);
        else if(Operador.equals("*"))
            return (Operando1*Operando2);
        else if(Operador.equals("/"))
            return (Operando1/Operando2);

        return 0;
    }

    public void evaluar(String elem)
    {
        if (DeterminaType.obtieneTipo(elem)==2)
            operando.push(elem);
        else if(DeterminaType.obtieneTipo(elem)==1)
        {
            val2 = DeterminaType.numerico(operando.pop());
            val1 = DeterminaType.numerico(operando.pop());
            operando.push(String.valueOf(operaciones(val1,val2,elem)));
        }
    }

}
