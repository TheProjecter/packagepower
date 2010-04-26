import javax.swing.JOptionPane;
public class AnalizadorGramatical {
	private AnalizadorLexico analizadorLex;
	private Token token;
		
	public AnalizadorGramatical(AnalizadorLexico analizadorLex){
		this.analizadorLex = analizadorLex;
		siguiente();
	}
	
	public void siguiente(){
		token = analizadorLex.siguienteToken();
	}
	
	private void empatar(TipoToken tipoToken){
		try{
		if(token.ObtenerTipo() == tipoToken)
			siguiente();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error en la expresion");
		}
	}	
		
	public Expresion analizar(){
		Expresion raiz= expresion();
		try{
		if(token.ObtenerTipo()==TipoToken.finalTokens)
			return raiz;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error en la expresion");
		}
		return null;
		
	}
	
	private Expresion expresion(){
		Termino ter = primerTermino();
		SigExpresion SE = sigExpresion();
		return new PrimerExpresion(ter, SE);
	} 
	
	private SigExpresion sigExpresion(){
		if(token.ObtenerTipo()==TipoToken.suma){
			empatar(TipoToken.suma);
			Termino T = primerTermino();
			SigExpresion SE = sigExpresion();
			return new SigExpresionSuma(T,SE);
		}
		if(token.ObtenerTipo()==TipoToken.resta){
			empatar(TipoToken.resta);
			Termino ter = primerTermino();
			SigExpresion SE = sigExpresion();
			return new SigExpresionResta(ter, SE);
		}		
		return null;
	}
			
	private Factor factor(){
		try{
			if(token.ObtenerTipo()==TipoToken.identificador){
				String id = token.obtenerValor();
				empatar(TipoToken.identificador);
				return new Identificador(id);
			}		
			if(token.ObtenerTipo()==TipoToken.parentesisInicial){
				empatar(TipoToken.parentesisInicial);
				Expresion exp=expresion();
				empatar(TipoToken.parentesisFinal);
				return new Parentesis(exp);
			}
			if(token.ObtenerTipo()==TipoToken.raiz){
				empatar(TipoToken.raiz);
				Expresion exp= expresion();
				return new Raiz(exp);
			}
			if(token.ObtenerTipo()==TipoToken.entero){
				String entero=token.obtenerValor();
				empatar(TipoToken.entero);
				return new Entero(Integer.parseInt(entero));
			}
			if(token.ObtenerTipo()==TipoToken.flotante){
				String entero=token.obtenerValor();
				empatar(TipoToken.flotante);
				return new Decimal(Double.parseDouble(entero));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error en la expresion");
		}
		return null;
	}
	
	private SigExponente sigExponente(){
		if(token.ObtenerTipo()==TipoToken.exponente){
			empatar(TipoToken.exponente);
			Factor fac = factor();
			SigExponente SE = sigExponente();
			return new SigExponentePotencia(fac, SE);
		}
		return null;
	}

	private Exponente primerExponente(){
		Factor fac = factor();
		SigExponente SE = sigExponente();
		return new PrimerExponente(fac, SE);		
	} 
	
	private SigTermino sigTerminos(){
		if(token.ObtenerTipo()==TipoToken.multiplicacion){
			empatar(TipoToken.multiplicacion);
			Exponente E = primerExponente();
			SigTermino R = sigTerminos();
			return new Multiplicacion(E,R);
		}
		if(token.ObtenerTipo()==TipoToken.division){
			empatar(TipoToken.division);
			Exponente expo = primerExponente();
			SigTermino sigTer = sigTerminos();
			return new Division(expo,sigTer);
		}
		if(token.ObtenerTipo()==TipoToken.modulo){
			empatar(TipoToken.modulo);
			Exponente E = primerExponente();
			SigTermino R = sigTerminos();
			return new Modulo(E,R);
		}
		return null;
	}
	
	private Termino primerTermino(){
		Exponente expo = primerExponente();
		SigTermino  sigTer =sigTerminos();
		return new PrimerTermino(expo, sigTer);		
	}
}