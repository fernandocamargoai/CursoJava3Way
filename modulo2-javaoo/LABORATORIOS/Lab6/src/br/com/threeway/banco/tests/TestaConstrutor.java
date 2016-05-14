package br.com.threeway.banco.tests;

import br.com.threeway.banco.bean.Conta;
import br.com.threeway.banco.util.DataUtil;

public class TestaConstrutor {

    public static void main(String[] args){
        Conta conta1 = new Conta();
        Conta conta2 = new Conta("Fernando", 12345);

        System.out.println("Data de criação da conta 1: " + DataUtil.formateData(conta1.getDataAbertura()));
        System.out.println("Data de criação da conta 1: " + DataUtil.formateData(conta2.getDataAbertura()));
    }

}
