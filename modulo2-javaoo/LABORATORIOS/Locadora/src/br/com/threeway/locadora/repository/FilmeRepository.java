package br.com.threeway.locadora.repository;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoDeFilme;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FilmeRepository {

    private static Map<Integer, Filme> filmes = new TreeMap<Integer, Filme>();

    static {
        filmes.put(1, new Filme(1, "Invocação do Mal 2", TipoDeFilme.SUPER_LANCAMENTO));
        filmes.put(2, new Filme(2, "Lagoa Azul", TipoDeFilme.CATALOGO));
        filmes.put(3, new Filme(3, "De volta à Lagoa Azul", TipoDeFilme.CATALOGO));
        filmes.put(4, new Filme(4, "Velozes e Furiosos 5", TipoDeFilme.LANCAMENTO));
        filmes.put(5, new Filme(5, "Deadpool", TipoDeFilme.SUPER_LANCAMENTO));
        filmes.put(6, new Filme(6, "Harry Potter e a Ordem da Fenix", TipoDeFilme.LANCAMENTO));

    }


    public static Filme getFilme(Integer codigo){
        return filmes.get(codigo);
    }

    public static Collection<Filme> getFilmes(){
        return filmes.values();
    }

}
