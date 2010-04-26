public class Token { 
	private TipoToken tipo;
	private String valorToken;
	
	public Token(TipoToken tipo, String valor){
		this.tipo=tipo;
		valorToken= valor;
	}
	
	public TipoToken ObtenerTipo(){
		return tipo;
	}
	
	public String obtenerValor(){
		return valorToken;
	}
}