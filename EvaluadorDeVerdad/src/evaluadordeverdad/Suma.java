/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluadordeverdad;
import java.io.*;

public class Suma
{
    public static void main (String [] args)
    {
        Analiza analiza = new Analiza();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        try
        {
            System.out.print("Ingrese la expresion separada por espacios \n Ejemplo: 3 + 4 : ");
            String Expresion =(br.readLine());
         //  analiza.checaPar(Expresion);
            analiza.Analiza(Expresion);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

