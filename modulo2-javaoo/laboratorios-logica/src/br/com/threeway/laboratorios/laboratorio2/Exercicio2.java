package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira um número");
		int numero1 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Insira outro número");
		int numero2 = scanner.nextInt();
		scanner.nextLine();

		if(numero1 > numero2){
			System.out.println(numero1);
		}
		else if(numero2 > numero1) {
			System.out.println(numero2);
		}
		else {
			System.out.println("Números iguais");
		}
	}
}
