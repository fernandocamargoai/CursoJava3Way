package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Desafio {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);


		System.out.println("Insira A");
		int a = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Insira B");
		int b = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Insira C");
		char c = scanner.nextLine().charAt(0);

		int resultado;

		switch (c){
			case '+':
				resultado = a + b;
				break;
			case '-':
				resultado = a - b;
				break;
			case '*':
				resultado = a * b;
				break;
			case '/':
				if(b == 0){
					System.out.println("Não pode dividir por 0");
					return;
				}
				resultado = a / b;
				break;
			default:
				System.out.println("Operador inválido");
				return;
		}

		System.out.println("Resultado: " + resultado);
	}

}
