
/**
 *
 * @author Fredy Ramirez Guzman
 */
import java.io.*;
public class Codigo{
    File c = new File("expresion.c");
    File f = new File("expresion.asm");
    RandomAccessFile raf, raf2;
    boolean entrar = true;
    int contador = 0;
    String expresion;
	public double evaluar(Expresion raiz, String exp){
        if(entrar){
            expresion = exp;
            entrar = false;
        }
        try{
        if(f.exists()) f.delete();
        if(c.exists()){ c.delete();}
        raf = new RandomAccessFile(f,"rw");
        raf2 = new RandomAccessFile(c,"rw");
        raf.writeBytes("INCLUDE<irvine16.inc>\n");
        raf2.writeBytes("#include <stdio.h>\n"+                        
                        "void main(){\n"+
                        "float a = 0;\n"+
                        "printf(\""+expresion+"\");\n");
        }catch(Exception rt){}
 		if(raiz instanceof PrimerExpresion){
			PrimerExpresion primera=(PrimerExpresion)raiz;
			double value=evaluar(primera.termino);
			if(primera.sigExp!=null){               
                double valor = evaluar(primera.sigExp,value);                                 
				return valor;
			}
            try{
                raf2.writeBytes("a="+String.valueOf(value)+";");
            }catch(Exception exc){}
			return value;
		}
		throw new Error("Favor de verificar la expresion");
	}

    int ban = 0;

	private double evaluar(SigExpresion raiz,double elemento){
        int ban2 = 0;
		if(raiz instanceof SigExpresionSuma){
			SigExpresionSuma SES =(SigExpresionSuma)raiz;
			double valor=evaluar(SES.termino);
			if(SES.sigExp!=null){
                try{
                   raf.seek(raf.length());
                   raf.writeByte('\n');
                   raf.writeBytes("SUMAR  \t");
                   raf.writeBytes(String.valueOf(elemento)+","
                                      +String.valueOf(valor));

                   raf2.seek(raf2.length());                   
                   raf2.writeBytes("\na=");
                   raf2.writeBytes(String.valueOf(elemento)+"+"+String.valueOf(valor)+";");

                }catch(Exception exc){}
				return evaluar(SES.sigExp,elemento+valor);
            }
            try{
               raf.seek(raf.length());
               raf.writeByte('\n');
               raf.writeBytes("SUMAR  \t");
               raf.writeBytes(String.valueOf(elemento)+","
                                +String.valueOf(valor));
               raf2.seek(raf2.length());
               raf2.writeBytes("\na=");
               raf2.writeBytes(String.valueOf(elemento)+"+"+String.valueOf(valor)+";");
            }catch(Exception exc){}
			return elemento+valor;
		}

		if(raiz instanceof SigExpresionResta){
			SigExpresionResta SER=(SigExpresionResta)raiz;
			double valor = evaluar(SER.termino);
			if(SER.sigExp!=null){
                try{
                   raf.seek(raf.length());
                   raf.writeByte('\n');
                   raf.writeBytes("RESTAR\t");
                   raf.writeBytes(String.valueOf(elemento)+","
                                  +String.valueOf(valor));
                   raf2.seek(raf2.length());
                   raf2.writeBytes("\na=");
                   raf2.writeBytes(String.valueOf(elemento)+"-"+String.valueOf(valor)+";");
                }catch(Exception exc){}
				return evaluar(SER.sigExp,elemento - valor);
            }
            try{
               raf.seek(raf.length());
               raf.writeByte('\n');
               raf.writeBytes("RESTAR\t");
               raf.writeBytes(String.valueOf(elemento)+","
                              +String.valueOf(valor));
               raf2.seek(raf2.length());
               raf2.writeBytes("\na=");
               raf2.writeBytes(String.valueOf(elemento)+"-"+String.valueOf(valor)+";");
            }catch(Exception exc){}
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
                try{
                   raf.seek(raf.length());
                   raf.writeByte('\n');
                   raf.writeBytes("MULTIPLICAR\t");
                   raf.writeBytes(String.valueOf(termino)+","
                                  +String.valueOf(valor));
                   raf2.seek(raf2.length());
                   raf2.writeBytes("\na=");
                   raf2.writeBytes(String.valueOf(termino)+"*"+String.valueOf(valor)+";");
                }catch(Exception exc){}
                return evaluar(M.sigTer,termino * valor);
            }
            try{
               raf.seek(raf.length());
               raf.writeByte('\n');
               raf.writeBytes("MULTIPLICAR\t");
               raf.writeBytes(String.valueOf(termino)+","
                              +String.valueOf(valor));
                raf2.seek(raf2.length());
                raf2.writeBytes("\na=");
                raf2.writeBytes(String.valueOf(termino)+"*"+String.valueOf(valor)+";");
            }catch(Exception exc){}
			return termino * valor;
		}

