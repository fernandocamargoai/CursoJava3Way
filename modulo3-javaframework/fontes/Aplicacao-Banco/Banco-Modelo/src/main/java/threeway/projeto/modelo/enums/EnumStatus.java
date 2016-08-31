package threeway.projeto.modelo.enums;

public enum EnumStatus {
	
	ATIVO("ativo"), INATIVO("inativo");
	
	private String valor;
	
	
	private EnumStatus (String valor) {
		
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
