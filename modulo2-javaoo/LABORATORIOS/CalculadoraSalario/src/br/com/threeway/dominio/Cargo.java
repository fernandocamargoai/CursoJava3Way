package br.com.threeway.dominio;

public enum Cargo {

    DESENVOLVEDOR(3000.0, 5.0, 8.0),
    DESIGNER(2800.0, 6.0, 8.0),
    VENDEDOR(1200.0, 15.0, 12.0),
    GERENTE(3150.0, 6.0, 9.0),
    ADMINISTRADOR(1500.0, 7.0, 11.0);


    private Double limiar;
    private Double porcentagemMaiorQueLimiar;
    private Double porcentagemMenorQueLimiar;

    Cargo(Double limiar, Double porcentagemMaiorQueLimiar, Double porcentagemMenorQueLimiar) {
        this.limiar = limiar;
        this.porcentagemMaiorQueLimiar = porcentagemMaiorQueLimiar;
        this.porcentagemMenorQueLimiar = porcentagemMenorQueLimiar;
    }

    public Double getLimiar() {
        return limiar;
    }

    public Double getPorcentagemMaiorQueLimiar() {
        return porcentagemMaiorQueLimiar;
    }

    public Double getPorcentagemMenorQueLimiar() {
        return porcentagemMenorQueLimiar;
    }
}
