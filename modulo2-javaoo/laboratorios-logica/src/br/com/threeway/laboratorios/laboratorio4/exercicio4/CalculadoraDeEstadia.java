package br.com.threeway.laboratorios.laboratorio4.exercicio4;

public class CalculadoraDeEstadia {

	private int pontoDeCorte;
	private double valorDaDiaria;
	private double valorEstadiaLonga;
	private double valorEstadiaMedia;
	private double valorEstadiaCurta;

	public CalculadoraDeEstadia(int pontoDeCorte, double valorDaDiaria, double valorEstadiaLonga, double valorEstadiaMedia, double valorEstadiaCurta) {
		this.pontoDeCorte = pontoDeCorte;
		this.valorDaDiaria = valorDaDiaria;
		this.valorEstadiaLonga = valorEstadiaLonga;
		this.valorEstadiaMedia = valorEstadiaMedia;
		this.valorEstadiaCurta = valorEstadiaCurta;
	}

	public double calculeValorTotal(Estadia estadia){
		return estadia.getQuantidadeDeDiarias() * valorDaDiaria + calculeTaxaDeServico(estadia);
	}

	private double calculeTaxaDeServico(Estadia estadia){
		if(estadia.getQuantidadeDeDiarias() > pontoDeCorte){
			return valorEstadiaLonga * estadia.getQuantidadeDeDiarias();
		}
		else if(estadia.getQuantidadeDeDiarias() < pontoDeCorte){
			return valorEstadiaMedia * estadia.getQuantidadeDeDiarias();

		}
		else {
			return valorEstadiaCurta * estadia.getQuantidadeDeDiarias();
		}
	}

	public void setPontoDeCorte(int pontoDeCorte) {
		this.pontoDeCorte = pontoDeCorte;
	}

	public void setValorDaDiaria(double valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	public void setValorEstadiaLonga(double valorEstadiaLonga) {
		this.valorEstadiaLonga = valorEstadiaLonga;
	}

	public void setValorEstadiaMedia(double valorEstadiaMedia) {
		this.valorEstadiaMedia = valorEstadiaMedia;
	}

	public void setValorEstadiaCurta(double valorEstadiaCurta) {
		this.valorEstadiaCurta = valorEstadiaCurta;
	}
}
