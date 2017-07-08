package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio8 {

	private static final String[] MESES = {
			"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		System.out.println("Insira o número do mês");
		int mes = scanner.nextInt() - 1;
		scanner.nextLine();

		if(mes < 0 || mes > 11){
			System.out.println("Mês inválido");
			return;
		}

		System.out.println(MESES[mes]);
	}

}
