package br.com.threeway.banco.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {

    private int numero;
    private String titular;
    private double saldo;
    private Date dataAbertura;
    private List<Transacao> movimento;

    public Conta() {
        this.dataAbertura = new Date();
        movimento = new ArrayList<Transacao>();
    }

    public Conta(String titular, int numero) {
        this();
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public List<Transacao> getMovimento() {
        return movimento;
    }

    public void setMovimento(List<Transacao> movimento) {
        this.movimento = movimento;
    }
}
