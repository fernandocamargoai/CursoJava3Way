package br.com.threeway.locadora.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class TipoFilme implements Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Integer quantidadeDeDias;
	private Double valorDaLocacao;
	private Double valorDaRelocacao;

	public TipoFilme() {
	}

	public TipoFilme(String nome, Integer quantidadeDeDias, Double valorDaLocacao, Double valorDaRelocacao) {
		this.nome = nome;
		this.quantidadeDeDias = quantidadeDeDias;
		this.valorDaLocacao = valorDaLocacao;
		this.valorDaRelocacao = valorDaRelocacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public void setQuantidadeDeDias(Integer quantidadeDeDias) {
		this.quantidadeDeDias = quantidadeDeDias;
	}

	public Double getValorDaLocacao() {
		return valorDaLocacao;
	}

	public void setValorDaLocacao(Double valorDaLocacao) {
		this.valorDaLocacao = valorDaLocacao;
	}

	public Double getValorDaRelocacao() {
		return valorDaRelocacao;
	}

	public void setValorDaRelocacao(Double valorDaRelocacao) {
		this.valorDaRelocacao = valorDaRelocacao;
	}
}
