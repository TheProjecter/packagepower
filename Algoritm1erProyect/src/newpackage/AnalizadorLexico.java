/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.StringTokenizer;

public class AnalizadorLexico {

	private StringTokenizer tokens;

	public AnalizadorLexico(String expresion){
		tokens = new StringTokenizer(expresion,"()^*/%+- ",true);
	}

	public Token siguienteToken(){
		if(!tokens.hasMoreElements())
			return new Token(TipoToken.finalTokens,null);

		String lexema=tokens.nextToken();
		while(lexema.equals(" ")){
			if(!tokens.hasMoreElements())
				return new Token(TipoToken.finalTokens,null);
			lexema = tokens.nextToken();
		}
		return obtenerToken(lexema);
	}

	private Token obtenerToken(String lexema){
		ElementoLexico elementoLex = new ElementoLexico();
		if(elementoLex.esIdentificador(lexema))
			return new Token(TipoToken.identificador,lexema);
		if(elementoLex.esEntero(lexema))
			return new Token(TipoToken.entero,lexema);
		if(elementoLex.esFlotante(lexema))
			return new Token(TipoToken.flotante,lexema);

		if(elementoLex.esParentesisInicial(lexema))
			return new Token(TipoToken.parentesisInicial,lexema);
		if(elementoLex.esParentesisFinal(lexema))
			return new Token(TipoToken.parentesisFinal,lexema);

		if(elementoLex.esSignoSuma(lexema))
			return new Token(TipoToken.suma,lexema);
		if(elementoLex.esSignoResta(lexema))
			return new Token(TipoToken.resta,lexema);
		if(elementoLex.esSignoModulo(lexema))
			return new Token(TipoToken.modulo,lexema);
		if(elementoLex.esSignoMultiplicacion(lexema))
			return new Token(TipoToken.multiplicacion,lexema);
		if(elementoLex.esSignoDivision(lexema))
			return new Token(TipoToken.division,lexema);
		if(elementoLex.esSignoExponente(lexema))
			return new Token(TipoToken.exponente,lexema);

		return new Token(TipoToken.nodefinido,null);
	}
}

}
