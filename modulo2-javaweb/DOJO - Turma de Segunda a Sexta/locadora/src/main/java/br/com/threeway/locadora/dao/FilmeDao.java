package br.com.threeway.locadora.dao;

import br.com.threeway.locadora.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeDao extends JpaRepository<Filme, Long>{

	List<Filme> findByNomeStartingWithIgnoreCase(String nome);
}
