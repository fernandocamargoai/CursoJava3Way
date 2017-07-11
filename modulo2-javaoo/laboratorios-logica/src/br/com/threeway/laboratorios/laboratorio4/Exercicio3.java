package br.com.threeway.laboratorios.laboratorio4;

import java.util.Arrays;

public class Exercicio3 {

	public static void main(String[] args) {
		double[] vetor = {3.6, 1.1, 2.3};

		Arrays.sort(vetor);

		invertaSeNecessario(vetor, 0, 1);
		invertaSeNecessario(vetor, 1, 2);
		invertaSeNecessario(vetor, 0, 2);
	}

	private static void invertaSeNecessario(double[] vetor, int i, int j) {
		if (compare(vetor[i], vetor[j]) > 0) {
			inverta(vetor, i, j);
		}
	}

	private static void inverta(double[] vetor, int i, int j) {
		double temp = vetor[i];

		vetor[i] = vetor[j];
		vetor[j] = temp;
	}

	private static int compare(double e1, double e2) {
		if (e1 > e2) {
			return 1;
		} else if (e1 < e2) {
			return -1;
		}
		return 0;
	}
}