		if(raiz instanceof Division){
			Division D=(Division)raiz;
			double valor = evaluar(D.exponente);
			if(D.resto!=null){
                try{
                   raf.seek(raf.length());
                   raf.writeByte('\n');
                   raf.writeBytes("DIVIDIR\t");
                   raf.writeBytes(String.valueOf(termino)+","
                                  +String.valueOf(valor));
                   raf2.seek(raf2.length());
                   raf2.writeBytes("\na=");
                   raf2.writeBytes(String.valueOf(termino)+"/"+String.valueOf(valor)+";");
                }catch(Exception exc){}
				return evaluar(D.resto,termino/valor);
            }
            try{
               raf.seek(raf.length());
               raf.writeByte('\n');
               raf.writeBytes("DIVIDIR\t");
               raf.writeBytes(String.valueOf(termino)+","
                              +String.valueOf(valor));
               raf2.seek(raf2.length());
               raf2.writeBytes("\na=");
               raf2.writeBytes(String.valueOf(termino)+"/"+String.valueOf(valor)+";");
            }catch(Exception exc){}
			return termino/valor;
		}

		if(raiz instanceof Modulo){
			Modulo Mo = (Modulo) raiz;
			double valor=evaluar(Mo.exponente);
			if(Mo.sigTer!=null)
				return evaluar(Mo.sigTer,termino % valor);
            try{
               raf.seek(raf.length());
               raf.writeByte('\n');
               raf.writeBytes("MODULO\t");
               raf.writeBytes(String.valueOf(termino)+","
                              +String.valueOf(valor));
               raf2.seek(raf2.length());
               raf2.writeBytes("\na=");
               raf2.writeBytes(
                       String.valueOf((int)termino)+"%"+String.valueOf((int)valor)+";");
            }catch(Exception exc){}
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
			if(REP.sigExpo!=null)
				return evaluar(REP.sigExpo,Math.pow(base,valor));
            try{
               raf.seek(raf.length());
               raf.writeByte('\n');
               raf.writeBytes("POTENCIA\t");
               raf.writeBytes(String.valueOf(base)+","
                              +String.valueOf(valor));
                raf2.seek(raf2.length());
                raf2.writeBytes("\na=");
                raf2.writeBytes("pow("+String.valueOf(base)+","+String.valueOf(valor)+");");
            }catch(Exception exc){}
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
			return numero.entero;
		}
		if(raiz instanceof Decimal){
			Decimal numero=(Decimal)raiz;
			return numero.flotante;
		}
		if(raiz instanceof Parentesis){
			Parentesis parentesis =(Parentesis)raiz;
			return evaluar(parentesis.expresion,"");
		}
		if(raiz instanceof Raiz){
			Raiz principal = (Raiz)raiz;
			double valor = evaluar(principal.expresion,"");
			return Math.pow(valor, 0.5);
		}
		throw new Error("Favor de verificar la expresion");
	}
}

