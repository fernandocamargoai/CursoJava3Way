package br.com.threeway.locadora.dao;

import br.com.threeway.locadora.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeDao extends JpaRepository<Filme, Long> {

}
