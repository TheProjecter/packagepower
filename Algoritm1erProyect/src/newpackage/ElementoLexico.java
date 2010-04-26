/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import java.util.regex.Pattern;

public class ElementoLexico {
	private boolean reconocedorElementoLexico(String valorToken,String patronRegular){
		return Pattern.matches(patronRegular,valorToken);
	}

	public boolean esIdentificador(String valorToken){
		 return reconocedorElementoLexico(valorToken,"(_|[a-zA-Z])(\\d|[a-zA-z]|_)*");
	}

	public  boolean esEntero(String valorToken){
		 return reconocedorElementoLexico(valorToken,"[+-]?\\d+");
	}

	public  boolean esNotacionCientifica(String valorToken){
		 return reconocedorElementoLexico(valorToken,"[+-]?\\d*[\\.]?\\d+[eE][+-]?\\d+");
	}

	public  boolean esFlotante(String valorToken){
		 if(reconocedorElementoLexico(valorToken,"[+-]?\\d*\\.\\d+"))
			 return true;
		 return esNotacionCientifica(valorToken);
	}

	public  boolean esParentesisInicial(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\({1}");
	}

	public  boolean esParentesisFinal(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\){1}");
	}

	public  boolean esSignoSuma(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\+{1}");
	}

	public  boolean esSignoResta(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\-{1}");
	}

	public  boolean esSignoMultiplicacion(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\*{1}");
	}

	public  boolean esSignoDivision(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\/{1}");
	}

	public  boolean esSignoModulo(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\%{1}");
	}

	public  boolean esSignoExponente(String valorToken){
		return reconocedorElementoLexico(valorToken,"\\^{1}");
	}
}
