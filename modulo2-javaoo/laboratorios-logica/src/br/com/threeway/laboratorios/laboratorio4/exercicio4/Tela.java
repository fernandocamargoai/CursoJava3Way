package br.com.threeway.laboratorios.laboratorio4.exercicio4;

import java.util.Scanner;

public class Tela {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira o nome do cliente");
		String nome = scanner.nextLine();

		System.out.println("Insira a quantidade de diárias");
		int diarias = scanner.nextInt();
		scanner.nextLine();

		Cliente cliente = new Cliente(nome);
//		Estadia estadia = new Estadia(new Cliente(nome), diarias);
		Estadia estadia = new Estadia(cliente, diarias);

		CalculadoraDeEstadia calculadoraDeEstadiaHotel1 = new CalculadoraDeEstadia(15, 60.0, 5.5, 6.0, 8.0);
		System.out.println("O cliente " + cliente.getNome() + " pagaria " + calculadoraDeEstadiaHotel1.calculeValorTotal(estadia) + " no hotel 1");

		CalculadoraDeEstadia calculadoraDeEstadiaHotel2 = new CalculadoraDeEstadia(20, 120.0, 12.5, 15.0, 20.0);
		System.out.println("O cliente " + cliente.getNome() + " pagaria " + calculadoraDeEstadiaHotel2.calculeValorTotal(estadia) + " no hotel 2");
	}

}
