package br.com.threeway.locadora.dao;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoFilmeDao extends JpaRepository<TipoFilme, Long>{

}
