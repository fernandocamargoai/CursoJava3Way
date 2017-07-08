package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double precoDeCustoTotal = 0;
		double precoDeVendaTotal = 0;

		int quantidadeDeProdutos = 4;
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			System.out.println("Insira preço de custo");
			double precoDeCusto = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("Insira preço de venda");
			double precoDeVenda = scanner.nextDouble();
			scanner.nextLine();

			if (precoDeVenda > precoDeCusto) {
				System.out.println("Houve lucro");
			} else if (precoDeVenda < precoDeCusto) {
				System.out.println("Houve prejuízo");
			} else {
				System.out.println("Houve empate");
			}

			precoDeCustoTotal += precoDeCusto;
			precoDeVendaTotal += precoDeVenda;
		}

		System.out.println("Média de preço de custo: " + precoDeCustoTotal / quantidadeDeProdutos);
		System.out.println("Média de preço de venda: " + precoDeVendaTotal / quantidadeDeProdutos);
	}

}
