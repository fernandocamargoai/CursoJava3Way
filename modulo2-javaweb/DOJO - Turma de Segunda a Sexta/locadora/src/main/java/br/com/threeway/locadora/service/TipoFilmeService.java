package br.com.threeway.locadora.service;

import br.com.threeway.locadora.dao.TipoFilmeDao;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoFilmeService {

	@Autowired
	private TipoFilmeDao tipoFilmeDao;

	@Transactional
	public void save(TipoFilme tipoFilme){
		tipoFilmeDao.save(tipoFilme);
	}

	@Transactional
	public void delete(TipoFilme tipoFilme){
		tipoFilmeDao.delete(tipoFilme);
	}

	public List<TipoFilme> list(){
		return tipoFilmeDao.findAll();
	}
}
