/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;
import java.io.*;
import java.util.Scanner;

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
            System.out.print("Ingrese la expresion separada por espacios \n Ejemplo: X + 4 : ");
            String Expresion =(br.readLine());
            System.out.println("Introduce el primer valor de x:");
            double inferior = (new Scanner(System.in)).nextDouble();
            System.out.println("Introduce el ultimo valor de x:");
            double superior = (new Scanner(System.in)).nextDouble();
            System.out.println("Introduce el incremento de x:");
            double incremento = (new Scanner(System.in)).nextDouble();
            Tabulador T = new Tabulador();
            T.tabula(inferior,superior,incremento,Expresion);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

    



