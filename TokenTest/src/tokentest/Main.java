/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tokentest;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author andrewwolff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        //Obtener la cadena
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa la expresion (separando cada elemento con un espacio)\nDespues presiona enter: ");
		String sentence = scanner.nextLine();//En sentence se guarda la expresion

		//Procesando la cadena
		StringTokenizer tokens = new StringTokenizer(sentence);
		System.out.printf("El numero de elementos es: %d \n Las palabras son: \n",tokens.countTokens());

		while(tokens.hasMoreTokens())
			System.out.println(tokens.nextToken());

    }

}
