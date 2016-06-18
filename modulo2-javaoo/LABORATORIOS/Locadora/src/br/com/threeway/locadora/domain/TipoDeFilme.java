package br.com.threeway.locadora.domain;

public enum TipoDeFilme {

    CATALOGO(3, 1.5, 1.0),
    LANCAMENTO(2, 2.5, 2.0),
    SUPER_LANCAMENTO(1, 4.0, 4.0);

    private int quantidadeDeDias;
    private double valorDaLocacao;
    private double valorDaRelocacao;

    private TipoDeFilme(int quantidadeDeDias,
                double valorDaLocacao,
                double valorDaRelocacao) {
        this.quantidadeDeDias = quantidadeDeDias;
        this.valorDaLocacao = valorDaLocacao;
        this.valorDaRelocacao = valorDaRelocacao;
    }

    public int getQuantidadeDeDias() {
        return quantidadeDeDias;
    }

    public double getValorDaLocacao() {
        return valorDaLocacao;
    }

    public double getValorDaRelocacao() {
        return valorDaRelocacao;
    }
}
