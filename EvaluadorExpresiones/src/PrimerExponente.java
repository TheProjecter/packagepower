
public  class PrimerExponente extends Exponente {
	public Factor factor;
	public SigExponente sigExp;
		
	public PrimerExponente (Factor factor, SigExponente sigExp){
		this.sigExp = sigExp;	
		this.factor=factor;
	}
}
