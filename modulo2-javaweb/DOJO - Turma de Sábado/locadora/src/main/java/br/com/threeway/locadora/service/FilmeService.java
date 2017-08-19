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
	public void save(Filme filme) {
		filmeDao.save(filme);
	}

	@Transactional
	public void delete(Long id) {
		filmeDao.delete(id);
	}

	public List<Filme> findAll() {
		return filmeDao.findAll();
	}
}
