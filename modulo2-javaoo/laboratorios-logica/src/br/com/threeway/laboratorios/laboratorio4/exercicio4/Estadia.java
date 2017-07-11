package br.com.threeway.laboratorios.laboratorio4.exercicio4;

public class Estadia {

	private Cliente cliente;
	private int quantidadeDeDiarias;

	public Estadia(Cliente cliente, int quantidadeDeDiarias) {
		this.cliente = cliente;
		this.quantidadeDeDiarias = quantidadeDeDiarias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getQuantidadeDeDiarias() {
		return quantidadeDeDiarias;
	}

	public void setQuantidadeDeDiarias(int quantidadeDeDiarias) {
		this.quantidadeDeDiarias = quantidadeDeDiarias;
	}
}
