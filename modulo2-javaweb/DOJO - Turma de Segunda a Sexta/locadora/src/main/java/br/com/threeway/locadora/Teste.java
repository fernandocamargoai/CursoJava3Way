package br.com.threeway.locadora;

import br.com.threeway.locadora.dao.FilmeDao;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		Filme filme = new Filme();
		filme.setNome("Oioioi");
		filme.setTipo(TipoFilme.LANCAMENTO);

		FilmeDao dao = new FilmeDao();
		dao.insira(filme);

		List<Filme> lista = dao.listeFilmes();

		System.out.println(lista);


	}






}
