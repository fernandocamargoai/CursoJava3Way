package br.com.threeway.banco.tests;

import br.com.threeway.banco.bean.Conta;
import br.com.threeway.banco.service.ContaService;

import java.util.Scanner;

public class TestaConta {

    public static void main(String[] argv) {
        //Objeto para ler dados via console
        Scanner c = new Scanner(System.in);
        //Declara e inicializa a variavel saldoConta
        System.out.println("Digite o saldo inicial da conta");
        double saldoConta = c.nextDouble();
        //Declara e inicializa o numero da conta
        System.out.println("Digite o numero da conta");
        int numeroConta = c.nextInt();
        //Cria uma instância de ContaService onde está presente as operações para Objeto Conta
        ContaService operacoesConta = new ContaService();
        //Cria uma instância da classe Conta
        Conta conta1 = new Conta();
        //Altera o valor dos atributos da instância conta criada
        conta1.setNumero(numeroConta);
        conta1.setSaldo(saldoConta);
        //Cria uma nova instância da classe Conta
        Conta conta2 = new Conta();
        //Imprime os dados do objetos conta1
        System.out.println("O numero da Conta1 :" + conta1.getNumero());
        System.out.println("O saldo da Conta1 :" + conta1.getSaldo());
        //Chama o método depositar para adicionar saldo na conta
        System.out.println("Será creditado 100 reais na conta ");
        operacoesConta.deposite(conta1, 100.00);
        System.out.println("Saldo da Conta1 :" + conta1.getSaldo());
        //Chama o método sacar para debitar no saldo da conta
        System.out.println("Será debitado 56.43 reais na conta ");
        operacoesConta.saque(conta1, 56.43);
        System.out.println("Saldo da Conta :" + conta1.getSaldo());
        //Imprime o saldo das contas 1 e 2.
        System.out.println("Saldo da Conta 1 :" + conta1.getSaldo());
        System.out.println("Saldo da Conta 2 :" + conta2.getSaldo());
        //Chama o método tranferir para debitar na conta 1 e creditar na conta 2
        System.out.println("Transferir 50.00 de conta 1 para conta2 ");
        operacoesConta.transfira(conta1, 50.00, conta2);
        //Imprime o saldo das contas 1 e 2.
        System.out.println("Saldo da Conta 1 :" + conta1.getSaldo());
        System.out.println("Saldo da Conta 2 :" + conta2.getSaldo());
        Conta conta3 = new Conta();
        System.out.println("Transferir " + conta1.getSaldo() / 2 + " de conta 1 para conta3 ");
        operacoesConta.transfira(conta1, conta1.getSaldo() / 2, conta3);
        System.out.println("Saldo da Conta 1 :" + conta1.getSaldo());
        System.out.println("Saldo da Conta 3 :" + conta3.getSaldo());
    }

}
