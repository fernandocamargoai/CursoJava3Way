package br.com.threeway.laboratorios.laboratorio2;

import java.util.Scanner;

public class Exercicio7 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira o salário mínimo");
		double salarioMinimo = scanner.nextDouble();
		scanner.nextLine();

		double reajusteTotal = 0;

		for(int i=0; i<5; i++){
			System.out.println("Insira o nome do funcionário");
			String nome = scanner.nextLine();

			System.out.println("Insira o salário do funcionário");
			double salario = scanner.nextDouble();

			double vezesSalarioMinimo = salario / salarioMinimo;

			double reajuste;

			if(vezesSalarioMinimo > 20){
				// Demais funcionários
				reajuste = 10/100 * salario;
			}
			else if(vezesSalarioMinimo > 10){
				// Entre 10 e 20
				reajuste = 15/100 * salario;
			}
			else if(vezesSalarioMinimo >= 3){
				// Entre 3 e 10
				reajuste = 20/100 * salario;
			}
			else {
				// Menos que 3
				reajuste = 50/100 * salario;
			}

			double novoSalario = salario + reajuste;

			reajusteTotal += reajuste;

			System.out.println("Funcionário: " + nome);
			System.out.println("Reajuste: " + reajuste);
			System.out.println("Novo salário: " + novoSalario);
		}

		System.out.println("Vai aumentar " + reajusteTotal + " na folha salarial.");
	}

}
