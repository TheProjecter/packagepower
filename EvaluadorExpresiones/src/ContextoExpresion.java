
public class ContextoExpresion{
     String varI="\n.data\nResultado REAL8 ?";
	String Oper="";


	public String Var(){
		return Variables;
	}

	public String VarInicial(){
		return varI;
	}

	String Variables="";
	int bandera=0;

	public void Variables(String valor){
		bandera++;
		Variables+="\nNombre"+bandera+" Real8 "+valor;
		Oper+="\nfld Nombre"+bandera;
	}

	String Cabecera="INCLUDE Irvine16.inc"+
			  "\nINCLUDE macros.inc"+
			  "\nInclude operaciones.asm";

	public String Cabecera(){
		return Cabecera;
	}

	String CodeI="\n.code"+
			"\nmain PROC"+
			"\nmov ax, @data"+
			"\nmov ds, ax"+
			"\nfinit";

	public String CodeI(){
		return CodeI;
	}

	String CodeF="\ncall writeFloat"+
				"\nexit"+
				"\nmain ENDP"+
				"\nEND main";

	public String CodeF(){
		return CodeF;
	}

	public String Operaciones(){
		return Oper;
	}

	public double evaluar(Expresion raiz){       
 		if(raiz instanceof PrimerExpresion){
			PrimerExpresion primera=(PrimerExpresion)raiz;
			double value=evaluar(primera.termino);
			if(primera.sigExp!=null){               
				return evaluar(primera.sigExp,value);
			}            
			return value;
		}
		throw new Error("Favor de verificar la expresion");
	}

	private double evaluar(SigExpresion raiz,double elemento){       
		if(raiz instanceof SigExpresionSuma){
			SigExpresionSuma SES =(SigExpresionSuma)raiz;         
			double valor=evaluar(SES.termino);
			if(SES.sigExp!=null){
                Oper+="\nfadd";
				return evaluar(SES.sigExp,elemento+valor);
            }
            Oper+="\nfadd";
			return elemento+valor;
		}
	
		if(raiz instanceof SigExpresionResta){
			SigExpresionResta SER=(SigExpresionResta)raiz;            
			double valor = evaluar(SER.termino);
			if(SER.sigExp!=null){
                Oper+="\nfsub";
				return evaluar(SER.sigExp,elemento - valor);
            }
            Oper+="\nfsub";
			return elemento - valor;
		}		
		throw new Error("Favor de verificar la expresion");
	}
		
	private double evaluar(Termino raiz){
		if(raiz instanceof PrimerTermino){
			PrimerTermino PT = (PrimerTermino)raiz;
			double valor = evaluar(PT.exponente);
			if(PT.sigTer!=null)
				return evaluar(PT.sigTer,valor);
			return valor;
		}
		throw new Error("Favor de verificar la expresion");
	}
	
	private double evaluar(SigTermino raiz,double termino){
		if(raiz instanceof Multiplicacion){
			Multiplicacion M =(Multiplicacion)raiz;
			double valor = evaluar(M.exponente);
			if(M.sigTer!=null){
                Oper+="\nfmul";
                return evaluar(M.sigTer,termino * valor);
            }
            Oper+="\nfmul";
			return termino * valor;
		}
		
		if(raiz instanceof Division){
			Division D=(Division)raiz;
			double valor = evaluar(D.exponente);
			if(D.resto!=null){
                	Oper+="\nfdiv";
				return evaluar(D.resto,termino/valor);
            }
            Oper+="\nfdiv";
			return termino/valor;
		}
		
		if(raiz instanceof Modulo){
			Modulo Mo = (Modulo) raiz;
			double valor=evaluar(Mo.exponente);
			if(Mo.sigTer!=null){
                Oper+="\nmodulo ";
				return evaluar(Mo.sigTer,termino % valor);
            }
            Oper+="\nmodulo ";
			return termino % valor;
		}		
		throw new Error("Favor de verificar la expresion");
	}
	
	private double evaluar(Exponente raiz){
		if(raiz instanceof PrimerExponente){
			PrimerExponente PE = (PrimerExponente)raiz;
			double valor=evaluar(PE.factor);
			if(PE.sigExp != null)
				return evaluar(PE.sigExp,valor);
			return valor;
		}
		throw new Error("Favor de verificar la expresion");
	}
	
	private double evaluar(SigExponente raiz,double base){
		if(raiz instanceof SigExponentePotencia){
			SigExponentePotencia REP=(SigExponentePotencia)raiz;
			double valor = evaluar(REP.factor);
			if(REP.sigExpo!=null){
                Oper+="\npotencia ";
				return evaluar(REP.sigExpo,Math.pow(base,valor));
            }
            Oper+="\npotencia ";
			return Math.pow(base,valor);
		}				
		throw new Error("Favor de verificar la exprecion");		
	}
	
	private double evaluar(Factor raiz){
		if(raiz instanceof Identificador){
			throw new Error();
		}
		if(raiz instanceof Entero){
			Entero numero=(Entero)raiz;
            String var=String.valueOf((double)numero.entero);
			Variables(var);
			return numero.entero;
		}
		if(raiz instanceof Decimal){
			Decimal numero=(Decimal)raiz;
            String var=String.valueOf((double)numero.flotante);
			Variables(var);
			return numero.flotante;
		}
		if(raiz instanceof Parentesis){
			Parentesis parentesis =(Parentesis)raiz;
			return evaluar(parentesis.expresion);
		}
		if(raiz instanceof Raiz){
			Raiz principal = (Raiz)raiz;
			double valor = evaluar(principal.expresion);
			return Math.pow(valor, 0.5);
		}		
		throw new Error("Favor de verificar la expresion");
	}
}
