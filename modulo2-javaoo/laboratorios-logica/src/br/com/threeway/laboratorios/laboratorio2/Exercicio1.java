package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira um número");
		int numero = scanner.nextInt();
		scanner.nextLine();

		if(numero > 10){
			System.out.println("Número maior que 10");
		}
	}

}
