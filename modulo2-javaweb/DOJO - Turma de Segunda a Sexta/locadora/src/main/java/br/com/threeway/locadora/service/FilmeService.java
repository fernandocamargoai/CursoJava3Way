package br.com.threeway.locadora.service;

import br.com.threeway.locadora.dao.FilmeDao;
import br.com.threeway.locadora.domain.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmeService {

	@Autowired
	private FilmeDao filmeDao;

	@Transactional
	public void save(Filme filme){
		filmeDao.save(filme);
	}

	@Transactional
	public void delete(Filme filme){
		filmeDao.delete(filme);
	}

	public List<Filme> search(String query){
		return filmeDao.findByNomeContainsIgnoreCase(query);
	}
}
