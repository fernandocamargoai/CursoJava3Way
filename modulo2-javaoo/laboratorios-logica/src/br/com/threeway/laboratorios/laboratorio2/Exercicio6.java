package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio6 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		char opcao;

		double totalDesconto = 0;
		double totalPago = 0;

		while (true){
			System.out.println("Insira valor do carro (0 para finalizar)");
			double valor = scanner.nextDouble();
			scanner.nextLine();

			if(valor == 0){
				break;
			}

			System.out.println("Insira o combustivel: 1=Álcool; 2=Gasolina; 3=Diesel");
			int combustivel = scanner.nextInt();
			scanner.nextLine();

			double desconto;

			switch (combustivel){
				case 1:
					desconto = valor * 25/100;
					break;
				case 2:
					desconto = valor * 21/100;
					break;
				case 3:
					desconto = valor * 14/100;
					break;
				default:
					System.out.println("Não existe esse combustível");
					continue;
			}

			double novoValor = valor - desconto;

			totalDesconto += desconto;
			totalPago += novoValor;

			System.out.println("Desconto: " + desconto);
			System.out.println("Valor pago: " + novoValor);
		}

		System.out.println("Total de desconto: " + totalDesconto);
		System.out.println("Total pago: " + totalPago);

	}
}
