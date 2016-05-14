package br.com.threeway.banco.service;

import br.com.threeway.banco.bean.Conta;
import br.com.threeway.banco.bean.TipoTransacao;
import br.com.threeway.banco.bean.Transacao;
import br.com.threeway.banco.util.DataUtil;

public class ContaService {

    public void depositar(Conta contaDestino, double valor) {
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        this.registreTransacao(null, contaDestino, valor, "deposito na conta " + contaDestino.getNumero(), TipoTransacao.DEPOSITO);
    }

    public void sacar(Conta contaSaque, double valor) {
        contaSaque.setSaldo(contaSaque.getSaldo() - valor);
        this.registreTransacao(contaSaque, null, valor, "saque na conta " + contaSaque.getNumero(), TipoTransacao.SAQUE);
    }

    public boolean transferir(Conta contaSaque, double valor, Conta contaDestino) {
        return transferir(contaSaque, valor, contaDestino, "transferencia para conta " + contaDestino.getNumero());
    }

    public boolean transferir(Conta contaSaque, double valor, Conta contaDestino, String descricao) {
        if (contaSaque.getSaldo() - valor >= 0) {
            this.debite(contaSaque, valor);
            this.credite(contaDestino, valor);
            this.registreTransacao(contaSaque, contaDestino, valor, descricao, TipoTransacao.TRANSFERENCIA);
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
    public void transferir(Conta contaSaque, double valor, Conta contaDestino, double limite) {
        if ((contaSaque.getSaldo() + limite) < valor) {
            System.out.print("Saldo insuficiente para esta operação");
            return;
        }
        // transfere valor da conta para conta destino
        this.sacar(contaSaque, valor);
        this.depositar(contaDestino, valor);
    }


}
