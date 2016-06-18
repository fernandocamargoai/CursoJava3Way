package br.com.threeway.locadora.main;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.repository.FilmeRepository;
import br.com.threeway.locadora.service.FilmeService;
import br.com.threeway.locadora.util.DataUtil;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Filme> filmes = FilmeRepository.getFilmes();

        for (Filme filme : filmes) {
            System.out.println(filme);
        }

        int codigo;
        Date dataLocacao = null;
        Date dataDevolucao = null;
        System.out.println("Digite o código do filme selecionado");
        codigo = scanner.nextInt();

        Filme filme = FilmeRepository.getFilme(codigo);
        if (filme == null) {
            System.out.println("Filme inexistente");
            System.exit(0);
        }

        System.out.println("Insira a data de locação (dd/mm/yyyy)");
        try {
            dataLocacao = DataUtil.getDate(scanner.next());
        } catch (ParseException e) {
            System.out.println("Data de locação inválida");
            System.exit(0);
        }
        System.out.println("Insira a data de devolução (dd/mm/yyyy)");
        try {
            dataDevolucao = DataUtil.getDate(scanner.next());
        } catch (ParseException e) {
            System.out.println("Data de locação inválida");
            System.exit(0);
        }

        System.out.println("O valor a ser pago é: " +
                NumberFormat.getCurrencyInstance().format(
                        FilmeService.calculePrecoDeLocacacao(filme,
                        dataLocacao, dataDevolucao)));
    }

}
