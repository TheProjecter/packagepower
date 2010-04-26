/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

/**
 *
 * @author arturo88
 */
public  class Division extends SigTermino{
	public Exponente exponente;
	public SigTermino resto;

	public Division (Exponente exponente,SigTermino resto){
		this.exponente = exponente;
		this.resto = resto;
	}

}

