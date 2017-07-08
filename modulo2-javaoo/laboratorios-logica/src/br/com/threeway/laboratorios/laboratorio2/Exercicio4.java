package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		char opcao;
		int contadorAte2000 = 0;
		int contadorGeral = 0;

		do {
			System.out.println("Insira valor do carro");
			double valor = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Insira ano do carro");
			int ano = scanner.nextInt();
			scanner.nextLine();

			double desconto;
			if(ano > 2000){
				desconto = valor * 7/100;
			}
			else {
				desconto = valor * 12/100;
				contadorAte2000++;
			}
			contadorGeral++;

			double novoValor = valor - desconto;

			System.out.println("Desconto: " + desconto);
			System.out.println("Valor pago: " + novoValor);


			System.out.println("Deseja continuar? (N) para Não.");
			opcao = scanner.nextLine().toUpperCase().charAt(0);
		}while (opcao != 'N');

		System.out.println("Quantidade de carros: " + contadorGeral);
		System.out.println("Quantidade de carros até 2000: " + contadorAte2000);

	}

}
