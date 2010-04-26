/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

public  class Multiplicacion extends SigTermino{
	public Exponente exponente;
	public SigTermino sigTer;

	public Multiplicacion (Exponente exponente, SigTermino sigTer){
		this.exponente = exponente;
		this.sigTer = sigTer;
	}
}