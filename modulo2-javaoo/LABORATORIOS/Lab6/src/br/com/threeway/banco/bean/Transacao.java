package br.com.threeway.banco.bean;

import br.com.threeway.banco.util.DataUtil;

import java.util.Date;

public class Transacao {

    private Date data;
    private Conta contaDebito;
    private Conta contaCredito;
    private double valor;
    private String descricao;
    private TipoTransacao tipoTransacao;

    public Transacao(Date data, Conta contaDebito, Conta contaCredito, Double valor, String descricao,
                     TipoTransacao tipoTransacao) {
        this.data = data;
        this.contaDebito = contaDebito;
        this.contaCredito = contaCredito;
        this.valor = valor;
        this.descricao = descricao;
        this.tipoTransacao = tipoTransacao;
    }

    public String toString() {
        switch (tipoTransacao){
            case TRANSFERENCIA:
                return "Transacao data " + DataUtil.formateDataHora(data) + ", conta debito "
                        + contaDebito.getNumero() + ", conta credito " + contaCredito.getNumero() + ", valor " +
                        valor + ", descricao -> " + descricao;
            case DEPOSITO:
                return "Deposito data " + DataUtil.formateDataHora(data) + ", conta " + contaCredito.getNumero() + ", valor " + valor + ", descricao -> " + descricao;
            case SAQUE:
                return "Saque data " + DataUtil.formateDataHora(data) + ", conta " + contaDebito.getNumero() + ", valor " + valor + ", descricao -> " + descricao;
            default:
                return "Nenhum tipo de transação";
        }
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getContaDebito() {
        return contaDebito;
    }

    public void setContaDebito(Conta contaDebito) {
        this.contaDebito = contaDebito;
    }

    public Conta getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(Conta contaCredito) {
        this.contaCredito = contaCredito;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
