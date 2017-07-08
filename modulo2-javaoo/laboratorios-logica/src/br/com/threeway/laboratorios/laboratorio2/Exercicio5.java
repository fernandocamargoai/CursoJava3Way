package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira um número de 1 a 5");
		int numero = scanner.nextInt();
		scanner.nextLine();

		switch (numero){
			case 1:
				System.out.println("UM");
				break;
			case 2:
				System.out.println("DOIS");
				break;
			case 3:
				System.out.println("TRÊS");
				break;
			case 4:
				System.out.println("QUATRO");
				break;
			case 5:
				System.out.println("CINCO");
				break;
			default:
				System.out.println("Número inválido");
				break;
		}
	}

}
