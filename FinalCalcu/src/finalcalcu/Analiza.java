/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

import java.util.StringTokenizer;
import java.util.Stack;

/**
 *
 * @author arturo88
 */
public class Analiza {
    private StringTokenizer elemento;
    private static boolean correcto=false;

    /*  public boolean isCorrecto(){
        return correcto;
    }

    public void setCorrecto(boolean titi){
        correcto = titi;
    }*/


 /*public void checaPar(String expresion )
    {
      Stack <char> parentesis = new <char>  Stack();
      for(int i = 0; i<= expresion.length();i++)
      {
          char x = expresion.charAt(i);
          if(x=='(')
              parentesis.push(x);
          else if(x==')')
              if(parentesis.lastElement()=='(')
                  parentesis.pop();
              else if(parentesis.isEmpty())
                  correcto=true;
                  break;
      }
    }
   */
    public Analiza(String expresion)
    {

        elemento= new StringTokenizer(expresion);

        while (elemento.hasMoreTokens()) {
            String str = elemento.nextToken();
            int op = DeterminaType.obtieneTipo(str);
            if(op==1) {
                System.out.println("operador ");
            }
            else if(op == 2){
                System.out.println("operando ");
            }
            else System.out.println("null ");
            }

    }

    public void MeterArbol(double elemento)
    {

    }


}
