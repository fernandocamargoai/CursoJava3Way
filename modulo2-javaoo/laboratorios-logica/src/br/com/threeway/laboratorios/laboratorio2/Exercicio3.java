package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira o nome do aluno");
		String nome = scanner.nextLine();
		System.out.println("Insira a nota 1");
		double nota1 = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Insira a nota 2");
		double nota2 = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Insira a nota 3");
		double nota3 = scanner.nextDouble();
		scanner.nextLine();

		double media = (nota1 + nota2 + nota3) / 3;

		System.out.println("Aluno: " + nome);
		if (media >= 7) {
			System.out.println("Aprovado: " + media);
		} else if (media >= 5) {
			System.out.println("Recuperação: " + media);
		} else {
			System.out.println("Reprovado: " + media);
		}
	}

}
