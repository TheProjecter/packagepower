/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;
import java.io.*;

/**
 * Aqui se ejecuta el programa
 * @author Amnesiac
 */
public class Main {
    public static void main(String args[]){
         InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        try
        {
            System.out.print("Ingrese la expresion separada por espacios \n Ejemplo: 3 + 4 : ");
            String Expresion =(br.readLine());
            new Analiza(Expresion); 


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

    



