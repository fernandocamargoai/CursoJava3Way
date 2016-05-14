package br.com.threeway.banco.service;

import br.com.threeway.banco.bean.Conta;
import br.com.threeway.banco.bean.TipoTransacao;
import br.com.threeway.banco.bean.Transacao;
import br.com.threeway.banco.util.DataUtil;

public class ContaService {



    public void deposite(Conta contaCredito, double valor) {
        contaCredito.setSaldo(contaCredito.getSaldo() + valor);
        this.registreTransacao(null, contaCredito, valor, "deposito na conta " + contaCredito.getNumero(), TipoTransacao.DEPOSITO);
    }

    public boolean saque(Conta contaDebito, double valor) {
        if (contaDebito.getSaldo() >= valor) {
            contaDebito.setSaldo(contaDebito.getSaldo() - valor);
            this.registreTransacao(contaDebito, null, valor, "saque na conta " + contaDebito.getNumero(), TipoTransacao.SAQUE);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean transfira(Conta contaDebito, double valor, Conta contaCredito) {
        return transfira(contaDebito, valor, contaCredito, "transferencia para conta " + contaCredito.getNumero());
    }

    public boolean transfira(Conta contaDebito, double valor, Conta contaCredito, String descricao) {
        if (contaDebito.getSaldo() >= valor) {
            this.debite(contaDebito, valor);
            this.credite(contaCredito, valor);
            this.registreTransacao(contaDebito, contaCredito, valor, descricao, TipoTransacao.TRANSFERENCIA);
            return true;
        } else {
            return false;
        }
    }

    private void debite(Conta contaOperacao, double valor) {
        contaOperacao.setSaldo(contaOperacao.getSaldo() - valor);
    }

    private void credite(Conta contaOperacao, double valor) {
        contaOperacao.setSaldo(contaOperacao.getSaldo() + valor);
    }

    private void registreTransacao(Conta contaDebito, Conta contaCredito, double valor, String descricao, TipoTransacao tipoTransacao) {
        Transacao transacao = new Transacao(DataUtil.data(), contaDebito, contaCredito, valor, descricao, tipoTransacao);
        if (contaDebito != null) {
            contaDebito.getMovimento().add(transacao);
        }
        if (contaCredito != null) {
            contaCredito.getMovimento().add(transacao);
        }
    }


    // Sobrecarga do método transferir. Quando for invocado este método
    // deverá ser informado um valor para limite (cheque especial) que será adicionado ao
    // saldo da conta para verificar se pode ocorrer a transferência.
    public void transfira(Conta contaSaque, double valor, Conta contaDestino, double limite) {
        if ((contaSaque.getSaldo() + limite) < valor) {
            System.out.print("Saldo insuficiente para esta operação");
            return;
        }
        // transfere valor da conta para conta destino
        this.saque(contaSaque, valor);
        this.deposite(contaDestino, valor);
    }


}
