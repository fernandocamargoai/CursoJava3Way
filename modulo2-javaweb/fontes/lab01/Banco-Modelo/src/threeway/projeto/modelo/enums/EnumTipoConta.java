package threeway.projeto.modelo.enums;

public enum EnumTipoConta {

	CONTA_PESSOAL("Conta Pessoal"), CONTA_ESPECIAL("Conta Especial");

	private String valor;

	private EnumTipoConta( String valor ) {

		this.valor = valor;
	}

	public String getValor() {

		return valor;
	}

	public void setValor(String valor) {

		this.valor = valor;
	}

	@Override
	public String toString() {

		return valor;
	}

}
