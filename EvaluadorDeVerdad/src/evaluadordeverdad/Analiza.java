/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package evaluadordeverdad;
import java.util.StringTokenizer;
import java.util.Stack;

/**
 *
 * @author arturo88
 */
public class Analiza {
    private StringTokenizer elemento;
    private static boolean correcto=false;
    Arbol arbolin = new Arbol();
      public boolean isCorrecto(){
        return correcto;
    }

    public void setCorrecto(boolean titi){
        correcto = titi;
    }


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
    public void Analiza(String expresion)
    {
        elemento= new StringTokenizer(expresion);
         while (elemento.hasMoreTokens()) {
         MeterArbol(elemento.nextToken());
     }

    }

    public void MeterArbol(String elemento)
    {
        arbolin.insertar(elemento);
        arbolin.postorden();
    }


}
